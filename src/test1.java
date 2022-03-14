
import java.util.HashMap;
import java.util.Vector;

class test {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
		
	}
    public static void solution(String[] record) {
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

        for(int i=0; i<answer.size(); i++) {
        	System.out.println(answer.get(i));
        }
        
        
        
    }
}