package cassianoalves.tdddojo.entity;

import lombok.Getter;
import java.math.BigDecimal;
import java.util.Currency;

@Getter
public class Amount {
	private BigDecimal value;
	private Currency currency;

	public Amount(long value, String currency) {
		this.value = BigDecimal.valueOf(value);
		this.currency = Currency.getInstance(currency);
	}
}
