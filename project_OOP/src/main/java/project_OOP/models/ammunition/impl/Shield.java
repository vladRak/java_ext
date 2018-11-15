package project_OOP.models.ammunition.impl;

import project_OOP.models.ammunition.HandAmmunition;

import java.io.Serializable;

public class Shield extends AbstractAmmunition implements HandAmmunition , Serializable {

    private final int attackPower;
    private final int armor;

    public static class Builder extends AbstractAmmunition.Builder {

        private int attackPower;
        private int armor;

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

        public Builder armor(int armor) {
            this.armor = armor;
            return this;
        }

        @Override
        public Shield build() {
            return new Shield(this);
        }
    }

    private Shield(Builder builder) {
        super(builder);
        this.attackPower = builder.attackPower;
        this.armor = builder.armor;
    }

    @Override
    public String coolHand() {
        return "Shield cooling hand.";
    }

    @Override
    public int attack() {
        return (attackPower * getTechnicalCondition()) / 100;
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
        return "Shield{" +
                "technicalCondition=" + getTechnicalCondition() +
                ", attackPower=" + attackPower +
                ", armor=" + armor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shield)) return false;

        Shield shield = (Shield) o;

        if (attackPower != shield.attackPower) return false;
        return armor == shield.armor;
    }

    @Override
    public int hashCode() {
        int result = attackPower;
        result = 31 * result + armor;
        return result;
    }
}
