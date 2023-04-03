package com.alg.middle;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
public class StockPrice2034 {
    int maxTimestamp;
    HashMap<Integer, Integer> timePriceMap;
    TreeMap<Integer, Integer> prices;

    public StockPrice2034() {
        maxTimestamp = 0;
        timePriceMap = new HashMap<>();
        prices = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        maxTimestamp = Math.max(maxTimestamp, timestamp);
        Integer prePrice = timePriceMap.getOrDefault(timestamp,0);
        timePriceMap.put(timestamp, price);
        if (prePrice > 0) {
            prices.put(prePrice, prices.get(prePrice) - 1);
            if (prices.get(prePrice) == 0) {
                prices.remove(prePrice);
            }
        }
        prices.put(price, prices.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return timePriceMap.get(maxTimestamp);
    }

    public int maximum() {
        return prices.lastKey();
    }

    public int minimum() {
        return prices.firstKey();
    }


}
