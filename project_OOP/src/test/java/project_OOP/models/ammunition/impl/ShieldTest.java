package project_OOP.models.ammunition.impl;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShieldTest {

    @Test
    public void attackWithMaxTechCondMaxAttackPower() throws Exception {
        Shield shield = new Shield.Builder(10,10f)
                .armor(10)
                .attackPower(5)
                .technicalCondition(100)
                .build();

        assertEquals(5,shield.attack());
    }

    @Test
    public void attackWithZeroTechCondMinAttackPower() throws Exception {
        Shield shield = new Shield.Builder(10,10f)
                .attackPower(5)
                .technicalCondition(0)
                .build();

        assertEquals(0,shield.attack());
    }

    @Test
    public void protectWithMaxTechCondMaxProtect() throws Exception {
        Shield shield = new Shield.Builder(10,10f)
                .armor(10)
                .technicalCondition(100)
                .build();
        final int attackPower = 10;

        assertEquals(0,shield.protect(attackPower));
    }

    @Test
    public void protectWithZeroTechCondMinProtect() throws Exception {
        Shield shield = new Shield.Builder(10,10f)
                .armor(10)
                .technicalCondition(0)
                .build();
        final int attackPower = 10;

        assertEquals(10,shield.protect(attackPower));
    }

    @Test
    public void protectWithMaxTechCondTechCondLower() throws Exception {
        Shield shield = new Shield.Builder(10,10f)
                .armor(10)
                .technicalCondition(100)
                .build();
        final int attackPower = 20;
        shield.protect(attackPower);

        assertEquals(80,shield.getTechnicalCondition());
    }

}