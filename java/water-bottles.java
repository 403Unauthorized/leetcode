package java;

class WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles / numExchange > 0) {
            int bottles = numBottles / numExchange;
            ans += bottles;
            bottles += numBottles % numExchange;
            numBottles = bottles;
        }
        return ans;
    }
}
