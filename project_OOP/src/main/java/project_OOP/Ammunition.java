package project_OOP;

public abstract class Ammunition {

    private final int weight;
    private final float price;

    protected static abstract class Builder<B extends Builder<B>> {
        private int weight;
        private float price;

        public Builder(int weight, float price) {
            this.weight = weight;
            this.price = price;
        }

        public abstract Ammunition build();
    }

    protected Ammunition(Builder builder) {
        this.weight = builder.weight;
        this.price = builder.price;
    }

    public int getWeight() {
        return weight;
    }

    public float getPrice() {
        return price;
    }
}
