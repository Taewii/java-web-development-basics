package metube.domain.enums;

public enum TubeStatus {
    PENDING, APPROVED, DECLINED;

    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }
}
