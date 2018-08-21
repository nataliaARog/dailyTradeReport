package action;

import java.math.BigDecimal;

@FunctionalInterface
public interface Operation {

	public BigDecimal calculateTradeAmount(BigDecimal pricePerUnit,int units,BigDecimal agreedFx);
}
