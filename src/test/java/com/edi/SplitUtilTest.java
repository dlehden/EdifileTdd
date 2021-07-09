package com.edi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.edi.utils.SplitUtil;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class SplitUtilTest {
	@Test
	 void 플러스기호_두번째_앞에문자가져오기() {
		SplitUtil check = new SplitUtil();
		String input = "LOC+88+:::BUSAN, KOREA'";
		log.info(check.searcLeftPlusData(input, 2));
		assertEquals("88",check.searcLeftPlusData(input,2));
	}
	@Test
	 void 연속플러스_세가_뒤에문자가져오기() {
		SplitUtil check = new SplitUtil();
		String input = "FTX+AAA+++AUTOMOBILE SERVICE PARTS";
		log.info(check.searcLeftPlusData(input, 4));
		assertEquals("AUTOMOBILE SERVICE PARTS",check.searchThreeRightPlusData(input,4));
	}
	@Test
	 void 첫번쨰태그앞에_FW태그확인후_플러스두개뒤에데이터가져오기() {
		SplitUtil check = new SplitUtil();
		String input = "NAD+FW++301, TEHERAN-RO, GANGNAM-GU,:SEOUL, KOREA+HYUNDAI GLOVIS CO., LTD.";
		String seconddata= "301, TEHERAN-RO, GANGNAM-GU,:SEOUL, KOREA+HYUNDAI GLOVIS CO., LTD.";
		
		assertEquals("FW",check.searcLeftPlusData(input,2));
		assertEquals(seconddata,check.searchTwoRightPlusData(input,2));
	
	}
	

}
