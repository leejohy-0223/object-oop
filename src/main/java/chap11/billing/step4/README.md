### step4

---
#### 합성 관계로 변경하기
- 합성은 컴파일 타임 관계를 런타임 관계로 변경함으로써 클래스 폭발 문제를 해결한다.
- 상속을 사용하는 것은 컴파일, 런타임 의존성을 동일하게 만들겠다고 선언하는 것이다. 따라서 부모 - 자식 관계가 정적으로 고정되기 때문에 실행 시점에 동적으로
변경할 방법이 없다.
  
- 합성은 런타임에 동적으로 변경 가능하다. 구현 시점에 정책의 관계를 고정시킬 필요가 없어진다.

<br>

#### 기본 정책 합성하기
- RatePolicy라는 인터페이스를 두고, 각각 일반 요금제 / 부과 요금제 용 추상 클래스를 만든다.
- AdditionalRatePolicy는, 일반 요금제에 추가로 부과되는 것이다. 따라서 부과 요금제에는 일반 요금제 또는 또다른 부과요금제를 참조할 수 있는 RatePolicy 참조자가 필요하다.
- 즉, 메시지의 흐름은 Phone -> 부가 정책 -> 일반 정책으로 전달되어야 하며, 반환결과는 일반정책요금 -> 일반 + 부과정책된 요금이 되어야 한다.


```java
        // 1. 일반 요금제 + 부가 요금제
        Phone phone1 = new Phone(
            new TaxablePolicy(
                new RegularPolicy(Money.wons(100), Duration.ofSeconds(10)), 0.01));

        // 2. 일반 요금제 + 기본 요금 할인 정책 + 세금 정책
        Phone phone2 = new Phone(
            new TaxablePolicy(
                new RateDiscountablePolicy(
                    new RegularPolicy(Money.wons(100), Duration.ofSeconds(10)), Money.wons(100)), 0.01));

        // 3. 일반 요금제 + 세금 정책 + 기본 요금 정책
        Phone phone3 = new Phone(
            new RateDiscountablePolicy(
                new TaxablePolicy(
                    new RegularPolicy(Money.wons(100), Duration.ofSeconds(10)), 0.01), Money.wons(100)));

```
- 위와 같이 유연한 합성을 통해, 다양한 요금제 조합을 런타임(클라이언트가 사용하는 시점)에 직접 주입하여 결정할 수 있도록 한다.
