import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> numList = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i < N; i++) {
            numList.add(Integer.parseInt(st.nextToken()));
        }
        
        int result = 0;

        for (int i=0; i < N-2; i++) {
            for (int k=i+1; k < N-1; k++) {
                for (int j=k+1; j < N; j++) {
                    int total = numList.get(i) + numList.get(k) + numList.get(j);

                    if (total == M) {
                        System.out.println(M);
                        return;
                    }
                    if (total > M) {
                        continue;
                    }
                    else {
                        result = (M-total < M-result) ? total : result;
                    }
                }
            }
        }

        System.out.println(result);
    }
}