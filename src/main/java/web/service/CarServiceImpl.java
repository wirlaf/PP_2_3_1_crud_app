package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    private final List<Car> cars;

    CarServiceImpl() {
        cars = new ArrayList<>();
        cars.add(new Car("bmw", "red", 2000));
        cars.add(new Car("vaz", "black", 2005));
        cars.add(new Car("ford", "blue", 1997));
        cars.add(new Car("toyota", "green", 1980));
        cars.add(new Car("volvo", "yellow", 2000));
    }

    @Override
    public List<Car> getCars() {
        return cars;
    }

    @Override
    public List<Car> getCars(int num) {
        return cars.subList(0, num);
    }

}
