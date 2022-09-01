import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int[] numbers = new int[7];

        int result = 0;

        boolean next = true;

        for (int i=0; i<=6; i++) {
            numbers[i] = 0;
        }

        for (int i=1; i<=3; i++) {
            numbers[Integer.parseInt(st.nextToken())] ++;
        }

        for (int i=1; i<=6; i ++) {
            if (numbers[i] == 3) {
                result = 10000 + i*1000;
                next = false;
            }
            if (numbers[i] == 2) {
                result = 1000 + i*100;
                next = false;
            }
        }

        if (next) {
            int maxIndex = 0;
            for (int i=1; i<=6; i++) {
                if (numbers[i] == 1) {
                    maxIndex = i;
                }
            }
            result = maxIndex * 100;
        }

        System.out.println(result);
    }
}