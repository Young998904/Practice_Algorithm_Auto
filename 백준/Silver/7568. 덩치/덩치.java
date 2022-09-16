import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] xList = new int[N];
        int[] yList = new int[N];
        int[] rank = new int[N];

        for (int i=0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for (int j=0; j < i; j++) {
                if (xList[j] > x && yList[j] > y) {
                    rank[i]++;
                }
                else if (xList[j] < x && yList[j] < y) {
                    rank[j]++;
                }
            }
            xList[i] = x;
            yList[i] = y;
        }

        for (int R : rank) {
            System.out.printf("%d ", R+1);
        }
    }
}