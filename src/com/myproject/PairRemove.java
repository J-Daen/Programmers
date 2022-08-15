package com.myproject;

import java.util.Stack;

//짝지어 제거하기
public class PairRemove {
	 public int solution(String s)
    {
        int answer = 0;

        Stack<Character> alpabat = new Stack<Character>();
        for(char c : s.toCharArray()) {
        	if(!alpabat.isEmpty()) {
        		if(c == alpabat.peek())
        			alpabat.pop();
        		else
        			alpabat.push(c);
        	}
        	else
        		alpabat.push(c);
        }

        if(alpabat.isEmpty())
        	answer = 1;
        
        return answer;
    }
}
