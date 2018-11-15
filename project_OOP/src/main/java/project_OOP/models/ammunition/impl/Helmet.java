package project_OOP.models.ammunition.impl;

import project_OOP.models.ammunition.HeadAmmunition;

import java.io.Serializable;

public class Helmet extends AbstractAmmunition implements HeadAmmunition, Serializable {

    private final int armor;

    public static class Builder extends AbstractAmmunition.Builder {

        private int armor;

        public Builder(int weight, float price) {
            super(weight, price);
        }

        public Builder technicalCondition(int technicalCondition) {
            super.technicalCondition(technicalCondition);
            return this;
        }

        public Builder armor(int armor) {
            this.armor = armor;
            return this;
        }

        @Override
        public Helmet build() {
            return new Helmet(this);
        }
    }

    private Helmet(Builder builder) {
        super(builder);
        this.armor = builder.armor;
    }

    @Override
    public String open() {
        return "Helmet open.";
    }

    @Override
    public String close() {
        return "Helmet close.";
    }

    @Override
    public int protect(int attackPower) {
        int damage = attackPower - (armor * getTechnicalCondition()) / 100;
        if (damage > 0) {
            setTechnicalCondition(getTechnicalCondition() - attackPower);
            return damage;
        } else return 0;
    }

    @Override
    public String toString() {
        return "Helmet{" +
                "armor=" + armor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Helmet)) return false;

        Helmet helmet = (Helmet) o;

        return armor == helmet.armor;
    }

    @Override
    public int hashCode() {
        return armor;
    }
}
