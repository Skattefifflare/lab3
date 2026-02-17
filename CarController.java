import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
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
    // ArrayList<ACar> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

<<<<<<< Updated upstream
        // cc.cars.add(new Volvo240());
=======
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.get(1).SetPos(0, 100);
        cc.cars.add(new Scania());
        cc.cars.get(2).SetPos(0, 200);

>>>>>>> Stashed changes

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
<<<<<<< Updated upstream
 /*           for (ACar car : cars) {
=======
            edgeCollision();
            int i = 0;
            for (Car car : cars) {
>>>>>>> Stashed changes
                car.move();
                int x = (int) Math.round(car.getPosition().getX());
                int y = (int) Math.round(car.getPosition().getY());
                frame.drawPanel.moveit(x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }*/
        }
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
       /* for (ACar car : cars
                ) {
            car.gas(gas);
<<<<<<< Updated upstream
        }*/
=======
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
                ((Saab95)car).setTurboOn();
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
    void edgeCollision(){
        var YLimit = frame.drawPanel.getHeight();
        var XLimit = frame.drawPanel.getWidth();

        for (Car car : cars){
            if (car.getX() < 0){
                car.SetPos(0, car.getY());
                turn(car);
            } else if (car.getX() > XLimit) {
                car.SetPos(XLimit, car.getY());
                turn(car);
            } else if (car.getY() < 0) {
                car.SetPos(car.getX(), 0);
                turn(car);
            } else if (car.getY() > YLimit) {
                car.SetPos(car.getX(), YLimit);
                turn(car);
            }
        }
>>>>>>> Stashed changes
    }
    void turn(Car car){
        car.stopEngine();
        car.turnLeft();
        car.turnLeft();
        car.startEngine();
    }
}
