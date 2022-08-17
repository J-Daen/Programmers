package com.myproject;

//이상한 문자 만들기
public class CreateCharacters {
	public String solution(String s) {
        String answer = "";
        String[] characters = s.split(" ", -1);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < characters.length; i++) {
        	char[] character = characters[i].toCharArray();
        	for(int j = 0; j < character.length; j++) {
        		String alpabat = String.valueOf(character[j]);
        		if(j % 2 ==0)
        			sb.append(alpabat.toUpperCase());
        		else
        			sb.append(alpabat.toLowerCase());
        	}
        	sb.append(" ");
        }
        return sb.toString().trim();
    }
}
