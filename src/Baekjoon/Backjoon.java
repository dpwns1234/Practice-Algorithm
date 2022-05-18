package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Backjoon {
	public static void main(String[] args) {
		p1052();
	}
	
	// 문제: https://www.acmicpc.net/problem/15829 
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
	
	public static void p1138() {
		Scanner scr = new Scanner(System.in);
		int n;
		n = scr.nextInt();
		Vector<Integer> list = new Vector<Integer>();
		
		// 입력
		for(int i=0; i<n; i++) {
			int num = scr.nextInt();
			list.add(num);
		}
		Vector<Integer> answer = new Vector<Integer>(list);
		
        int mens = list.size();
        // 큰 수부터 차례대로 배치
        for(int i = mens-1; i>=0; i--) {
        	answer.add(list.get(i), mens);
        	mens--;
        }
		
        // 출력
        for(int i=0; i<n; i++) {
        	System.out.print(answer.get(i) + " ");
        }
	}
	
	public static void p1051() {

		Scanner scr = new Scanner(System.in);
		int row, col;
		col = scr.nextInt();
		row = scr.nextInt();

		// 입력
		int[][] square = new int[col][row];
		for(int i=0; i<col; i++) {
			String line = scr.next();
			for(int j=0; j<line.length(); j++) {
				square[i][j] = line.charAt(j) - '0';
			}
		}
		
		// maxLine * maxLine = answer
		int maxLine = 0;
		
		for(int i=0; i<col; i++) {
			// 최대 길이가 세로보다 길다면 더이상 찾지 않아도 되므로 break
			if(maxLine >= col)
				break;
			
			for(int j=0; j<row; j++) {
				int cnt = 1;
				while(true) {
					// 가로 기준 가장 넓은 길이를 찾는다.
					// 하지만 세로길이를 넘어설 경우 반복 횟수를 줄이기 위해 + 가로길이를 넘기지 않기 위해 break를 사용
					if(cnt+i >= col || cnt+j >= row)
						break;
					
					// 4 꼭지점이 모두 같을 경우 maxLine 갱신
					if(square[i][j] == square[i][j+cnt])
						if(square[i+cnt][j] == square[i+cnt][j+cnt] && square[i][j] == square[i+cnt][j])
							maxLine = Math.max(maxLine, cnt);
						
					cnt++;
				}
				
			}
		}
		
		// 위에서 구한 maxLine은 길이가 아닌 그 사이 간격이었으므로 1을 더해준다.
		maxLine += 1;
		// 출력
		System.out.println(maxLine*maxLine);
	}

	public static void p1052() {
		
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int k = scr.nextInt();
		
		// 1. 이진수로 바꾼다.
		String binary = Integer.toBinaryString(n);
		
		// 2. binary의 1의 개수가 k 보다 크면 3으로 아니면 0 리턴
		int cnt = 0;
		for(int i=0; i< binary.length(); i++) {
			if(binary.charAt(i) == '1')
				cnt++;
		}
		
		if(cnt <= k) {
			System.out.print(0);
			return;
		}
		
		// 3. k만큼 1로 이동(0은 그냥 넘김). 그리고 그 자리 수를 10진수로 바꾼다. = goalCnt
		// 예를 들어 101101 에서 goalCnt = 100000 이고, hadCnt = 1101 이다.
		// 그리고 answer = goalCnt(100000) - hadCnt(1101) 이다.
		// 아래의 for문은 '101101'을 구하기 위한 함수이다.
		String subBin = null;
		for(int i=0; i<binary.length(); i++) {
			if(binary.charAt(i) == '1') {
				k--;
			}
			
			if(k==0) {
				subBin = binary.substring(i);
				break;
			}
		}
		
		int subCnt = Integer.parseInt(subBin, 2);
		
		// 4. 그 뒤의 부분을 10진수로 바꾼다. = hadCnt
		String hadCntBin = subBin.substring(1);
		int hadCnt = Integer.parseInt(hadCntBin, 2);
		
		int goalCnt = subCnt - hadCnt;
		
		int answer = goalCnt - hadCnt;
		
		System.out.println(answer);
		
	}
}