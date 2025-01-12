package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    public User getUserByCar(int series, String model);
    List<User> listUsers();
}
