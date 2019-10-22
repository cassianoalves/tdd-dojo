package cassianoalves.tdddojo.component;

import cassianoalves.tdddojo.entity.Amount;

import java.util.Currency;

public interface AmountComponent {
    Amount sum(Amount a, Amount b, Currency currencyToReturn);
}
