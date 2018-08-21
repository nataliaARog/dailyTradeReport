package util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Formatter {

	private Formatter() {
		 
	}
	
	public static String format(LocalDate date) {
		StringBuilder sb = new StringBuilder();
		sb.append(date.getDayOfYear());
		sb.append(" ");
		sb.append(date.getMonth().getDisplayName(TextStyle.SHORT, Locale.UK));
		sb.append(" ");
		sb.append(date.getYear());
		return sb.toString();
	}
	
	public static String format(BigDecimal currency) {
		return NumberFormat.getCurrencyInstance(Locale.US).format(currency).replace("$","");
	}
}
