package project_OOP.models.ammunition.impl;

import project_OOP.models.ammunition.Ammunition;

import java.io.Serializable;

public abstract class AbstractAmmunition implements Ammunition, Serializable {

    private final int weight;
    private final float price;
    private int technicalCondition;

    protected static abstract class Builder<B extends Builder<B>> {
        private int weight;
        private float price;
        private int technicalCondition;

        public Builder(int weight, float price) {
            this.weight = weight;
            this.price = price;
        }

        public Builder technicalCondition(int technicalCondition) {
            this.technicalCondition = technicalCondition;
            return this;
        }

        public abstract AbstractAmmunition build();
    }

    protected AbstractAmmunition(Builder builder) {
        this.weight = builder.weight;
        this.price = builder.price;
        this.technicalCondition = builder.technicalCondition;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public float getPrice() {
        return price;
    }

    public int getTechnicalCondition() {
        return technicalCondition;
    }

    public void setTechnicalCondition(int technicalCondition) {
        this.technicalCondition = technicalCondition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractAmmunition)) return false;

        AbstractAmmunition that = (AbstractAmmunition) o;

        if (getWeight() != that.getWeight()) return false;
        if (Float.compare(that.getPrice(), getPrice()) != 0) return false;
        return getTechnicalCondition() == that.getTechnicalCondition();
    }

    @Override
    public int hashCode() {
        int result = getWeight();
        result = 31 * result + (getPrice() != +0.0f ? Float.floatToIntBits(getPrice()) : 0);
        result = 31 * result + getTechnicalCondition();
        return result;
    }
}
