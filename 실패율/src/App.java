import java.util.*;

public class App {
  public static void main(String[] args) throws Exception {
    // 스테이지의 총 개수 (예시: 5개의 스테이지)
    int N = 5;
    // 각 플레이어가 머무르고 있는 스테이지 정보 (예시 데이터)
    int[] stages = { 2, 1, 2, 6, 2, 4, 3, 3 };
 
    // 실패율 계산 후 결과 출력
    System.out.println("실패율 : " + Arrays.toString(failsRto(N, stages)));
  }

  // 각 스테이지의 실패율을 계산하고, 실패율이 높은 순으로 스테이지 번호를 반환하는 함수
  private static int[] failsRto(int n, int[] stages) {
    // 각 스테이지에 도전한 사람 수를 기록하는 배열 (인덱스 0은 사용하지 않음)
    int[] challenger = new int[n + 2]; // n + 2로 크기를 설정하여 모든 스테이지를 포함 (스테이지 번호는 1부터 시작)

    // 각 플레이어가 어느 스테이지에 도전하고 있는지 카운트
    for (int i = 0; i < stages.length; i++) {
      challenger[stages[i]] += 1; // 해당 스테이지에 도전한 사람 수 증가
    }

    // 각 스테이지별 실패율을 저장하는 맵 (스테이지 번호 -> 실패율)
    HashMap<Integer, Double> failse = new HashMap<>();

    // 총 도전자 수는 처음에는 모든 플레이어의 수와 동일
    double total = stages.length;

    // 각 스테이지에 대한 실패율 계산
    for (int i = 1; i <= n; i++) {
      // 스테이지에 도전한 사람이 없을 경우 실패율은 0
      if (challenger[i] == 0) {
        failse.put(i, 0.0);  // 실패율 0으로 설정
      } else {
        // 실패율 = (해당 스테이지에 머물고 있는 사람 수) / (해당 스테이지에 도전한 총 사람 수)
        failse.put(i, challenger[i] / total);
        // 다음 스테이지의 실패율을 계산할 때, 현재 스테이지에 도전한 사람 수를 제외
        total -= challenger[i];
      }
    }

    // 실패율을 기준으로 스테이지를 내림차순으로 정렬
    // 정렬 후, 스테이지 번호만 추출하여 배열로 변환
    return failse.entrySet().stream()
                 .sorted((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())) // 실패율 높은 순으로 정렬
                 .mapToInt(Map.Entry::getKey) // 스테이지 번호만 배열로 변환
                 .toArray();
  }
}
