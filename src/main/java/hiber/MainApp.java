package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car bmw = new Car("BMW", 1);
      userService.add(new User("Oleg","Kiselev","kisly@mail.ru",bmw));

      Car mersedec = new Car("mersedes", 2);
      userService.add(new User("Vitya","Golih","goliy@mail.ru",mersedec));

      Car opel = new Car("opel", 3);
      userService.add(new User("Anton","Petuh","kukareku@mail.ru",opel));

      User userHavingCar = userService.getUserHavingCar("mersedes", 2);
      System.out.println(userHavingCar);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user);
      }
      context.close();
   }
}
