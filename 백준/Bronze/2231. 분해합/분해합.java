import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        for (int i = 1; i < N; i++) {
            int total = i;
            int num = i;
            while(num > 0) {
                total += num % 10;
                num = num / 10;
            }

            if (N == total) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}