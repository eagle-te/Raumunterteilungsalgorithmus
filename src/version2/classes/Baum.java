package version2.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abg628 on 30.04.14.
 */
public class Baum {
    private Region root;
    private int elements;
    public static List<String> rectangles;

    private Baum(float region_size) {
        this.elements = 0;
        root = Region.create(region_size, Vector3d.create());
        rectangles = new ArrayList<String>();
        rectangles.add("" + root.origin_x() + "," + root.origin_y() + "," + root.size());
    }

    public static Baum create(float region_size) {
        return new Baum(region_size);
    }

    public int size() {
        return elements;
    }

    public void add(Particle particle) {
        elements++;
        root.add(particle, null, root);

    }

//    public Interaction traverse(Node node) {
//        return null;
//    }
}
