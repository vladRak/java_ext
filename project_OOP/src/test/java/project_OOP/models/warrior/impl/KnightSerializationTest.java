package project_OOP.models.warrior.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project_OOP.models.ammunition.Ammunition;
import project_OOP.models.ammunition.impl.Armor;
import project_OOP.models.ammunition.impl.Helmet;
import project_OOP.models.ammunition.impl.Shield;
import project_OOP.models.ammunition.impl.Sword;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class KnightSerializationTest {
    Knight lancelot;

    @Before
    public void setUp() throws Exception {
        lancelot = new Knight("Lancelot", 35, 15);

        Ammunition shield = new Shield.Builder(10, 50f)
                .armor(25)
                .attackPower(10)
                .technicalCondition(100)
                .build();

        Ammunition sword = new Sword.Builder(7, 45f)
                .attackPower(30)
                .technicalCondition(100)
                .build();

        Ammunition helmet = new Helmet.Builder(5, 40f)
                .armor(20)
                .technicalCondition(100)
                .build();

        Ammunition armor = new Armor.Builder(20, 100f)
                .armor(20)
                .technicalCondition(100)
                .build();


        lancelot.getBodyParts()[0].equip(helmet);
        lancelot.getBodyParts()[1].equip(armor);
        lancelot.getBodyParts()[2].equip(sword);
        lancelot.getBodyParts()[3].equip(shield);
    }

    @After
    public void tearDown() throws Exception {
        lancelot = null;
    }

    @Test
    public void knightSerializeDeserializeTest() throws Exception {
        Knight knight = lancelot;
        String filename = "file.ser";
        FileOutputStream fileOs = null;
        ObjectOutputStream out = null;
        try {
            fileOs = new FileOutputStream(filename);
            out = new ObjectOutputStream(fileOs);
            out.writeObject(knight);
        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } finally {
            out.close();
            fileOs.close();
        }

        Knight object = null;

        FileInputStream fileIs = null;
        ObjectInputStream in = null;
        try {
            fileIs = new FileInputStream(filename);
            in = new ObjectInputStream(fileIs);

            object = (Knight) in.readObject();

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException is caught");
        }finally {
            in.close();
            fileIs.close();
        }

        assertEquals(lancelot,object);
    }
}
