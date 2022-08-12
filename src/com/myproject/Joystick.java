package com.myproject;

public class Joystick {
	public int solution(String name) {
        int answer = 0;
        char[] names = name.toCharArray();
        JoystickControll controll = new JoystickControll(names.length-1);
        for(int i = 0; i < names.length; i++) {
        	answer += controll.start(names[i], i);
        }
		return answer;
       
    }
	private class JoystickControll{
		int location;
		int size;
		
		//
		int firstNumber = Character.getNumericValue('A');
        int lastNumber = Character.getNumericValue('Z');
        int middleNumber = ((lastNumber - firstNumber) + 1) / 2;
        
		public JoystickControll(int length) {
			size = length;
		}

		private int start(char alpabat, int index) {
			int move = joystickLeftToRight(alpabat, index);
			int keyPress = joystickKeypress(alpabat);
			return keyPress+move;
		}
		
		private int joystickLeftToRight(char c, int index) {
			// TODO Auto-generated method stub
			int move = 0;
			if(c == 'A') {
				if(size - index == 1) {
					move = 1;
					location = size;
				}
			}
			else {
				move = index - location;
				location += move;
				if(move - location > size - move)
					move -= location;
				
			}
			return move;
		}

		private int joystickKeypress(char c) {
			// TODO Auto-generated method stub
	        
	        int countrollCount = 0;
	        //위 조이스틱 검사
	        countrollCount = Character.getNumericValue(c) - firstNumber;
	        if(countrollCount >= middleNumber) {
	        	//아래 검사
	        	countrollCount = lastNumber - Character.getNumericValue(c) + 1;
	        }
			return countrollCount;
		}
	}

	
}
