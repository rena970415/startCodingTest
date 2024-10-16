import java.util.*;

public class App {
  // 정답 배열, 여기서는 예시로 1, 2, 3, 4, 5로 설정
  public static int[] answer1 = { 1, 2, 3, 4, 5 };
  public static int[] answer2 = {1,3,2,4,2};

  public static void main(String[] args) throws Exception {
    // 세 사람의 답안 패턴 배열
    int[][] pattern = {
        { 1, 2, 3, 4, 5 },               // 첫 번째 사람의 패턴
        { 2, 1, 2, 3, 2, 4, 2, 5 },      // 두 번째 사람의 패턴
        { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } // 세 번째 사람의 패턴
    };

    // 결과 출력
    System.out.println("결과 : " + Arrays.toString(ComparePattern(pattern)));
  }

  // 패턴과 정답을 비교하여 가장 많이 맞춘 사람(들)을 반환하는 함수
  private static int[] ComparePattern(int[][] arr)
  {
    // 각 사람의 맞춘 답 개수를 기록하는 배열 (3명의 사람)
    int[] result = new int[3]; 
    // 가장 높은 점수를 받은 사람들의 번호를 저장할 리스트
    ArrayList<Integer> rlst = new ArrayList<>();

    // 정답(answer1)과 각 사람의 패턴을 비교하는 반복문
    /*
     * 나머지 연산(%)을 이용한 이유
       예를 들어, 두 번째 사람의 패턴 { 2, 1, 2, 3, 2, 4, 2, 5 }의 길이는 8입니다. 그러나 비교해야 할 정답(answer1)은 5개이기 때문에 패턴의 답을 반복해서 사용할 수 있게 i % arr[j].length를 사용합니다.

       i = 0일 때: i % 8 = 0 → 패턴에서 0번째 값 사용
       i = 1일 때: i % 8 = 1 → 패턴에서 1번째 값 사용
       ...
       i = 5일 때: i % 8 = 5 → 패턴에서 5번째 값 사용
       이렇게 마지막까지 비교할 수 있게 됩니다.
     */
    for (int i = 0; i < answer1.length; i++) { 
      // 각 사람의 패턴과 비교하기 위한 반복문
      for (int j = 0; j < arr.length; j++) { 
        // 정답과 각 사람의 패턴을 비교 (나머지 연산을 통해 패턴이 반복되도록 함)
        if (answer1[i] == arr[j][i % arr[j].length]) { 
          // 정답이 일치하면 해당 사람의 점수를 1 증가
          result[j]++;
        }
      }
    }

    // 모든 문제를 비교한 후, 가장 높은 점수를 찾음
    int maxScore = Arrays.stream(result).max().getAsInt();

    // 가장 높은 점수를 받은 사람을 찾아서 리스트(rlst)에 추가
    for (int x = 0; x < result.length; x++) {
      if (result[x] == maxScore) {
        // 사람 번호는 1부터 시작하므로 (x + 1)을 리스트에 추가
        rlst.add(x + 1);
      }
    }

    // 리스트(rlst)를 배열로 변환하여 반환
    return rlst.stream().mapToInt(Integer::intValue).toArray();
  }

}
