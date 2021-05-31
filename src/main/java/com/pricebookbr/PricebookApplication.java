package com.pricebookbr;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PricebookApplication implements CommandLineRunner {

	//@Autowired
	//private ClienteService cs;
	
	@PostConstruct
	public void init() {
		// Setting Spring Boot SetTimeZone
		//TimeZone.setDefault(TimeZone.getTimeZone("IST"));
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(">> Minha data e hora na mão: "+dateFormat.format(date)); //2016/11/16 12:08:43
	}

	public static void main(String[] args) {		
		SpringApplication.run(PricebookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
