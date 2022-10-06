import java.util.Scanner;

public class Main {
    public int fibo(int one, int two) {
        return one + two;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Main m = new Main();

        // 0 이나 1 일 때
        if (N == 0 || N == 1) {
            System.out.println(N);
            return;
        }

        int one = 0;
        int two = 1;
        int newOne;

        for (int i=2; i<=N; i++) {
            newOne = two;
            two = m.fibo(one, two);
            one = newOne;
        }
        System.out.println(two);
    }
}