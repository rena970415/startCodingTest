import java.util.Arrays;      // Arrays 관련 메서드를 사용하기 위한 패키지 임포트
import java.util.Collections; // Collections 관련 메서드를 사용하기 위한 패키지 임포트

public class App {
    public static void main(String[] args) throws Exception {
        // 기본 int 배열을 선언하고 값을 초기화
        int[] Iarr = { 4, 4, 1, 1, 2, 3 };

        // 결과를 출력할 때 배열을 문자열로 변환하여 출력
        // Arrays.toString()은 배열을 "[1, 2, 3]" 형식으로 문자열로 만들어줌
        System.out.println("결과 : " + Arrays.toString(removeDistinctNumber(Iarr)));
    }

    /**
     * 이 메서드는 배열에서 중복된 숫자를 제거하고 내림차순으로 정렬한 후 반환합니다.
     * @param arr 입력받은 int 배열
     * @return 중복이 제거되고 내림차순으로 정렬된 int 배열
     */
    private static int[] removeDistinctNumber(int arr[]) {
        // 1. Arrays.stream(arr): 배열을 스트림(데이터의 흐름)으로 변환
        // 2. .boxed(): 기본형 int를 객체 Integer로 박싱 (Stream<Integer>로 변환)
        // 3. .distinct(): 스트림에서 중복된 값을 제거
        // 4. .toArray(Integer[]::new): 결과를 새로운 Integer 배열로 변환
        Integer[] result = Arrays.stream(arr) // 배열을 스트림으로 변환
                                .boxed()      // int -> Integer (박싱)
                                .distinct()   // 중복된 값 제거
                                .toArray(Integer[]::new); // Integer 배열로 변환

        // 5. Arrays.sort: 배열을 내림차순으로 정렬
        Arrays.sort(result, Collections.reverseOrder());

        // 6. 스트림을 사용하여 다시 Integer 배열을 int 배열로 변환
        // .mapToInt(Integer::intValue): Integer 값을 다시 int로 변환 (언박싱)
        // .toArray(): 최종적으로 int 배열로 변환
        return Arrays.stream(result)         // Integer 배열을 다시 스트림으로 변환
                     .mapToInt(Integer::intValue) // Integer -> int (언박싱)
                     .toArray();                 // 최종적으로 int 배열로 변환
    }
}
