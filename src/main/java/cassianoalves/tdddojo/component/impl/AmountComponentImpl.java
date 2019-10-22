package cassianoalves.tdddojo.component.impl;

import cassianoalves.tdddojo.component.AmountComponent;
import cassianoalves.tdddojo.entity.Amount;
import cassianoalves.tdddojo.repository.ExchangeRepository;
import lombok.Builder;
import java.util.Currency;

@Builder
public class AmountComponentImpl implements AmountComponent {
	private ExchangeRepository exchangeRepository;
	
	public Amount sum(Amount a, Amount b, Currency currencyToReturn) {

		Amount resultCurrencyA = getAmountInCurrency(a, currencyToReturn);
		Amount resultCurrencyB = getAmountInCurrency(b, currencyToReturn);

		return Amount.getInstance(resultCurrencyA.getValue().add(resultCurrencyB.getValue()), currencyToReturn);
	}

	private Amount getAmountInCurrency(Amount a, Currency currencyToReturn) {
		if(a.getCurrency().equals(currencyToReturn)) {
			return a;
		}
		return null;
	}
}
