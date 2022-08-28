package com.myproject;

import java.util.Arrays;
//구명보트
public class Lifeboat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        int index = 0;
        for(int i = people.length -1; i >= index; i-- ){
        	if(people[index] + people[i] <= limit) {
        		answer++;
        		index++;
        	}
        	else
        		answer++;
        }
       
        
        return answer;
    }
}
