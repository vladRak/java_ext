import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import project_OOP.models.ammunition.Ammunition;
import project_OOP.models.ammunition.impl.Armor;
import project_OOP.models.ammunition.impl.Helmet;
import project_OOP.models.ammunition.impl.Shield;
import project_OOP.models.ammunition.impl.Sword;
import project_OOP.models.warrior.impl.Knight;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TaskTest {

    Knight lancelot;

    @Before
    public void setUp() throws Exception {
        lancelot = new Knight("Lancelot", 35, 15);

        Ammunition sword = new Sword.Builder(7, 45f)
                .attackPower(30)
                .technicalCondition(100)
                .build();

        Ammunition helmet = new Helmet.Builder(5, 40f)
                .armor(20)
                .technicalCondition(100)
                .build();

        Ammunition shield = new Shield.Builder(10, 50f)
                .armor(25)
                .attackPower(10)
                .technicalCondition(100)
                .build();

        Ammunition armor = new Armor.Builder(20, 100f)
                .armor(40)
                .technicalCondition(100)
                .build();

        lancelot.getBodyParts()[0].equip(helmet);
        lancelot.getBodyParts()[1].equip(armor);
        lancelot.getBodyParts()[2].equip(shield);
        lancelot.getBodyParts()[3].equip(sword);
    }

    @After
    public void tearDown() throws Exception {
        lancelot = null;
    }

    @Test
    public void sortAmmunitionTest() {
        List<Ammunition> ammunition = Arrays.asList(lancelot.getBodyParts()).stream()
                .map(bodyPart -> bodyPart.getAmmunition())
                .collect(Collectors.toList());
        List<Ammunition> sortedAmmunition = ammunition.stream()
                .sorted(((ammunition1, ammunition2) -> ammunition2.getWeight() - ammunition1.getWeight()))
                .collect(Collectors.toList());

        Assert.assertEquals(20, sortedAmmunition.get(0).getWeight());
    }

    @Test
    public void countAmmunitionPriceTest() {
        final float[] price = new float[1];
        List<Ammunition> ammunition = Arrays.asList(lancelot.getBodyParts()).stream()
                .map(bodyPart -> {
                    Ammunition ammunition1 = bodyPart.getAmmunition();
                    price[0] = price[0] + ammunition1.getPrice();
                    return ammunition1;
                })
                .collect(Collectors.toList());


        Assert.assertEquals(235f, price[0], 0.0001);
    }

}
