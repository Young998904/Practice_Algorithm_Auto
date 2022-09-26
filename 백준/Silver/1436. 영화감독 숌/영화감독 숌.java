import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // N 입력받기
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String triSix="666";
        String fill = "";

        List<Integer> numList = new ArrayList<>();

        // 세자리 (완)
        numList.add(666);

        // 네자리 (완)
        for (int i=0; i<10; i++) {
            numList.add(Integer.parseInt(i + triSix));
            numList.add(Integer.parseInt(triSix + i));
        }

        // 다섯자리 (완)
        for (int i=0; i<100; i++) {
            fill = String.format("%02d", i);
            numList.add(Integer.parseInt( fill + triSix));
            numList.add(Integer.parseInt(triSix + fill));
        }
        for (int i=1; i<10; i++) {
            for (int j=0; j<10; j++) {
                numList.add(Integer.parseInt(i + "666" + j));
            }
        }

        // 여섯자리
        for (int i=0; i<1000; i++) {
            fill = String.format("%03d", i);
            numList.add(Integer.parseInt(fill + triSix));
            numList.add(Integer.parseInt(triSix + fill));
        }
        for (int i=1; i<10; i++) {
            for (int j=0; j < 100; j++) {
                fill = String.format("%02d", j);
                numList.add(Integer.parseInt(i + triSix + fill));
            }
        }
        for (int i=10; i<100; i++) {
            for (int j=0; j < 10; j++) {
                numList.add(Integer.parseInt(i + triSix + j));
            }
        }

        // 일곱 자리
        for (int i=0; i<10000; i++) {
            fill = String.format("%04d", i);
            numList.add(Integer.parseInt(fill + triSix));
            numList.add(Integer.parseInt(triSix + fill));
        }
        for (int i=1; i<10; i++) {
            for (int j=0; j<1000; j++) {
                fill = String.format("%03d", j);
                numList.add(Integer.parseInt(i + triSix + fill));
            }
        }
        for (int i=10; i<100; i++) {
            for (int j=0; j<100; j++) {
                fill = String.format("%02d", j);
                numList.add(Integer.parseInt(i + triSix + fill));
            }
        }
        for (int i=100; i<1000; i++) {
            for (int j=0; j<10; j++) {
                numList.add(Integer.parseInt(i + triSix + j));
            }
        }

        numList.sort(Comparator.naturalOrder());

        List<Integer> newNumList = numList.stream().distinct().collect(Collectors.toList());
        System.out.println(newNumList.get(N-1));
    }
}