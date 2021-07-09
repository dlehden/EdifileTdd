package com.edi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class EdiFileReaderApplication {

	public static void main(String[] args) {
			    EdiFileRead ediFileRead = new EdiFileRead();

				ediFileRead.IftMinConvertToSrDb();
		
		//SpringApplication.run(EdiFileReaderApplication.class, args);
	}

}
