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



      User user = new User("Artem","Dunaev","dunaev@mail.ru");
      User user2 = new User("Ivan","Ivanov","ivanov@mail.ru");
      User user3 = new User("Misha","Petrov","mishapetrov@mail.ru");
      Car car1 = new Car("bmw",4);
      Car car2 = new Car("MB",63);
      Car car3 = new Car("bmw",5);
      Car car4 = new Car("VAZ",2111);

      user.setCar(car1);
      user2.setCar(car3);
      user3.setCar(car4);



//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

userService.add(user);
userService.add(user2);
userService.add(user3);

    List a = userService.getUserByCar("bmw",4);
       System.out.println(a);



      List<User> users = userService.listUsers();
      for (User userr : users) {
         System.out.println("Id = "+userr.getId());
         System.out.println("First Name = "+userr.getFirstName());
         System.out.println("Last Name = "+userr.getLastName());
         System.out.println("Email = "+userr.getEmail());
         System.out.println();
      }

      context.close();
   }
}
