package cassianoalves.tdddojo.component.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import cassianoalves.tdddojo.entity.Amount;
import cassianoalves.tdddojo.repository.ExchangeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Currency;

@RunWith(MockitoJUnitRunner.class)
public class AmountComponentImplTest {
	@Mock
	ExchangeRepository exchangeRepository;

	@InjectMocks
	AmountComponentImpl amountComponent;

	@Test
	public void shouldSumAmountsInSameCurrency() {
		Amount a = Amount.getInstance(25000, "USD");
		Amount b = Amount.getInstance(40000, "USD");

		Amount result = amountComponent.sum(a, b, Currency.getInstance("USD"));

		verifyZeroInteractions(exchangeRepository);
		assertEquals(BigDecimal.valueOf(65000).setScale(2), result.getValue());
		assertEquals(Currency.getInstance("USD"), result.getCurrency());
	}
	
	@Test
	public void shouldSumAmountsInDifferentCurrency() {
		Amount a = Amount.getInstance(25000, "USD");
		Amount b = Amount.getInstance(56000, "EUR");

		when(exchangeRepository.getAmountInDollars(Currency.getInstance("EUR")))
				.thenReturn(BigDecimal.valueOf(1.4));

		Amount result = amountComponent.sum(a, b, Currency.getInstance("USD"));

		verify(exchangeRepository, times(1)).getAmountInDollars(Currency.getInstance("EUR"));
		assertEquals(BigDecimal.valueOf(103400).setScale(2), result.getValue());
		assertEquals(Currency.getInstance("USD"), result.getCurrency());
	}
	

}
