package com.myproject;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

//다리를 지나는 트럭
public class BridgeTruck {
	  public int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 0;
	        Queue<Integer> bridge = new LinkedList<Integer>();
	        Queue<Integer> truck = new LinkedList<Integer>();
	        
	        for(int i = 0; i < bridge_length; i++) {
	        	bridge.offer(0);
	        }
	        
	        Arrays.res
	        Collections.reverse(null);
	        for(int i : truck_weights) {
	        	truck.offer(i);
	        }
	        
	        int passTime = 0;
	        int totalWeight = 0;
	        while(!bridge.isEmpty()) {
	        	totalWeight -= bridge.peek();
        		bridge.poll();
	        	
	        	if(truck.isEmpty()) {
	        		passTime += bridge_length;
	        		break;
	        	}
	        	else {
	        		if(totalWeight + truck.peek() <= weight) {
		        		int truckWeight = truck.poll();
		        		totalWeight += truckWeight;
		        		bridge.offer(truckWeight);
		        	}
		        	else {
		        		bridge.offer(0);
		        	}
	        	}
	        	passTime++;
	        }
	        
	        
	        return passTime;
	   }
}
