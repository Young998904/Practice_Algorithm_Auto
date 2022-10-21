import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int top = Integer.parseInt(st.nextToken());

        int[] numArr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        // 버블 정렬
        for (int i=1; i<=N-1; i++) {
            for (int j=0; j<N-i; j++) {
                if (numArr[j] > numArr[j+1]) {
                    int save = numArr[j+1];
                    numArr[j+1] = numArr[j];
                    numArr[j] = save;
                }
            }
        }
        
        System.out.println(numArr[N-top]);
    }
}
