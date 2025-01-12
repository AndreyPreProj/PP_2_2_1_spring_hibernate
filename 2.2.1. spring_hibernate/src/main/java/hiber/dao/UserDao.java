package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   public User getUserByCar(int series, String model);
   List<User> listUsers();
}
