package com.myproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//다트 게임
public class DartGame {
	public int solution(String dartResult) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        dartResult = dartResult.replace("10", "N");
        int stage = 0;
        int score = 0;
        for(char c : dartResult.toCharArray()) {
        	
        	if(isNumber(c)) {
        		score = Integer.valueOf(String.valueOf(c));
        		stage++;
        	}
        	else {
        		switch(c) {
        			case 'N':
        				score = 10;
                		stage++;
        			break;
	        		case 'S':
	        			map.put(stage, score);
	        			break;
	        		case 'D':
	        			score = score * score;
	        			map.put(stage, score);
	        			break;
	        		case 'T':
	        			score = score * score * score;
	        			map.put(stage, score);
	        			break;
	        		case '*':
	        			int preStage = stage -1;
	        			map.put(stage, map.get(stage) * 2);
	        			if(map.containsKey(preStage))
	        				map.put(preStage, map.get(preStage) * 2);
	        			break;
	        		case '#':
	        			map.put(stage, map.get(stage) * -1);
	        			break;
	        							
        		}
        	}
        }
        
        Set<Integer> set = map.keySet();
        for(int step : set) {
			answer += map.get(step);
		}
        
        return answer;
    }
	
	public boolean isNumber(char c) {
		try {
			Double.parseDouble(String.valueOf(c));
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
