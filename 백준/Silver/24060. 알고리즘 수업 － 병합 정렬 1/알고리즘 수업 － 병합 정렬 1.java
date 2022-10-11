import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] src;
    public static int[] tmp;
    public static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        src = new int[N];
        tmp = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }
        
        mergeSort(0, src.length-1, K);
        if (cnt < K) {
            System.out.println(-1);
        }
    }

    public static void mergeSort(int start, int end,int K) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid, K);
            mergeSort(mid + 1, end, K);

            int p = start;
            int q = mid + 1;
            int idx = p;

            while (p <= mid || q <= end) {
                if (q > end || (p <= mid && src[p] < src[q])) {
                    tmp[idx++] = src[p++];
                    cnt++;
                    if (cnt == K) {
                        System.out.println(tmp[idx-1]);
                    }
                } else {
                    tmp[idx++] = src[q++];
                    cnt++;
                    if (cnt == K) {
                        System.out.println(tmp[idx-1]);
                    }
                }
            }
            for (int i = start; i <= end; i++) {
                src[i] = tmp[i];
            }
        }
    }
}