package jp.co.example;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import jp.co.example.dao.UserDao;
import jp.co.example.entity.User;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context =
		SpringApplication.run(SpringJdbcApplication.class, args);

		UserDao userDao = context.getBean(UserDao.class);
		List<User> list = userDao.findAll();

		for (User u : list) {
			System.out.println(u);
		}
}
}