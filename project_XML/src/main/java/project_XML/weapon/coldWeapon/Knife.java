package project_XML.weapon.coldWeapon;

import project_XML.weapon.Handy;
import project_XML.weapon.Material;
import project_XML.weapon.Origin;

public class Knife {
    private static final String xmlNodeName = "knife";
    private long id;
    private Type type;
    private Handy handy;
    private Origin origin;
    private Visual visual;
    private boolean value;

    public Knife() {
    }

    public Knife(Builder builder) {
        this.id = builder.id;
        this.type = builder.type;
        this.handy = builder.handy;
        this.origin = builder.origin;
        this.visual = builder.visual;
        this.value = builder.value;
    }

    public static String getXmlNodeName() {
        return xmlNodeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Handy getHandy() {
        return handy;
    }

    public void setHandy(Handy handy) {
        this.handy = handy;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Visual getVisual() {
        return visual;
    }

    public void setVisual(Visual visual) {
        this.visual = visual;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public static class Builder {
        private long id;
        private Type type;
        private Handy handy = Handy.OneHanded;
        private Origin origin = Origin.UA;
        private Visual visual = new Visual(30, Material.Steel);
        private boolean value;

        public Builder(long id, Type type) {
            this.id = id;
            this.type = type;
        }

        public Builder handy(Handy handy) {
            this.handy = handy;
            return this;
        }

        public Builder origin(Origin origin) {
            this.origin = origin;
            return this;
        }

        public Builder visual(Visual visual) {
            this.visual = visual;
            return this;
        }

        public Builder value(boolean value) {
            this.value = value;
            return this;
        }
    }

    @Override
    public String toString() {
        return String.format("Knife: id: %s, Type: %s, Handy: %s, Origin: %s, Visual: %s, Value: %s", id, type, handy, origin, visual, value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Knife)) return false;

        Knife knife = (Knife) o;

        if (getId() != knife.getId()) return false;
        if (isValue() != knife.isValue()) return false;
        if (getType() != knife.getType()) return false;
        if (getHandy() != knife.getHandy()) return false;
        if (getOrigin() != knife.getOrigin()) return false;
        return getVisual() != null ? getVisual().equals(knife.getVisual()) : knife.getVisual() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getHandy() != null ? getHandy().hashCode() : 0);
        result = 31 * result + (getOrigin() != null ? getOrigin().hashCode() : 0);
        result = 31 * result + (getVisual() != null ? getVisual().hashCode() : 0);
        result = 31 * result + (isValue() ? 1 : 0);
        return result;
    }
}
