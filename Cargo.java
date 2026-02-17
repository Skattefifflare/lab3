import java.util.List;
import java.util.Stack;



public class Cargo<E extends Car> {
    int max_cars;
    List<E> car_list;

    public Cargo(int max_cars){
        this.max_cars = max_cars;

        car_list = new Stack<>();
    }

    public void Add(E car){
        if (car instanceof Truck || car_list.size() == max_cars) return;
        car_list.add(car);
    }
    public E Remove(){
        return car_list.removeLast();
    }
}
