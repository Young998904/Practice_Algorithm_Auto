import javax.swing.*;
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseUnsignedInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        List<String> numbers = new ArrayList<>();

        for (int i=1; i<=T; i++) { // 배열 삽입
            numbers.add(st.nextToken());
        }

        for (int i=1; i<T; i++) {
            for (int k=0; k<numbers.size()-1; k++) {
                if (numbers.get(k).charAt(0) == numbers.get(k+1).charAt(0)) {
                    long stay = Long.parseLong(numbers.get(k)+numbers.get(k+1));
                    long change = Long.parseLong(numbers.get(k+1)+numbers.get(k));
                    if (stay < change) {
                        String a = numbers.get(k);
                        numbers.set(k, numbers.get(k+1));
                        numbers.set(k+1, a);
                    }
                }
                else {
                    if (Integer.parseInt(String.valueOf(numbers.get(k).charAt(0)))
                            < Integer.parseInt(String.valueOf(numbers.get(k+1).charAt(0)))) {
                        String a = numbers.get(k);
                        numbers.set(k, numbers.get(k+1));
                        numbers.set(k+1, a);
                    }
                }
            }
        }

        if (numbers.get(0).equals("0")) {
            System.out.printf("0");
            return;
        }
        for (String number : numbers) {
            System.out.printf("%s", number);
        }
    }
}