package io.codeforall.bootcamp.WorldPc;

public class Pc
{
    public static void main(String[] args) {


    MyPc pc1 = new MyPc("Lenovo", "ATX 45","X1",128);
    MyPc pc2 = new MyPc("HP","Filo","I9 45",64);
   // MyPc pc2 = new My
    System.out.println("PC1 > Brand: "+pc1.brand + " ,Description: "+pc1.description);
    System.out.println("PC2 > Brand: "+pc2.brand + " ,Description: "+pc2.description);

        System.out.println(pc1.tellMeYourMemory());


    }



}
