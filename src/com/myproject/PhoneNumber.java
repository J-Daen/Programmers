package com.myproject;
//전화번호 목록
public class PhoneNumber {
	public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        String searchNumber = phone_book[0];
        
        for(int i  = 1; i < phone_book.length; i++) {
        	if(phone_book[i].startsWith(searchNumber))
        		return false;
        }
        
        return answer;
    }
}
