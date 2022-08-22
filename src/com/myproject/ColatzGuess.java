package com.myproject;
//콜라츠 추측
public class ColatzGuess {
	public int solution(int num) {
        int answer = 0;
        if(num == 1)
        	return 0;
        
        long value = num;
        boolean isRun = true;
        while(isRun) {
        	
        	if(value % 2 == 0) {
        		value = value / 2;
        	}
        	else {
        		value = (value * 3) + 1;
        	}
        	answer++;
        	
        	if(value == 1)
        		isRun = false;
        	if(answer == 500)
        	{
        		answer = -1;
        		isRun = false;
        	}
        }
        
        return answer;
    }
}
