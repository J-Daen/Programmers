package com.myproject;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveSmallestNumber {
	public int[] solution(int[] arr) {

		if(arr.length == 1)
			return new int[] {-1};
		
        Set<Integer> set = new LinkedHashSet<Integer>();
        for(int i : arr) {
        	set.add(i);
        }
        
        int min = Collections.min(set);
        set.remove(min);
        
        
        return set.stream().mapToInt(i -> i).toArray();
    }
}
