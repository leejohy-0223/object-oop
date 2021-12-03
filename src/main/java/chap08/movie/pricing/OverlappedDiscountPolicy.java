package chap08.movie.pricing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chap02.money.Money;
import chap02.movie.step1.Screening;
import chap08.movie.DiscountPolicy;

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
