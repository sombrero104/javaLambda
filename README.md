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

<br/>
https://coding-factory.tistory.com/265 <br/>
https://jdm.kr/blog/181 <br/>
<br/>