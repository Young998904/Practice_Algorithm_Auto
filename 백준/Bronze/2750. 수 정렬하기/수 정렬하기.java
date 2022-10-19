import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 배열 크기 입력
        int N = Integer.parseInt(br.readLine());

        int [] numList = new int[N];
        int cnt = 1;

        numList[0] = Integer.parseInt(br.readLine());

        for (int i=1; i<N; i++) {
            int num = Integer.parseInt(br.readLine());

            for (int j=0; j<cnt; j++) {
                if (numList[j] < num) {
                    if (j == cnt -1) {
                        numList[j+1] = num;
                    }
                }
                else {
                    for (int k=cnt-1; k >= j; k--) {
                        numList[k+1] = numList[k];
                    }
                    numList[j] = num;
                    break;
                }
            }
            cnt++;
        }

        for (int i=0; i<N; i++) {
            System.out.println(numList[i]);
        }
    }
}