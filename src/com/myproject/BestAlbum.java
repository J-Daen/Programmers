package com.myproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BestAlbum {
	
	 public int[] solution(String[] genres, int[] plays) {
	        Map<String, Genres> sumGenresPlay = new HashMap<String, Genres>();
	        
	        int size = genres.length;
	        for(int i  = 0; i < size; i++) {
	        	//장르별 최대 play 횟수
	        	Genres genre = null;
	        	if(!sumGenresPlay.containsKey(genres[i])) {
	        		genre = new Genres();
	        	}
	        	else {
	        		genre = sumGenresPlay.get(genres[i]);
	        	}

        		genre.playMap.put(i, plays[i]);
        		genre.sumPlay += plays[i];
        		sumGenresPlay.put(genres[i], genre);
	        }
	        
	        List<Map.Entry<String, Genres>> sumGenresPlayList = new LinkedList<Map.Entry<String, Genres>>(sumGenresPlay.entrySet());
	        sumGenresPlayList.sort(new Genres());
	        
	        List<Integer> result = new ArrayList<Integer>();
	        for(Map.Entry<String, Genres> entry : sumGenresPlayList) {
	        	Genres genre = entry.getValue();
	        	List<Map.Entry<Integer, Integer>> playList = new LinkedList<Map.Entry<Integer, Integer>>(genre.playMap.entrySet());
	        	playList.sort(new MapComparator());
	        	
	        	int count = 1;
	        	for(Map.Entry<Integer, Integer> entry1 : playList) {
	        		if(count > 2)
	        			break;
	        		result.add(entry1.getKey());
	        		count++;
	        	}
	        }
	        
	        return result.stream().mapToInt(i -> i).toArray();
	 }
	 
	 public class MapComparator implements Comparator<Map.Entry<Integer, Integer>>{
		@Override
		public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
			// TODO Auto-generated method stub
			return o2.getValue().compareTo(o1.getValue());
		}
		 
	 }
	 
	 public class Genres implements Comparator<Map.Entry<String, Genres>>{
		 int sumPlay = 0;
		 Map<Integer, Integer> playMap = new HashMap<Integer, Integer>();
		@Override
		public int compare(Map.Entry<String, Genres> o1, Map.Entry<String, Genres> o2) {
			// TODO Auto-generated method stub
			return o2.getValue().sumPlay - o1.getValue().sumPlay;
		}
	 }
	 /*
	 public int[] solution(String[] genres, int[] plays) {
	        int[] answer = {};
	        
	        Map<String, Integer> sumGenresPlay = new HashMap<String, Integer>();
	        Map<String, Map<String, Integer>> genresPlay = new HashMap<String, Map<String, Integer>>();
	        Map<String, Integer> playCount = new HashMap<String, Integer>();
	        
	        int size = genres.length;
	        for(int i  = 0; i < size; i++) {
	        	//장르별 최대 play 횟수
	        	sumGenresPlay.put(genres[i], sumGenresPlay.getOrDefault(genres[i], 0) + plays[i]);
	        	
	        	//play 횟수
	        	playCount.put(String.valueOf(i), plays[i]);
	        	
	        	//장르별 플레이 등록
	        	genresPlay.put(genres[i], playCount);
	        }
	        
	        List<Map.Entry<String, Integer>> sumGenresPlayList = new LinkedList<Map.Entry<String, Integer>>(sumGenresPlay.entrySet());
	        sumGenresPlayList.sort(new MapComparator());
	        
	        List<Integer> result = new ArrayList<Integer>();
	        for(Map.Entry<String, Integer> entry : sumGenresPlayList) {
	        	Map<String, Integer> play = genresPlay.get(entry.getKey());
	        	List<Map.Entry<String, Integer>> playList = new LinkedList<Map.Entry<String, Integer>>(play.entrySet());
	        	playList.sort(new MapComparator());
	        	
	        	int count = 1;
	        	for(Map.Entry<String, Integer> entry1 : playList) {
	        		if(count > 2)
	        			break;
	        		result.add(Integer.valueOf(entry1.getKey()));
	        	}
	        }
	        
	        return result.stream().mapToInt(i -> i).toArray();
	 }
	 */
}
