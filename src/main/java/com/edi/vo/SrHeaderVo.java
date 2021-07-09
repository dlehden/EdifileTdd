package com.edi.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class SrHeaderVo {
	
	public SrHeaderVo() {
		
	}
	
	private String POL;
	private String POD;

}
