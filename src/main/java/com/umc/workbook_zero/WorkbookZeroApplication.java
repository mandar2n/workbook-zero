package com.umc.workbook_zero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WorkbookZeroApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkbookZeroApplication.class, args);
	}

}
