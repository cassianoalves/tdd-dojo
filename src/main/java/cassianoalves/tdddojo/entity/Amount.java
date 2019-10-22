package cassianoalves.tdddojo.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Currency;

@Data
public class Amount {
	private BigDecimal value;
	private Currency currency;
}
