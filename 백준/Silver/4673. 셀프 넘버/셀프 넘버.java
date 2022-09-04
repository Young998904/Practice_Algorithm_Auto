import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {

    List<Integer> numList = new ArrayList<>();
    for(int i=1; i <= 10000; i++) {
      numList.add(i);
    }

    for(int i = 1; i < 10000; i++) {
      int a = d(Integer.toString(i));
      if (numList.contains(a)) {
        int index = numList.indexOf(a);
        numList.remove(index);
      }
    }

    for (int num : numList) {
      System.out.println(num);
    }
  }
  public static int d (String number) {
    int result = Integer.parseInt(number);

    for (int i=0; i < number.length(); i++) {
      result += Character.getNumericValue(number.charAt(i));
    }
    return result;
  }
}
