import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        /**
         * 6. flatMap
         * stream의 내부에 있는 객체들을 연결한 stream을 반환한다.
         */
        System.out.println("[flatMap]-----------------------------------");
        Arrays.asList(Arrays.asList(1,2), Arrays.asList(3,4,5), Arrays.asList(6,7,8,9)).stream()
                .flatMap(i -> i.stream())
                .forEach(System.out::println); // 1,2,3,4,5,6,7,8,9

        /**
         * 7. reduce
         * stream을 단일 요소로 반환한다.
         * 아래 코드에서는 첫번째 연산으로 1과 2가 선택되고,
         * 계산식은 앞의 값에서 뒤의 값을 빼는 것이기 때문에 결과가 -1이 된다.
         * 그리고 바로 다음 값 3이 선택되고 계산식이 -1-3이 되어서 최종 결과로는 -4가 된다.
         */
        System.out.println("[reduce]-----------------------------------");
        int reduce = Arrays.asList(1,2,3).stream()
                .reduce((a,b) -> a-b)
                .get();
        System.out.println(reduce); // -4

        /**
         * 8. collection
         * 아래의 코드들은 각각의 메소드로 컬렉션 객체를 만들어서 반환한다.
         */
        System.out.println("[collection]-----------------------------------");

        // (1) List로 변환.
        List list = Arrays.asList(1,2,3).stream()
                .collect(Collectors.toList());
        System.out.println("# list: " + list);

        // (2) Iterator로 변환.
        Iterator iterator = Arrays.asList(1,2,3).stream()
                .iterator();
        while(iterator.hasNext())
            System.out.println("# iterator: " + iterator.next());


        Stream stream = Arrays.asList(1,2,3).stream();
    }

}
