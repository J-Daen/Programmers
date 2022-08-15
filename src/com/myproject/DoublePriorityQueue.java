package com.myproject;

import java.util.Collections;
import java.util.PriorityQueue;

//이중우선순위큐
public class DoublePriorityQueue {
	public int[] solution(String[] operations) {
        int[] answer = new int[]{0,0};
        
        PriorityQueue<Integer> MaxValueQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(String cmd : operations) {
        	if(cmd.contains("I")) {
        		cmd = cmd.substring(2, cmd.length());
        		int number = Integer.valueOf(cmd);
        			MaxValueQueue.offer(number);
        	}
        	else if(cmd.equals("D 1")) {
        		if(!MaxValueQueue.isEmpty()) {
        			MaxValueQueue.poll();
        		}
        	}
        	else {
        		if(!MaxValueQueue.isEmpty()) {
        			MaxValueQueue.remove(Collections.min(MaxValueQueue));
        		}
        	}
        }
        if(MaxValueQueue.size() >=2) {
        	answer[0] = MaxValueQueue.poll();
        	answer[1] = Collections.min(MaxValueQueue);
        }
        
        return answer;
    }
}
