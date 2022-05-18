package Baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Backjoon {
	public static void main(String[] args) {
		p1052();
	}
	
	// ����: https://www.acmicpc.net/problem/15829 
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
		
		// �Է�
		for(int i=0; i<n; i++) {
			int num = scr.nextInt();
			list.add(num);
		}
		Vector<Integer> answer = new Vector<Integer>(list);
		
        int mens = list.size();
        // ū ������ ���ʴ�� ��ġ
        for(int i = mens-1; i>=0; i--) {
        	answer.add(list.get(i), mens);
        	mens--;
        }
		
        // ���
        for(int i=0; i<n; i++) {
        	System.out.print(answer.get(i) + " ");
        }
	}
	
	public static void p1051() {

		Scanner scr = new Scanner(System.in);
		int row, col;
		col = scr.nextInt();
		row = scr.nextInt();

		// �Է�
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
			// �ִ� ���̰� ���κ��� ��ٸ� ���̻� ã�� �ʾƵ� �ǹǷ� break
			if(maxLine >= col)
				break;
			
			for(int j=0; j<row; j++) {
				int cnt = 1;
				while(true) {
					// ���� ���� ���� ���� ���̸� ã�´�.
					// ������ ���α��̸� �Ѿ ��� �ݺ� Ƚ���� ���̱� ���� + ���α��̸� �ѱ��� �ʱ� ���� break�� ���
					if(cnt+i >= col || cnt+j >= row)
						break;
					
					// 4 �������� ��� ���� ��� maxLine ����
					if(square[i][j] == square[i][j+cnt])
						if(square[i+cnt][j] == square[i+cnt][j+cnt] && square[i][j] == square[i+cnt][j])
							maxLine = Math.max(maxLine, cnt);
						
					cnt++;
				}
				
			}
		}
		
		// ������ ���� maxLine�� ���̰� �ƴ� �� ���� �����̾����Ƿ� 1�� �����ش�.
		maxLine += 1;
		// ���
		System.out.println(maxLine*maxLine);
	}

	public static void p1052() {
		
		Scanner scr = new Scanner(System.in);
		int n = scr.nextInt();
		int k = scr.nextInt();
		
		// 1. �������� �ٲ۴�.
		String binary = Integer.toBinaryString(n);
		
		// 2. binary�� 1�� ������ k ���� ũ�� 3���� �ƴϸ� 0 ����
		int cnt = 0;
		for(int i=0; i< binary.length(); i++) {
			if(binary.charAt(i) == '1')
				cnt++;
		}
		
		if(cnt <= k) {
			System.out.print(0);
			return;
		}
		
		// 3. k��ŭ 1�� �̵�(0�� �׳� �ѱ�). �׸��� �� �ڸ� ���� 10������ �ٲ۴�. = goalCnt
		// ���� ��� 101101 ���� goalCnt = 100000 �̰�, hadCnt = 1101 �̴�.
		// �׸��� answer = goalCnt(100000) - hadCnt(1101) �̴�.
		// �Ʒ��� for���� '101101'�� ���ϱ� ���� �Լ��̴�.
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
		
		// 4. �� ���� �κ��� 10������ �ٲ۴�. = hadCnt
		String hadCntBin = subBin.substring(1);
		int hadCnt = Integer.parseInt(hadCntBin, 2);
		
		int goalCnt = subCnt - hadCnt;
		
		int answer = goalCnt - hadCnt;
		
		System.out.println(answer);
		
	}
}