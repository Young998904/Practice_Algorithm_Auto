import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        List<Long> xArr = new ArrayList<>();
        List<Long> yArr = new ArrayList<>();

        int T = Integer.parseInt(br.readLine().trim());

        for (int i=1; i <= T; i++) {
            st = new StringTokenizer(br.readLine().trim());
            xArr.add(Long.parseLong(st.nextToken()));
            yArr.add(Long.parseLong(st.nextToken()));
        }

        Collections.sort(xArr);
        Collections.sort(yArr);
        
        long xMid = 0;
        long yMid = 0;

        xMid = xArr.get((T-1)/2);
        yMid = yArr.get((T-1)/2);

        long sum =  0;
        for (int i=0; i<xArr.size(); i ++) {
            sum += Math.abs(xMid-xArr.get(i)) + Math.abs(yMid-yArr.get(i));
        }
        System.out.println(sum);
    }
}