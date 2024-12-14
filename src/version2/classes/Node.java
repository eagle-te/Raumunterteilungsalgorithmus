package version2.classes;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander Breitenstein
 * Date: 26.05.2014
 * Time: 02:41
 */
public abstract class Node {

    public Quadrant evaluateQuadrant(Particle particle, Region region) {
        Quadrant quadrant;
        final float regionExtension = region.size() * 0.5f;
        final Vector3d particlePosition = particle.getPosition();

        float nodeX = particlePosition.x(),
                nodeY = particlePosition.y(),
                regionBorderX = (region.origin_x()+regionExtension),
                regionBorderY = (region.origin_y()+regionExtension);

        final boolean nodesmallerEqualBorderX = nodeX <= regionBorderX;
        final boolean nodesmallerEqualBorderY = nodeY <= regionBorderY;
        
        if ( nodesmallerEqualBorderX && nodesmallerEqualBorderY) {
            quadrant = Quadrant.NW;
        }else if (nodeX > regionBorderX && nodesmallerEqualBorderY) {
            quadrant = Quadrant.NO;
        }else if (nodesmallerEqualBorderX && nodeY > regionBorderY) {
            quadrant = Quadrant.SW;
        } else { // nodeX > regionX && nodeY > regionY
            quadrant = Quadrant.SO;
        }
                
//        if (nodeX <= regionBorderX && nodeY <= regionBorderY) {
//            quadrant = Quadrant.NW;
//        }else if (nodeX > regionBorderX && nodeY <= regionBorderY) {
//            quadrant = Quadrant.NO;
//        }else if (nodeX <= regionBorderX && nodeY > regionBorderY) {
//            quadrant = Quadrant.SW;
//        } else { // nodeX > regionX && nodeY > regionY
//            quadrant = Quadrant.SO;
//        }

        return quadrant;
    }

    @Override
    public String toString() {
        return getNodeType().toString();
    }

    abstract public NodeType getNodeType();


    abstract public Node create();

    /**
     * Adds a Node to the UpperNode:Region to the referenceNode:Particle|Empty
     *
     * @param node Particle to be added to the upperNode:Region
     * @param quadrant choosen quadrant
     * @param upperNode :Region owns referenceNode, node is added to upperNode
     */
    abstract public void add(Particle node, Quadrant quadrant, Region upperNode);
}