public class APCalendar
{
    private static boolean isLeapYear(int year)
    {
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            return true;
        }
        return false;
    }
    public static int numberOfLeapYears(int year1, int year2)
    {
        int totalLeapYears = 0;
        for (int i = year1; i <= year2; i++) {
            if (isLeapYear(i)) {
                totalLeapYears++;
            }
        }
        return  totalLeapYears;
    }
    public static int firstDayOfYear(int year)
    {
        int day = 6; //2000 Jan 1st Saturday
        if (year > 2000) {
            for (int i = 2000; i < year; i++) {
                int days = isLeapYear(i) ? 366 : 365; //if isleapyear then 366 else 365
                day = (day + days) % 7; //mod to get the actual week
            }
        } else {
            for (int i = 1999; i >= year; i--) {
                int days = isLeapYear(i) ? 366 : 365; //if isleapyear then 366 else 365
                day = (day - days) % 7;
                if (day < 0) day += 7 ;
            }
        }

        return day;
    }
    public static int dayOfYear(int month, int day, int year)
    {
        int n = 0;
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            daysInMonth[1] = 29; //leap year so feb becomes 29
        }

        for (int i = 0; i < month - 1; i++) {
            n += daysInMonth[i];
        }
        n += day;
        return n;
    }
    public static int dayOfWeek(int month, int day, int year)
    {
        int firstDay = firstDayOfYear(year);
        int dayNumber = dayOfYear(month, day, year);
        return (firstDay + dayNumber - 1) % 7;
    }
}