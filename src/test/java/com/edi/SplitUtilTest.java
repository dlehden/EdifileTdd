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
	 void 플러스기호찾기() {
		SplitUtil check = new SplitUtil();
		String input = "LOC+88+:::BUSAN, KOREA'";
		//log.info(check.searchBeforePlusData(input, 1));
		assertEquals("test",check.searchBeforePlusData(input, 1));
	}

}
