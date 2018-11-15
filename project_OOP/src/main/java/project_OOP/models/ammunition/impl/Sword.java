package project_OOP.models.ammunition.impl;

import project_OOP.models.ammunition.HandAmmunition;

import java.io.Serializable;

public class Sword extends AbstractAmmunition implements HandAmmunition , Serializable {

    private final int attackPower;

    public static class Builder extends AbstractAmmunition.Builder {

        private int attackPower;

        public Builder(int weight, float price) {
            super(weight, price);
        }

        public Builder technicalCondition(int technicalCondition) {
            super.technicalCondition(technicalCondition);
            return this;
        }

        public Builder attackPower(int attackPower) {
            this.attackPower = attackPower;
            return this;
        }

        @Override
        public Sword build() {
            return new Sword(this);
        }
    }

    private Sword(Builder builder) {
        super(builder);
        this.attackPower = builder.attackPower;
    }

    @Override
    public int attack() {
        return (attackPower * getTechnicalCondition()) / 100;
    }

    @Override
    public String coolHand() {
        return "Sword cooling hand.";
    }

    @Override
    public int protect(int attackPower) {
        return attackPower;
    }

    @Override
    public String toString() {
        return "Sword{" +
                "technicalCondition=" + getTechnicalCondition() +
                ", attackPower=" + attackPower +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sword)) return false;

        Sword sword = (Sword) o;

        return attackPower == sword.attackPower;
    }

    @Override
    public int hashCode() {
        return attackPower;
    }
}
