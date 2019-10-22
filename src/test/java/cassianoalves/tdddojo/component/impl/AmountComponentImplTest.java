package cassianoalves.tdddojo.component.impl;

import static org.junit.Assert.*;

import cassianoalves.tdddojo.entity.Amount;
import org.junit.Test;

public class AmountComponentImplTest {

	@Test
	public void shouldSumAmountsInSameCurrency() {
		Amount a = new Amount(25000, "USD");
	}
	
	@Test
	public void shouldSumAmountsInDifferentCurrency() {
		
	}
	

}
