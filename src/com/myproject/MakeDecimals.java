package com.myproject;

//소수 만들기
public class MakeDecimals {
	public int solution(int[] nums) {
        int answer = 0;

        int size = nums.length;
        for(int one = 0; one < size - 2; one++ ){
        	for(int two = one + 1; two < size -1; two++){
        		for(int three = two + 1; three < size; three++) {
        			int sum = nums[one] + nums[two] + nums[three];
        			if(isPrime(sum))
        				answer++;
        		}
        	}
        }
        
        return answer;
    }

	private boolean isPrime(int sum) {
		// TODO Auto-generated method stub
		for(int i = 2; i*i<=sum; i++) {
			if(sum % i == 0)
				return false; //소수가 아님
		}
		return true;
	}
}
