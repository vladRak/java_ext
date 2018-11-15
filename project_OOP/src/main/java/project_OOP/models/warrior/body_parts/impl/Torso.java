package project_OOP.models.warrior.body_parts.impl;

import project_OOP.models.ammunition.Ammunition;
import project_OOP.models.ammunition.TorsoAmmunition;
import project_OOP.models.warrior.body_parts.BodyPart;

import java.io.Serializable;

public final class Torso implements BodyPart , Serializable {

    private TorsoAmmunition ammunition;

    @Override
    public TorsoAmmunition getAmmunition() {
        return ammunition;
    }

    @Override
    public TorsoAmmunition takeOff() {
        TorsoAmmunition ammunition = this.ammunition;
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
        if (ammunition instanceof TorsoAmmunition) {
            this.ammunition = (TorsoAmmunition) ammunition;
            return ammunition;
        } else return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Torso)) return false;

        Torso torso = (Torso) o;

        return getAmmunition() != null ? getAmmunition().equals(torso.getAmmunition()) : torso.getAmmunition() == null;
    }

    @Override
    public int hashCode() {
        return getAmmunition() != null ? getAmmunition().hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Torso{" +
                "ammunition=" + ammunition +
                '}';
    }
}
