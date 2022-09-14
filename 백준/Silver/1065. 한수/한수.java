import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int [] numList = new int[1001];

        for (int i = 1; i < 100; i++) {
            numList[i] = 1;
        }
        numList[1000] = 0;

        for (int i = 100; i < 1000; i++) {
            String num = String.valueOf(i);

            int a = num.charAt(0);
            int b = num.charAt(1);
            int c = num.charAt(2);

            numList[i] = (a-b == b-c) ? 1 : 0;
        }
        
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();

        int count = 0;
        for(int i = 1; i <= d; i++) {
            if (numList[i] == 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}