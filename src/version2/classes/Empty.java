package version2.classes;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander Breitenstein
 * Date: 26.05.2014
 * Time: 03:17
 */
public class Empty extends Node {

    private Empty() {
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.EMPTY;
    }

    @Override
    public Node create() {
        return new Empty();
    }

    public static Node createEmpty() {
        return new Empty();
    }

    @Override
    public void add(Particle node, Quadrant quadrant, Region upperNode) {
        upperNode.setQuadrant(quadrant, node);

//        switch (quadrant) {
//            case NW: Baum.rectangles.add(""+upperNode.origin_x()+","+upperNode.origin_y()+","+upperNode.size()*0.5); break;
//            case NO: Baum.rectangles.add(""+(upperNode.origin_x()+upperNode.size()*0.5)+","+upperNode.origin_y()+","+upperNode.size()*0.5); break;
//            case SW: Baum.rectangles.add(""+upperNode.origin_x()+","+(upperNode.origin_y()+upperNode.size()*0.5)+","+upperNode.size()*0.5); break;
//            case SO: Baum.rectangles.add(""+(upperNode.origin_x()+upperNode.size()*0.5)+","+(upperNode.origin_y()+upperNode.size()*0.5)+","+upperNode.size()*0.5); break;
//        }
    }
}