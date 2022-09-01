import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int [] now = new int[3];
        int time;
        int d = 0;
        int h = 0;
        int m = 0;
        int s = 0;

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<3; i++) {
            now[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        time = Integer.parseInt(st.nextToken());

        s = time % 60;
        time = time / 60;
        m = time % 60;
        time = time / 60;
        h = time % 24;
        d = time / 24;

        now[2] = now[2] + s;
        if (now[2] > 59) {
            now[2] -= 60;
            now[1] ++;
        }
        now[1] = now[1] + m;
        if (now[1] > 59) {
            now[1] -= 60;
            now[0] ++;
        }
        now[0] = now[0] + h;
        if (now[0] > 23) {
            now[0] -= 24;
        }

        System.out.printf("%d %d %d", now[0], now[1], now[2]);
    }
}
