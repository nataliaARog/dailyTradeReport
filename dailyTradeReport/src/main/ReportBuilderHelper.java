package main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.function.Predicate;

import action.Operation;
import util.Currency;
import util.WeekDay;

public class ReportBuilderHelper {

	public static BigDecimal calculate(BigDecimal pricePerUnit,int units,BigDecimal agreedFx) {
		Operation operation = (p,u,a) -> p.multiply(new BigDecimal(u)).multiply(a);
		return operation.calculateTradeAmount(pricePerUnit, units, agreedFx);
	}

	@SuppressWarnings("unlikely-arg-type")
	public static LocalDate setSettlementDate(LocalDate settlementDate, String currency) {
		Predicate<String> isSAROrAED = (c) -> {
			return Currency.AED.equals(c) || Currency.SAR.equals(c);
		};	

		if(isSAROrAED.test(currency)) {
			return setSettlementDate(settlementDate);

		} else {
			return setSettlementDateCommon(settlementDate);
		}
	}

	@SuppressWarnings("unlikely-arg-type")
	private static LocalDate setSettlementDateCommon(LocalDate settlementDate) {
		Predicate<LocalDate> isOneDayInvalidCommon = (d) -> {
			return WeekDay.SUNDAY.equals(d.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.UK));
		};

		Predicate<LocalDate> isTwoDaysInvalidCommon = (d) -> {
			return WeekDay.SATURDAY.equals(d.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.UK));
		};
		
		if(isOneDayInvalidCommon.test(settlementDate)) {
			return settlementDate.plusDays(1);
			
		} else if(isTwoDaysInvalidCommon.test(settlementDate)) {
			return settlementDate.plusDays(2);
		}
		
		return settlementDate;
	}

	@SuppressWarnings("unlikely-arg-type")
	private static LocalDate setSettlementDate(LocalDate settlementDate) {
		Predicate<LocalDate> isOneDayInvalid = (d) -> {
			return WeekDay.SATURDAY.equals(d.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.UK));
		};

		Predicate<LocalDate> isTwoDaysInvalid = (d) -> {
			return WeekDay.FRIDAY.equals(d.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.UK));
		};
		
		if(isOneDayInvalid.test(settlementDate)) {
			return settlementDate.plusDays(1);
			
		} else if(isTwoDaysInvalid.test(settlementDate)) {
			return settlementDate.plusDays(2);
		}
		
		return settlementDate;
	}
}
