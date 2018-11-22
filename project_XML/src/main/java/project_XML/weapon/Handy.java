package project_XML.weapon;

public enum Handy {
    OneHanded(1), TwoHanded(2);

    private final int handsRequired;

    Handy(final int handsRequired) {
        this.handsRequired = handsRequired;
    }

    public int getHandsRequired() {
        return handsRequired;
    }
}
