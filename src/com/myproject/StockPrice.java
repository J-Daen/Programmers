package com.myproject;
//주식 가격
public class StockPrice {
	public int[] solution(int[] prices) {
        
        int seconds = prices.length;
        int[] answer = new int[seconds];
        for(int i = 0; i < seconds; i++){
        	int term = 0;
        	int price = prices[i];
        	for(int s = i+1; s < seconds; s++ ) {
        		term = s - i;
        		if(prices[s] < price)
        			break;
        	}
        	answer[i] = term;
        }
        return answer;
    }
}
