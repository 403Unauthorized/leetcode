package java;

class DayOfTheWeek {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = new String[] {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] monthDay = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int days = 4;
        for (int i = 1971; i < year; i++) {
            boolean leapYear = (i % 4 == 0 && i % 100 != 0) || i % 400 == 0;
            days += leapYear ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            days += monthDay[i - 1];
            if (i == 2 && ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)) days++;
        }
        days += day;
        return week[days % 7];
    }
}
