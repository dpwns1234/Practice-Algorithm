package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;
import java.util.Comparator;


class Pair implements Comparable<Pair> {
    int originNum;
    int thousandNum;
    
    public Pair(int originNum, int thousandNum) {
        this.originNum = originNum;
        this.thousandNum = thousandNum;
    }
    
    public int getOriginNum() {
        return this.originNum;
    }
    
    public int getSize() {
    	return this.getSize();
    }
    
    @Override
    public int compareTo(Pair pair) {
        if(pair.thousandNum < thousandNum)
            return 1;
        else if (pair.thousandNum > thousandNum)
            return -1;
        else 
            return 0;
    }
}


class Programmers {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		Level2 level2 = new Level2(); 
		level2.solution5();
		//System.out.println(answer);
//		Level1 level1 = new Level1();
//		int [] answer2 = level1.solution1();

		return;
	}

	public static class Level1 {
		// K��° ��
		public int[] solution1() {
			int[] array = {1, 5, 2, 6, 3, 7, 4};
			int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
			int[] answer = new int [commands.length];
	        for(int index=0; index < commands.length; index++) {
	            int i = commands[index][0];
	            int j = commands[index][1];
	            int k = commands[index][2];
	            int [] tmpList= new int [j-i+1];
	            // -1 ���� ������ index�� �����ϱ� ����
	            for(int index2=i-1, tmpIndex=0; index2<=j-1; index2++, tmpIndex++) {
	                tmpList[tmpIndex] = array[index2];
	            }
	            
	            // �������� ����
	            Arrays.sort(tmpList);
	            
	            answer[index] = tmpList[k-1];
	        }
	        return answer;
		}
	}
	public static class Level2 {
		
		// ���� ū ��
		public void solution5() {
			int [] numbers = {3, 30, 34, 5, 9};
	        String answer = "";
	        ArrayList<Integer>[] yj = new ArrayList [10];
	        
	        for(int i=0; i<10; i++)
	        	yj[i] = new ArrayList<Integer>();
	        // �� �ڸ� ���� ���� ���
	        for(int i=0; i<numbers.length; i++) {
	            int frontNum = numbers[i];
	            // �� ���ڸ� ���ϱ�
	            while(true) {
	            	if(frontNum / 10 == 0)
	                    break;
	                frontNum /= 10; 
	               
	            }
	            yj[frontNum].add(numbers[i]);
	        }
	        
	        // �� �ڸ����� ������������ �������ش�.
	        for(int i=0; i<yj.length; i++) {
	            yj[i].sort(Comparator.reverseOrder());
	        }
	        
	        // ���ڸ��� ���� ū 9���� answer�� �ִ´�.
	        for(int i=9; i>=0; i--) {
	        	// ��, �ڸ����� ���� �͵���� �ִ´�.
	        	for(int exp=1; exp<=3; exp++) {
		            for(int j=0; j<yj[i].size(); j++) {
		            	 if(yj[i].get(j) / (int) Math.pow(10, exp) == 0) {
	                        answer += Integer.toString(yj[i].get(j));
	                        yj[i].remove(j);
		            	 }
		            }
	        	}
	        
	        }
	        
	        System.out.println(answer);
	        
		}
		
		
		// ����: https://programmers.co.kr/learn/courses/30/lessons/42888 �ҿ�ð�-1~2�ð�
	    public void solution1(String[] record) {
	    	Vector<String> answer = new Vector<String>();
	    	// ���� : Enter�� ��� answer�� name���� ���ڿ��� ���� -> �������� name�̶� ���ڿ��̶� ��ġ��
	        // Map���� id ���
	        HashMap<String, String> recordId = new HashMap<String, String>();
	        // 1. Enter, Leave, Change �� answer����
	        for(int i=0; i<record.length; i++) {
	        	
	        	String order = record[i].split(" ")[0];
	        	String id = record[i].split(" ")[1];
	        	
	            // 2. Enter -> ���� or ���� / Leave -> ���� / Change -> ����
	        	switch(order) {
	        	case "Enter":
	        	{
	        		String name = record[i].split(" ")[2];
	        		// id�� ��ϵ� ���� ���ٸ�(= ó�� ���� ģ��) -> answer�� ���ڿ� ����
	        		// if(recordId.get(id) == null || recordId.get(id).isEmpty())
	        		answer.add(id + "���� ���Խ��ϴ�.");
	        		recordId.put(id, name);
	        		break;
	        	}
	        	case "Leave":
	        	{
	        		answer.add( id + "���� �������ϴ�.");
	        		break;
	        	}
	        	    		
	        	case "Change":
	        	{
	        		String name = record[i].split(" ")[2];
	        		recordId.put(id, name);
	        		break;
	        	}	
	        	default:
	        		break;
	        	}
	        }
	        
	        for(int i=0; i<answer.size(); i++)
	        {
	        	String id = answer.get(i).split("��")[0];
	        	String name = recordId.get(id);
	        	String change = answer.get(i).replaceAll(id, name);
	        	answer.set(i, change);
	        }
	        String b = "231";

	        for(int i=0; i<answer.size(); i++) {
	        	System.out.println(answer.get(i));
	        }
	    }
	    // ����: https://programmers.co.kr/learn/courses/30/lessons/12899 �ҿ�ð�-2��
	    public void solution2(int n) {
	    	String answer = "";
	    	StringBuffer sb = new StringBuffer("");
	    	int remainder = 0;

	    	// n = 3�� �� ����ó���̴�. �ϴ� ���Ѵ�� �����ϱ� ������ ���߿� �����ϵ��� ����.
	    	if(n==3)
                return;
	    	
	    	while(n > 0)
	    	{
	    		remainder = n % 3;
	    		sb.append(Integer.toString(remainder));
	    		n /= 3;
	    	}
	    	// 3������ �°� �������� ������ �ٲ���.
	    	sb = sb.reverse();
	    	// �������̽�: 513 -> 124224
	    	for(int i=0; i<sb.length(); i++)
	    	{
	    		if(sb.charAt(i) == '0')
	    		{
	    			if(sb.charAt(i-1) == '1')
	    				{
	    					sb.setCharAt(i-1, '0');
	    					// ���� ���� 0���� ������� ������ ������ �ٽ� ���� ����.
	    					// ��, ������ i-1�� �ε����� �����ϰ� �ֱ� ������ �ε����� 0���� ���� ���� ������ �ؾ��Ѵ�.
	    					if(i==1)
	    						continue;
	    					sb.setCharAt(i, '4');
	    					i -= 2; // for���� i++�� �ֱ� ������ -2�� ���ش�.
	    					continue;
	    				}
	    			
	    			else if(sb.charAt(i-1) == '2')
	    				sb.setCharAt(i-1, '1');
	    			
	    			else if(sb.charAt(i-1) == '4')
	    				sb.setCharAt(i-1, '2');
	    				
	    			sb.setCharAt(i, '4');
	    		}
	    	}
	    	
	    	answer = sb.toString();
	    	answer = answer.replace("0", "");
	    	System.out.println(answer);
	    	
	    	
	    	// 3�������� ��ȯ. 402 -> 12220 -> 12214
	    	// 10 -> 101 -> 41
//	    	10����	124 ����	 10����	124 ����
//	    	1	1	1  /	  6	  14	20	/	11	42	102
//	    	2	2	2  /	  7	  21	21	/	12	44	110   104 44
//	    	3	4	10 /	  8	  22	22	/	13	111	111
//	    	4	11	11 /	  9	  24	100	/	14	112	112
//	    	5	12	12 / 	 10   41	101	/	15	114	120 
	    	// 3������ 2 -> 0 ���� ���� ����, 124�������� 2 -> 4�� ���� �������� ���̰� ����.
	    	// 0 �տ� 1�� ������ 0�� 4��, 1�� 0���� ����� 
	    	// 0 �տ� 2�� ������ 0�� 4��, 2�� 1�� �����. �������� ������ ���.
	    	// 0 �տ� 0�� ������ �տ� 0�� ���� ������ �̵�, 
	    	// 0�� ���� ������ �ݺ�.
	    	
	    	// 513 -> 201000 -> 141000 -> 140400 -> 124400 ->
	    	// 100001 -> 04001
	    }
	    // ����: https://programmers.co.kr/learn/courses/30/lessons/60057 �ҿ�ð�-2~3�ð�
		public int solution3(String s) {
	        int answer = s.length();
	        String cuttingString = "";
	        // �ִ�� �����ص� 2���� �����ϴ� ���̱� ������ �̿� ���� �ݺ�
	        for(int cuttingNum=1; cuttingNum <= s.length()/2; cuttingNum++)
	        {
	        	// cnt 1�� �ٲٱ� �ֳĸ� ��ġ�� ���� 2�ϱ�
	            int tryNum = 0;
	            int cnt = 1;	// �ݺ��Ǵ� ���� ���ڸ� ǥ��
	            
	            int startIndex = 0;
	            int endIndex = cuttingNum;
	            
	            while(s.length() >= endIndex)
	            {
	                cuttingString = s.substring(startIndex, endIndex);
	                // ���� ���ڿ��� ���Ҵٸ� �׳� �ٿ��ش�.
	                if(endIndex + cuttingNum > s.length())
	                {
	                	// �ݺ��Ǵ� ���ڸ� ����ϰ� �־��ٸ� �������ְ�,
	                	if(cnt != 1)
	                		cnt = (int) Math.log10(cnt) + 1;
	                	else
	                		cnt = 0;
	                	tryNum += cuttingNum + cnt;
	                	
	    	            // ���� ���ڸ� �����ش�.
	                    tryNum += (s.length()-endIndex);
	                    break;
	                }
	                String nextString = s.substring(endIndex, endIndex+cuttingNum);
	                
	                // ���� ���ڿ��� ������, �ݺ��Ǿ����� �˷���.
	                if(cuttingString.equals(nextString))
	                	cnt++;
	                // �ƴϸ�, tryNum ����
	                else
	                {
	                	if(cnt != 1)
	                		cnt = (int) Math.log10(cnt) + 1;
	                	else
	                		cnt = 0;
	                	tryNum += cuttingNum + cnt;
	                	
	                	cnt=1;
	                }
	                
	                startIndex = endIndex;
	                endIndex += cuttingNum;
	                
	            }
	            // tryNum�� answer�� �ּҰ� ���ϱ�.
                if(answer > tryNum)
                	answer = tryNum;
	        }
	        return answer;
		}
		// ����: https://programmers.co.kr/learn/courses/30/lessons/1835 1���õ�(4�ð�) ���� / 
		public int solution4(String[] data) {
			int answer = 0;
			int cnt = 0;
			StringBuffer line = new StringBuffer("***********");
			
			String me = "N";
			String another = "F";
			String sign = "=";
			int signNum = 0;
			
			char me2 = 'R';
			char another2 = 'T';
			String sign2 = ">";
			int signNum2 = 2;
			
			// �ε����� ���� �ʰ� �׳� ���ڴ�� �����ϱ�� ��.
			for(int i=1; i<=8; i++)
			{
				// i�� �ڸ��� ����ְų�(=*) �Ǵ� �ڱ� �ڽ��� �ڸ���� ����
				if(line.charAt(i) == '*' || line.charAt(i) == me2)
					line.setCharAt(i, me2);
				else
					continue;
				
				// for runtime error
				if(i+signNum2 > 8)
					break;
				
				//for(int j=0; j<)
				if(line.charAt(i+signNum2) == '*' || line.charAt(i+signNum2) == another2)
					line.setCharAt(i+signNum2, another2);
				else
					continue;
				
				cnt++;
			}
			
			
			// n > �� ��� (�ʰ�)
			cnt = 0;
			// me �ø��� �ݺ���
			for(int i=1; i<=8; i++)
			{
				// another �ø��� �ݺ���
				for(int j=signNum2; j<7; j++)
				{				
					int distance = j + 1;
					
					line.setCharAt(i, me2);
					// another�� ��ġ�� �� �ִٸ� cnt++;
					if(i+distance <= 8)
					{
						line.setCharAt(i+distance, another2);
						cnt++;
					}
					// line �ʱ�ȭ
					
					// another�� �������� ��ġ�� �� �ִٸ� cnt++;
					if(i-distance >= 1)
					{
						line.setCharAt(i-distance, another2);
						cnt++;
					}
					// line �ʱ�ȭ
					
				}
			}
			
			
			// < n �� ���(�̸�)
			cnt=0;
			
			// me�� �� ĭ�� �̵� 
			for(int i=1; i<=8; i++)
			{
				// another�� me���׷� �� ĭ�� �̵�
				for(int j=signNum2; j>=1; j--)
				{
					int distance = j;
					
					if(i+distance <= 8)
					{
						line.setCharAt(i, me2);
						line.setCharAt(i+distance, another2);
						cnt++;
					}
					
					if(i-distance >= 1)
					{
						line.setCharAt(i, another2);
						line.setCharAt(i+distance, me2);
						cnt++;
					}
				}
			}
			
			answer = cnt;
			return answer;
		}
	
	}
}


