package version1.classes;


/**
 * Created by abg628 on 30.04.14.
 */
public interface Knoten {

    Knoten initializeParticle(ElementPointer elementPointer, double region_size);

    Knoten initializeRegion(double region_size, Vector3d origin);

    void add(Knoten knoten);

    double getRegionSize();

    Vector3d getOrigin();

    Quadrant getQuadrant(Vector3d position, Vector3d origin, double v);

    Knotentype getKnotentype();

    ElementPointer getElem();

    void addMass(double mass);

    void calculateNewMassPoint(Vector3d position);

    Knoten getNW();

    Knoten getNO();

    Knoten getSW();

    Knoten GetSO();

    double getInteratctionRadius();

    double getRegionMass();

    Vector3d getRegionMassPoint();
}
