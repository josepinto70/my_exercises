package io.codeforall.bootcamp;

import com.sun.source.tree.ImportTree;

public class Tasks implements Comparable<Tasks>{
    Importance importance;
    private int priority;
    private String message;
    public Tasks(Importance importance,int priority, String message){
        this.importance = importance;
        this.priority = priority;
        this.message = message;
    }
    @Override
    public int compareTo(Tasks o) {
        if(importance.getLevel() > o.importance.getLevel()){
            return -1;
        }
        else if(importance.getLevel() == o.importance.getLevel()) {
            if (priority < o.priority) {
                return -1;
            } else if (priority == o.priority) {
                return 0;
            }
            return 1;
        }

        return 1;
    }

    public String getMessage() {
        return message;
    }
}
