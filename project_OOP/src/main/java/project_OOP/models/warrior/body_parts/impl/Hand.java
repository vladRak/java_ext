package project_OOP.models.warrior.body_parts.impl;

import project_OOP.models.ammunition.Ammunition;
import project_OOP.models.ammunition.HandAmmunition;
import project_OOP.models.warrior.body_parts.BodyPart;

import java.io.Serializable;

public final class Hand implements BodyPart ,Serializable {

    private HandAmmunition ammunition;
    private final String name;

    public Hand(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public HandAmmunition getAmmunition() {
        return ammunition;
    }

    @Override
    public HandAmmunition takeOff() {
        HandAmmunition ammunition = this.ammunition;
        this.ammunition = null;
        return ammunition;
    }

    @Override
    public boolean isFree() {
        if (ammunition == null) return true;
        else return false;
    }

    @Override
    public int takeHit(final int hitPower) {
        if (isFree()) return hitPower;
        else return ammunition.protect(hitPower);
    }

    @Override
    public Ammunition equip(Ammunition ammunition) {
        if (ammunition instanceof HandAmmunition) {
            this.ammunition = (HandAmmunition) ammunition;
            return ammunition;
        } else return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hand)) return false;

        Hand hand = (Hand) o;

        if (getAmmunition() != null ? !getAmmunition().equals(hand.getAmmunition()) : hand.getAmmunition() != null)
            return false;
        return getName() != null ? getName().equals(hand.getName()) : hand.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getAmmunition() != null ? getAmmunition().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "ammunition=" + ammunition +
                ", name='" + name + '\'' +
                '}';
    }
}
