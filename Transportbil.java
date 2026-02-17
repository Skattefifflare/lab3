import java.awt.*;
import java.util.List;



public class Transportbil extends Car implements Truck {
    Cargo<Car> cargo;
    public List<Car> getCargo(){
        return cargo.car_list;
    }

    public Transportbil(){
        super(2, 25, Color.green, "Transportbil");
        cargo = new Cargo<Car>(7); // antal i flaket ska vara en constructor parameter?
    }

    private boolean flakUp;
    public boolean getFlakAngle() {
        return flakUp;
    }

    @Override
    public double speedFactor(){
        if (flakUp) return 0;
        else return 1;
    }

    @Override
    public void startEngine(){
        if (!flakUp) return;
        super.startEngine();
    }


    public void DecrementFlak() {
        if(getCurrentSpeed() == 0){
            if (flakUp){
                flakUp = false;
            }
        }
    }

    public void IncrementFlak() {
        if(getCurrentSpeed() == 0){
            if(!flakUp) {
                flakUp = true;

            }
        }
    }
    public void loadCar(Car car){
        double length = Math.sqrt((Math.pow(this.getX()-car.getX(),2)+Math.pow(this.getY()-car.getY(),2)));
        if (!flakUp && length<1) {
            cargo.Add(car);
        }
    }
    public void deloadCar(){
        if (flakUp){
            var car = cargo.Remove();
            car.SetPos(this.getX()-10, this.getY());
        }
    }

    public void Tow(){
        for (Car car : cargo.car_list){
            car.SetPos(this.getX(), this.getY());
        }
    }
}