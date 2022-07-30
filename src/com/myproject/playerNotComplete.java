package com.myproject;

import java.util.ArrayList;
import java.util.List;

//완주하지 못한 선수
public class playerNotComplete {
	 public String solution(String[] participants, String[] completion) {
	        String answer = "";
	        
	        for(String completPlayer : completion) {
	        	for(int i = 0; i < participants.length; i++) {
	        		if("".equals(participants[i]))
	        			continue;
	        		
	        		if(completPlayer.equals(participants[i]))
	        			participants[i] = "";
	        	}
	        }
	        
	        for(String player : participants) {
	        	if(!"".equals(player)) {
	        		answer = player;
	        		break;
	        	}
	        		
	        }
	        
	        return answer;
	 }
}
