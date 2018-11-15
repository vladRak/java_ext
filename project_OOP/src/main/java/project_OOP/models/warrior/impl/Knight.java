package project_OOP.models.warrior.impl;

import project_OOP.models.ammunition.HandAmmunition;
import project_OOP.models.warrior.Warrior;
import project_OOP.models.warrior.body_parts.BodyPart;
import project_OOP.models.warrior.body_parts.impl.BodyPartType;
import project_OOP.models.warrior.body_parts.impl.Hand;
import project_OOP.models.warrior.body_parts.impl.Head;
import project_OOP.models.warrior.body_parts.impl.Torso;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Knight implements Warrior, Serializable {
    private final String name;
    private final int age;
    private int health;
    private final int power;
    private final BodyPart[] bodyParts;
    private boolean alive = true;

    public Knight(String name, int age, int power) {
        this.name = name;
        this.age = age;
        this.power = power;
        health = 100;
        bodyParts = new BodyPart[]{
                new Head(),
                new Torso(),
                new Hand("Left"),
                new Hand("Right")};
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public void setHealth(int health) {
        this.health = health;
    }

    public int getPower() {
        return power;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }

    @Override
    public BodyPart[] getBodyParts() {
        return bodyParts;
    }

    @Override
    public int attack(Warrior enemy, BodyPartType bodyPart) {
        int attackPower;
        if (isAlive()) {
            HandAmmunition handAmmunition = findHandAmmunitionForAttack();
            if (handAmmunition != null) {
                attackPower = power + handAmmunition.attack();
            } else attackPower = power;
            enemy.takeHit(bodyPart, attackPower);
        } else attackPower = 0;
        return attackPower;
    }

    private HandAmmunition findHandAmmunitionForAttack() {
        Comparator<HandAmmunition> comparator = new Comparator<HandAmmunition>() {
            @Override
            public int compare(HandAmmunition hA1, HandAmmunition hA2) {
                return new Integer(hA1.attack()).compareTo(new Integer(hA2.attack()));
            }
        };
        return findBestHandAmmunition(comparator);
    }

    @Override
    public int takeHit(BodyPartType bodyPart, int attackPower) {
        HandAmmunition handAmmunition = findHandAmmunitionForProtect(attackPower);
        BodyPart attackedBodyPart = findBodyPart(bodyPart);
        int damage;
        if (handAmmunition != null) {
            damage = attackedBodyPart.takeHit(handAmmunition.protect(attackPower));
        } else damage = attackedBodyPart.takeHit(attackPower);

        health = healthAfterDamage(attackedBodyPart, damage);
        checkHealth();
        return damage;
    }

    private HandAmmunition findHandAmmunitionForProtect(int attackPower) {
        Comparator<HandAmmunition> comparator = new Comparator<HandAmmunition>() {
            @Override
            public int compare(HandAmmunition hA1, HandAmmunition hA2) {
                return new Integer(hA1.protect(attackPower)).compareTo(new Integer(hA2.protect(attackPower)));
            }
        };
        return findBestHandAmmunition(comparator);
    }

    private BodyPart findBodyPart(BodyPartType bodyPart) {
        Class clazz = bodyPart.getBodyPart();
        BodyPart searchedBodyPart = null;
        for (BodyPart bp : bodyParts) {
            if (bp.getClass() == clazz) searchedBodyPart = bp;
        }
        return searchedBodyPart;
    }

    private int healthAfterDamage(BodyPart bodyPart, int damage) {
        if (bodyPart instanceof Head) return getHealth() - damage * 3;
        else if (bodyPart instanceof Torso) return getHealth() - damage * 2;
        else return getHealth() - damage;
    }

    private int checkHealth() {
        if (health <= 0) die();
        return health;
    }

    private HandAmmunition findBestHandAmmunition(Comparator<HandAmmunition> comparator) {
        List<HandAmmunition> handAmmunition = findHandAmmunition();

        if (handAmmunition.size() > 0) {
            handAmmunition = handAmmunition
                    .stream()
                    .sorted(comparator)
                    .collect(Collectors.toList());
            return handAmmunition.get(0);
        } else return null;
    }

    private List<HandAmmunition> findHandAmmunition() {
        List<HandAmmunition> handAmmunition = new ArrayList<>();
        for (BodyPart bp : bodyParts) {
            if (bp instanceof Hand && ((Hand) bp).getAmmunition() != null) {
                handAmmunition.add(((Hand) bp).getAmmunition());
            }
        }
        return handAmmunition;
    }

    @Override
    public Warrior die() {
        alive = false;
        System.out.println(name + " die.");
        return this;
    }

    @Override
    public String toString() {
        return "Knight{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", health=" + health +
                ", power=" + power +
                ", bodyParts=" + Arrays.toString(bodyParts) +
                ", alive=" + alive +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Knight)) return false;

        Knight knight = (Knight) o;

        if (getAge() != knight.getAge()) return false;
        if (getHealth() != knight.getHealth()) return false;
        if (getPower() != knight.getPower()) return false;
        if (isAlive() != knight.isAlive()) return false;
        if (!getName().equals(knight.getName())) return false;
        return Arrays.equals(getBodyParts(), knight.getBodyParts());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + getHealth();
        result = 31 * result + getPower();
        result = 31 * result + Arrays.hashCode(getBodyParts());
        result = 31 * result + (isAlive() ? 1 : 0);
        return result;
    }
}