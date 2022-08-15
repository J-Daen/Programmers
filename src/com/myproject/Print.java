package com.myproject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Print {
	public int solution(int[] priorities, int location) {
        int answer = 0;
        int maxPriorite = Integer.MIN_VALUE;
        Queue<Integer> queue = new LinkedList<Integer>();
        Queue<Integer> queuePrint = new LinkedList<Integer>();
        int locationValue = 0;
        for(int i = 0; i < priorities.length; i++) {
        	queue.offer(i);
        	maxPriorite = Math.max(maxPriorite, priorities[i]);
        	
        	if(i == location)
        		locationValue = i;
        }
        for(int i = 0; i < priorities.length; i++) {
        	if(priorities[i] < maxPriorite) {
        		Integer data = queue.remove();
        		queue.offer(data);
        	}
        	else{
        		Integer data = queue.remove();
        		queuePrint.offer(data);
        	}
        }
        
        queuePrint.addAll(queue);
        int printLocation = 1;
        int queueSize = queuePrint.size();
        for(int i = 0; i < queueSize; i++) {
        	if(queuePrint.remove() == locationValue)
        		break;
        	else
        		printLocation++;
        }
        
        return printLocation;
    }
}
