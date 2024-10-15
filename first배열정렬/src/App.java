import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // 배열 크기 입력 받기
        System.out.print("배열의 크기를 입력하세요: ");
        int n = scanner.nextInt(); 

        // 배열 요소 입력 받기
        int[] arr = new int[n];
        System.out.println(n + "개의 숫자를 입력하세요:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // 정렬된 배열 얻기
        int[] sorted = solution(arr);
        System.out.println("정렬된 배열: " + Arrays.toString(sorted));

        scanner.close(); // Scanner 닫기
    }

    private static int[] solution(int[] arr) {
        Arrays.sort(arr); // 배열 정렬
        return arr;
    }
}
