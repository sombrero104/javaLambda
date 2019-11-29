# 람다식(Lambda Expressions)
>식별자 없이 실행 가능한 함수 표현식.
<br/>
자바 8의 가장 특징적인 기능.<br/>
불필요한 코드를 줄이고 가독성을 향상시키는 것이 목적.<br/>
메서드를 하나의 '식(expression)'으로 표현한 것.<br/>
람다식 표현에는 메서드 이름과 반환값이 없다.(때문에 익명 함수(anonymous function)이라고도 부른다.) <br/>
람다식은 메서드의 매개변수로 전달될 수 있고, 메서드의 결과로 반환될 수도 있다. <br/>
즉, 메서드를 변수처럼 다루는 것이 가능하다. <br/>
<br/>

#### 장점
- 코드를 간결하게 만들 수 있다.
- 개발자의 의도가 명확히 드러나므로 가독성이 향상된다.
- 함수를 만드는 과정없이 한번에 처리할 수 있어서 코딩하는 시간이 줄어든다.
- 병렬 프로그래밍이 용이하다.
<br/>

#### 단점
- 람다를 사용하면서 만드는 무명함수는 재사용이 불가능하다.
- 디버깅이 다소 까다롭다.
- 람다를 남발하면 코드가 지저분해질 수 있다.(코드를 중복 생성할 가능성이 높음.)
- 재귀로 만들 경우에 다소 부적합한 면이 있다.
<br/>

## Lambda Expressions Example
<pre>
( parameters ) -> expression body
( parameters ) -> { expression body }
() -> { expression body }
() -> expression body
</pre>
<br/>

## Using @FunctionalInterface
객체지향 언어인 자바에서 값이나 객체가 아닌 하나의 함수(Function)을 변수에 담아둔다는 것은 이해가 되지 않을 것입니다.<br/>
하지만 자바8에서 람다식이 추가되고 나서는 하나의 변수에 하나의 함수를 매핑할 수 있습니다.<br/>
<pre>
Func add = (int a, int b) -> a + b;
</pre>
int형 매개변수 a, b를 받아 그것을 합치는 것을 람다식으로 표현한 것입니다.<br/>
그러면 Func는 무엇이어야 할까요? 답은 interface 입니다.<br/>
<pre>
interface Func {
    public int calc(int a, int b);
}
</pre>
이 인터페이스에서는 하나의 추상 메소드를 가지고 있습니다. 바로 calc라는 메소드 입니다.<br/>
이 메소드는 int형 매개변수 2개를 받아 하나의 int형 변수를 반환합니다. 아직 내부 구현은 어떻게 할지 정해지지 않았죠.<br/>
이 내부 구현을 람다식으로 만든 것이 처음에 보셨던 코드 입니다.<br/>
<pre>
Func add = (int a, int b) -> a + b;
</pre>
그러면 혹시 Func 인터페이스에 메소드를 추가하게 되면 어떻게 될까요?<br/>
람다식으로 구현했던 add 함수 코드에서 오류가 납니다.<br/>
기본적으로 람다식을 위한 인터페이스에서 추상 메소드는 단 하나여야 합니다.<br/>
하지만 이러한 사실을 알고 있다 하더라도 람다식으로 사용하는 인터페이스나<br/>
그냥 메소드가 하나뿐인 인터페이스나 구별을 하기 힘들뿐더러 혹시라도 누군가 람다식으로 사용하는 인터페이스에<br/>
메소드를 추가하더라도 해당 인터페이스에서는 오류가 나지 않습니다.<br/>
따라서 이 인터페이스는 람다식을 위한 것이다라는 표현을 위해 애노테이션 @FunctionalInterface 를 사용합니다.<br/>
실제로 저 애노테이션을 선언하면 해당 인터페이스에 메소드를 두 개 이상 선언할 경우 유효하지 않다는 오류를 냅니다.<br/>
즉, 컴파일러 수준에서 오류를 확인할 수 있습니다.<br/>
<pre>
@FunctionalInterface
interface Func {
    public int calc(int a, int b);
}
</pre>

### Various uses
다음의 코드는 조금씩 내부 구현을 바꿔본 예제 코드입니다.<br/>
<pre>
Func sub = (int a, int b) -> a - b;
Func add = (int a, int b) -> a + b;
Func add2 = (int a, int b) -> { return a + b; };
</pre>
실제로 람다식을 통해 내부를 구현한 함수 add는 어떻게 사용할까요?<br/>
위에서 만든 add와 add2 함수를 사용했습니다.<br/>
<pre>
int result = add.calc(1, 2) + add2.calc(3, 4); // 10
</pre>
result 변수의 결과값으로 10이 나오게 됩니다.<br/>
<br/><br/><br/>

## Stream
컬렉션, 배열 등의 저장 요소를 하나씩 참조하여 <br/>
함수형 인터페이스(람다식)를 적용하며 반복적으로 처리할 수 있도록 해주는 기능.<br/>
<br/>
스트림은 '데이터의 흐름’입니다. <br/>
배열 또는 컬렉션 인스턴스에 함수 여러 개를 조합해서 원하는 결과를 필터링하고 가공된 결과를 얻을 수 있습니다. <br/>
또한 람다를 이용해서 코드의 양을 줄이고 간결하게 표현할 수 있습니다. <br/>
즉, 배열과 컬렉션을 함수형으로 처리할 수 있습니다.<br/>
<br/>
또 하나의 장점은 간단하게 병렬처리(multi-threading)가 가능하다는 점입니다. <br/>
하나의 작업을 둘 이상의 작업으로 잘게 나눠서 동시에 진행하는 것을 병렬 처리(parallel processing)라고 합니다. <br/>
즉 쓰레드를 이용해 많은 요소들을 빠르게 처리할 수 있습니다.<br/>
<br/>
https://futurecreator.github.io/2018/08/26/java-8-streams/ <br/>
<br/>

## Stream API
### Get Stream
Stream API를 사용하려면 stream을 얻어와야 합니다. 얻는 방법은 다음과 같습니다.<br/>
<pre>
1. stream을 가져오는 일반적인 방법.
Arrays.asList(1,2,3).stream();

2. 병렬로 stream을 가져오는 방법.
Arrays.asList(1,2,3).parallelStream();
</pre>
실제로 얻어온 stream에 연산을 해봅시다. 주요하게 쓰이는 몇가지 API만 살펴봅시다.<br/>
<br/>

#### 1. forEach<br/>
stream의 요소를 순회해야 한다면 forEach를 활용할 수 있습니다.<br/>
<pre>
Arrays.asList(1,2,3).stream()
    .forEach(System.out::println); // 1,2,3
</pre>

#### 2. map<br/>
stream의 개별 요소마다 연산을 수행할 수 있습니다.<br/>
아래의 코드는 리스트에 있는 요소의 제곱 연산을 합니다.<br/>
<pre>
Arrays.asList(1,2,3).stream()
    .map(i -> i*i)
    .forEach(System.out::println); // 1,4,9
</pre>

#### 3. limit<br/>
stream의 최초 요소부터 선언한 인덱스까지의 요소를 추출해서 새로운 stream을 만듭니다.<br/>
<pre>
Arrays.asList(1,2,3).stream()
    .limit(1)
    .forEach(System.out::println); // 1
</pre>

#### 4. skip<br/>
stram의 최초 요소부터 선언한 인덱스까지의 요소를 제외하고 새로운 stream을 만듭니다.<br/>
<pre>
Arrays.asList(1,2,3).stream()
    .skip(1)
    .forEach(System.out::println); // 2,3
</pre>

#### 5. filter<br/>
stream의 요소마다 비교를 하고 비교문을 만족하는 요소로만 구성된 stream을 반환한다.<br/>
<pre>
Arrays.asList(1,2,3).stream()
    .filter(i -> i<=2)
    .forEach(System.out::println); // 1,2
</pre>

#### 6. flatMap<br/>
stream의 내부에 있는 객체들을 연결한 stream을 반환한다.<br/>
<pre>
Arrays.asList(Arrays.asList(1,2), Arrays.asList(3,4,5), Arrays.asList(6,7,8,9)).stream()
    .flatMap(i -> i.stream())
    .forEach(System.out::println); // 1,2,3,4,5,6,7,8,9
</pre>

#### 7. reduce<br/>
stream을 단일 요소로 반환한다.<br/>
아래 코드에서는 첫번째 연산으로 1과 2가 선택되고, 계산식은 앞의 값에서 뒤의 값을 빼는 것이기 때문에 결과가 -1이 된다.
그리고 바로 다음 값 3이 선택되고, 계산식이 -1-3이 되어서 최종 결과로는 -4가 된다.
<pre>
int reduce = Arrays.asList(1,2,3).stream()
        .reduce((a,b) -> a-b)
        .get();
System.out.println(reduce); // -4
</pre>

#### 8. collection<br/>
아래의 코드들은 각각의 메소드로 컬렉션 객체를 만들어서 반환한다.<br/>
<pre>
// (1) List로 변환.
List list = Arrays.asList(1,2,3).stream()
        .collect(Collectors.toList());
System.out.println("# list: " + list);

// (2) Iterator로 변환.
Iterator iterator = Arrays.asList(1,2,3).stream()
        .iterator();
while(iterator.hasNext())
    System.out.println("# iterator: " + iterator.next());
</pre>
<br/>
https://coding-factory.tistory.com/265 <br/>
https://jdm.kr/blog/181 <br/>
https://futurecreator.github.io/2018/08/26/java-8-streams/ <br/>
<br/><br/><br/>

### 병렬 스트림(Parallel Stream)
스트림 생성 시 사용하는 stream() 대신 parallelStream() 메소드를 사용해서 병렬 스트림을 쉽게 생성할 수 있습니다.<br/>
내부적으로는 쓰레드를 처리하기 위해 자바 7부터 도입된 Fork/Join framework 를 사용합니다.<br/>
<pre>
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
</pre>
<br/>
https://futurecreator.github.io/2018/08/26/java-8-streams/ <br/>
<br/>