import java.util.*;

public class App {
  public static void main(String[] args) throws Exception {
    String s = "[](){}";  // 괄호 문자열
    System.out.println();
    System.out.println(solution(s));  // 결과 출력
  }

  private static int solution(String x) {
    // 닫는 괄호를 키로, 여는 괄호를 값으로 맵을 생성하여 짝을 정의
    HashMap<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');

    int n = x.length();  // 원래 문자열의 길이
    x += x;  // 문자열을 두 배로 만듦 (회전된 문자열을 쉽게 처리하기 위해)
    int answer = 0;  // 올바른 괄호 문자열의 개수를 셀 변수

    // 문자열을 회전시키면서 괄호가 올바른지 검사
    A: for (int i = 0; i < n; i++) {
      ArrayDeque<Character> stack = new ArrayDeque<>();  // 괄호 짝을 맞추기 위한 스택
      
      // 회전된 문자열을 처리 (i번째부터 i + n번째까지의 부분 문자열을 검사)
      for (int j = i; j < i + n; j++) {
        char c = x.charAt(j);  // 현재 검사할 문자

        if (!map.containsKey(c)) {  // 여는 괄호인 경우 스택에 추가
          stack.push(c);
        } else {  // 닫는 괄호인 경우
          if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {  // 짝이 맞지 않거나 스택이 비었으면
            continue A;  // 올바르지 않으므로 다음 회전으로 넘어감
          }
        }
      }

      // 모든 괄호가 짝을 맞췄다면 스택이 비었을 것이므로
      if (stack.isEmpty()) {
        answer++;  // 올바른 괄호 문자열인 경우 카운트를 증가
      }
    }

    return answer;  // 올바른 괄호 문자열의 개수를 반환
  }
}
