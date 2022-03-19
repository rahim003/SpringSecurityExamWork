package peaksoft.springsecurityexamwork;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import peaksoft.springsecurityexamwork.entity.Role;
import peaksoft.springsecurityexamwork.entity.User;
import peaksoft.springsecurityexamwork.service.UserService;

import java.util.ArrayList;

@SpringBootApplication
public class SpringSecurityExamWorkApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityExamWorkApplication.class, args);
    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run(UserService userService){
        return args ->{
            userService.saveRole(new Role("ROLE_ADMIN"));
            userService.saveRole(new Role("ROLE_STUDENT"));


            userService.saveUser(new User("Rahim","Kurbanov","kurbanov@gmail.com","rahim2003",new ArrayList<>()));
            userService.saveUser(new User("Muhammed","Baaturov","muhammed@gmail.com","1234",new ArrayList<>()));
            userService.saveUser(new User("Aisuluu","Baaturova","aisuluu@gmail.com","aisuluu2001",new ArrayList<>()));
            userService.saveUser(new User("Meder","Tynychbekov","meder@gmail.com","meder5996",new ArrayList<>()));
            userService.saveUser(new User("Zinattullo","Kursanbai uulu","zinattullo@gmail.com","123123",new ArrayList<>()));

            userService.addRoleToUser("Rahim","ROLE_ADMIN");
            userService.addRoleToUser("Muhammed","ROLE_STUDENT");
            userService.addRoleToUser("Zinattullo","ROLE_STUDENT");
            userService.addRoleToUser("Meder","ROLE_STUDENT");
            userService.addRoleToUser("Aisuluu","ROLE_ADMIN");
        };
    }

}
