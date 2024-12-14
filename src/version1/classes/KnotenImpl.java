package version1.classes;

/**
 * Created by abg628 on 30.04.14.
 */
public class KnotenImpl implements Knoten{

    Knoten nw, no, sw, so;
    Knotentype knotentype;
    double interaction_radius;
    double region_size;
    double region_mass;
    Vector3d region_mass_point;
    Vector3d origin;
    ElementPointer elem;

    private KnotenImpl() {
        this.knotentype = Knotentype.Empty;
    }
    private KnotenImpl(Knoten knoten) {

        this.nw = knoten.getNW();
        this.no = knoten.getNO();
        this.sw = knoten.getSW();
        this.so = knoten.GetSO();
        this.knotentype = knoten.getKnotentype();
        this.interaction_radius = knoten.getInteratctionRadius();
        this.region_size = knoten.getRegionSize();
        this.region_mass = knoten.getRegionMass();
        this.region_mass_point = knoten.getRegionMassPoint();
        this.origin = knoten.getOrigin();
        this.elem = knoten.getElem();
    }

    public static KnotenImpl create() {
        return new KnotenImpl();
    }
    public static KnotenImpl create(Knoten knoten) {
        return new KnotenImpl(knoten);
    }


    @Override
    public Knoten initializeParticle(ElementPointer elementPointer, double region_size) {
        this.elem = elementPointer;
        this.region_size = region_size;
        this.knotentype = Knotentype.Particle;
        return this;
    }

    @Override
    public Knoten initializeRegion(double region_size, Vector3d origin) {
        this.region_size = region_size;
        this.knotentype = Knotentype.Region;
        this.origin = origin;

        this.nw = KnotenImpl.create();
        this.no = KnotenImpl.create();
        this.sw = KnotenImpl.create();
        this.so = KnotenImpl.create();

        return this;
    }

    @Override
    public Quadrant getQuadrant(Vector3d knotenPosition, Vector3d regionOrigin, double erweiterung) {
        Quadrant quadrant;

        double nodeX = knotenPosition.x(),
               nodeY = knotenPosition.y(),
               regionX = (regionOrigin.x()+erweiterung),
               regionY = (regionOrigin.y()+erweiterung);

        if (nodeX <= regionX && nodeY <= regionY) {
            quadrant = Quadrant.NW;
        }else if (nodeX > regionX && nodeY <= regionY) {
            quadrant = Quadrant.NO;
        }else if (nodeX <= regionX && nodeY > regionY) {
            quadrant = Quadrant.SW;
        } else { // nodeX > regionX && nodeY > regionY
            quadrant = Quadrant.SO;
        }

        return quadrant;
    }

    @Override
    public void add(Knoten knoten) {
        switch (this.knotentype) {

            case Particle:
                Knoten oldKnoten = KnotenImpl.create(this);
                Vector3d newOrigin = Vector3d.create();
                double halfRegionsize = oldKnoten.getRegionSize()*0.5;
                switch (knoten.getQuadrant(knoten.getElem().getPosition(),oldKnoten.getElem().getPosition(), halfRegionsize)) {
                    case NW: newOrigin = Vector3d.create(0,0,0); break;
                    case NO: newOrigin = Vector3d.create(halfRegionsize,0,0); break;
                    case SW: newOrigin = Vector3d.create(0,halfRegionsize,0); break;
                    case SO: newOrigin = Vector3d.create(halfRegionsize,halfRegionsize,0); break;
                }
                this.initializeRegion(halfRegionsize, newOrigin);
                this.add(oldKnoten);
                this.add(knoten);
            break;

            case Region:
                switch (knoten.getQuadrant(knoten.getElem().getPosition(),this.origin, this.region_size * 0.5)) {
                    case NW: nw.add(knoten); break;
                    case NO: no.add(knoten); break;
                    case SW: sw.add(knoten); break;
                    case SO: so.add(knoten); break;
                }
                this.addMass(knoten.getElem().getMass());
                this.calculateNewMassPoint(knoten.getElem().getPosition());
            break;

            case Empty:
                this.knotentype = knoten.getKnotentype();
                this.interaction_radius = knoten.getInteratctionRadius();
                this.region_size = knoten.getRegionSize();
                this.origin = knoten.getOrigin();
                this.elem = knoten.getElem();
            break;
        }
    }

    @Override
    public void addMass(double mass) {
        this.region_mass += mass;
    }

    @Override
    public void calculateNewMassPoint(Vector3d position) {
        //TODO: NACHSCHLAGEN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    }

    @Override
    public double getRegionSize() {
        return region_size;
    }

    @Override
    public Vector3d getOrigin() {
        return origin;
    }

    @Override
    public Knotentype getKnotentype() {
        return knotentype;
    }

    @Override
    public ElementPointer getElem() {
        return elem;
    }

    @Override
    public String toString() {
        return "KnotenImpl{" +
                ", knotentype=" + knotentype +
                ", origin=" + origin +
                ", interaction_radius=" + interaction_radius +
                ", region_size=" + region_size +
                ", region_mass=" + region_mass +
                ", elem=" + elem +
                '}';
    }

    @Override
    public Knoten getNW() {
        return nw;
    }

    @Override
    public Knoten getNO() {
        return no;
    }

    @Override
    public Knoten getSW() {
        return sw;
    }

    @Override
    public Knoten GetSO() {
        return so;
    }

    @Override
    public double getInteratctionRadius() {
        return interaction_radius;
    }

    @Override
    public double getRegionMass() {
        return region_mass;
    }

    @Override
    public Vector3d getRegionMassPoint() {
        return region_mass_point;
    }
}
