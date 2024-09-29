package io.codeforall.bootcamp;



public class Ai {


    private String name;
    private String creationDate;


       // Constructor
    public Ai(String  name, String creationDate){

        this.name = name;
        this.creationDate = creationDate;

    }


    // Double Array
      public void doubleArray(String Array) {

       /* int intArray;
        for (int i=0; i<Array.length(); ++i) {
           intArray[i] = (double) Array[i];
        }

         System.out.println("doubleArray" + intArray);
       */
       }



    // Factorial Iterative
    public void factoralIterative(int number) {
        int i, fact = 1;
        for (i = 1; i <= number; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial Iterative of " + number + " is: " + fact);
    }

    // Factorial Recursive
    static int factorial(int n) {
        if (n == 0)
            return 1;
        else
            return (n * factorial(n - 1));
    }

    public void factorialRecursive(int numberfactrecursive) {

        int factrecur = 1;
        factrecur = factorial(numberfactrecursive);
        System.out.println("Factorial Recursive of " + numberfactrecursive + " is: " + factrecur);
    }


    // Palindrome replace
    // takes a string as an argument and returns a new string with all the occurrences of words
    // that are palindromes replaced with the word “palindrome”

    public  void palindromeRelace(String original) {
        //String original = input.nextLine().toLowerCase();

        String reverse = "";

        for (int i = original.length() - 1; i >= 0; i--) {
            reverse += original.charAt(i);
        }

        if (original.equals(reverse)) {
            System.out.println(original + " is a palindrome");
        }
        else {
            System.out.println(original + " is not a palindrome");
        }
    }



    //Email Regex

    public void emailValidator(){

        // email validation
        // takes no arguments and returns a string with a regex expression to validate emails

        System.out.println("(([a-zA-Z0-9]+)([\\.\\-_]?)([a-zA-Z0-9]+)([\\.\\-_]?)([a-zA-Z0-9]+)?)(@)([a-zA-Z]+.[A-Za-z]+\\.?([a-zA-Z0-9]+)\\.?([a-zA-Z0-9]+))");
       }

}












