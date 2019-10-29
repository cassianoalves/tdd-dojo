package cassianoalves.tdddojo.component.impl;

import cassianoalves.tdddojo.component.AmountComponent;
import cassianoalves.tdddojo.entity.Amount;
import cassianoalves.tdddojo.exception.DojoSumException;
import cassianoalves.tdddojo.repository.ExchangeRepository;
import lombok.Builder;
import java.util.Currency;

@Builder
public class AmountComponentImpl implements AmountComponent {
	private ExchangeRepository exchangeRepository;
	
	public Amount sum(Amount a, Amount b, Currency currencyToReturn) {
		// TODO
		Amount result = new Amount();
		try {
			if(a.getCurrency().equals(b.getCurrency())){
					
			}else {
				result.setValue(a.getValue().add(b.getValue()));
				result.setCurrency(currencyToReturn);
			}
		} catch (NullPointerException e) {
			throw new DojoSumException();
		}

		return result;
	}
}
