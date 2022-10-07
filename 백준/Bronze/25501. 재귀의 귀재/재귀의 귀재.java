import java.util.Scanner;

public class Main{
    public static int recursion(String s, int l, int r, int count){
        count++;
        if(l >= r) { System.out.print("1 "); return count; }
        else if(s.charAt(l) != s.charAt(r)) { System.out.print("0 "); return count; }
        else return recursion(s, l+1, r-1, count);
    }

    public static int isPalindrome(String s, int count){
        return recursion(s, 0, s.length()-1, count);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int i = 0; i < t; i++) {
            int count = 0;
            String s = sc.nextLine();
            System.out.print(isPalindrome(s, count));
            System.out.println();
        }
    }
}