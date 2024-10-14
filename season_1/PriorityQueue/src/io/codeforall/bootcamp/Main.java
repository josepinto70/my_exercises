package io.codeforall.bootcamp;

public class Main {

    public static void main(String[] args) {

        TodoList todoList = new TodoList();

        todoList.add(Importance.MEDIUM, 1, "Medium priority 1");
        todoList.add(Importance.LOW, 1, "Low priority 1");
        todoList.add(Importance.HIGH, 1, "High priority 1");
        todoList.add(Importance.LOW, 2, "Low priority 2");
        todoList.add(Importance.MEDIUM, 2, "Medium priority 2");
        todoList.add(Importance.HIGH, 2, "High priority 2");


        while (!todoList.isEmpty()) {
            System.out.println(todoList.remove());
        }
    }
}
