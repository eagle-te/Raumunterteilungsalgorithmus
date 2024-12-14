package version2.classes;

/**
 * Created by abg628 on 30.04.14.
 */
public class ElementPointer {
    private Vector3d position;
    private float mass;

    private ElementPointer(Vector3d position, float mass) {
        this.position = position;
        this.mass = mass;
    }

    public static ElementPointer create(Vector3d position, float mass) {
        return new ElementPointer(position, mass);
    }

    final public Vector3d getPosition() {
        return position;
    }

    public float getMass() {
        return mass;
    }

    public void setPosition(Vector3d position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "ElementPointer{" +
                "position=" + position +
                ", mass=" + mass +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElementPointer)) return false;

        ElementPointer that = (ElementPointer) o;

        if (!position.equals(that.position)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = position.hashCode();
        return result;
    }
}
