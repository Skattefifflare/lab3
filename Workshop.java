public class Workshop<E extends Car> {
    private Cargo<E> cars;

    float x = 300;
    float y = 300;


    public Workshop(int max_cars){
        cars = new Cargo<E>(max_cars);
    }
    public void LeaveCar(E car){
        if (x >= car.getX() && x <= car.getX()+100 && y >= car.getY() && y <= car.getY()+60){
            cars.Add(car);
            car.stopEngine();
        }
    }
    public E GetCar(){
        return cars.Remove();
    }
}
