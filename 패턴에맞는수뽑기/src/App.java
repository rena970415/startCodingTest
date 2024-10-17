import java.util.*;

public class App {
  public static void main(String[] args) throws Exception {
    // 두 개의 행렬 arr1과 arr2 정의 (테스트용 데이터)
    int[][] arr1 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };  // 3x2 행렬
    int[][] arr2 = { { 3, 3 }, { 3, 3 } };            // 2x2 행렬

    // 행렬 곱의 결과를 출력
    System.out.println("결과 : " + Arrays.deepToString(solution(arr1, arr2)));
  }

  // 두 행렬의 곱을 계산하는 함수
  private static int[][] solution(int[][] arr1, int[][] arr2) {
    // arr1의 행(r1)과 열(c1)을 구함
    int r1 = arr1.length;     // arr1의 행 개수
    int c1 = arr1[0].length;  // arr1의 열 개수

    // arr2의 행(r2)과 열(c2)을 구함
    int r2 = arr2.length;     // arr2의 행 개수
    int c2 = arr2[0].length;  // arr2의 열 개수

    // 결과 행렬(answer)은 arr1의 행(r1)과 arr2의 열(c2)의 크기로 초기화
    int[][] answer = new int[r1][c2];

    // 행렬 곱을 계산하는 3중 for문
    // 1. 첫 번째 for문: arr1의 각 행(row)을 순회
    for (int i = 0; i < r1; i++) {
      // 2. 두 번째 for문: arr2의 각 열(column)을 순회
      for (int j = 0; j < c2; j++) {
        // 3. 세 번째 for문: arr1의 행과 arr2의 열을 곱해서 더함
        for (int k = 0; k < c1; k++) {
          // arr1의 i번째 행과 arr2의 j번째 열을 곱해서 결과 행렬의 (i, j) 위치에 더함
          answer[i][j] += arr1[i][k] * arr2[k][j];
        }
      }
    }

    // 결과 행렬 반환
    return answer;
  }

}
