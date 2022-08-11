package com.myproject;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
// 더 맵게
public class MoreSpicy {
	public int solution(int[] scovilles, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        for(int scovile : scovilles) {
        	queue.offer(scovile);
        }
        
        while(queue.peek()  <= K) {
        	if(queue.size() == 1) {
            	return -1;
            }
        	int first=  queue.poll();
        	int secend = queue.poll();
        	int mix = mixScovile(first, secend);
        	answer++;
        	queue.offer(mix);
        }
        
        
        return answer;
    }
	
	public int mixScovile(int first, int secend) {
		return first + (secend * 2);
	}
}
