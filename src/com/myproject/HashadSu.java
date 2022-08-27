package com.myproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
//하샤드 수
public class HashadSu {
	 public boolean solution(int x) {
        boolean answer = true;
        String sNumber = String.valueOf(x);
        int sum = 0;
        for(char cNumber : sNumber.toCharArray()) {
        	sum += Integer.valueOf(String.valueOf(cNumber));
        }
        
        if(x % sum != 0)
        	answer = false;
        
        return answer;
    }
}
