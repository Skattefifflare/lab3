package cars;

import towing.Car;

import java.awt.*;

public class Volvo240 extends Car {

    public final static double trimFactor = 1.25;
    
    
    public Volvo240(){
        super(4, 30, Color.black, "cars.Volvo240");
    }
    
    @Override
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
