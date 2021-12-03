### step3

---
- 기본 정책에 세금 정책 조합하기

```java
public abstract class Phone {
    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for(Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected Money afterCalculated(Money fee) {
        return fee; // 기본 정책이므로 요금 그대로 반환하면 된다.
    }
    
    abstract protected Money calculateCallFee(Call call);
}
```
- afterCalculated라는 메서드를 통해, 하위 클래스에서 이 메서드를 이용하여 부가 정책을 사용하도록 한다.
- 부가 정책은 기본 정책 객체(RegularPhone, NightlyDiscountPhone)에는 관련 없으므로, Phone에서 기본 구현을 제공한다.
- 이를 통해 이와 관련 없는 기본 정책들은 굳이 afterCalfulated 메서드를 오버라이딩 할 필요 없다.
- 이와 같이 자식 클래스에서 오버라이딩할 의도로 메서드를 추가했으나, 편의를 위해 기본 구현을 제공하는 메서드를 훅 메서드(Hook method)라고 한다.

<br>

- 부가 정책을 구현한 TaxableRegularPhone
```java
public class TaxableRegularPhone extends RegularPhone {

    private double taxRate;

    public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.plus(fee.times(taxRate));
    }
}
```
- 이제 자식에서는 부모의 super 메서드를 호출할 필요 없다. 따라서 결합도가 느슨해진다(생성자는 어쩔 수 없다)
- 마찬가지로 심야 폰에서 부가(세금)정책을 할당한 TaxableNighlyDiscouintPhone을 구현하면 된다.
- 문제는, TaxableNightlyDiscountPhone과 TaxableRegularPhone 사이에 오버리이딩 한 메서드의 구현이 중복되게 된다.(afterCalculated)

<br>

- 이번에는 기본 요금 할인 정책을 추가한다고 가정하자.
```java
public class RateDiscountableRegularPhone extends RegularPhone {
    
    private Money discountAmount;
    
    public RateDiscountableRegularPhone(Money amount, Duration seconds, Money discountAmount) {
        super(amount, seconds);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return fee.minus(discountAmount);
    }
}
```
- 마찬가지로 RegularPhone을 상속받는 자식 클래스를 만들고, afterCalculated에 자신만의 로직을 더해서 만들면 된다.
- 상속은 되게 편리한 도구인 것처럼 보인다.. 하지만 NightlyPhone에도 기본 정책을 추가하고자 한다면 마찬가지로 중복이 존재하게 될 것이다.

<br>

- 요구 사항은, 부가 정책을 동시에 적용할 수 있다는 것이다. 따라서 조합별로 자식 클래스를 하나씩 추가하면 된다.
```java
public class TaxableAndRateDiscountableRegularPhone extends TaxableRegularPhone {

    private Money discountAmount;
    
    public TaxableAndRateDiscountableRegularPhone(Money amount, Duration seconds, double taxRate, Money discountAmount) {
        super(amount, seconds, taxRate);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).minus(discountAmount);
    }
}
```
- 위 자식 클래스는, 부가 정책을 2개 사용한다. 여기에서는 tax 정책을 먼저 적용하고, 할인정책을 나중에 적용한다.
- 이와 같이 조합을 통해 모든 경우의 클래스를 만들면 된다.
- 복잡해보이는 클래스 네임에도 문제가 있지만, 현재 설계에 새로운 정책이 추가된다면 불필요하게 많은 수의 클래스를 상속에 추가해야 한다.
  
- 새로운 기본정책이 추가된다고 가정한다면, 이에 맞는 부가정책에 대한 조합 클래스를 똑같이 생성해야 한다.. bad
- 이처럼 상속의 남용으로 하나의 기능을 추가하기 위해 필요 이상으로 많은 클래스를 추가하는 경우를 클래스 폭발(class explosion) 또는 조합의 폭발(combinational explosion)이라고 한다.
- 컴파일 타임에 결정된 자식, 부모 사이의 관계는 변경될 수 없기 때문에 다양한 조합이 필요한 상황에서 유일한 해결 방법은, 조합의 수만큼 새로운 클래스를 추가하는 것이다.
- 이 문제를 해결하는 최선의 방법은 **상속을 포기하는 것이다.**

