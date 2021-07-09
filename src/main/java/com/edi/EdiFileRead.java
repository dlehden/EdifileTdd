package com.edi;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import com.edi.vo.SrHeaderVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EdiFileRead {
     static HashMap<Integer,String> locTag = new HashMap<Integer,String>(); static int locTagCnt = 0;
     static HashMap<Integer,String> pciTag = new HashMap<Integer,String>(); static int pciTagCnt = 0;
     static HashMap<Integer,String> rffTag = new HashMap<Integer,String>(); static int rffTagCnt = 0;


    static SrHeaderVo srHeaderVo = new SrHeaderVo();
	public void IftMinConvertToSrDb() {
		log.info("Iftmin파일을 Sr 테이블로 전환 시작");
		try {
			getReadFile("C:/Users/drlee/Desktop/editest.edi");
		
			log.info(srHeaderVo.getPOD()+"----------------------------<<<< 들어옴");
			log.info(srHeaderVo.getPOL()+"----------------------------<<<< 들어옴");
			log.info("----------------------------");
			getReadFile("C:/Users/drlee/Desktop/editest2.edi");
			log.info(srHeaderVo.getPOD()+"----------------------------<<<< 들어옴");
			log.info(srHeaderVo.getPOL()+"----------------------------<<<< 들어옴");
			log.info("----------------------------");

		
		
		}catch(Exception e) {
			log.info("file not found");
		}
	}

	
    public static boolean getReadFile(String path) throws FileNotFoundException, IOException {
        String readRowLine;
        String[] arrayRowLine=null;
		FileReader reader = new FileReader(path);
        BufferedReader bufferReader = new BufferedReader(reader);
	        while((readRowLine= bufferReader.readLine())!=null)
	        {
	        	arrayRowLine = readRowLine.split("'");   
	        	
	        	if(arrayRowLine[0].contains("LOC")) addLocTag(arrayRowLine[0]);
	        	if(arrayRowLine[0].contains("RFF")) addRffTag(arrayRowLine[0]);
	        	if(arrayRowLine[0].contains("PCI")) addPciTag(arrayRowLine[0]);
	        	
	        }
	        printHahMapDateAll();
	
	        init();
	    	reader.close();
	    	bufferReader.close();
	   
      return true;
  }
    
    
    private static void addLocTag(String rowLine) {
    		locTag.put(locTagCnt,rowLine);
    		locTagCnt++;
    }
    private static void addRffTag(String rowLine) {
		    rffTag.put(rffTagCnt,rowLine);
		    rffTagCnt++;
}
    
    private static void addPciTag(String rowLine) {
    		pciTag.put(pciTagCnt,rowLine);
    		pciTagCnt++;
    }

    private static void printHahMapDateAll() {
        
        for(Integer rffRow : rffTag.keySet()){ //저장된 key값 확인
            log.info("[Key]:" + rffRow + " [Value]:" + rffTag.get(rffRow));
        }
        
        for(Integer pciRow : pciTag.keySet()){ //저장된 key값 확인
        	log.info("[Key]:" + pciRow + " [Value]:" + pciTag.get(pciRow));
        }
        
        for(Integer locRow : locTag.keySet()){ //저장된 key값 확인
        	log.info("[Key]:" + locRow + " [Value]:" + locTag.get(locRow));

        }
        
        srHeaderVo = SrHeaderVo.builder().POD(pciTag.get(0))
        							     .POL(locTag.get(1)).build();
		

    }
    
    public static void init() {
    	locTag.clear();
    	locTagCnt=0;
    	pciTag.clear();
    	pciTagCnt=0;
    	rffTag.clear();
    	rffTagCnt=0;

    }
}
