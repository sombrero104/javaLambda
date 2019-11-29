import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Stream API
 */
public class StreamAPI_01 {

    public static void main(String[] args) {

        /**
         * 1. forEach
         * stream 요소를 순회.
         */
        Arrays.asList(1,2,3).stream()
                .forEach(System.out::println); // 1,2,3

        /**
         * 2. map
         * stream 개별 요소마다 연산 수행.
         * 아래 코드는 리스트에 있는 요소의 제곱 연산을 수행한다.
         */
        Arrays.asList(1,2,3).stream()
                .map(i -> i*i)
                .forEach(System.out::println); // 1,4,9
    }

}
