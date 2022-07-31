package com.myproject;

import java.util.Arrays;

public class Suit {
	  public int solution(int n, int[] lost, int[] reserve) {
	        int attend = n - lost.length;
	        
	        Arrays.sort(lost);
	        Arrays.sort(reserve);
	        
        	for(int r = 0; r < reserve.length; r++) {
    	        for(int l = 0; l < lost.length; l++) {
    	        	if(reserve[r] == lost[l]) {
    	        		reserve[r] = Integer.MIN_VALUE;
    	        		lost[l] = Integer.MIN_VALUE;
                        attend++;
    	        	}
	        	}
	        }
	        
        	for(int r = 0; r < reserve.length; r++) {
        		if(reserve[r] == Integer.MIN_VALUE) continue;
    	        for(int l = 0; l < lost.length; l++) {
            		if(lost[r] == Integer.MIN_VALUE) continue;
		        	int previewNumber = reserve[r] - 1;
		        	int nextNumber = reserve[r] + 1;
		        	
		        	if(previewNumber == lost[l]) {
		        		attend++;
		        		lost[l] = Integer.MIN_VALUE;
		        		break;
		        	}
		        	if(nextNumber == lost[l]) {
		        		attend++;
		        		lost[l] = Integer.MIN_VALUE;
		        		break;
		        	}
		        }
	        }
	        
	        
	        return attend;
	    }
}
