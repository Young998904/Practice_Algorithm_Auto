import java.util.*;

class Info {
    String uuid;
    boolean isEnter;
    
    public Info (String uuid, boolean isEnter) {
        this.uuid = uuid;
        this.isEnter = isEnter;
    }
}

class Solution {
    public static Queue<Info> queue = new LinkedList<>();
    public static HashMap<String, String> nicknameMap = new HashMap<>();
    
    public String[] solution(String[] record) {    
        for (String rec : record) {
            String[] order = rec.split(" ");
            
            switch(order[0]) {
		
			    case "Enter":
				// 명령어 : Enter
                    nicknameMap.put(order[1], order[2]);
                    queue.add(new Info(order[1], true));
				    break;
			    case "Leave":
                // 명령어 : Leave
                    queue.add(new Info(order[1], false));
				    break;
			    case "Change":
				    nicknameMap.put(order[1], order[2]);
				    break;
		        }
            }
        
        String[] answer = new String[queue.size()];
        int index = 0;
        
        String nickname = "";
        
        while (! queue.isEmpty()) {
            Info info = queue.poll();
            // System.out.printf("%s, %b\n", info.uuid, info.isEnter);
            
            nickname = nicknameMap.get(info.uuid);
            // System.out.printf("%s\n", nickname);
                
            if (info.isEnter) {
                answer[index] = nickname + "님이 들어왔습니다.";
            }
            else {
                answer[index] = nickname + "님이 나갔습니다.";
            }
            
            index++;
        }
        
        return answer;
    }
}