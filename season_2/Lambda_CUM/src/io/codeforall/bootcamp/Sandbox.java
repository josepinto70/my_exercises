package io.codeforall.bootcamp;

public class Sandbox {
    public static void main(String[] args) {

    int result ;
    String tt;

    // increment + 1 to an number
    MonoOperation<Integer> increment = (n) -> n+1;
    result = increment.execute(5);

        System.out.println(result);

        // Sum two numbers
    BioOperation<Integer> sum = (n1, n2) -> n1+n2;
    result = sum.execute(13,1);
        System.out.println(result);

    //Multiplication
        BioOperation<Integer> multiplication = (n1,n2)->n1 * n2;
        result = multiplication.execute(12,2);
        System.out.println(result);


    // String
    MonoOperation<String> text = (n) -> (n + " OK");
    tt = text.execute("rt");
    System.out.printf(tt);




    }
}
