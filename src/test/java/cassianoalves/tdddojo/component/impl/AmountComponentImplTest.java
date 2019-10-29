package cassianoalves.tdddojo.component.impl;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

import cassianoalves.tdddojo.entity.Amount;
import cassianoalves.tdddojo.exception.DojoSumException;
import cassianoalves.tdddojo.repository.ExchangeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.util.Currency;

@RunWith(MockitoJUnitRunner.class)
public class AmountComponentImplTest {

	@Mock
	private ExchangeRepository exchangeRep;

	@InjectMocks
	private AmountComponentImpl amountComponent;

	@Test
	public void shouldSumAmountsInSameCurrency() {

		Amount retorno = amountComponent.sum(new Amount(new BigDecimal(500),Currency.getInstance("USD")),new Amount(new BigDecimal(540),Currency.getInstance("USD")),Currency.getInstance("USD"));
		assertEquals( Currency.getInstance("USD"),retorno.getCurrency());
		assertEquals(new BigDecimal(1040),retorno.getValue());
	}
	
	@Test
	public void shouldSumAmountsInDifferentCurrency() {
		Mockito.when(exchangeRep.getAmountInDollars(any(Currency.class))).thenReturn(new BigDecimal( 2 ));


		Amount retorno = amountComponent.sum(new Amount(new BigDecimal(500),Currency.getInstance("USD")),new Amount(new BigDecimal(500),Currency.getInstance("EUR")),Currency.getInstance("USD"));
		assertEquals( Currency.getInstance("USD"),retorno.getCurrency());
		assertEquals(new BigDecimal(1500),retorno.getValue());
		Mockito.verify(exchangeRep, Mockito.times(1)).getAmountInDollars(Currency.getInstance("EUR"));
	}

	@Test(expected = DojoSumException.class)
	public void shouldNotSumAmountsWhenAmountNull() {

		amountComponent.sum(null, createAmountSimple(), Currency.getInstance("USD"));

	}

	private Amount createAmountSimple(){
		return  new Amount(new BigDecimal(10), Currency.getInstance("USD"));
	}


}
