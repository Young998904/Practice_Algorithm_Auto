import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String roomNum = sc.nextLine();

        int[] numCount = new int[9];

        for (int i=0; i<roomNum.length(); i++) {
            char num = roomNum.charAt(i);
            switch (num) {
                case '0' :
                    numCount[0]++;
                    break;
                case '1' :
                    numCount[1]++;
                    break;
                case '2' :
                    numCount[2]++;
                    break;
                case '3' :
                    numCount[3]++;
                    break;
                case '4' :
                    numCount[4]++;
                    break;
                case '5' :
                    numCount[5]++;
                    break;
                case '6' :
                    numCount[6]++;
                    break;
                case '7' :
                    numCount[7]++;
                    break;
                case '8' :
                    numCount[8]++;
                    break;
                case '9' :
                    numCount[6]++;
                    break;
            }
        }
        numCount[6] = (numCount[6]/2 + numCount[6]%2);

        int max=0;

        for(int i=0; i<numCount.length; i++) {
            if(numCount[i] >= max) {
                max=numCount[i];
            }
        }

        System.out.printf("%d", max);
    }
}
