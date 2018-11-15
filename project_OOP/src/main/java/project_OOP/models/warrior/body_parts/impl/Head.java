package project_OOP.models.warrior.body_parts.impl;

import project_OOP.models.ammunition.Ammunition;
import project_OOP.models.ammunition.HeadAmmunition;
import project_OOP.models.warrior.body_parts.BodyPart;

import java.io.Serializable;

public final class Head implements BodyPart , Serializable {

    private HeadAmmunition ammunition;

    @Override
    public HeadAmmunition getAmmunition() {
        return ammunition;
    }

    @Override
    public HeadAmmunition takeOff() {
        HeadAmmunition ammunition = this.ammunition;
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
        if (ammunition instanceof HeadAmmunition) {
            this.ammunition = (HeadAmmunition) ammunition;
            return ammunition;
        } else return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Head)) return false;

        Head head = (Head) o;

        return getAmmunition() != null ? getAmmunition().equals(head.getAmmunition()) : head.getAmmunition() == null;
    }

    @Override
    public int hashCode() {
        return getAmmunition() != null ? getAmmunition().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Head{" +
                "ammunition=" + ammunition +
                '}';
    }
}
