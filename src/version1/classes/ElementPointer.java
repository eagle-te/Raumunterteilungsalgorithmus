package version1.classes;


/**
 * Created by abg628 on 30.04.14.
 */
public class ElementPointer {
    private Vector3d position;
    private double mass;

    private ElementPointer(Vector3d position, double mass) {
        this.position = position;
        this.mass = mass;
    }

    public static ElementPointer create(Vector3d position, double mass) {
        return new ElementPointer(position, mass);
    }

    public Vector3d getPosition() {
        return position;
    }

    public double getMass() {
        return mass;
    }

    public void setPosition(Vector3d position) {
        this.position = position;
    }
}
