# 람다식(Lambda Expressions)
>식별자 없이 실행 가능한 함수 표현식.
<br/>
자바 8의 가장 특징적인 기능.<br/>
불필요한 코드를 줄이고 가독성을 향상시키는 것이 목적.<br/>
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

### Lambda Expressions Example
<pre>
( parameters ) -> expression body
( parameters ) -> { expression body }
() -> { expression body }
() -> expression body
</pre>
<br/>

### Using @FunctionalInterface
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
이 인터페이스에서는 하나의 추상 메소드를 가지고 있습니다. 바로 calc라는 메소드 입니다.
이 메소드는 int형 매개변수 2개를 받아 하나의 int형 변수를 반환합니다. 아직 내부 구현은 어떻게 할지 정해지지 않았죠.
이 내부 구현을 람다식으로 만든 것이 처음에 보셨던 코드 입니다.
<pre>
Func add = (int a, int b) -> a + b;
</pre>
그러면 혹시 Func 인터페이스에 메소드를 추가하게 되면 어떻게 될까요?
람다식으로 구현했던 add 함수 코드에서 오류가 납니다.
기본적으로 람다식을 위한 인터페이스에서 추상 메소드는 단 하나여야 합니다.
하지만 이러한 사실을 알고 있다 하더라도 람다식으로 사용하는 인터페이스나
그냥 메소드가 하나뿐인 인터페이스나 구별을 하기 힘들뿐더러 혹시라도 누군가 람다식으로 사용하는 인터페이스에
메소드를 추가하더라도 해당 인터페이스에서는 오류가 나지 않습니다.
따라서 이 인터페이스는 람다식을 위한 것이다라는 표현을 위해 애노테이션 @FunctionalInterface 를 사용합니다.
실제로 저 애노테이션을 선언하면 해당 인터페이스에 메소드를 두 개 이상 선언할 경우 유효하지 않다는 오류를 냅니다.
즉, 컴파일러 수준에서 오류를 확인할 수 있습니다.
<pre>
@FunctionalInterface
interface Func {
    public int calc(int a, int b);
}
</pre>
<br/>

### Various uses
다음의 코드는 조금씩 내부 구현을 바꿔본 예제 코드입니다.
<pre>
Func sub = (int a, int b) -> a - b;
Func add = (int a, int b) -> a + b;
Func add2 = (int a, int b) -> { return a + b; };
</pre>
실제로 람다식을 통해 내부를 구현한 함수 add는 어떻게 사용할까요?
위에서 만든 add와 add2 함수를 사용했습니다.
<pre>
int result = add.calc(1, 2) + add2.calc(3, 4); // 10
</pre>
result 변수의 결과값으로 10이 나오게 됩니다.
<br/>


<br/>
https://coding-factory.tistory.com/265 <br/>
https://jdm.kr/blog/181 <br/>
<br/>