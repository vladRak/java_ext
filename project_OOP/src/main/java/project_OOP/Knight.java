package project_OOP;

public class Knight {
    private final String name;
    private final int age;
    private int health;
    private final Knight.Hand[] hands = new Knight.Hand[2];

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        health = 100;
        hands[0] = (new Knight.Hand("Left"));
        hands[1] =(new Knight.Hand("Right"));
    }

    public static class Hand {
        String name;
        boolean isFree = true;

        public Hand(String name) {
            this.name = name;
        }

        public boolean isFree() {
            return isFree;
        }
        public void setFree(boolean free) {
            isFree = free;
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Hand[] getHands() {
        return hands;
    }

    public int getHealth() {
        return health;
    }
}
