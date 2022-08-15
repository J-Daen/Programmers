package com.myproject;

import java.util.Arrays;
import java.util.Comparator;

//가장 큰 수
public class LargestNumber {
	public String solution(int[] numbers) {
        String answer = "";
        String[] sNumbers = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
        	sNumbers[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(sNumbers, new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				// TODO Auto-generated method stub
				int result = (b+a).compareTo(a+b);
				return result;
			}
        	
        });
        
        if(sNumbers[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String sNumber : sNumbers) {
        	sb.append(sNumber);
        }
        
        return sb.toString();
    }
}
