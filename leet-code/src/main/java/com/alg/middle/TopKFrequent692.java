package com.alg.middle;

import java.util.*;

public class TopKFrequent692 {
    public static void main(String[] args) {
        String codeStr = "i love leetcode  i love coding";
        String[]  code = codeStr.split(" ");
        topKFrequent(code,4);
    }
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> codeFreq = new HashMap<>();
        for (String word: words) {
            codeFreq.put(word,codeFreq.getOrDefault(word,0)+1);
        }
        ArrayList<String> rec = new ArrayList<>();
        for (Map.Entry<String,Integer>entry:codeFreq.entrySet()){
            rec.add(entry.getKey());
        }
        Collections.sort(rec, (o1, o2) -> codeFreq.get(o1)==codeFreq.get(o2)?
                o1.compareTo(o2):
                codeFreq.get(o2)-codeFreq.get(o1));
        return rec.subList(0,k);
    }
}
