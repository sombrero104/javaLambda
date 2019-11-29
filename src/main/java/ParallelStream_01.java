import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 병렬 스트림(Parallel Stream)
 * 스트림 생성 시 사용하는 stream() 대신 parallelStream() 메소드를 사용해서 병렬 스트림을 쉽게 생성할 수 있습니다.
 * 내부적으로는 쓰레드를 처리하기 위해 자바 7부터 도입된 Fork/Join framework 를 사용합니다.
 */
public class ParallelStream_01 {

    public static class Product {
        int amount = 0;

        Product(int amount) {
            this.amount = amount;
        }

        public int getAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(10));
        productList.add(new Product(300));
        productList.add(new Product(120));

        // 병렬 스트림 생성.
        Stream<Product> parallelStream = productList.parallelStream();

        // 병렬 여부 확인.
        boolean isParallel = parallelStream.isParallel();
        System.out.println("# isParallel: " + isParallel);

        // 따라서 다음 코드는 각 작업을 스레드를 이용해 병렬 처리된다.
        boolean isMany = parallelStream
                .map(product -> product.getAmount()*10)
                .anyMatch(amount -> amount > 200);
        System.out.println("# isMany: " + isMany);
    }

}
