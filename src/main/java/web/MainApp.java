package web;

import web.config.AppConfig;
import web.model.User;
import web.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Ivan", "Deduskin", "ivan@mail.ru");
        userService.add(user1);
        User user2 = new User("Maria", "Babushkina", "maria@mail.ru");
        userService.add(user2);
        User user3 = new User("Pavel", "Lisicin", "pavel4@mail.ru");
        userService.add(user3);
        User user4 = new User("Artur", "Kolobkov", "artur@mail.ru");
        userService.add(user4);

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
