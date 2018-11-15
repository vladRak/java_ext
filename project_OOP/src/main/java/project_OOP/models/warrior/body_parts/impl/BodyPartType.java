package project_OOP.models.warrior.body_parts.impl;

public enum BodyPartType {

    HAED(Head.class),
    TORSO(Torso.class),
    HAND(Hand.class);

    private Class<?> bodyPart;

    BodyPartType(Class<?> bodyPart) {
        this.bodyPart = bodyPart;
    }

    public Class<?> getBodyPart() {
        return bodyPart;
    }
}
