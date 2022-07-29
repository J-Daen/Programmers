package com.myproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Sample {
	//행렬 테두리 회전하기 //실패
		public static int[] solution8(int rows, int columns, int[][] queries) {
			//solution8(6,6, new int[][] {{2, 2, 5, 4}, {3, 3, 6, 6}});
			int[] answer = new int[queries.length];
	        
	        //int[][] board = new int[rows][columns];
	        int[][] board = new int[rows][columns];
	        for(int row=0; row < rows; row++) {
	        	for(int col = 0; col < columns; col++) {
	        		board[row][col] = (((row+1)-1) * columns + (col+1));
	        	}
	        }
	        
	        int height = queries.length;
	        Queue<Integer> q = new LinkedList<Integer>();
	        for(int y = 0; y < height; y++) {
	            int min = 1000000000;
			 	int row1 = queries[y][0] - 1;
		        int column1 = queries[y][1] - 1;
		        int row2 = queries[y][2] - 1;
		        int column2 = queries[y][3] - 1;
		        
		        q.offer(board[row1][column1]);
		        for(int w = column1+1; w < column2; w++ ) { //위
		        	q.offer(board[row1][w]);
	        		board[row1][w] = q.remove();
	        		min = Math.min(min, board[row1][w]);
		        }
		        
		        for(int h = row1; h < row2; h++ ) { //오른쪽
		        	q.offer(board[h][column2]);
	        		board[h][column2] = q.remove();
	        		min = Math.min(min, board[h][column2]);
		        	
		        }
		        

		        for(int w = column2; w > column1; w-- ) { //오른쪽 아래
	        		q.offer(board[row2][w]);
	        		board[row2][w] = q.remove();
	        		min = Math.min(min, board[row2][w]);
		        }
		        
		        for(int h = row2; h >= row1; h-- ) { //왼쪽
		        	
		        	q.offer(board[h][column1]);
	        		board[h][column1] = q.remove();
	        		min = Math.min(min, board[h][column1]);
	        		
		        }
		        answer[y] = min;
		        q.clear();
	    	        
	        }
	        
	        return answer;
	    }
		//포켓몬
	    public int solution7(int[] nums) {
	        int answer = 0;
	        
	        int size = nums.length;
	        Set<Integer> set = new HashSet<Integer>();
	        
	        for(int num : nums) {
	        	set.add(num);
	        }
	        
	        if(size <= set.size())
	        	answer = size;
	        else
	        	answer = set.size();
	        
	        return answer;
	    }
		
		public static int solution6(int[][] board, int[] moves) {
			int[][] test = new int[][] {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2}, {3,5,1,3,1}};
			int[] test1 = new int[]{1,5,3,5,1,2,1,4};
			//solution6(test, test1);
			
			int answer = 0;
			int width = board[0].length;
			int height = board.length;
			
			Stack<Integer> resultStack = new Stack<Integer>(); 
			HashMap<Integer, Stack<Integer>> map = new HashMap<Integer, Stack<Integer>>();
			for(int w = 0; w < width; w ++) {//가로길이 만큼 task
				
				Stack<Integer> stack = new Stack<Integer>();
				
				//for(int h = height-1; h >= 0; h--) {
				for(int h = 0; h < height; h++) {
					int dollNum = board[h][w];
					if(dollNum!=0)
						stack.push(dollNum);
				}
				map.put(w+1, stack);
			}
			
			//moves 구현
			for(int move : moves) {
				Stack<Integer> stack = map.get(move);
				
				if(stack.isEmpty())
					continue;
				
				int dollNum = stack.pop();
				
				if(resultStack.isEmpty())
					resultStack.push(dollNum);
				else {
					int peekDoll = resultStack.peek();
					if(dollNum == peekDoll) {
						resultStack.pop();	
						answer+=2;
					}
					else {
						resultStack.push(dollNum);
					}
				}
			}
			
			
	        return answer;
	    }
		
		 public static int solution5(String s) {
			 	//solution5("one4seveneight");
		        int answer = 0;
		        
		        HashMap<String, String> alpa = new HashMap<String,String>();
		        alpa.put("zero", "0");
		        alpa.put("one", "1");
		        alpa.put("two", "2");
		        alpa.put("three", "3");
		        alpa.put("four", "4");
		        alpa.put("five", "5");
		        alpa.put("six", "6");
		        alpa.put("seven", "7");
		        alpa.put("eight", "8");
		        alpa.put("nine", "9");
		        
		        Set<String> keys = alpa.keySet();
		        for(String key : keys) {
		        	s = s.replace(key, alpa.get(key));
		        }
		        answer = Integer.valueOf(s);
		        return answer;
	    }
		 public static String solution4(int[] numbers, String hand) {
			//solution4(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},"left");
	        HashMap<String, int[]> numberLocation = new HashMap<String, int[]>();
	        numberLocation.put("1", new int[] {0,0});
	        numberLocation.put("2", new int[] {0,1});
	        numberLocation.put("3", new int[] {0,2});
	        numberLocation.put("4", new int[] {1,0});
	        numberLocation.put("5", new int[] {1,1});
	        numberLocation.put("6", new int[] {1,2});
	        numberLocation.put("7", new int[] {2,0});
	        numberLocation.put("8", new int[] {2,1});
	        numberLocation.put("9", new int[] {2,2});

	        numberLocation.put("*", new int[] {3,0});
	        numberLocation.put("0", new int[] {3,1});
	        numberLocation.put("#", new int[] {3,2});
	        
	        String LeftNumber = "147";
	        String rightNumber = "369";
	        
	        String sLeftHand = "*";
	        String sRightHand = "#";
	        
	        String resultString = "";
	        for(int num : numbers) {
	        	String sNumber = String.valueOf(num);
	        	if(LeftNumber.contains(sNumber)) {
	        		resultString = resultString.concat("L");	
	        		sLeftHand=sNumber;
	        		continue;
	        	}
	        	
	        	if(rightNumber.contains(sNumber)) {
	        		resultString = resultString.concat("R");	
	        		sRightHand=sNumber;
	        		continue;
	        	}
	        	
	        	//현재 입력 숫자 위치
	        	int[] input = numberLocation.get(sNumber);
	        	//손 위치 계산
	        	int[] leftHandLocation = numberLocation.get(sLeftHand);
	        	int[] rightHandLocation = numberLocation.get(sRightHand);
	        	
	        	int leftLength = locationLength(input, leftHandLocation);
	        	int rightLength = locationLength(input, rightHandLocation);
	        	
	        	if(leftLength < rightLength) {
	        		resultString = resultString.concat("L");	
	        		sLeftHand=sNumber;
	        	}else if(leftLength > rightLength) {
	        		resultString = resultString.concat("R");	
	        		sRightHand=sNumber;
	        	}
	        	else if(leftLength == rightLength) {
	        		if("right".equals(hand)) {
	            		resultString = resultString.concat("R");	
	            		sRightHand=sNumber;
	        		}
	        		else {
	            		resultString = resultString.concat("L");	
	            		sLeftHand=sNumber;
	        		}
	        	}
	        		
	        	
	        }
	        
	        return resultString;
	    }
		 public static int locationLength(int[] input, int[] HandLocation) {

	     	int x = input[0];
	     	int y = input[1];
	     	
	     	int hx = HandLocation[0];
	     	int hy = HandLocation[1];
	     	
	     	
			//int result = ((x - hx) > 0 ? x - hx : 0) + ((y - hy) > 0 ? y - hy : 0);
	     	int result = Math.abs(x - hx) + Math.abs(y - hy);
	     	
	     	return result;
		 }
		 

		//문자열 압축
		public static int solution2(String s) {
			//solution2("aaaaaaaaaaaa");
			int answer = 0;
			
			if(1==s.length())
				return 1;
			//int[] iSplits = new int[]{1,2,3,4,5,6,7,8};

			int[] iSplits = new int[s.length()];
			for(int i = 0; i < s.length(); i++) {
				iSplits[i] = i+1;
			}
			                        
			
			//List<Integer> iResults = new ArrayList<Integer>();
			Stack<Integer> iResults = new Stack<Integer>();
			for(int iSplit : iSplits){
				if(iSplit == s.length())
					continue;
				List<String> sInput = new ArrayList<String>();
				
				for(int i = 0; i < s.length(); i += iSplit){
					int lastLength = s.length() - i; 
					String sub = null;
					
					if(lastLength < iSplit)//�ڸ��� �������� ������ ���̰� ������
						sub = s.substring(i, i+lastLength);
					else
						sub = s.substring(i,i+iSplit);
						
					sInput.add(sub);
					
				}

				Stack<String> stack = new Stack<String>();
				for(int i = sInput.size(); i  > 0; i--){
					stack.push(sInput.get(i-1));
				}
				
				String search = stack.pop();
				String sResult = "";
				int dupliate = 1;
				
				while(!stack.isEmpty()){
					if(!search.equals(stack.peek())){
						if(dupliate > 1){
							String data = String.format("%d%s",dupliate ,search);
							sResult = sResult.concat(data);
							search = stack.pop();
							dupliate = 1;
						}else{
							sResult = sResult.concat(search);
							search = stack.pop();
						}
					}
					else{
						dupliate++;
						stack.pop();
					}
					
					if(stack.isEmpty()){
						if(dupliate > 1){
							String data = String.format("%d%s",dupliate ,search);
							sResult = sResult.concat(data);
						}else{
							sResult = sResult.concat(search);
						}
					}
				}
				iResults.add(sResult.length());
				
			}
			

			iResults.sort(Collections.reverseOrder());
			answer = iResults.pop();
	        return answer;
	    }
		
		 

		public static String solution1(String new_id) {
				solution1("...!@BaT#*..y.abcdefghijklm");
		        String answer = "";
		        
		        String result_id = new_id.toLowerCase(); //�ҹ��� ����
		        result_id = result_id.replaceAll("[^a-z0-9-_.]", ""); //Ư������ ����
		        result_id = result_id.replaceAll("[.]{2,}", ".");
		        result_id = result_id.replaceAll("^[.]|[.]$", "");
		        
		        //
		        result_id = result_id.replace(" ", "a");
		        
		        //
		        if(result_id.length() > 15)
		        	result_id = result_id.substring(0, 14);
		        
		        //
		        if(result_id.length() == 0)
		        	result_id = "a";
		        
		        //
		        if(result_id.length() <= 2){
		        	String lastChar = result_id.substring(result_id.length() - 1);
		        	while(result_id.length() < 3){
		        		result_id = result_id.concat(lastChar);
		        	}
		        }
		        	
		        answer = result_id;
		         
		        return answer;
		    }
}
