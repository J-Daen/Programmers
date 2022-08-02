package com.myproject;

import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

//같은 숫자는 싫어
public class NotSamNumber {
	public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < arr.length; i++) {
        	int insertNumber = arr[i];
        	if(!stack.isEmpty())
        		if(stack.peek() == insertNumber)
        			continue;
        		else
        			stack.add(insertNumber);
        	else{
        		stack.add(insertNumber);
        	}
        }
        
        int[] answer = new int[stack.size()];
        Collections.reverse(stack);
        int index = 0;
        while(!stack.isEmpty()) {
        	answer[index++] = stack.pop();
        }
        
        return answer;
    }
}
