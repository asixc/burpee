package com.burpee;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class BurpeeApplication {

	private static final Log log = LogFactory.getLog(BurpeeApplication.class);

	public static void main(String[] args) {
		var context = SpringApplication.run(BurpeeApplication.class, args);


		BCryptPasswordEncoder en = context.getBean(BCryptPasswordEncoder.class);
		log.info(en.encode("admin"));
	}

}
