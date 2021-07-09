package com.edi.utils;

public  class SplitUtil {
	
	public  String searcLeftPlusData(String input, int countPlus) {
		
		String[] splitPlus = input.split("[+]");
		
		for(int i=0; i < splitPlus.length; i++) {
			if((countPlus-1)==i) {
				input = splitPlus[i];
				break;
			}
		}
		return input;
	}

	public  String searchThreeRightPlusData(String input, int countPlus) {
		
		int idx = input.indexOf("+++");
		if(idx>1) {
			System.out.println(input.substring(idx+3));
			input = input.substring(idx+3);
		}
		return input;
	}
	public  String searchTwoRightPlusData(String input, int countPlus) {
		int idx = input.indexOf("++");
		if(idx>1) {
			System.out.println(input.substring(idx+2));
			input = input.substring(idx+2);
		}
		return input;
	}


	
}
