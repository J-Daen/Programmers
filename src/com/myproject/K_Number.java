package com.myproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class K_Number {
	public Integer[] solution(int[] array, int[][] commands) {
		array = new int[] {1, 5, 2, 6, 3, 7, 4};
		commands = new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		int rows = commands.length;
		
		Integer[] answer = new Integer[rows];
		List<Integer> split = new ArrayList<Integer>();
		for(int row = 0; row < rows; row++) {
			split.clear();
			int start = commands[row][0] - 1;
			int end = commands[row][1] -1;
			int location =commands[row][2] -1;
			
			for(int i = start; start <= end; i++ ) {
				split.add(array[i]);
			}
			
			Collections.sort(split);
			answer[row] = split.get(location);
		}
			
		
        return answer;
    }
}
