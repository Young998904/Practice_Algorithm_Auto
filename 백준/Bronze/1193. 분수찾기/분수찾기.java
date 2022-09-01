import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long x = Long.parseLong(br.readLine());

        long sonCount = 0;
        long sonSum =  0;

        long mon;
        long son;


        while (x > sonSum) {
            sonSum += 4*sonCount + 1;
            sonCount ++;
        }

        sonCount--;

        Long sonMax = 2*sonCount + 1;

        long monCount = 0;
        long monSum = 0;


        while (x > monSum) {
            monSum += 4*monCount + 3;
            monCount ++;
        }

        monCount--;

        Long monMax = 2*monCount + 2;

        long sonIndex = sonSum - x + 1;
        if (sonIndex > sonMax) {
            son = 2*sonMax - sonIndex;
        }
        else {
            son = sonIndex;
        }

        long monIndex = monSum - x + 1;
        if (monIndex > monMax) {
            mon = 2*monMax - monIndex;
        }
        else {
            mon = monIndex;
        }

        System.out.printf("%d/%d", son, mon);
    }
}