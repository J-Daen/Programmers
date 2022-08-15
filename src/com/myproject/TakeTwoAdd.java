package com.myproject;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TakeTwoAdd {
	public int[] solution(int[] numbers) {
        int[] answer = {};
        
        //Set<Integer> set = new HashSet<Integer>();
        Set<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < numbers.length -1; i++) {
        	for(int j = i + 1; j < numbers.length; j++) {
        		set.add(numbers[i] + numbers[j]);
            }
        }
        answer = set.stream().mapToInt(i -> i).toArray();
        //Arrays.sort(answer);
        return answer;
    }
}
