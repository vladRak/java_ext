package hw_3.models;

public enum VehiclesTypes {

    FLYABLE(Flyable.class),
    MOVEABLE(MoveAble.class),
    SWIMABLE(SwimAble.class);

    private Class<?> type;

    VehiclesTypes(Class<?> type) {
        this.type = type;
    }

    public Class<?> getType() {
        return type;
    }
}
