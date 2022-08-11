package com.myproject;

public class Carpet {
	public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int width = 0;
        int height = 0;
        for(int i = 1; i <= yellow; i++){
            if(yellow % i == 0)
            {
                width = i;
                height = yellow / i;
                
                if(width >= height){
                    if((width + height)*2 + 4 == brown)
                    break;
                }
            }
        }
        answer[0] = width + 2;
        answer[1] = height + 2;
        return answer;
    }
}
