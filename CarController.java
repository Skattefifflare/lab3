import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;


    // A list of cars, modify if needed
    ArrayList<Car> cars = new ArrayList<>();
    Workshop<Volvo240> workshop = new Workshop<>(10);

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.get(0).SetPos(0, 300);
        cc.cars.add(new Saab95());
        cc.cars.get(1).SetPos(0, 100);
        cc.cars.add(new Scania());
        cc.cars.get(2).SetPos(0, 200);





        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            turnOnEdgeCollision();
            int i = 0;
            for (Car car : cars) {
                car.move();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(i, x, y);
                frame.drawPanel.repaint();
                i++;
                if (car instanceof Volvo240) {
                    workshop.LeaveCar((Volvo240) car);
                }
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
         for (Car car : cars) {
            car.gas(gas);
        }
    }
    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Car car : cars) {
            car.brake(brake);
        }
    }
    void turboOn(){
        for (Car car : cars){
            if (car instanceof Saab95){
                ((Saab95)car).setTurboOn();
            }
        }
    }
    void turboOff(){
        for (Car car : cars){
            if (car instanceof Saab95){
                ((Saab95)car).setTurboOff();
            }
        }
    }
    void liftBed(){
        for (Car car : cars){
            if (car instanceof Scania){
                ((Scania)car).IncrementFlak();
            }
        }
    }
    void lowerBed(){
        for (Car car : cars){
            if (car instanceof Scania){
                ((Scania)car).DecrementFlak();
            }
        }
    }
    void startCars(){
        for (Car car : cars){
            car.startEngine();
        }
    }
    void stopCars(){
        for (Car car : cars){
            car.stopEngine();
        }
    }
    void turnOnEdgeCollision(){
        var YLimit = frame.drawPanel.getHeight();
        var XLimit = frame.drawPanel.getWidth();
        for (Car car : cars){
            if (car.getX() < 0){
                car.SetPos(0, car.getY());
                turn(car);
            } else if (car.getX() + 100 > XLimit) {
                car.SetPos(XLimit-100, car.getY());
                turn(car);
            } else if (car.getY() + 60 < 0) {
                car.SetPos(car.getX(), -60);
                turn(car);
            } else if (car.getY() > YLimit) {
                car.SetPos(car.getX(), YLimit);
                turn(car);
            }
        }
    }
    private void turn(Car car){
        car.stopEngine();
        car.turnLeft();
        car.turnLeft();
        car.startEngine();
    }
}
