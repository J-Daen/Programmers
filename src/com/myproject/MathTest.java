package com.myproject;

import java.util.ArrayList;
import java.util.List;

//모의고사(수학시험)
public class MathTest {
	public int[] solution(int[] answers) {
		int[] person1 = new int[] {1, 2, 3, 4, 5};
		int[] person2 = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
		int[] person3 = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int person1Count = 0;
		int person2Count = 0;
		int person3Count = 0;
		int maxCount = Integer.MIN_VALUE;
		for(int i = 0; i < answers.length; i++) {
				if(answers[i] == person1[i%person1.length]) {
					person1Count++;
					if(person1Count > maxCount)
						maxCount = person1Count;
				}
				if(answers[i] == person2[i%person2.length]) {
					person2Count++;
					if(person2Count > maxCount)
						maxCount = person2Count;
				}
				if(answers[i] == person3[i%person3.length]) {
					person3Count++;
					if(person3Count > maxCount)
						maxCount = person3Count;
				}
		}
		
        List<Integer> result = new ArrayList<Integer>();
        if(maxCount == person1Count)
        	result.add(1);
        if(maxCount == person2Count)
        	result.add(2);
        if(maxCount == person3Count)
        	result.add(3);
        
        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++) {
        	answer[i] = result.get(i);
        }
        
        return answer;
    }
}
