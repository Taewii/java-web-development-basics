package panda.domain.enums;

public enum Status {
    PENDING, SHIPPED, DELIVERED, ACQUIRED;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
