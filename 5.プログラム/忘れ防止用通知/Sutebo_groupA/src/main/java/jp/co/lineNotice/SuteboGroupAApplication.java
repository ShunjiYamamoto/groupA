package jp.co.lineNotice;

import java.text.ParseException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SuteboGroupAApplication {

	public static void main(String[] args) throws ParseException {

		SpringApplication.run(SuteboGroupAApplication.class, args);
		//LineNoticeTimer.subAll();

	}
}
