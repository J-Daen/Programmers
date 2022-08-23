package com.myproject;

//가운데 글자 가져오기
public class GetLetters {
    public String solution(String s) {
        String answer = "";
        
        int size = s.length();
        int midIndex = size / 2;
        if(size %2 == 0)
        	answer = s.substring(midIndex-1, midIndex + 1);
        else
        	answer = s.substring(midIndex, midIndex + 1);
        
        return answer;
    }
}
