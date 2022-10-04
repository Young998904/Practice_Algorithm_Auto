import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        String [][] chessPan = new String[v][h];

        // 비교하면서 카운트를 하나씩 늘려가면 될듯.
        // 2차원 배열

        for (int i=0; i < v; i++) {
            String[] line = br.readLine().split("");

            for (int j = 0; j< h; j++) {
                chessPan[i][j] = line[j];
            }
        }

        // 비교 시작
        int answer = 64; // max 64 를 넘지 않음
        int count = 0;
        String[] startWithB = {"B", "W", "B", "W", "B", "W", "B", "W"};
        String[] startWithW = {"W", "B", "W", "B", "W", "B", "W", "B"};

        // 총 18개의 경우의 수 확인
        for(int i=0; i <= v-8; i++) {
            for (int j=0; j <= h-8; j++) {
                for (int x = 0; x < 8; x ++) {
                    for (int y = 0; y < 8; y++) {
                        if (x % 2 == 0) {
                            if (!chessPan[i+x][j+y].equals(startWithB[y])) {
                                count++;
                            }
                        }
                        else {
                            if (!chessPan[i+x][j+y].equals(startWithW[y])) {
                                count++;
                            }
                        }
                    }
                }
                if(count < answer) {
                    answer = count;
                }
                count = 0;

                for (int x = 0; x < 8; x ++) {
                    for (int y = 0; y < 8; y++) {
                        if (x % 2 == 0) {
                            if (!chessPan[i+x][j+y].equals(startWithW[y])) {
                                count++;
                            }
                        }
                        else {
                            if (!chessPan[i+x][j+y].equals(startWithB[y])) {
                                count++;
                            }
                        }
                    }
                }

                if(count < answer) {
                    answer = count;
                }
                count = 0;
            }
        }
        System.out.println(answer);
    }
}