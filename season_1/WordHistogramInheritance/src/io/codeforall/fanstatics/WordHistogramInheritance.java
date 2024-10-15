package io.codeforall.fanstatics;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;

public class WordHistogramInheritance extends HashMap<String,Integer> implements Iterable<String> {
    private String string;

    public WordHistogramInheritance(String string){
        this.string = string;
        String[] strings = string.split(" ");
        for (int i = 0; i < strings.length; i++) {
            if(this.get(strings[i]) == null){
                put(strings[i],1);
            } else{
            put(strings[i],get(strings[i]) + 1);
            }

        }
    }

    @Override
    public Iterator iterator() {
        return keySet().iterator();
    }
}

