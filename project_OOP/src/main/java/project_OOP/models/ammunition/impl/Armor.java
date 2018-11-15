package project_OOP.models.ammunition.impl;

import project_OOP.models.ammunition.TorsoAmmunition;

import java.io.Serializable;

public class Armor extends AbstractAmmunition implements TorsoAmmunition, Serializable {

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
        public Armor build() {
            return new Armor(this);
        }
    }

    private Armor(Builder builder) {
        super(builder);
        this.armor = builder.armor;
    }

    @Override
    public String shine() {
        return "Armor shine.";
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
        return "Armor{" +
                "technicalCondition=" + getTechnicalCondition() +
                ", armor=" + armor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Armor)) return false;
        if (!super.equals(o)) return false;

        Armor armor1 = (Armor) o;

        return armor == armor1.armor;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + armor;
        return result;
    }
}
