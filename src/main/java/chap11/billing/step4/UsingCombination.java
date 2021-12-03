package chap11.billing.step4;

import java.time.Duration;

import chap05.money.Money;

public class UsingCombination {
    public static void main(String[] args) {

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



    }
}
