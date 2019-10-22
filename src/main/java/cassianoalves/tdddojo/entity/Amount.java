package cassianoalves.tdddojo.entity;

import lombok.Getter;
import java.math.BigDecimal;
import java.util.Currency;

@Getter
public class Amount {
	private BigDecimal value;
	private Currency currency;

	private Amount(long value, String currencyCode) {
		this.value = BigDecimal.valueOf(value);
		this.currency = Currency.getInstance(currencyCode);
	}

	public static Amount getInstance(long value, String currencyCode) {
		return new Amount(value, currencyCode);
	}
}
