package cassianoalves.tdddojo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.math.BigDecimal;
import java.util.Currency;

@Getter
@AllArgsConstructor
public class Amount {
	private BigDecimal value;
	private Currency currency;

	private Amount(long value, String currencyCode) {
		this.currency = Currency.getInstance(currencyCode);
		this.value = BigDecimal.valueOf(value).setScale(this.currency.getDefaultFractionDigits());
	}

	public static Amount getInstance(long value, String currencyCode) {
		return new Amount(value, currencyCode);
	}

	public static Amount getInstance(BigDecimal value, Currency currency) {
		return new Amount(value.setScale(currency.getDefaultFractionDigits()), currency);
	}
}
