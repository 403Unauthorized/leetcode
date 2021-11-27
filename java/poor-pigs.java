//
//
package java;

class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest / minutesToDie;
        int base = times + 1;
        return (int) Math.ceil(Math.log(buckets) / Math.log(base));
    }
}