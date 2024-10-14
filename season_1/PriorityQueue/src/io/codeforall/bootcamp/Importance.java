package io.codeforall.bootcamp;

public enum Importance {
    LOW (1),
    MEDIUM (2),
    HIGH (3);
    private int level;
    Importance(int level){
        this.level = level;

    }

    public int getLevel() {
        return level;
    }
}
