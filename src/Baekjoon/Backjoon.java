package Baekjoon;

import java.util.Scanner;

public class Backjoon {
	public static void main(String[] args) {
		solution1();
	}
	
	// ¹®Á¦: https://www.acmicpc.net/problem/15829 
	public static void solution1() {
		Scanner scr = new Scanner(System.in);
		int l, M=1234567891, r=31, charInt;
		String str;
		long H, sum = 0;
		
		l = scr.nextInt();
		str = scr.next();
		
		for(int i=0; i<l; i++)
		{
			charInt = str.charAt(i) - 'a' + 1;
			long r_i = 1;
			for(int j=0; j<i; j++)
			{
				r_i = (r_i * r) % M;
			}
			sum += (charInt * r_i) % M;
		}
		
		System.out.print(sum);
	}
}