package com.myproject;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

//지갑 크기 구하기
public class MinRectangle {
	public int solution(int[][] sizes) {
        Map<Integer, Integer> rectangle = new HashMap<Integer, Integer>();
        for(int i = 0; i < sizes.length; i++) {
        	int width = sizes[i][0];
        	int height = sizes[i][1];
        	if(sizes[i][0] < sizes[i][1]){
        		width = sizes[i][1];
        		height = sizes[i][0];
        	}
        	int oldHeight = 0;
        	if(rectangle.containsKey(width)) {
        		oldHeight = rectangle.get(width); 
        	}
        		
        	if(oldHeight < height)
        		rectangle.put(width, height);
        }
        
        int maxWidth = Collections.max(rectangle.keySet());
        int maxHeight = Collections.max(rectangle.values());
        
        return maxWidth * maxHeight;
    }
}
