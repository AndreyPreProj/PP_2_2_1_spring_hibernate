package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Arr", "Lastname1", "user1@mail.ru");
        Car car1 = new Car(5505, "BMW");
        car1.setUser(user1);
        user1.setCar(car1);
        userService.add(user1);
        User user11 = userService.getUserByCar(5505, "BMW");
        System.out.println(user11);

        User user2 = new User("Sasha", "Lastname2", "user1@mail.ru");
        Car car2 = new Car(1305, "Ferrari");
        car2.setUser(user2);
        user2.setCar(car2);
        userService.add(user2);
        User user22 = userService.getUserByCar(1305, "Ferrari");
        System.out.println(user22);

        User user3 = new User("Peta", "Lastname2", "user1@mail.ru");
        Car car3 = new Car(1662, "Audi");
        car3.setUser(user3);
        user3.setCar(car3);
        userService.add(user3);
        User user33 = userService.getUserByCar(1662, "Audi");
        System.out.println(user33);


        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }

        context.close();
    }
}
