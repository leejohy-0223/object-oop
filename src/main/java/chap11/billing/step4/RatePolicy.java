package chap11.billing.step4;

import chap05.money.Money;

public interface RatePolicy {
    /**
     *
     * @param phone
     * @return 계산된 요금 반환
     */
    Money calculateFee(Phone phone);
}
