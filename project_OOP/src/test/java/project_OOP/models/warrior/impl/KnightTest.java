package project_OOP.models.warrior.impl;

import org.junit.Test;
import project_OOP.models.ammunition.Ammunition;
import project_OOP.models.ammunition.impl.Helmet;
import project_OOP.models.ammunition.impl.Shield;
import project_OOP.models.ammunition.impl.Sword;
import project_OOP.models.warrior.body_parts.impl.BodyPartType;

import static org.junit.Assert.assertEquals;

public class KnightTest {

    @Test
    public void attackWithOutHandAmmun() throws Exception {
        Knight lancelot = new Knight("Lancelot", 35, 15);
        Knight artibalt = new Knight("Artibalt", 28, 12);

        lancelot.attack(artibalt, BodyPartType.HAED);

        assertEquals(55, artibalt.getHealth());
    }

    @Test
    public void attackWithHandAmmun() throws Exception {
        Knight lancelot = new Knight("Lancelot", 35, 15);
        Knight artibalt = new Knight("Artibalt", 28, 12);

        Ammunition sword = new Sword.Builder(7, 45f)
                .attackPower(30)
                .technicalCondition(100)
                .build();

        lancelot.getBodyParts()[2].equip(sword);

        lancelot.attack(artibalt, BodyPartType.HAED);

        assertEquals(-35, artibalt.getHealth());
    }

    @Test
    public void takeHitWithHeadAmmun() throws Exception {
        Knight lancelot = new Knight("Lancelot", 35, 15);
        Knight artibalt = new Knight("Artibalt", 28, 12);

        Ammunition helmet = new Helmet.Builder(5, 40f)
                .armor(20)
                .technicalCondition(100)
                .build();
        artibalt.getBodyParts()[0].equip(helmet);

        lancelot.attack(artibalt, BodyPartType.HAED);

        assertEquals(100, artibalt.getHealth());
    }

    @Test
    public void takeHitWithHandAmmun() throws Exception {
        Knight lancelot = new Knight("Lancelot", 35, 15);
        Knight artibalt = new Knight("Artibalt", 28, 12);

        Ammunition shield = new Shield.Builder(10, 50f)
                .armor(25)
                .attackPower(10)
                .technicalCondition(100)
                .build();

        artibalt.getBodyParts()[2].equip(shield);

        lancelot.attack(artibalt, BodyPartType.HAED);

        assertEquals(100, artibalt.getHealth());
    }

    @Test
    public void die() throws Exception {
        Knight knight = new Knight("Lancelot", 35, 100);

        knight.die();

        assertEquals(false, knight.isAlive());
    }
}