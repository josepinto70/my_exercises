package io.codeforall.bootcamp;

import java.io.IOException;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws IOException {

        WordReader wordReader = new WordReader("/Users/codecadet/Documents/my_exercises/season_1/ReadWords/rsc/file.txt");

        for (String word: wordReader){
            System.out.println(word);
        }

        /*Iterator<String> iterator = wordReader.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
    }
}
