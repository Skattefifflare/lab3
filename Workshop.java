import towing.Car;
import towing.Cargo;

public class Workshop<E extends Car> {
    private Cargo<E> cars;

    public Workshop(int max_cars){
        cars = new Cargo<E>(max_cars);
    }
    public void LeaveCar(E car){
        cars.Add(car);
    }
    public E GetCar(){
        return cars.Remove();
    }
}
