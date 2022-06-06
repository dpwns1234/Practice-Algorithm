package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Vector;
import java.util.stream.Collectors;


class Pair implements Comparable<Pair> {
	private int originNum;
	private int changedNum;
	
	public Pair(int originNum, int changedNum) {
		this.originNum = originNum;
		this.changedNum = changedNum;
	}

	@Override
	public int compareTo(Pair pair) {
		if(this.changedNum > pair.changedNum)
			return 1;
		else if (this.changedNum < pair.changedNum)
			return -1;
		else 
			return 0;
	}
	
	public int getOriginNum() {
		return this.originNum;
	}
}

class Programmers {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		Level1 level1 = new Level1();
		Level2 level2 = new Level2(); 
		//level1.solution2();
		level2.solution11();
		
		//System.out.println(answer);
//		Level1 level1 = new Level1();
//		int [] answer2 = level1.solution1();

		return;
	}

	public static class Level1 {
		
		// 모의고사
		public void solution2() {
			int[] answers = {1,2,3,4,5};
	        int[] answer = {};
	        
	        // pattern
	        int [][] supoja = {{1, 2, 3, 4, 5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};
	        
	        int[] answersNum = new int [3];
	        int maxNum = 0;
	        
	        for(int i=0; i<supoja.length; i++) {
	        	int num = 0;
	        	int supojaIndex = 0;
	            int answerIndex = 0;
	            // 각 최소공배수 만큼 반복
	            for(int j=0; j<answers.length; j++) {
	                // index가 length를 넘지 않도록
	                if(supoja[i].length == supojaIndex)
	                    supojaIndex = 0;
	                if(answers.length == answerIndex)
	                    answerIndex = 0;
	                
	                if(supoja[i][supojaIndex++] == answers[answerIndex++])
	                    num++;
	            }

	            answersNum[i] = num;
	            maxNum = Math.max(maxNum, num);
	            
	        }        
	        ArrayList<Integer> answer2 = new ArrayList<Integer>();
	        for(int i=0; i<answersNum.length; i++) {
	            if(maxNum == answersNum[i])
	                answer2.add(i+1);
	        }
	        
	        answer = new int [answer2.size()];
	        for(int i=0; i<answer2.size(); i++) {
	            answer[i] = answer2.get(i);
	        }
	        
	        for(int i=0; i<answer.length; i++) {
		        System.out.println(answer[i]);
	        }
		}
		
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
		class GenreInf {
			public Integer sum = 0;
			public int firstPlay = -1;
			public int firstNum = -1;
			public int secondPlay = -1;
			public int secondNum = -1;
			public GenreInf() {
				
			}
		}
		// 중복을 피하기 위해, 011 등 앞의 0이 붙은 것을 피하기 위해 map을 사용한다.
		HashMap<Integer, Boolean> map = new HashMap<>();
		// 소수 찾기
		public void solution11() {
			ArrayList<Integer> numbersList = new ArrayList<>();
			String numbers = "00000211";
			int answer = 0;
			
			// String -> ArrayList<Integer>
			int num = Integer.parseInt(numbers);
			while(num != 0) {
				numbersList.add(num%10);
				num /= 10;
			}
			// 숫자 앞에 0 이 붙여져 있다면 그것들을 모두 numbersList에 더해준다.
			for(int i=0; i<numbers.length(); i++) {
				if(numbers.charAt(i) == '0') {
					numbersList.add(0);
				}
				else
					break;
			}
			
			
			for(int i=1; i<=numbersList.size(); i++) {
				recursive(numbersList, 0, i);
			}
			numbersList.clear();
			// map -> ArrayList<Integer>
			for(Integer value : map.keySet())
				numbersList.add(value);
			
			// 이제 소수 찾기
			for(int value : numbersList) {
				if(isPrimeNum(value)) 
					answer++;
			}
			
			System.out.print(isPrimeNum(1));
			
		}
		
		// digits = 자리수. 예를들어 digits = 4이면 4자리 수의 모든 조합을 얻는다.
		public void recursive(ArrayList<Integer> array, int value, int digits) {
			if(digits == (int) (Math.log10(value)) + 1) {
				map.put(value, true);
				return;
			}
			else {
				for(int i=0; i<array.size(); i++) {
					ArrayList<Integer> tmp = new ArrayList<>(array);
					// 1234 만들고 다시 123으로 돌아왔을 때 1243을 만들기 위해
					if(i != 0)
						value = value / 10;
					value *= 10;
					value = value + array.get(i);
					tmp.remove(i);
					recursive(tmp, value, digits);
				}
			}
		}
		
		// 소수 찾기 function
		public boolean isPrimeNum(int value) {
			if(value < 2) return false;
			
			for(int i=2; i*i<=value; i++){
	            if(value % i == 0) return false;
	        }
	        return true;
		}
		
		public void solution10() {
			String [] genres = {"classic", "pop", "classic", "classic", "pop"};
			int [] plays = {500, 600, 150, 800, 2500};
	        ArrayList<Integer> answer = new ArrayList<>();
	        HashMap<String, GenreInf> map = new HashMap<>();
	        
	        for(int i=0; i<genres.length; i++) {
	            String genre = genres[i];
	            int play = plays[i];
	            // 새로운 장르 곡이라면
	            if(!map.containsKey(genre)) {
	            	GenreInf inf = new GenreInf();
	            	inf.sum += play;
	            	inf.firstPlay = play;
	            	inf.firstNum = i;
	                map.put(genre, inf);
	            }
	            else {
	            	GenreInf inf = map.get(genre);
                	inf.sum += play;
                	
	                // 새로 들어온 play 수와 firstPlay의 수를 비교한다.
	                if(play > inf.firstPlay) {
	                	// first의 내용을 second로 옮겨준다.
	                	inf.secondPlay = inf.firstPlay;
	                	inf.secondNum = inf.firstNum;
	                    
	                    // first에 새로 들어온 값을 넣어준다.
	                	inf.firstPlay = play;
	                	inf.firstNum = i;
	                	
	                	map.put(genre, inf);
	                }
	                // 1순위보다 작고 + 2순위가 있다면
	                else if (inf.secondPlay != -1){
	                    // 새로 들어온게 2순위보다 크다면
	                    if (play > inf.secondPlay) {
	                    	inf.secondPlay = play;
	                    	inf.secondNum = i;
	                    }
	                    // 작으면 추가하지 않고 넘어가기.
	                    
	                }
	                // 1순위보다 작은데 2순위가 없다면
	                else {
	                	inf.secondPlay = play;
	                	inf.secondNum = i;
	                }
	            }
	            
	        }
	      
	        ArrayList<String> genreListOrdered = new ArrayList<>(map.keySet());
	        // 내림차순으로 정렬
	        Collections.sort(genreListOrdered, (value1, value2) ->
	                        map.get(value2).sum.compareTo(map.get(value1).sum));
	        
	        for(String genre : genreListOrdered) {
	            int num1 = map.get(genre).firstNum;
	            answer.add(num1);
	            int num2 = map.get(genre).secondNum;
	            if(num2 != -1) {
		            answer.add(num2);
	            }
	        }
	        int [] answer2 = new int [answer.size()];
	        // convert
	        for(int i=0; i<answer.size(); i++) {

		        System.out.print(answer.get(i) + " ");
	            answer2[i] = answer.get(i);
	        }
		}
		
		public void solution9() {
			String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
	        int answer = 1;
	        HashMap<String, Integer> map = new HashMap<>();
	        int typeNum = 0; // 종류(type) 개수
	        
	        for(String[] elements: clothes) {
	            String name = elements[0];
	            String type = elements[1];
	            if(map.containsKey(type)) {
	                int num = map.get(type);
	                num++;
	                map.put(type, num);
	            }
	            else {
	                map.put(type, 1);
	                typeNum++;
	            }
	        }
	        for(String type : map.keySet()) {
	            int num = map.get(type);
	            answer *= (num + 1); 
	        }
	        
	        answer -= 1;
	        
	        System.out.println(answer);
	    }
		
		// 전화번호 목록
		public void solution8() {
			String [] phone_book = {"119", "97674223", "1195524421"};
			boolean answer = true;
	        Arrays.sort(phone_book);
	        
	        for(int i=0; i<phone_book.length-1; i++) {
	            if(phone_book[i+1].startsWith(phone_book[i])){
	                answer = false;
	                break;
	            }
	        }
	        
	        System.out.println(answer);
		}
		
		// 완주하지 못한 선수
		public void solution7() {
	        String answer = "";
	        String[] participant = {"leo", "kiki", "eden"};
	        String[] completion = {"eden", "kiki"};
	        
	        HashMap<String, Integer> map = new HashMap<>();
	        
	        // 완주자명단 -> map 으로 변환
	        for(int i=0; i<completion.length; i++) {
	            // 동명이인일 경우
	            if(map.containsKey(completion[i])) {
	                int num = map.get(completion[i]);
	                num++;
	                map.put(completion[i], num);
	            }
	            else
	                map.put(completion[i], 1);
	        }
	        
	        // 불 완주자 찾기
	        for(int i=0; i<participant.length; i++) {
	        	// 완주자 명단에 없다면
	            if(!map.containsKey(participant[i])){
	                answer = participant[i];
	                break;
	            }
	            // 동명이인 처리
	            else {
	                int num = map.get(participant[i]);
	                num--;
	                
	                if(num < 0) {
	                	answer = participant[i];
	                	break;
	                }
	                map.put(participant[i], num);
	            }
	        }
	        
	        System.out.println(answer);
		}
		
		// H-Index
		public void solution6() {
			int answer = 0;
			int [] citations = {10,10,10,10,10};
	        int size = citations.length;
	        
	        for(int i=0; i<size; i++) {
	            int h = size - i, moreNum = 0, lessNum = 0;
	            for(int j=0; j<size; j++) {
	                // 인용횟수가 h보다 클 경우
	                if(citations[j] >= h)
	                    moreNum++;
	            }
	            lessNum = size - moreNum;
	            
	            // (인용횟수가 h보다 큰)인용 논문이 h보다 클 경우 + 
	            // (인용횟수가 h보다 작은)인용 논문이 h보다 작을 경우
	            if(moreNum >= h && lessNum <= h) {
	                answer = h;
	                break;
	            }
	        }
	            
	        System.out.println(answer);
		}
		
		// 가장 큰 수
		public void solution5() {
			int [] numbers = {0,0, 1, 0};
	        String answer = "";
	        ArrayList<Pair> pairList = new ArrayList<>();
	        for(int i=0; i<numbers.length; i++) {
	        	int divisor = 0;
	            // number가 0일 경우 Log를 취하면 infinity가 나오기 때문
	            if(numbers[i] != 0)
	                divisor = (int) Math.log10(numbers[i]);
	            switch(divisor) {
	            	// 일의 자리 수
	                case 0:
	                    pairList.add(new Pair(numbers[i], numbers[i] * 1000 + numbers[i] * 100 + numbers[i] * 10 + numbers[i]) );
	                    break;
	                case 1:
	                    pairList.add(new Pair(numbers[i], numbers[i] * 100 + numbers[i]));
	                    break;
	                case 2:
	                    pairList.add(new Pair(numbers[i], numbers[i] * 10 + numbers[i]/100));
	                    break;
	                case 3:
	                    pairList.add(new Pair(numbers[i], numbers[i]));
	                    break;
		            }
	        }
	        // 정렬
	        Collections.sort(pairList, Collections.reverseOrder());

	        for(int i=0; i<pairList.size(); i++) {
	            answer += Integer.toString(pairList.get(i).getOriginNum());
	        }
	        // "000000" 이런 경우 -> "0"으로 만들기
	        if(answer.charAt(0) == '0')
	            answer = "0";
	        
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


