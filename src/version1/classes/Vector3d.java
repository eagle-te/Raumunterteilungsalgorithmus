package version1.classes;

//TODO: rm external library use
//import org.jblas.DoubleMatrix;

/**
 * User: Alex
 * Date: 21.05.2014
 * Time: 17:24
 */
public class Vector3d {

    DoubleMatrix vector;

    private Vector3d(double x, double y, double z) {
        this.vector = new DoubleMatrix(new double[]{x ,y, z});
    }

    private Vector3d() {
        this.vector = DoubleMatrix.zeros(3);
    }

    public static Vector3d create(double x, double y, double z) {
        return new Vector3d(x, y, z);
    }

    public static Vector3d create() {
        return new Vector3d();
    }

    // --- Getter & Setter

    public double x() { return vector.get(0);}
    public double y() { return vector.get(1);}
    public double z() { return vector.get(2);}

    public void x(double x) { vector = new DoubleMatrix(new double[]{x, this.y(), this.z()});}
    public void y(double y) { vector = new DoubleMatrix(new double[]{this.x(), y, this.z()});}
    public void z(double z) { vector = new DoubleMatrix(new double[]{this.x(), this.y(), z});}

    @Override
    public String toString() {
        return "Vector3d{" +
                "vector=" + vector +
                '}';
    }
}
