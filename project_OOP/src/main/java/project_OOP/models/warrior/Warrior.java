package project_OOP.models.warrior;

import project_OOP.models.warrior.body_parts.BodyPart;
import project_OOP.models.warrior.body_parts.impl.BodyPartType;

public interface Warrior {
    boolean isAlive();
    int getHealth();
    void setHealth(int health);
    int attack(Warrior enemy, BodyPartType bodyPart);
    int takeHit(BodyPartType attackedBodyPart, int attackPower);
    BodyPart[] getBodyParts();
    Warrior die();
}
