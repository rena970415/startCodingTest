import java.util.*;

public class App {
  public static void main(String[] args) throws Exception {
    int n = 13;
    System.out.println();
    System.out.println(solution(n));
  }

  private static String solution(int decimal)
  {
    Stack<Integer> stack = new Stack<>();

    while (decimal > 0) {
      int remainder = decimal % 2;

      stack.push(remainder);

      decimal /= 2;
    }
    
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
    }


    return sb.toString();
  }
}
