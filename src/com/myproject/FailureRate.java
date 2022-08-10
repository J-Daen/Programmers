package com.myproject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//실패율
public class FailureRate {
	 public int[] solution(int N, int[] stages) {
	        int[] answer = new int[N];
	        
	        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	        Map<Integer, Double> failer = new HashMap<Integer, Double>();
	        for(int userStage : stages) {
	        	map.put(userStage, map.getOrDefault(userStage, 0) + 1);
	        }
	        
	        int userCount = stages.length;
	        for(int stage = 1; stage <= N; stage++){
	        	int notClearCount =  map.getOrDefault(stage, 0);
	        	failer.put(stage, notClearCount / (double)userCount);
	        	userCount = userCount - notClearCount;
	        }
	        
	        List<Map.Entry<Integer, Double>> entryList = new LinkedList<Map.Entry<Integer, Double>>(failer.entrySet());
	        entryList.sort(Map.Entry.comparingByValue());
	        
	        int i = N-1;
	        for(Map.Entry<Integer, Double> entry : entryList) {
	        	answer[i--] = entry.getKey();
	        }
	        
	        return answer;
	 }
}
