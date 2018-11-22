package project_XML.weapon.coldWeapon;

import project_XML.weapon.Material;

public class Visual {
    private int length;
    private Material material;

    public Visual(final int length, Material material) {
        this.length = length;
        this.material = material;
    }

    public int getLength() {
        return length;
    }

    public Material getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return String.format("[Length: %s, Material: %s]", length, material);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Visual)) return false;

        Visual visual = (Visual) o;

        if (getLength() != visual.getLength()) return false;
        return getMaterial() == visual.getMaterial();
    }

    @Override
    public int hashCode() {
        int result = getLength();
        result = 31 * result + (getMaterial() != null ? getMaterial().hashCode() : 0);
        return result;
    }
}
