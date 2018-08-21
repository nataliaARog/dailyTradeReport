package action;

import java.math.BigDecimal;

@FunctionalInterface
public interface RankVerify {
	
	public boolean verifyRank(BigDecimal value1, BigDecimal value2);

}
