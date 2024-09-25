package io.codeforall.bootcamp.WorldPc;

public class MyPc {

    public String brand;
    public String description;
    public String processor;
    private  int memory;

    public MyPc(String nBrand, String nDescription, String nProcessor, int nMemory){


        this.brand = nBrand;
        this.description = nDescription;
        this.processor = nProcessor;
        this.memory = nMemory;

    }

public String tellMeYourMemory () {return this.memory;}


    public int Calcula(int nr1, int nr2){

        return nr1+nr2;

}




}
