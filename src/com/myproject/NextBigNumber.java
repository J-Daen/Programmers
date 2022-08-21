package com.myproject;
//다음 큰 숫자
public class NextBigNumber {
    public int solution(int n) {
        int answer = 0;
        
        int oneCount = 0;
        String binaryValue = Integer.toBinaryString(n);
        for(char c : binaryValue.toCharArray()) {
        	if(c == '1')
        		oneCount++;
        }
        
        for(int number = n+1; number < 1000000; number++) {
        	int nextOneCount = 0;
            binaryValue = Integer.toBinaryString(number);
        	for(char c : binaryValue.toCharArray()) {
            	if(c == '1')
            		nextOneCount++;
            }
        	
        	if(oneCount == nextOneCount) {
        		answer = number;
        		break;
        	}
        }
        
        
        return answer;
    }
}
