import java.awt.*;


public abstract class Car implements Movable {
	private int     nrDoors;
    private double  enginePower;
    private double  currentSpeed;
    private Color   color;
    private String  modelName;

    public Car(int nrDoors, double enginePower, Color color, String modelName){
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
    }

    public int getNrDoors(){return nrDoors;}
    public double   getEnginePower(){return enginePower;}
    public double   getCurrentSpeed(){return Math.min(Math.max(0, currentSpeed), enginePower);}
    public Color    getColor(){return color;}
    public void     setColor(Color clr){color = clr;}
    public String   getModelName(){return modelName;}


    private double  x_pos = 0;
    private double  y_pos = 0;
    public double   getX(){return x_pos;}
    public double   getY(){return y_pos;}
    public void  SetPos(double x, double y){
        x_pos = x; y_pos = y;
    }
    private int direction = 1;
    public int getDirection(){return direction;}




    public void startEngine(){currentSpeed = 0.1;}
    public void stopEngine(){currentSpeed = 0;}

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
}