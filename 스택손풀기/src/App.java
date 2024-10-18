import java.util.*;

public class App {
  public static void main(String[] args) throws Exception {
    // 검사할 문자열 s: 여기에 괄호 문자열을 입력합니다.
    String s = "()()"; // true
    String x = "(())("; // false;
    System.out.println();

    // isStack 메서드를 호출하여 괄호의 유효성을 확인하고 결과를 출력합니다.
    System.out.println(isStack(x));
  }

  // isStack 메서드는 주어진 문자열이 올바른 괄호 문자열인지 확인하는 함수입니다.
  private static boolean isStack(String s) {
    // 스택을 생성합니다. 스택은 괄호의 여는 부분 '('을 저장하기 위해 사용됩니다.
    ArrayDeque<Character> stack = new ArrayDeque<>();

    // 문자열을 문자 배열로 변환하여 하나씩 처리할 수 있도록 합니다.
    char[] a = s.toCharArray();

    // for-each 문을 사용해 문자열의 각 문자를 순차적으로 검사합니다.
    for (char c : a) {
      // 현재 문자가 '('일 경우 스택에 추가합니다.
      if (c == '(') {
        stack.push(c);  // 여는 괄호는 스택에 저장됩니다.
      } else {
        // 닫는 괄호 ')'일 경우
        // 1. 스택이 비어 있다면 (여는 괄호가 없는데 닫는 괄호가 나온 경우) false 반환
        // 2. 스택에서 여는 괄호를 pop했을 때 같은 문자가 나오면 잘못된 쌍이므로 false 반환
        if (stack.isEmpty() || stack.pop() == c) {
          return false;
        }
      }
    }

    // 문자열을 모두 처리한 후, 스택이 비어 있으면 올바른 괄호 문자열이므로 true 반환
    // 스택에 남아있으면 여는 괄호가 닫히지 않았다는 의미이므로 false 반환
    return stack.isEmpty();
  }
}
