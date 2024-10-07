package io.codeforall.bootcamp;

public abstract class GameObject {

    //private String name;
    private  String type;

    public GameObject(String type){

            this.type = type;
    }

    public abstract String getMessage();

public String getType(){
    return  type;
}
}


