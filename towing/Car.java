package towing;

import cars.Movable;

import java.awt.*;


public abstract class Car implements Movable {
	private int nrDoors;          // Number of doors on the car
    private double enginePower;   // Engine power of the car
    private double currentSpeed;  // The current speed of the car
    private Color color;          // Color of the car
    private String modelName;     // The car model name

    private boolean towed;
    public boolean getTowed(){return towed;}

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }
    private double x_pos = 0;
    private double y_pos = 0;

    private int direction = 0;

    public double getX(){return x_pos;}
    public double getY(){return y_pos;}
    public int getDirection(){return direction;}


    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public String getModelName(){
        return modelName;
    }

    public double getCurrentSpeed(){
        return Math.min(Math.max(0, currentSpeed), enginePower);
    }

    public Color getColor(){
        return color;
    }
    public void setColor(Color clr){
	    color = clr;
    }

    public void startEngine(){
	    currentSpeed = 0.1;
    }
    public void stopEngine(){
	    currentSpeed = 0;
    }

    public void gas(double amount){
        if (amount < 0 || amount > 1 ) throw new Error("invalid gas parameter");
        incrementSpeed(amount);
    }
    public void brake(double amount){
        if (amount < 0 || amount > 1 ) throw new Error("invalid brake parameter");
        decrementSpeed(amount);
    }


    protected abstract double speedFactor();

    private void incrementSpeed(double amount){
        currentSpeed = Math.min( getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount){
        currentSpeed = getCurrentSpeed() - speedFactor() * amount;//max
    }

    @Override
    public void move(){
        switch (direction){
            case 0:
                y_pos += getCurrentSpeed();
                break;
            case 1:
                x_pos += getCurrentSpeed();
                break;
            case 2:
                y_pos -= getCurrentSpeed();
                break;
            case 3:
                x_pos -= getCurrentSpeed();
                break;
        }
    }
    @Override
    public void turnLeft(){
       direction = (direction + 3) % 4;
    }
    @Override
    public void turnRight(){
        direction = (direction +1) % 4;
    }

    protected void StartTowing(){towed = true;}
    protected void StopTowing(){towed = false;}
    protected void SetPos(double x, double y){
        if (!towed) return;
        x_pos = x; y_pos = y;
    }
}