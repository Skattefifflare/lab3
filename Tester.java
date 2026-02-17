import cars.Saab95;
import cars.Scania;
import cars.Volvo240;
import org.junit.jupiter.api.Test;
import towing.Transportbil;

import static org.junit.jupiter.api.Assertions.*;

public class Tester {

    @Test
    public void testMove() {
        var car = new Saab95();
        car.startEngine();
        car.move();
        assertEquals(0.1, car.getY());
    }

    public static void main(String[] args) {

    }

    @Test
    public void testGasAndBrake() {
        var car2 = new Volvo240();
        var car3 = new Volvo240();
        car2.startEngine();
        car2.move();
        var old_speed = car2.getCurrentSpeed();
        car2.gas(0.9);
        assertTrue(old_speed < car2.getCurrentSpeed());//Gas
        var incSpeed = car2.getCurrentSpeed();
        car2.brake(0.4);
        assertTrue(incSpeed > car2.getCurrentSpeed());//Brake
    }


    @Test
    public void testTurnLeft() {
        var car = new Saab95();
        car.startEngine();


        car.turnLeft();
        assertEquals(3, car.getDirection());
        car.move();
        assertEquals(-0.1, car.getX());
        assertEquals(0.0, car.getY());

        car.turnLeft();
        assertEquals(2, car.getDirection());
        car.move();
        assertEquals(-0.1, car.getX());
        assertEquals(-0.1, car.getY());

        car.turnLeft();
        assertEquals(1, car.getDirection());
        car.move();
        assertEquals(0.0, car.getX());
        assertEquals(-0.1, car.getY());

        car.turnLeft();
        assertEquals(0, car.getDirection());
        car.move();
        car.move();
        assertEquals(0.0, car.getX());
        assertEquals(0.1, car.getY());
    }

    @Test
    public void testTurnRight() {
        var car = new Saab95();
        car.startEngine();

        car.turnRight();
        assertEquals(1, car.getDirection());
        car.move();
        assertEquals(0.1, car.getX());
        assertEquals(0.0, car.getY());

        car.turnRight();
        assertEquals(2, car.getDirection());
        car.move();
        assertEquals(0.1, car.getX());
        assertEquals(-0.1, car.getY());

        car.turnRight();
        assertEquals(3, car.getDirection());
        car.move();
        assertEquals(0.0, car.getX());
        assertEquals(-0.1, car.getY());

        car.turnRight();
        assertEquals(0, car.getDirection());
        car.move();
        car.move();
        assertEquals(0.0, car.getX());
        assertEquals(0.1, car.getY());
    }

    @Test
    public void testTurbo() {
        var saab = new Saab95();
        saab.setTurboOn();
        saab.gas(1);
        assertEquals(1.625, saab.getCurrentSpeed());
    }
    @Test
    public void testLoad() {
        var tb = new Transportbil();
        var car1 = new Saab95();
        var car2 = new Volvo240();
        car1.startEngine();
        car1.gas(1);
        car1.turnLeft();
        car1.move();
        tb.loadCar(car1);
        assertEquals(0, tb.getCargo().size());
        tb.loadCar(car2);

        assertEquals(1, tb.getCargo().size());
        tb.deloadCar();

    }
    @Test
    public void testDeload(){
        var tb = new Transportbil();
        var car1 = new Saab95();
        tb.loadCar(car1);
        tb.deloadCar();
        assertEquals(-10, car1.getX());
    }
    @Test
    public void testTow(){
        var transport = new Transportbil();
        transport.move();
        var volvo1 = new Volvo240();
        transport.loadCar(volvo1);
        transport.move();
        transport.Tow();
        assertEquals(volvo1.getX(), transport.getX());
        assertEquals(volvo1.getY(), transport.getY());

    }
    @Test
    public void testFlak(){
        var scania = new Scania();
        scania.IncrementFlak();
        assertEquals(1, scania.getFlakAngle());
        var transport = new Transportbil();
        transport.move();
        transport.IncrementFlak();
        assertEquals(false, transport.getFlakAngle());
    }
}
