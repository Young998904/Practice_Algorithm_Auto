class Solution {
    public static String[] baby = new String[] {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        
//         String s = "ayamm";
//         String[] test = s.split("aya");
        
//         System.out.println(test.length);
        
//         for (String ss : test) System.out.println(ss);
        
//         String s = "aya";
//         String[] test = s.split("aya");
        
//         System.out.println(test.length);
        
        // System.out.println(test[0]);
        // System.out.println(test[1]);
        
        // for (String str : test) System.out.println(str);
        int answer = 0;
        
        for (String str : babbling) {
            char c = str.charAt(0);
            
            if (checkStr(c, str)) {
                // System.out.println("true 추가");
                // System.out.println("--------");
                answer++;
            }
            // else {
            //     System.out.println("--------");
            // }
        }
        
        return answer;
    }
    
    public static boolean checkStr (char startChar, String str) {
        // System.out.println(startChar);
        // System.out.println(str);
        // System.out.println("------------");
        
        String[] strs;
        
        switch (startChar) {
            case 'a' :
                strs = str.split(baby[0]);
                break;
            case 'y' :
                strs = str.split(baby[1]);
                break;
            case 'w' :
                strs = str.split(baby[2]);
                break;
            case 'm' :
                strs = str.split(baby[3]);
                break;
            default : 
                // System.out.println("종료");
                return false;
        }
        
//         System.out.println(strs.length);
        
//         for (String ss : strs) System.out.println(ss);
        
        if (strs.length == 0 || strs.length == 1) {
            // if (strs.length == 0) System.out.println("true 반환");
            // else System.out.println("false 반환");
            return strs.length == 0 ? true : false;
        }
        else {
            return checkStr(strs[1].charAt(0), strs[1]);
        }
        
        // System.out.println("false 반환");
        // return false;
    }
}