package action;

import java.time.LocalDate;

@FunctionalInterface
public interface DateVerify {

	public boolean verifyDate(LocalDate date);
}
