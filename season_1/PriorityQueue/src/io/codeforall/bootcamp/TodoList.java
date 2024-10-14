package io.codeforall.bootcamp;

import java.util.Collection;
import java.util.PriorityQueue;

public class TodoList {

    PriorityQueue<Tasks> priorityQueue = new PriorityQueue();

    public void add(Importance importance, int priority, String message) {
      priorityQueue.add(new Tasks(importance,priority,message ));
    }


    public boolean isEmpty() {
        return priorityQueue.isEmpty();

    }

    public String remove() {
       return priorityQueue.poll().getMessage();
    }
}



