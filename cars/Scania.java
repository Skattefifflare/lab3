package cars;

import towing.Car;

import java.awt.*;

public class Scania extends Car implements Truck  {


    public Scania(){
        super(2, 25, Color.pink, "cars.Scania");
    }

    private int flakAngle;
    public int getFlakAngle() {
        return flakAngle;
    }

    @Override
    public double speedFactor(){
        if (flakAngle != 0) return 0;
        else return 1;
    }


    public void DecrementFlak() {
        if(getCurrentSpeed() == 0){
            if (flakAngle > 0){
                flakAngle -= 1;
            }
        }
    }

    public void IncrementFlak() {
        if(getCurrentSpeed() == 0){
            if(flakAngle < 70) {
                flakAngle += 1;
            }
        }
    }
}