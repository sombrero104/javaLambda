import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Stream API
 */
public class StreamAPI_01 {

    public static void main(String[] args) {

        /**
         * 1. forEach
         */
        Arrays.asList(1,2,3).stream()
                .forEach(System.out::println);
    }

}
