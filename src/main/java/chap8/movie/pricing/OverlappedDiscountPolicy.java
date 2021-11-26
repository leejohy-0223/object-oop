package chap8.movie.pricing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chap2.money.Money;
import chap2.movie.step1.Screening;
import chap8.movie.DiscountPolicy;

public class OverlappedDiscountPolicy extends DiscountPolicy {

	private List<DiscountPolicy> discountPolicies = new ArrayList<>();

	public OverlappedDiscountPolicy(DiscountPolicy ... discountPolicies) {
		this.discountPolicies = Arrays.asList(discountPolicies);
	}

	@Override
	protected Money getDiscountAmount(Screening screening) {
		Money result = Money.ZERO;
		for(DiscountPolicy each : discountPolicies) {
			result = result.plus(each.calculateDiscountAmount(screening));
			// result = result.plus(each.getDiscountAmount(screening)); protected라 호출 불가
		}
		return result;
	}
}
