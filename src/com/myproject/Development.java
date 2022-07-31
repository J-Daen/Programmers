package com.myproject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

//기능개발
public class Development {
	 public Integer[] solution(int[] progresses, int[] speeds) {
	        int fuctionPercent = 100;
	        int fuctionCount = 0;
	        int displayDay = Integer.MIN_VALUE;
	        Map<Integer, Integer> developmentMap= new LinkedHashMap<Integer, Integer>();
	        
	        for(int i = 0; i < progresses.length; i++) {
	        	double work = (fuctionPercent - progresses[i]) / (double)speeds[i];
	        	int workDay = (int) Math.ceil(work);
	        	if(workDay > displayDay) {
	        		displayDay = workDay;
	        		fuctionCount=1;
	        		developmentMap.put(displayDay, fuctionCount);
	        	}
	        	else {
	        		developmentMap.put(displayDay, developmentMap.get(displayDay) + 1);
	        	}
	        	
	        }

	        Integer[] answer = new Integer[developmentMap.size()];
	        
	        Set<Integer> keys = developmentMap.keySet();
	        int index = 0;
	        for(int key : keys) {
	        	answer[index++] = developmentMap.get(key);
	        }
	        
	        return answer;
	    }
}
