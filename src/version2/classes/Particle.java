package version2.classes;


/**
 * Created with IntelliJ IDEA.
 * User: Alexander Breitenstein
 * Date: 26.05.2014
 * Time: 02:56
 */
public class Particle extends Node {
    private ElementPointer elem;

    private Particle(ElementPointer elem) {
        this.elem = elem;
    }

    private Particle() {

    }

    @Override

    public NodeType getNodeType() {
        return NodeType.PARTICLE;
    }

    @Override
    public Node create() {
        return new Particle();
    }

    public static Particle create(ElementPointer elem) {
        return new Particle(elem);
    }

    @Override
    public void add(Particle node, Quadrant quadrant, Region upperNode) {
        final float halfSizeRegion = upperNode.size() * 0.5f;
        Particle secondParticle = this;

        Vector3d newOrigin = null;

        final float upperNodeOriginX = upperNode.origin_x();
        final float upperNodeOriginY = upperNode.origin_y();
        switch (evaluateQuadrant(node,upperNode)) {
            case NW: newOrigin = Vector3d.create(upperNodeOriginX,upperNodeOriginY,0); break;
            case NO: newOrigin = Vector3d.create(upperNodeOriginX+halfSizeRegion,upperNodeOriginY,0); break;
            case SW: newOrigin = Vector3d.create(upperNodeOriginX,upperNodeOriginY+halfSizeRegion,0); break;
            case SO: newOrigin = Vector3d.create(upperNodeOriginX+halfSizeRegion,upperNodeOriginY+halfSizeRegion,0); break;
        }

        final Region region = Region.create(halfSizeRegion, newOrigin);

        upperNode.setQuadrant(quadrant, region);
        upperNode.getQuadrant(quadrant).add(node, quadrant, upperNode);
        upperNode.getQuadrant(quadrant).add(secondParticle, quadrant, upperNode);

    }

    public ElementPointer getElem() {
        return elem;
    }

    final public Vector3d getPosition() {
        return elem.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Particle)) return false;

        Particle particle = (Particle) o;

        if (!elem.equals(particle.elem)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return elem.hashCode();
    }
}