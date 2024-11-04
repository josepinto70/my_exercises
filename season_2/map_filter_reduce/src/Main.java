
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {


        //String text;
        String message = "I'll send an SOS to the garbage world, " +
                "I hope that someone garbage gets my message in a garbage bottle.";


        String result = Arrays.stream(message.split(" ")) //coloca a message no array pelo espaços
                .filter(word -> !word.equals("garbage")) // filtra apenas as palavras diferentes de garbage
                .map(String::toUpperCase) // transforma a array em UpperCase
                .reduce("", (acc, elem) ->acc + " " + elem); // a = accumulator e b=element


        System.out.println(result);
    }
}
