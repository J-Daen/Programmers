package com.myproject;

import java.util.HashSet;
import java.util.Set;

//없는 수 더하기
public class MissingNumbers {
	  public int solution(int[] numbers) {
	        int answer = 0;
	        
	        Set<Integer> set = new HashSet<Integer>();
	        for(int number : numbers) {
	        	set.add(number);
	        }
	        
	        for(int i = 0; i < 10; i++) {
	        	if(!set.contains(i))
	        		answer += i;
	        }
	        
	        return answer;
	    }
}
