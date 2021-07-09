package com.edi.utils;

public  class SplitUtil {
	
	public  String searchBeforePlusData(String input, int countPlus) {
		
		int idx = input.indexOf("+");
		String[] splitPlus = input.split("[+]");
		
		for(int i=0; i < splitPlus.length; i++) {
			System.out.println(splitPlus[i]);
		}
		
		
		return input;
	}

}
