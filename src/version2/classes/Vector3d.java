package version2.classes;

import org.jblas.FloatMatrix;

/**
 * User: Alex
 * Date: 21.05.2014
 * Time: 17:24
 */
public class Vector3d {

    FloatMatrix vector;

    private Vector3d(float x, float y, float z) {
        this.vector = new FloatMatrix(new float[]{x ,y, z});
    }

    private Vector3d() {
        this.vector = FloatMatrix.zeros(3);
    }

    public static Vector3d create(float x, float y, float z) {
        return new Vector3d(x, y, z);
    }

    public static Vector3d create() {
        return new Vector3d();
    }

    // --- Getter & Setter

    final public float x() { return vector.get(0);}
    final public float y() { return vector.get(1);}
    final public float z() { return vector.get(2);}

    public void x(float x) { vector = new FloatMatrix(new float[]{x, this.y(), this.z()});}
    public void y(float y) { vector = new FloatMatrix(new float[]{this.x(), y, this.z()});}
    public void z(float z) { vector = new FloatMatrix(new float[]{this.x(), this.y(), z});}

    @Override
    public String toString() {
        return "Vector3d{" +
                "vector=" + vector +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vector3d)) return false;

        Vector3d vector3d = (Vector3d) o;

        if (!vector.equals(vector3d.vector)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return vector.hashCode();
    }
}
