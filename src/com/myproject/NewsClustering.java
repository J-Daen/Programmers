package com.myproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//뉴스 클러스터링
public class NewsClustering {
    public int solution(String str1, String str2) {
        int answer = 0;
        //str1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        //str2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        String match = "^[a-zA-Z]*$";

        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        List<String> intersection = new ArrayList<String>();
        List<String> union = new ArrayList<String>();
        int index = 0;
        int splitLen = 2;
        while(splitLen <= str1.length() || splitLen <= str2.length()) {
        	if(splitLen  <= str1.length()) {
        		String data1 = str1.substring(index, splitLen);
        		if(data1.matches(match)) {
        			list1.add(data1);
        		}
        	}

        	if(splitLen  <= str2.length()) {
        		String data2 = str2.substring(index, splitLen);
        		if(data2.matches(match)) {
        			list2.add(data2);
        		}
        	}
        	index++;
        	splitLen++;
        }

        Collections.sort(list1);
        Collections.sort(list2);
        
        for(String data : list1) {
        	if(list2.remove(data))
        		intersection.add(data);
        	union.add(data);
        }
        
        for(String data : list2) {
        	union.add(data);
        }
        if(intersection.size() == union.size())
        	answer = 65536;
        else {
            double div = intersection.size() / (double) union.size();
            answer = (int) Math.abs(65536 * div);
        }
        return answer;
    }
}
