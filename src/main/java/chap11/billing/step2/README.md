### step2

---

- 세금 정책을 추가한다.
- 여기에서는 RegularPhone을 대상으로만 tax 정책을 추가한다.

```java
public class TaxableRegularPhone extends RegularPhone {

    private double taxRate;

    public TaxableRegularPhone(Money amount, Duration seconds, double taxRate) {
        super(amount, seconds);
        this.taxRate = taxRate;
    }

    @Override
    public Money calculateFee() {
        Money fee = super.calculateFee(); // super 호출로 인해 결합도 상승
        return fee.plus(fee.times(taxRate));
    }
}
```
- 위와 같이, Phone(추상 클래스)의 메서드인 calculateFee를 overriding 한다.
- super.calculateFee는 추상클래스에 구현된 메서드를 실행한다. 여기 안에서 RegularPhone에서 구현된 추상 메서드(calculateCallFee)가 실행된다.
- 이와 같이 super를 통해 호출하게 되면, 결합도가 높아지게 된다.