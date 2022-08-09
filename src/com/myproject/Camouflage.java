package com.myproject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//위장
public class Camouflage {
	public int solution(String[][] clothes) {
        Map<String, Integer> dressMap = new HashMap<String, Integer>();
        for(int h = 0; h < clothes.length; h++) {
        	String key = clothes[h][1];
        	dressMap.put(key, dressMap.getOrDefault(key, 1) + 1);
        }
        
        int answer = 1;
        Set<String> keys = dressMap.keySet();
        for(String key : keys) {
            answer *= dressMap.get(key);
        }
        
        return answer -1;
    }
}
