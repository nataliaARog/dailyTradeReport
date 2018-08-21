package util;

public enum WeekDay {
	
	MONDAY("Monday"), TUESDAY("Tuesday"), WEDNESDAY("Wednesday"), THURSDAY("Thursday"), FRIDAY("Friday"),
	SATURDAY("Saturday"), SUNDAY("Sunday");
	
	private String weekDay = "";

	WeekDay(String weekDay) {
        this.weekDay = weekDay;
    }

    @Override
    public String toString() {
        return weekDay;
    }

}
