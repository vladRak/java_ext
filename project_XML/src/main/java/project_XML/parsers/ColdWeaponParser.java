package project_XML.parsers;

import project_XML.weapon.coldWeapon.Knife;

import java.util.List;

public interface ColdWeaponParser {
    List<Knife> parseKnives(String filePath);
}
