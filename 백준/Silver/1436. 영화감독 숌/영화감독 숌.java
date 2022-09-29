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

        StringBuilder sb = new StringBuilder();
        String triSix="666";
        String fill = "";

        List<Integer> numList = new ArrayList<>();

        // 세자리 (완)
        numList.add(666);

        // 네자리 (완)
        for (int i=0; i<10; i++) {
            sb.append(i);
            sb.append(triSix);
            numList.add(Integer.parseInt(sb.toString()));
            sb.setLength(0);
            sb.append(triSix);
            sb.append(i);
            numList.add(Integer.parseInt(sb.toString()));
            sb.setLength(0);
        }

        // 다섯자리 (완)
        for (int i=0; i<100; i++) {
            fill = String.format("%02d", i);
            sb.append(fill);
            sb.append(triSix);
            numList.add(Integer.parseInt(sb.toString()));
            sb.setLength(0);
            sb.append(triSix);
            sb.append(fill);
            numList.add(Integer.parseInt(sb.toString()));
            sb.setLength(0);
        }
        for (int i=1; i<10; i++) {
            for (int j=0; j<10; j++) {
                sb.append(i);
                sb.append(triSix);
                sb.append(j);
                numList.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
        }

        // 여섯자리
        for (int i=0; i<1000; i++) {
            fill = String.format("%03d", i);
            sb.append(fill);
            sb.append(triSix);
            numList.add(Integer.parseInt(sb.toString()));
            sb.setLength(0);
            sb.append(triSix);
            sb.append(fill);
            numList.add(Integer.parseInt(sb.toString()));
            sb.setLength(0);
        }
        for (int i=1; i<10; i++) {
            for (int j=0; j < 100; j++) {
                fill = String.format("%02d", j);
                sb.append(i);
                sb.append(triSix);
                sb.append(fill);
                numList.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
        }
        for (int i=10; i<100; i++) {
            for (int j=0; j < 10; j++) {
                sb.append(i);
                sb.append(triSix);
                sb.append(j);
                numList.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
        }

        // 일곱 자리
        for (int i=0; i<10000; i++) {
            fill = String.format("%04d", i);
            sb.append(fill);
            sb.append(triSix);
            numList.add(Integer.parseInt(sb.toString()));
            sb.setLength(0);
            sb.append(triSix);
            sb.append(fill);
            numList.add(Integer.parseInt(sb.toString()));
            sb.setLength(0);
        }
        for (int i=1; i<10; i++) {
            for (int j=0; j<1000; j++) {
                fill = String.format("%03d", j);
                sb.append(i);
                sb.append(triSix);
                sb.append(fill);
                numList.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
        }
        for (int i=10; i<100; i++) {
            for (int j=0; j<100; j++) {
                fill = String.format("%02d", j);
                sb.append(i);
                sb.append(triSix);
                sb.append(fill);
                numList.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
        }
        for (int i=100; i<1000; i++) {
            for (int j=0; j<10; j++) {
                sb.append(i);
                sb.append(triSix);
                sb.append(j);
                numList.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
        }

        numList.sort(Comparator.naturalOrder());

        List<Integer> newNumList = numList.stream().distinct().collect(Collectors.toList());
        System.out.println(newNumList.get(N-1));
    }
}