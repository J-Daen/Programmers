package com.myproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//나누어 떨어지는 숫자 배열
public class DivisorNumber {
	 public int[] solution(int[] arr, int divisor) {
	     
		 int[] answer = Arrays.stream(arr).filter(number -> number % divisor == 0).toArray();		
		 if(answer.length == 0)
			 answer = new int[]{-1};
		 
		 Arrays.sort(answer);
	     return answer;
	 }
}
