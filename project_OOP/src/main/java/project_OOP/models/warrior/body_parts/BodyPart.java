package project_OOP.models.warrior.body_parts;

import project_OOP.models.ammunition.Ammunition;

public interface BodyPart {
    boolean isFree();
    int takeHit(int hitPower);
    Ammunition getAmmunition();
    Ammunition takeOff();
    Ammunition equip(Ammunition ammunition);
}
