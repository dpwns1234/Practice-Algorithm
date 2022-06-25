package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
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
		Level3 level3 = new Level3();
		//level1.specialSolution();
		//level2.solution21();
		//level3.solution2();
		//System.out.println(a);
		//System.out.println(answer);
//		Level1 level1 = new Level1();
//		int [] answer2 = level1.solution1();

		return;
	}

	public static class Level1 {
		
		// ���̹� �ν�Ʈķ�� �ڰ����� �Լ� ����
		public void specialSolution() {
			String s = "22";
			int[] arr = {1, 2, 3, 3, 3, 3, 4, 4};
			HashMap<Integer, Integer>map = new HashMap<Integer, Integer>();
			int answerSize = 0;
			for(int key : arr) {
				int value = 1;
				// �ߺ��� ��� value�� 1 ���������ش�.
				if(map.containsKey(key)) {
					value = map.get(key);
					value++;
					if(value == 2)
						answerSize++;
				}
				map.put(key, value);
			}
			
			
			int[] answer0;
			if(answerSize == 0) {
				answer0 = new int[1];
				answer0[0] = -1;
			}
			else {
				int i=0;
				answer0 = new int [answerSize];
				for(Integer key : arr) {
					// map.remove �� ����߱� ������ null ���� ����
					if(!map.containsKey(key))
						continue;
					if(map.get(key) != 1) {
						answer0[i++] = map.get(key);
						map.remove(key);	// �� �� ���� ������ �� �� �������� �ʱ� ���ؼ� ����
					}
				}
			}
			
			for(int e : answer0) {
				System.out.print(e + " ");
			}
		}
		
		// �Ҽ� �����
		public void solution3() {
			int answer = 0;
			int[] nums = {1,2,7,6,4};
	        for(int i=0; i<nums.length-2; i++) {
	            for(int j=i+1; j<nums.length-1; j++) {
	                for(int k=j+1; k<nums.length; k++) {
	                    int sum = nums[i] + nums[j] + nums[k];
	                    if(isPrime(sum))
	                        answer++;
	                    
	                }
	            }
	        }
	        System.out.println(answer);
	    }
	    
	    public boolean isPrime(int num) {
	        if(num == 0 || num == 1)
	            return false;
	        for(int i=2; i<=Math.sqrt(num); i++) {
	            if(num % i == 0)
	                return false;
	        }
	        
	        return true;
	    }
		
		// ���ǰ��
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
	            // �� �ּҰ���� ��ŭ �ݺ�
	            for(int j=0; j<answers.length; j++) {
	                // index�� length�� ���� �ʵ���
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
		class GenreInf {
			public Integer sum = 0;
			public int firstPlay = -1;
			public int firstNum = -1;
			public int secondPlay = -1;
			public int secondNum = -1;
			public GenreInf() {
				
			}
		}
		

		// ¦���� �����ϱ�
		public void solution21() {
			String s = "baabcc";
	        int answer21 = 1;
	        boolean[] removed = new boolean [s.length()];
	        for(boolean e : removed) {
	            e = false;
	        }
	        
	        // ��ü ���� ¦������ Ȯ��
	        if(s.length() % 2 == 0) {
	            // ������ ���� ���̿� �ִ� ������ ����(=num)�� ¦���� Ȯ��
	            for(int i=0; i<s.length()-1; i++) {
	                if(removed[i] == true)
	                    continue;
	                
	                int num = 0;
	                for(int j=i+1; j<s.length(); j++) {
	                    if(removed[j] == true)
	                        continue;
	                    
	                    if(s.charAt(i) == s.charAt(j)) {
	                        removed[j] = true;
	                        break;
	                    }
	                    else
	                        num++;
	                }
	                
	                // �� ���� ������ ���� ������ Ȧ���� ������ ����̹Ƿ� 0�� ����
	                if(num % 2 != 0) {
	                	answer21 = 0;
	                    break;
	                }
	            }
	        }
	        else
	        	answer21 = 0;
	        
	        System.out.print(answer21);
		}
		
		// �� �ʰ�
		public void solution20() {
			int[] scoville = {1, 2, 3, 9, 10, 12};
			int K = 7;
			int answer20 = 0;
			PriorityQueue<Integer> priorityQ = new PriorityQueue<>();
			for(int e : scoville) {
				priorityQ.offer(e);
			}
			
			// K�� ���ų� Ŀ���� break;
			while(priorityQ.peek() < K) {
				if(priorityQ.size() < 2) {
					answer20 = -1;
					break;
				}
				
				int first = priorityQ.poll();
				int second = priorityQ.poll();
				int scovilleNum = first + (second * 2);
				priorityQ.offer(scovilleNum);
				answer20++;
			}
			
			System.out.print(answer20);
			
		}
		
		// �ֽİ���
		public void solution19() {
			int[] prices = {1, 2, 3, 2, 3};
			int[] answer19 = new int [prices.length];

	        for (int i = 0; i < prices.length; i++) {
	            for (int j = i + 1; j < prices.length; j++) {
	            	answer19[i]++;
	                if (prices[i] > prices[j]) 
	                    break;
	            }
	        }
			
	        for(int a : answer19) {
	        	System.out.print(a + " ");
	        }
		}
		
		// �ٸ��� ������ Ʈ�� - ���� �ۿ� 
		// ��ó : https://hyojun.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%8B%A4%EB%A6%AC%EB%A5%BC-%EC%A7%80%EB%82%98%EB%8A%94-%ED%8A%B8%EB%9F%AD-Java
		public void solution18() {
			int[] truckWeights = {2, 2, 2, 2, 1, 1, 1, 1, 1};
			int bridgeLength = 5;
			int weight = 5;
			int answer18 = 0;
	        Queue<Integer> q = new LinkedList<Integer>();

	        int currentSum = 0; // ���� �ٸ� ���� �ö� �ִ� Ʈ���� ��ü ����
	        for(int t : truckWeights) {

	            while(true) {
	                //ť�� ����ִٸ� ���� Ʈ�� ����
	                if(q.isEmpty()) {
	                    q.offer(t);
	                    currentSum += t;
	                    answer18++;
	                    break;
	                }
	                //ť�� ������� �ٸ��� ���̰� ���ٸ� ť���� ť���� ó�� ���� ���� �ִ� ���� -
	                else if(q.size() == bridgeLength) {
	                    currentSum -= q.poll();
	                }
	                //ť�� ������� ���� ��
	                else {
	                    //���� Ʈ���� �ִ� ���� �ʰ�
	                    if(currentSum + t > weight) {
	                        q.offer(0);
	                        answer18++;
	                    }
	                    //���� Ʈ���� �ִ� ���� �̳�
	                    else {
	                        q.offer(t);
	                        currentSum += t;
	                        answer18++;
	                        break;
	                    }
	                }
	            }
	        }

	        //�ɸ� �ð� + ������ Ʈ���� ����ð�(�ٸ��� ����)
	        System.out.println( answer18 + bridgeLength);
		}
		// �ٸ��� ������ Ʈ��
		public void solution17() {
			int[] truckWeights = {2, 2, 2, 2, 1, 1, 1, 1, 1};
			int bridgeLength = 5;
			int weight = 5;
			int answer17 = 0;
	        Queue<Integer> q = new LinkedList<Integer>();
	        
	        int currentSum = 0; // ���� �ٸ� ���� �ö� �ִ� Ʈ���� ��ü ����
	        boolean many = false;
	        for(int i=0; i<truckWeights.length; i++) {
	            // �ٸ� ���� ���� �ʰ���
	            if(currentSum + truckWeights[i] > weight) {
	                // ���� ���� ����� Ʈ���� �ٸ� ������ �� �������� �ð��� �����ش�.
	                int num = q.poll();
	                currentSum -= num;
	                i--;
	            }
	            else {
	                q.offer(truckWeights[i]); // �ٸ� ���� Ʈ���� �ö󰬴�.
	                currentSum += truckWeights[i];
	                if(q.size() > 1) { // 2�� �̻��� ���� ������ ��
	                	answer17++;
	                }
	                else {
	                	answer17 += bridgeLength;
	                }
	            }
	        }
	        
	        System.out.println(answer17 + 1);
		}
		
		// ������
		public void solution16() {
			int[] priorities = {1, 1, 9, 1, 1, 1};
			int location = 0;
			int answer16 = 0;
	        Queue<Integer> q = new LinkedList<Integer>();
	        for(int i=0; i<priorities.length; i++) {
	            q.offer(priorities[i]);
	        }
	        
	        
	        while(true) {
	            boolean goBack = false;
	            int n = q.poll();
	            Iterator<Integer> iter = q.iterator();
	            // ���� �۾��� �켱������ ����� ��κ��� ������ Ȯ��
	            while(iter.hasNext()) {
	                // ���� �ϳ��� �۴ٸ�, �ڷ� ������ location�� �� ĭ ������ �´ٰ� �����Ѵ�.
	            	int a = iter.next();
	                if(n < a) {
	                    goBack = true;
	                    q.offer(n);
	                    location--;
	                    break;
	                }
	            }
	            
	            // ���� ���� �۾��� ���� �켱������ ���ٸ� ����Ʈ�Ѵ�.
	            if(goBack == false) {
	            	answer16++;
	            	// ���� ���� �۾��� �츮�� �˰��� �ϴ� ���̶�� ã�� ���� �����.
	            	if(location == 0)
	                    break;
	            	else 
	            		location--;
	            }
	            
	            // ���� �츮�� ���ϴ� �۾��� �켱������ �и��ٸ� �� ��(�ε���)�� �����ش�.
	            if(location < 0) {
	                location = q.size() - 1;
	            }
	        }
	        
	        System.out.println(answer16);
		}
		
		// ��ɰ���
		public void solution15() {
			int[] answer15;
			int[] progresses = {95, 90, 99, 99, 80, 99};
			int[] speeds = {1, 1, 1, 1, 1, 1};
	        ArrayList<Integer> answerList = new ArrayList<>();
	        // �� ���α׷��� ��ĥ�� �ɸ����� ���
	        Queue<Integer> q = new LinkedList<Integer>();
	        for(int i=0; i<progresses.length; i++) {
                int day = (100-progresses[i]) / speeds[i];
                if((100-progresses[i]) % speeds[i] > 0)
                    q.offer(day+1);
                else
                    q.offer(day);
	            
	        }
	        int cnt = 1;
	        int standard = q.poll();
	        while(!q.isEmpty()) {
	            if(standard >= q.peek()) {
	                cnt++;
	                if(q.poll() == null) {
	                	answerList.add(cnt);
	                	break;
	                }
	             
	            }
	            else {
	            	answerList.add(cnt);
	            	cnt = 1;
	            	standard = q.poll();
	            }
	        }
	        answerList.add(cnt);
	        
	        answer15 = new int [answerList.size()];
	        for(int i=0; i<answerList.size(); i++) {
	        	answer15[i] = answerList.get(i);
	            System.out.println(answer15[i]);
	        }
		}
		
		// ��Ʈ��ũ
		boolean[] visited;
        int answer = 0;
	    public void solution14() {
	    	int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
	    	int n = 3;
            visited = new boolean [n];
            for(int i=0; i<n; i++) {
                visited[i] = false;
            }
            
            for(int i=0; i<n; i++) {
            	if(visited[i] == false) {
            		visited[i] = true;
            		answer++;
            		solution14Dfs(i, computers, n);
            	}
            }
            System.out.print(answer);
	    }
	    
        public void solution14Dfs(int mine, int[][] computers, int n) {
            for(int i=0; i<n; i++) {
                // �̹� �湮�ߴ� ���̶�� answer + 1�� ���� �ʰ� ���� ������ �Ѿ��.
                if(visited[i])
                    continue;
                
                // ��Ʈ��ũ�� ����Ǿ� �����鼭 + �湮���� ���� ��ǻ�Ͷ�� into
                if(computers[mine][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    solution14Dfs(i, computers, n);
                }
                // �ϳ��� ��Ʈ��ũ�� �������� answer + 1
                
            }
        }
        
		// Ÿ�� �ѹ�
		int[] yj;
		public void solution13() {
			int target = 4;
	        yj = new int[] {4, 1, 2, 1};
	        int sum = 0;
	        for(int i=0; i<yj.length; i++) {
	            sum += yj[i];
	        }
	        int goal = (sum - target) / 2;
	        solution13Dfs(0, goal);
	        
	        System.out.print(answer);
	    }
		public void solution13Dfs(int index, int goal) {
	        if(goal == 0) {
	            answer++;
	            return;
	        }
	        
	        for(int i=index; i<yj.length; i++) {
	            // goal�� 0�� �ǰ��ϴ� ���� ã�Ƽ� ����
	            if(goal - yj[i] < 0)
	                continue;
	            // goal�� 0�� �Ǵ� ������ ã�Ƽ� ����
	            else {
	            	solution13Dfs(i+1, goal - yj[i]);
	            }
	        }
	    }
		
		// ī��
		public void solution12() {
			int brown = 24, yellow = 24;
	        int[] answer = new int[2];
	        // row, col ���� �� ���� Ž��
	        HashMap<Integer, Integer> map = new HashMap<>();
	        // row + col = (brown + 4) / 2 
	        int num = (brown + 4) / 2;
	        // row�� col���� ũ�ų� �����Ƿ� i <= num������ �ݺ��Ѵ�.
	        for(int i=1; i <= num/2; i++) {
	            map.put(num-i, i);
	        }

	        // (row-2)*(col-2) = 24
	        for(int row : map.keySet()) {
	            int col = map.get(row);
	            if((row-2)*(col-2) == yellow) {
	                answer[0] = row;
	                answer[1] = col;
	            }
	        }
	        
		}
		// �ߺ��� ���ϱ� ����, 011 �� ���� 0�� ���� ���� ���ϱ� ���� map�� ����Ѵ�.
		HashMap<Integer, Boolean> solution11Map = new HashMap<>();
		// �Ҽ� ã��
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
			// ���� �տ� 0 �� �ٿ��� �ִٸ� �װ͵��� ��� numbersList�� �����ش�.
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
			for(Integer value : solution11Map.keySet())
				numbersList.add(value);
			
			// ���� �Ҽ� ã��
			for(int value : numbersList) {
				if(isPrimeNum(value)) 
					answer++;
			}
			
			System.out.print(isPrimeNum(1));
			
		}
		
		// digits = �ڸ���. ������� digits = 4�̸� 4�ڸ� ���� ��� ������ ��´�.
		public void recursive(ArrayList<Integer> array, int value, int digits) {
			if(digits == (int) (Math.log10(value)) + 1) {
				solution11Map.put(value, true);
				return;
			}
			else {
				for(int i=0; i<array.size(); i++) {
					ArrayList<Integer> tmp = new ArrayList<>(array);
					// 1234 ����� �ٽ� 123���� ���ƿ��� �� 1243�� ����� ����
					if(i != 0)
						value = value / 10;
					value *= 10;
					value = value + array.get(i);
					tmp.remove(i);
					recursive(tmp, value, digits);
				}
			}
		}
		
		// �Ҽ� ã�� function
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
	            // ���ο� �帣 ���̶��
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
                	
	                // ���� ���� play ���� firstPlay�� ���� ���Ѵ�.
	                if(play > inf.firstPlay) {
	                	// first�� ������ second�� �Ű��ش�.
	                	inf.secondPlay = inf.firstPlay;
	                	inf.secondNum = inf.firstNum;
	                    
	                    // first�� ���� ���� ���� �־��ش�.
	                	inf.firstPlay = play;
	                	inf.firstNum = i;
	                	
	                	map.put(genre, inf);
	                }
	                // 1�������� �۰� + 2������ �ִٸ�
	                else if (inf.secondPlay != -1){
	                    // ���� ���°� 2�������� ũ�ٸ�
	                    if (play > inf.secondPlay) {
	                    	inf.secondPlay = play;
	                    	inf.secondNum = i;
	                    }
	                    // ������ �߰����� �ʰ� �Ѿ��.
	                    
	                }
	                // 1�������� ������ 2������ ���ٸ�
	                else {
	                	inf.secondPlay = play;
	                	inf.secondNum = i;
	                }
	            }
	            
	        }
	      
	        ArrayList<String> genreListOrdered = new ArrayList<>(map.keySet());
	        // ������������ ����
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
	        int typeNum = 0; // ����(type) ����
	        
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
		
		// ��ȭ��ȣ ���
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
		
		// �������� ���� ����
		public void solution7() {
	        String answer = "";
	        String[] participant = {"leo", "kiki", "eden"};
	        String[] completion = {"eden", "kiki"};
	        
	        HashMap<String, Integer> map = new HashMap<>();
	        
	        // �����ڸ�� -> map ���� ��ȯ
	        for(int i=0; i<completion.length; i++) {
	            // ���������� ���
	            if(map.containsKey(completion[i])) {
	                int num = map.get(completion[i]);
	                num++;
	                map.put(completion[i], num);
	            }
	            else
	                map.put(completion[i], 1);
	        }
	        
	        // �� ������ ã��
	        for(int i=0; i<participant.length; i++) {
	        	// ������ ��ܿ� ���ٸ�
	            if(!map.containsKey(participant[i])){
	                answer = participant[i];
	                break;
	            }
	            // �������� ó��
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
	                // �ο�Ƚ���� h���� Ŭ ���
	                if(citations[j] >= h)
	                    moreNum++;
	            }
	            lessNum = size - moreNum;
	            
	            // (�ο�Ƚ���� h���� ū)�ο� ���� h���� Ŭ ��� + 
	            // (�ο�Ƚ���� h���� ����)�ο� ���� h���� ���� ���
	            if(moreNum >= h && lessNum <= h) {
	                answer = h;
	                break;
	            }
	        }
	            
	        System.out.println(answer);
		}
		
		// ���� ū ��
		public void solution5() {
			int [] numbers = {0,0, 1, 0};
	        String answer = "";
	        ArrayList<Pair> pairList = new ArrayList<>();
	        for(int i=0; i<numbers.length; i++) {
	        	int divisor = 0;
	            // number�� 0�� ��� Log�� ���ϸ� infinity�� ������ ����
	            if(numbers[i] != 0)
	                divisor = (int) Math.log10(numbers[i]);
	            switch(divisor) {
	            	// ���� �ڸ� ��
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
	        // ����
	        Collections.sort(pairList, Collections.reverseOrder());

	        for(int i=0; i<pairList.size(); i++) {
	            answer += Integer.toString(pairList.get(i).getOriginNum());
	        }
	        // "000000" �̷� ��� -> "0"���� �����
	        if(answer.charAt(0) == '0')
	            answer = "0";
	        
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
	public static class Level3 {
		
		class MyPair implements Comparable<MyPair>{
			String next;
			int index;
			
			public MyPair(String next, int index) {
				this.next = next;
				this.index = index;
			}
			
			@Override
			public int compareTo(MyPair myPair) {
				if(this.next.compareTo(myPair.next) > 0)
					return 1;
				else if (this.next.compareTo(myPair.next) < 0) 
					return -1;
				else
					return 0;
			}
		}
		String[] answer2 = {};
		boolean success = false;
		// ������
		public void solution2() {
			String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
			answer2 = new String [tickets.length + 1];
	        // visited �ʱ�ȭ
	        boolean [] visited = new boolean [tickets.length];
	        for(int i=0; i<visited.length; i++)
	            visited[i] = false;
	        
	        answer2[0] = "ICN";
	        dfs2(tickets, "ICN", visited, 0);
	        for(int i=0; i<answer2.length; i++) {
		        System.out.println(answer2[i]);
	        }
		}
		
		public void dfs2(String[][] tickets, String from, boolean[] visited, int cnt) {
	        if(cnt == tickets.length) {
	            answer2[cnt] = from;
	            success = true;
	            return;
	        }
	        
	        ArrayList<MyPair> nextList = new ArrayList<>();
	        // ��߿��� ��� ã�´�. -> ���ĺ������� �����Ѵ�. -> ������� dfs�� �ִ´�.
	        for(int i=0; i<tickets.length; i++) {
	            if(tickets[i][0].equals(from) && visited[i] == false) {
	                nextList.add(new MyPair(tickets[i][1], i));
	                if(success)
	                    break;
	            }
	        }
	        
	        // ���ĺ� ������ �����Ѵ�.
	        Collections.sort(nextList);
	        
	        for(int i=0; i<nextList.size(); i++) {
	        	String next = nextList.get(i).next;
                visited[nextList.get(i).index] = true;
	        	dfs2(tickets, next, visited, ++cnt);
	        	
	        	// �ٽ� ����
	        	cnt--;
	        	visited[nextList.get(i).index] = false;
	        	// ��� �� ���ƿԴµ� ���������� �״�� ��� answer�� �־��ش�.
	        	if(success) {
	        		answer2[cnt] = from;
	        		break;
	        	}
	        }
	    }
		
		// �ܾ� ��ȯ
		// Exception in thread "main" java.lang.StackOverflowError at Solution.bfs(Unknown Source) -> ���⼱ �Ǵµ� ������ ���� ������
		public int solution1() {
			String begin = "hot";
			String target = "hit";
			String[] words = {"hit", "hot", "lot"};
			Queue<String> q = new LinkedList<>();
	        q.offer(begin);

	        // visited �ʱ�ȭ
	        boolean[] visited = new boolean [words.length];
	        for(boolean e : visited) {
	            e = false;
	        }

	        // target�� words�� ���� ��츸 bfs ����
	        for(String word : words) {
	            if(target.equals(word))
	                return bfs(q, words, target, visited);
	        }

	        return 0;
	    }

	    public int bfs(Queue<String> q, String[] words, String target, boolean[] visited) {
	        int answer = -1; // begin�� answer�� ���� x�̹Ƿ�
	        boolean isFind = false;
	        // level(����)�� ���� answer���� �˾ƾ� �ϹǷ� size�� �̸� ���Ѵ�.
	        while(!q.isEmpty()) {
	            if(isFind)
	                break;
	            else
	                answer++;
	            
	            int size = q.size();
	            for(int i=0; i<size; i++) {
	                String qWord = q.poll();
	                // ���� target�� ���ٸ� �ٷ� ����
	                if(qWord == target) {
	                    isFind = true;
	                    break;
	                }
	                for(int j=0; j<words.length; j++) {
	                    // �ϳ��� �ٸ��� + �湮���� �ʾ�����
	                    if(canChange(qWord, words[j]) && visited[j] == false) {
	                        q.offer(words[j]);
	                        visited[j] = true;
	                    }
	                }
	            }
	        }

	        return answer;
	    }

	    public boolean canChange(String word1, String word2) {
	        int cnt = 0;
	        for(int i=0; i<word1.length(); i++) {
	            if(word1.charAt(i) == word2.charAt(i))
	                cnt++;
	        }

	        if(word1.length() - 1 == cnt)
	            return true;
	        else 
	            return false;
	    }
	}
}


