package com.myproject;
//핸드폰 번호 가리기
public class HidePhoneNumber {
    public String solution(String phone_number) {
        String answer = "";
        
        int size = phone_number.length();
        int lastNumber = size - 4;
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < lastNumber; i++) {
        	sb.append("*");
        }
        sb.append(phone_number.substring(lastNumber, size));
        answer = sb.toString();
        return answer;
    }
}
