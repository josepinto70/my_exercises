package io.codeforall.bootcamp;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class WordReader implements Iterable<String> {
    private String text;
    private String[] result;

    public WordReader(String file) throws IOException {
        readFileByLine("/Users/codecadet/Documents/my_exercises/season_1/ReadWords/rsc/file.txt");


    }

    public String readFileByLine(String file) throws IOException {
        FileReader fileReader = new FileReader("/Users/codecadet/Documents/my_exercises/season_1/ReadWords/rsc/file.txt");

        BufferedReader bReader = new BufferedReader(fileReader);
        String line = "";
        String result = "";

        while ((line = bReader.readLine()) != null) {
            result += line + "\n";
        }
        this.result = result.split(" ");
        bReader.close();
        return result;
    }

    private void writeFileByline(String file, String text) throws IOException {
        FileWriter writer = new FileWriter("/Users/codecadet/Documents/my_exercises/season_1/ReadWords/rsc/file1.txt");
        BufferedWriter bWriter = new BufferedWriter(writer);
        bWriter.write(text);
        bWriter.flush();
        bWriter.close();
    }

    @Override
    public Iterator iterator() {
        return Arrays.stream(result).iterator();


    }
}
