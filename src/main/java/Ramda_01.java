/**
 * 두개의 숫자 더하기.
 */
public class Ramda_01 {

    public interface Compare {
        public int compareTo(int a, int b);
    }

    public static void exec(Compare compare) {
        int k = 10;
        int m = 20;
        int value = compare.compareTo(k, m);
        System.out.println(value);
    }

    public static void main(String[] args) {
        exec((i, j)->{ // compareTo(int a, int b) 부분, Compare 인터페이스를 구현
            return i+j;
        });
    }

}
