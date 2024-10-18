import java.util.*;

public class App {
  public static void main(String[] args) throws Exception {
    String s = "baabaa";  
    System.out.println();
    System.out.println(solution(s));  // 결과 출력
  }

  private static int solution(String x) {
    Stack<Character> stack = new Stack<>();

    for (int i = 0; i < x.length(); i++)
    {
      char s = x.charAt(i);

      if(!stack.empty() && stack.peek() == s)
      {
        stack.pop();
      }
      else
      {
        stack.push(s);
      }      
    }    
      return stack.isEmpty() ? 1 : 0;
  }
}
