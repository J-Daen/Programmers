package com.myproject;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Lifeboat {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Integer[] peoles = Arrays.stream(people).boxed().toArray(Integer[]::new);
        Arrays.sort(peoles, Collections.reverseOrder());
        
        PriorityQueue<Integer> queue = new PriorityQueue();
        for(int weight : peoles) {
        	if(weight > limit/2)
        		answer++;
        	else
        		queue.offer(weight);
        }
        int sumWeight = 0;
        while(!queue.isEmpty()) {
        	sumWeight += queue.peek();
        	if(sumWeight > limit) {
        		sumWeight = 0;
        		answer++;
        	}
        	else {
        		if(queue.size() == 1)
        			answer++;
        		queue.poll();
        	}
        	
        }
        
        return answer;
    }
}
