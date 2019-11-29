/**
 * 두개의 숫자중 큰 수 찾기.
 */
public class Ramda_02 {

    @FunctionalInterface
    public interface  MyNumber {
        int getMax(int num1, int num2);
    }

    public static void main(String[] args) {
        MyNumber max = (x, y)->(x>=y)?x:y;
        System.out.println(max.getMax(10, 30));
    }

}
