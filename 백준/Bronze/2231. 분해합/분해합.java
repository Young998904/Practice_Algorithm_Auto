import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i=1; i < N; i++) {
            int total = i;
            String num = String.valueOf(i);

            for (int j=0; j < num.length(); j++) {
                total += Character.getNumericValue(num.charAt(j));
            }

            if (N == total) {
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }
}