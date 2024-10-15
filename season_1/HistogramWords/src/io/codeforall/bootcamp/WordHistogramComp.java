package io.codeforall.bootcamp;

import java.util.HashMap;
import java.util.Iterator;

public class WordHistogramComp implements Iterable<String>{
    HashMap<String,Integer> hashMap = new HashMap<>();
    private String string;
    public WordHistogramComp(String string){
        this.string = string;
        String[] strings = string.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if (hashMap.get(strings[i]) == null) {
                hashMap.put(strings[i], 1);
            } else {
                hashMap.put(strings[i], hashMap.get(strings[i]) + 1);

            }
        }

    }
    @Override
    public Iterator iterator() {
        return hashMap.keySet().iterator();
    }
    public int size() {
            return hashMap.size();

        }
    public Integer get(String word) {
    return hashMap.get(word);
    }



}

