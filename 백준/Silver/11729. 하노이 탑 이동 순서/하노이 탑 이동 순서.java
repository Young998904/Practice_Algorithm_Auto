import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    static BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
    public static int cnt = 0;
    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);


        int N = sc.nextInt();

        br.write((int) Math.pow(2, N) -1 + "\n");

        Hanoi(N, 1, 2, 3);

        br.flush();
        br.close();
    }
    public static void Hanoi (int N, int start, int mid, int end) throws IOException {
        if (N == 1) {
            br.write(start + " " + end + "\n");
            return;
        }

        // N != 1 이면 N-1 개의 원판을 중간 지점으로 옮겨야 한다.
        // Step1 : start -> mid
        Hanoi(N-1, start, end, mid);
        // Step2 : 가장 큰 N 번째 원반을 end 에
        br.write(start + " " + end + "\n");
        // Step 3 : mid -> end
        Hanoi(N-1, mid, start, end);
    }
}