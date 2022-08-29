package com.myproject;

//점프와 순간 이동
public class JumpAndTeleport {
  public int solution(int n) {
      int ans = 0;

      while(n == 1) {
      	n = n / 2;
          if(n % 2 != 0)
          	ans++;
      }

      return ans;
  }
}
