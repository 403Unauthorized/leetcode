package java;

class StudentAttendanceRecord1 {
    public boolean checkRecord(String s) {
        char[] chs = s.toCharArray();
        int lateTimes = 0;
        int absentTimes = 0;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == 'P') continue;
            if (chs[i] == 'A') {
                absentTimes++;
                if (absentTimes == 2) {
                    return false;
                }
            }
            if (chs[i] == 'L') {
                if (lateTimes > 0) {
                    if (chs[i - 1] == 'L') {
                        lateTimes++;
                        if (lateTimes == 3) return false;
                    } else {
                        lateTimes = 1;
                    }
                } else {
                    lateTimes = 1;
                }
            }
        }
        return true;
    }
}
