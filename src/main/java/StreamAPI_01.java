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
        System.out.println("[forEach]-----------------------------------");
        Arrays.asList(1,2,3).stream()
                .forEach(System.out::println); // 1,2,3

        /**
         * 2. map
         * stream 개별 요소마다 연산 수행.
         * 아래 코드는 리스트에 있는 요소의 제곱 연산을 수행한다.
         */
        System.out.println("[map]-----------------------------------");
        Arrays.asList(1,2,3).stream()
                .map(i -> i*i)
                .forEach(System.out::println); // 1,4,9

        /**
         * 3. limit
         * stream의 최초 요소부터 선언한 인덱스까지의 요소를 추출해서
         * 새로운 stream을 만든다.
         */
        System.out.println("[limit]-----------------------------------");
        Arrays.asList(1,2,3).stream()
                .limit(1)
                .forEach(System.out::println); // 1

        /**
         * 4. skip
         * stream의 최초 요소부터 선언한 인덱스까지의 요소를 제외하고
         * 새로운 stream을 만든다.
         */
        System.out.println("[skip]-----------------------------------");
        Arrays.asList(1,2,3).stream()
                .skip(1)
                .forEach(System.out::println); // 2,3

        /**
         * 5. filter
         * stream의 요소마다 비교를 하고
         * 비교문을 만족하는 요소로만 구성된 stream을 반환한다.
         */
        System.out.println("[filter]-----------------------------------");
        Arrays.asList(1,2,3).stream()
                .filter(i -> i<=2)
                .forEach(System.out::println); // 1,2
    }

}
