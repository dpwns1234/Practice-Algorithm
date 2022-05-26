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
		// K번째 수
		public int[] solution1() {
			int[] array = {1, 5, 2, 6, 3, 7, 4};
			int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
			int[] answer = new int [commands.length];
	        for(int index=0; index < commands.length; index++) {
	            int i = commands[index][0];
	            int j = commands[index][1];
	            int k = commands[index][2];
	            int [] tmpList= new int [j-i+1];
	            // -1 해준 이유는 index로 변경하기 위함
	            for(int index2=i-1, tmpIndex=0; index2<=j-1; index2++, tmpIndex++) {
	                tmpList[tmpIndex] = array[index2];
	            }
	            
	            // 오름차순 정렬
	            Arrays.sort(tmpList);
	            
	            answer[index] = tmpList[k-1];
	        }
	        return answer;
		}
	}
	public static class Level2 {
		
		// 가장 큰 수
		public void solution5() {
			int [] numbers = {3, 30, 34, 5, 9};
	        String answer = "";
	        ArrayList<Integer>[] yj = new ArrayList [10];
	        
	        for(int i=0; i<10; i++)
	        	yj[i] = new ArrayList<Integer>();
	        // 앞 자리 별로 나눠 담기
	        for(int i=0; i<numbers.length; i++) {
	            int frontNum = numbers[i];
	            // 맨 앞자리 구하기
	            while(true) {
	            	if(frontNum / 10 == 0)
	                    break;
	                frontNum /= 10; 
	               
	            }
	            yj[frontNum].add(numbers[i]);
	        }
	        
	        // 각 자리별로 내림차순으로 정렬해준다.
	        for(int i=0; i<yj.length; i++) {
	            yj[i].sort(Comparator.reverseOrder());
	        }
	        
	        // 앞자리가 제일 큰 9부터 answer에 넣는다.
	        for(int i=9; i>=0; i--) {
	        	// 단, 자리수가 낮은 것들부터 넣는다.
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
		
		
		// 문제: https://programmers.co.kr/learn/courses/30/lessons/42888 소요시간-1~2시간
	    public void solution1(String[] record) {
	    	Vector<String> answer = new Vector<String>();
	    	// 설명 : Enter일 경우 answer에 name빼고 문자열만 저장 -> 마지막에 name이랑 문자열이랑 합치기
	        // Map으로 id 기록
	        HashMap<String, String> recordId = new HashMap<String, String>();
	        // 1. Enter, Leave, Change 비교 answer저장
	        for(int i=0; i<record.length; i++) {
	        	
	        	String order = record[i].split(" ")[0];
	        	String id = record[i].split(" ")[1];
	        	
	            // 2. Enter -> 저장 or 변경 / Leave -> 저장 / Change -> 변경
	        	switch(order) {
	        	case "Enter":
	        	{
	        		String name = record[i].split(" ")[2];
	        		// id가 기록된 적이 없다면(= 처음 들어온 친구) -> answer에 문자열 저장
	        		// if(recordId.get(id) == null || recordId.get(id).isEmpty())
	        		answer.add(id + "님이 들어왔습니다.");
	        		recordId.put(id, name);
	        		break;
	        	}
	        	case "Leave":
	        	{
	        		answer.add( id + "님이 나갔습니다.");
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
	        	String id = answer.get(i).split("님")[0];
	        	String name = recordId.get(id);
	        	String change = answer.get(i).replaceAll(id, name);
	        	answer.set(i, change);
	        }
	        String b = "231";

	        for(int i=0; i<answer.size(); i++) {
	        	System.out.println(answer.get(i));
	        }
	    }
	    // 문제: https://programmers.co.kr/learn/courses/30/lessons/12899 소요시간-2일
	    public void solution2(int n) {
	    	String answer = "";
	    	StringBuffer sb = new StringBuffer("");
	    	int remainder = 0;

	    	// n = 3일 때 예외처리이다. 일단 급한대로 설정하긴 했지만 나중에 수정하도록 하자.
	    	if(n==3)
                return;
	    	
	    	while(n > 0)
	    	{
	    		remainder = n % 3;
	    		sb.append(Integer.toString(remainder));
	    		n /= 3;
	    	}
	    	// 3진법에 맞게 역순으로 적절히 바꿔줌.
	    	sb = sb.reverse();
	    	// 히든케이스: 513 -> 124224
	    	for(int i=0; i<sb.length(); i++)
	    	{
	    		if(sb.charAt(i) == '0')
	    		{
	    			if(sb.charAt(i-1) == '1')
	    				{
	    					sb.setCharAt(i-1, '0');
	    					// 앞의 수를 0으로 만들었기 때문에 앞으로 다시 가서 연산.
	    					// 단, 위에서 i-1의 인덱스를 참고하고 있기 때문에 인덱스가 0으로 가는 일은 없도록 해야한다.
	    					if(i==1)
	    						continue;
	    					sb.setCharAt(i, '4');
	    					i -= 2; // for문의 i++가 있기 때문에 -2를 해준다.
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
	    	
	    	
	    	// 3진법으로 변환. 402 -> 12220 -> 12214
	    	// 10 -> 101 -> 41
//	    	10진법	124 나라	 10진법	124 나라
//	    	1	1	1  /	  6	  14	20	/	11	42	102
//	    	2	2	2  /	  7	  21	21	/	12	44	110   104 44
//	    	3	4	10 /	  8	  22	22	/	13	111	111
//	    	4	11	11 /	  9	  24	100	/	14	112	112
//	    	5	12	12 / 	 10   41	101	/	15	114	120 
	    	// 3진법의 2 -> 0 으로 가는 지점, 124진법에서 2 -> 4로 가는 지점에서 차이가 생김.
	    	// 0 앞에 1이 있으면 0을 4로, 1을 0으로 만들기 
	    	// 0 앞에 2가 있으면 0을 4로, 2를 1로 만들기. 덧셈에서 빌림과 비슷.
	    	// 0 앞에 0이 있으면 앞에 0이 없을 때까지 이동, 
	    	// 0이 없을 때까지 반복.
	    	
	    	// 513 -> 201000 -> 141000 -> 140400 -> 124400 ->
	    	// 100001 -> 04001
	    }
	    // 문제: https://programmers.co.kr/learn/courses/30/lessons/60057 소요시간-2~3시간
		public int solution3(String s) {
	        int answer = s.length();
	        String cuttingString = "";
	        // 최대로 압축해도 2개로 압축하는 것이기 때문에 이와 같이 반복
	        for(int cuttingNum=1; cuttingNum <= s.length()/2; cuttingNum++)
	        {
	        	// cnt 1로 바꾸기 왜냐면 겹치는 순간 2니까
	            int tryNum = 0;
	            int cnt = 1;	// 반복되는 앞의 숫자를 표현
	            
	            int startIndex = 0;
	            int endIndex = cuttingNum;
	            
	            while(s.length() >= endIndex)
	            {
	                cuttingString = s.substring(startIndex, endIndex);
	                // 뒤의 문자열이 남았다면 그냥 붙여준다.
	                if(endIndex + cuttingNum > s.length())
	                {
	                	// 반복되는 숫자를 계산하고 있었다면 정산해주고,
	                	if(cnt != 1)
	                		cnt = (int) Math.log10(cnt) + 1;
	                	else
	                		cnt = 0;
	                	tryNum += cuttingNum + cnt;
	                	
	    	            // 남은 숫자를 더해준다.
	                    tryNum += (s.length()-endIndex);
	                    break;
	                }
	                String nextString = s.substring(endIndex, endIndex+cuttingNum);
	                
	                // 다음 문자열과 같으면, 반복되었음을 알려줌.
	                if(cuttingString.equals(nextString))
	                	cnt++;
	                // 아니면, tryNum 갱신
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
	            // tryNum과 answer과 최소값 구하기.
                if(answer > tryNum)
                	answer = tryNum;
	        }
	        return answer;
		}
		// 문제: https://programmers.co.kr/learn/courses/30/lessons/1835 1차시도(4시간) 실패 / 
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
			
			// 인덱스로 하지 않고 그냥 숫자대로 진행하기로 함.
			for(int i=1; i<=8; i++)
			{
				// i의 자리가 비어있거나(=*) 또는 자기 자신의 자리라면 진행
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
			
			
			// n > 일 경우 (초과)
			cnt = 0;
			// me 늘리기 반복문
			for(int i=1; i<=8; i++)
			{
				// another 늘리기 반복문
				for(int j=signNum2; j<7; j++)
				{				
					int distance = j + 1;
					
					line.setCharAt(i, me2);
					// another이 배치될 수 있다면 cnt++;
					if(i+distance <= 8)
					{
						line.setCharAt(i+distance, another2);
						cnt++;
					}
					// line 초기화
					
					// another이 뒤쪽으로 배치될 수 있다면 cnt++;
					if(i-distance >= 1)
					{
						line.setCharAt(i-distance, another2);
						cnt++;
					}
					// line 초기화
					
				}
			}
			
			
			// < n 일 경우(미만)
			cnt=0;
			
			// me가 한 칸씩 이동 
			for(int i=1; i<=8; i++)
			{
				// another가 me한테로 한 칸씩 이동
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


