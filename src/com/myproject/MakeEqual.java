package com.myproject;

import java.util.LinkedList;
import java.util.Queue;

public class MakeEqual {
    public int solution(int[] numbers1, int[] numbers2) {
        int answer = 0;
        
        long sumToltal = 0;
        long sumQueue1 = 0;
        long sumQueue2 = 0;
        Queue<Integer> queue1 = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        
        for(int i = 0; i < numbers1.length; i++) {
        	sumToltal += numbers1[i] + numbers2[i];
        	sumQueue1 += numbers1[i];
        	sumQueue2 += numbers2[i];
        	
        	queue1.add(numbers1[i]);
        	queue2.add(numbers2[i]);
        }
        
        if(sumToltal % 2 != 0)
        	return -1;
        
        while(sumQueue1 != sumQueue2) {
        	int value = 0;
        	if(sumQueue1 < sumQueue2) {
        		value = queue2.poll();
        		sumQueue2 -= value;
        		sumQueue1 += value;
        		queue1.add(value);
        	}
        	else {
        		value = queue1.poll();
        		sumQueue1 -= value;
        		sumQueue2 += value;
        		queue2.add(value);
        	}
        	
        	//큐 양쪽이 번갈아 비어있을 경우
        	if(answer > queue1.size() + queue2.size() + 2) {
        		answer = -1;
        		break;
        	}
        	
        	answer++;
        }
        
        return answer;
    }
}
