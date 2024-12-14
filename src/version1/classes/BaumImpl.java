package version1.classes;

/**
 * Created by abg628 on 30.04.14.
 */
public class BaumImpl implements Baum{
    private Knoten wurzel;
    private int elemente;

    private BaumImpl(double region_size) {
        this.elemente = 0;
        Knoten knoten = KnotenImpl.create();
        Vector3d origin = Vector3d.create();
        this.wurzel = knoten.initializeRegion(region_size, origin);
    }

    public static BaumImpl create(double region_size) {
        return new BaumImpl(region_size);
    }

    @Override
    public int size() {
        return elemente;
    }

    @Override
    public void add(Knoten knoten) {
        elemente++;
        wurzel.add(knoten);

    }

    @Override
    public Interaction traverse(Knoten knoten) {
        return null;
    }
}
