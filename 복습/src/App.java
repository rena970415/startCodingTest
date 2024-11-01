import java.lang.reflect.Array;
import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
      //1번 문제
      // int[] arr = { 1, -5, 2, 4, 3 };
      // System.out.println();
      // System.out.println(Arrays.toString(solution(arr)));
      //2번 문제
      // int[] arr1 = { 4, 2, 2, 1, 3, 4 };
      // System.out.println();
      // System.out.println(Arrays.toString(solution1(arr1)));
      // int[] arr2 = { 2,1,3,4,1};
      // System.out.println();
      // System.out.println(Arrays.toString(solution2(arr2)));
      // 3번문제 패턴을 비교하여 가장 많이 맞힌 사람 구하기
      // int[] arr3 = { 2,1,3,4,1};
      // System.out.println();
      // System.out.println(Arrays.toString(solution2(arr3)));
      // 4번문제 행렬 곱 구하기
      // int[][] arr4 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
      // int[][] arr5 = { { 3, 3 }, { 3, 3 } };
      // System.out.println();
      // System.out.println(Arrays.deepToString(solution4(arr4, arr5)));
      //6번문제 실패율 구하기
      // int stage = 5;
      // int[] arr6 = { 2, 1, 2, 6, 2, 4, 3, 3 };
      // System.out.println();
      // System.out.println(Arrays.toString(solution5(stage, arr6)) );
      //7번문제 거리 구하기
      String dirs = "ULURRDLLU";

      
    }
    // 1번 정렬
    private static int[] solution(int[] arr) {
      Arrays.sort(arr);
      return arr;
    }
    // 2번 동일문자 제거 후 내림차순 정렬
    private static int[] solution1(int[] arr1) {

      // 자바 컬렉션을 사용하여 문제 해결
      // Integer[] answer = Arrays.stream(arr1).boxed().distinct().toArray(Integer[]::new);
      // Arrays.sort(answer, Collections.reverseOrder());

      // return Arrays.stream(answer).mapToInt(Integer::intValue).toArray();

      // TreeSet 을 이용하여 문제 해결
      TreeSet<Integer> tree = new TreeSet<>(Collections.reverseOrder());

      for (int num : arr1) {
        tree.add(num);
      }

      int[] result = new int[tree.size()];
      for (int i = 0; i < result.length; i++) {
        result[i] = tree.pollFirst();
      }
      return result;
    }
    //3번 두 수를 뽑아 오름차순 정렬
    private static int[] solution2(int[] arr2)
    {
      HashSet<Integer> set = new HashSet<>();
      for (int i = 0; i < arr2.length - 1; i++) {
        for (int j = i + 1; j < arr2.length; j++) {
          set.add(arr2[i] + arr2[j]);
        }
      }

      return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
    // 패턴을 비교하여 많이 맞힌 순으로 오름차순 
    private static int[] solution3(int[] arr3)
    {
      int[][] pattern = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }
      };
      int[] result = new int[3];

      for (int i = 0; i < arr3.length; i++) {
        for (int j = 0; j < pattern.length; j++) {
          if (arr3[i] == pattern[j][i % pattern[j].length])
            ;
          {
            result[j]++;
          }
        }
      }
      int maxScore = Arrays.stream(result).max().getAsInt();

      ArrayList<Integer> list = new ArrayList<>();

      for (int i = 0; i < result.length; i++) {
        if (result[i] == maxScore) {
          list.add(i + 1);
        }
      }

      return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private static int[][] solution4(int[][] arr4, int[][] arr5)
    {
      // 행의 길이
      int rLength1 = arr4.length;
      int rLength2 = arr5.length;
      // 열의 길이
      int cLength1 = arr4[0].length;
      int cLength2 = arr5[0].length;

      int[][] result = new int[rLength1][cLength2];

      for (int i = 0; i < rLength1; i++) {
        for (int j = 0; j < cLength2; j++) {
          for (int k = 0; k < cLength1; k++) {
            result[i][j] += arr4[i][k] * arr5[k][j];
          }
        }

      }

      return result;
    }

    private static int[] solution5(int stage, int[] arr6)
    {
      double total = arr6.length; // 참여자수
      int[] challengers = new int[stage + 2];

      for (int i = 0; i < arr6.length; i++) {
        challengers[arr6[i]] += 1;
      }

      HashMap<Integer, Double> result = new HashMap<>();

      for (int i = 1; i <= stage; i++) {
        if (challengers[i] == 0) {
          result.put(i, 0.);
        } else {
          result.put(i, challengers[i] / total);
          total -= challengers[i];
        }
      }
      return result.entrySet().stream().sorted((x, y) -> Double.compare(y.getValue(), x.getValue()))
          .mapToInt(HashMap.Entry::getKey).toArray();
    }
    
    private static HashMap<Character, int[]> location = new HashMap<>();

    private static void initLocation()
    {
      location.put('U', new int[] { 0, 1 });
      location.put('D', new int[] { 0, -1 });
      location.put('L', new int[] { -1, 0 });
      location.put('R', new int[]{1,0});
    }


    private static String solution6(String dirs)
    {
      initLocation();
      int x = 5;
      int y = 5;
      HashSet<String> answer = new HashSet<>();

      for (int i = 0; i < dirs.length(); i++)
      {
        int[] offset = location.get(dirs.charAt(i));

        int nx = x + offset[0];
        int ny = y + offset[1];

        if (!isValidation(nx, ny))
          continue;
        
        answer.add(x + " " + y + " " + nx + " " + ny);
        answer.add(nx + " " + ny + " " + x + " " + y);

      }

      return "ss";
    }

    private static boolean isValidation(int nx, int ny)
    {      
      return 0<= nx  && nx < 11 && 0 <= ny && ny < 11 ;
    }


}
