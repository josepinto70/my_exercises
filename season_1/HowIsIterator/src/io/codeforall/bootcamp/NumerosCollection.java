package io.codeforall.bootcamp;

import java.util.Enumeration;
import java.util.Iterator;

public class NumerosCollection  implements Iterable<Integer>{

    private int [] numeros;

    public class NumerosCollection(){

        numeros = new int[] {1,2,3,4,5};

    }
    // implementacao do metodo iterator() do padrao Iterator
    public Iterator<Integer> iterator(){
        return  new NumerosIterator(numeros);
    }

}



// Classe que representa o Iterator
public class NumerosIterator implements Iterable<Integer>{

    private int[] numeros;
    private int posicao = -1;

    public NumerosIterator(int[] numeros){
        this.numeros = numeros;

    }
    // Implementcao do metodo hashNext do padaro Iterator
    public boolean hashNext(){
        return  posicao < numeros.length -1;
    }

    // Implementacao do metodo next(9 do padrao Iterator
    public  Integer next(){
        posicao++;
        return numeros[posicao];
    }

    // Implementacao do metodo remove() do padaro Iterator
    public void remove(){
        throw new UnsupportedOperationException();

    }



}


