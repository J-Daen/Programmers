package com.myproject;

import java.util.Stack;

//올바른 괄호
public class StackTest {
	boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<Character>();
        if(s.length()%2 !=0)
        	return false;
        
        for(char c : s.toCharArray()) {
        	if(stack.isEmpty()) {
        		if(')' == c)
        			return false;
        		stack.push(c);
        	}
        	else {
        		char peek = stack.peek();
        		if(peek != c)
        			stack.pop();
        		else
        			stack.push(c);
        	}
        }
        if(stack.isEmpty())
        	return true;
        else 
        	return false;
    }
}
