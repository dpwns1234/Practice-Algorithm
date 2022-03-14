
import java.util.HashMap;
import java.util.Vector;

class test {
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		solution(record);
		
	}
    public static void solution(String[] record) {
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

        for(int i=0; i<answer.size(); i++) {
        	System.out.println(answer.get(i));
        }
        
        
        
    }
}