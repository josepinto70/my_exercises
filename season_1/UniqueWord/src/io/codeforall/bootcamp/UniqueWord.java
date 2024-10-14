package io.codeforall.bootcamp;

import java.util.Iterator;
import java.util.TreeSet;

public class UniqueWord implements Iterable<String> {
    TreeSet treeSet = new TreeSet();
    private String string;

    public UniqueWord(String string){
        this.string = string;
        String[] strings = string.split(" ");
        for (int i = 0; i < strings.length; i++) {
            treeSet.add(strings[i]);

        }


    }



    @Override
    public Iterator iterator() {
        return treeSet.iterator();

    }
}
