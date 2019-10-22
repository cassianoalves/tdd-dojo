package cassianoalves.tdddojo.repository;

import java.math.BigDecimal;
import java.util.Currency;

public interface ExchangeRepository {
    BigDecimal getAmountInDollars(Currency currency);
}
