package com.alg.middle;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
public class StockPrice2034Queue {
    int maxTimestamp;
    HashMap<Integer, Integer> timePriceMap;
    PriorityQueue<int[]> pqMax;
    PriorityQueue<int[]> pqMin;
    public StockPrice2034Queue() {
        int maxTimestamp = 0;
        timePriceMap = new HashMap<>();
        pqMax = new PriorityQueue<>();
        pqMin = new PriorityQueue<>();
    }

    public void update(int timestamp, int price) {
        maxTimestamp = Math.max(timestamp,maxTimestamp);
        timePriceMap.put(timestamp,price);
        pqMax.offer(new int[]{price,timestamp});
        pqMin.offer(new int[]{price,timestamp});
    }

    public int current() {
        return timePriceMap.get(maxTimestamp);
    }

    public int maximum() {
        while (true){
            int[] priceTime = pqMax.peek();
            int price = priceTime[0];
            int timestamp = priceTime[1];
            if(timePriceMap.get(timestamp)==price){
                return price;
            }
            pqMax.poll();
        }
    }

    public int minimum() {
        while (true){
            int[] priceTime = pqMin.peek();
            int price = priceTime[0];
            int timestamp = priceTime[1];
            if(timePriceMap.get(timestamp)==price){
                return price;
            }
            pqMin.poll();
        }
    }

    
}
