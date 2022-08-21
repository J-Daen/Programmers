package com.myproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

//주차 요금 계산
public class ParkingFeeCalculation {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        Map<String, Integer> feeCalculation = new HashMap<String, Integer>();
        Map<String, Integer> parking = new HashMap<String, Integer>();
        
        for(String record : records) {
        	String[] data = record.split(" ");
        	String time = data[0];
        	String carNumber = data[1];
        	String history = data[2];
        	if("IN".equals(history)) {
        		int minute = getMinute(time);
        		parking.put(carNumber, minute);
        	}
        	else {
        		if(parking.containsKey(carNumber)) {
        			int historyInMinute = parking.get(carNumber);
        			int historyOutMinute = getMinute(time);
        			int parkingMinute = historyOutMinute - historyInMinute;
        			feeCalculation.put(carNumber, feeCalculation.getOrDefault(carNumber, 0) + parkingMinute);
        			parking.remove(carNumber);
        		}
        	}
        }
        
        if(parking.size() > 0)
        {
        	Set<String> set = parking.keySet();
        	String notHistory = "23:59";
        	for(String carNumber : set) {
    			int historyInMinute = parking.get(carNumber);
    			int historyOutMinute = getMinute(notHistory);
    			int parkingMinute = historyOutMinute - historyInMinute;
        		feeCalculation.put(carNumber, feeCalculation.getOrDefault(carNumber, 0) + parkingMinute);
        	}
        }
        
        List<Integer> list = new ArrayList<Integer>();
    	Object[] set = feeCalculation.keySet().toArray();
    	Arrays.sort(set);
    	for(Object carNumber : set) {
    		int minute = feeCalculation.get(carNumber);
            int fee = parkingCalculation(fees, minute);
            list.add(fee);
    	}
        return list.stream().mapToInt(i -> i).toArray();
    }
    

	private int parkingCalculation(int[] fees, int minute) {
		// TODO Auto-generated method stub
		int defaultTime = fees[0];
		int dafultFee = fees[1];
		int unitMinute = fees[2];
		int unitFee = fees[3];
		int fee = 0;
		if(minute > defaultTime)
			fee = dafultFee + (int)Math.ceil((minute - defaultTime)/(double)unitMinute) * unitFee;
		else
			fee = dafultFee;
		return fee;
	}


	private int getMinute(String time) {

		String[] timeAndMin = time.split(":");
    	int minute = (Integer.valueOf(timeAndMin[0]) * 60) + Integer.valueOf(timeAndMin[1]);
		
    	return minute;
    }
}
