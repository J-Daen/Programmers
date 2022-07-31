package com.myproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//완주하지 못한 선수
public class playerNotComplete {
	 public String solution(String[] participants, String[] completion) {
	        String answer = "";

	        Arrays.sort(participants);
	        Arrays.sort(completion);
	        
	        for(int i = 0; i < participants.length; i++) {
	        	if(i == completion.length){
	        		answer = participants[i];
	        		break;
	        	}
	        	if(!participants[i].equals(completion[i])) {
	        		answer = participants[i];
	        		break;
	        	}
	        }
	        
	        return answer;
	 }
}
