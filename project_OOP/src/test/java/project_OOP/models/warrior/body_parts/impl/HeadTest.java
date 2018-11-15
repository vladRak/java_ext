package project_OOP.models.warrior.body_parts.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import project_OOP.models.ammunition.Ammunition;
import project_OOP.models.ammunition.impl.Helmet;
import project_OOP.models.warrior.body_parts.BodyPart;

import static org.junit.Assert.assertEquals;

public class HeadTest {

    BodyPart head;

    @Before
    public void setUp() throws Exception {
        head = new Head();
    }

    @After
    public void tearDown() throws Exception {
        head = null;
    }

    @Test
    public void equip() throws Exception {
        Ammunition helmet = new Helmet.Builder(5, 40f)
                .armor(20)
                .technicalCondition(100)
                .build();

        head.equip(helmet);

        assertEquals(helmet, head.getAmmunition());
    }

    @Test
    public void takeOff() throws Exception {
        Ammunition helmet = new Helmet.Builder(5, 40f)
                .armor(20)
                .technicalCondition(100)
                .build();
        head.equip(helmet);

        head.takeOff();

        assertEquals(true, head.isFree());
        assertEquals(null, head.getAmmunition());
    }
}