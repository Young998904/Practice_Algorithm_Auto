import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int answer = 0;

        // 컴퓨터 수
        int num = Integer.parseInt(br.readLine());
        // 연결되어있는 네트워크 수
        int n = Integer.parseInt(br.readLine());

        // 인접 행렬
        int [][] net = new int[num+1][num+1];

        for (int i=0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            net[a][b] = 1;
            net[b][a] = 1;
        }

//        for (int[] ne : net) {
//            for (int i=0; i<=num; i++) {
//                System.out.print(ne[i] + " ");
//            }
//            System.out.println();
//        }

        for (int k=1; k <= num; k++) {
            for (int i=1; i <=num; i++) {
                for (int j=1; j<=num; j++) {
                    if (i==j) continue;
                    if (net[i][k] == 1 && net[k][j] == 1) net[i][j] = 1;
                }
            }
        }

        for (int i=2; i<=num; i++) {
            if (net[1][i] == 1) answer++;
        }

        System.out.println(answer);
    }
}
