package com.myproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//메뉴 리뉴얼
public class MenuRenewal {
	public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        Map<Character, Integer> menu = new HashMap<Character, Integer>();
        for(String order : orders) {
        	for(char c : order.toCharArray()) {
        		menu.put(c, menu.getOrDefault(c, 0) + 1);
        	}
        }
        List<String> result = new ArrayList<String>();
    	StringBuilder sb = new StringBuilder();
    	for(String order : orders) {
            for(int i = 0; i < course.length; i++) {
            	int courseCount = course[i];
            	sb.setLength(0);
            	if(order.length() < courseCount)
            		continue;
            	for(char c : order.toCharArray()) {
            		int userSelect = menu.get(c);
            		if(userSelect >=2)
            			sb.append(c);
            		if( sb.length() >= courseCount)
            			result.add(sb.toString());
            	}
            }
        }
        
        return answer;
    }
}
