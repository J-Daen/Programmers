package com.myproject;
//JadenCase 문자열 만들기
public class JadenCase {
    public String solution(String s) {
        String answer = "";
        
        String[] contents = s.toLowerCase().split("");
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(String content : contents) {
        	answer = flag ? content.toUpperCase() : content;
        	flag = content.equals(" ") ? true : false;
        	sb.append(answer);
        }
       
        
        return sb.toString();
    }
    
}
