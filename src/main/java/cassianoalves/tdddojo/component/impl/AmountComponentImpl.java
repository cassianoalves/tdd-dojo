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
		// TODO
		return null;
	}
}
