package version2.classes;

import static version2.classes.Quadrant.*;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander Breitenstein
 * Date: 26.05.2014
 * Time: 03:00
 */
public class Region extends Node{
    private float size;
    private Vector3d origin;
    private final int quadrantNumber = 4;

    /**
     * NW = 0
     * NO = 1
     * SW = 2
     * SO = 3
     */
    Node[] quadrants;

    private Region() {
        quadrants = new Node[quadrantNumber];
    }

    private Region(float regionSize, Vector3d origin) {
        quadrants = new Node[quadrantNumber];
        for (int i = 0; i < quadrantNumber; i++) {
            quadrants[i] = Empty.createEmpty();
        }
        this.size = regionSize;
        this.origin = origin;
    }

    @Override
    public NodeType getNodeType() {
        return NodeType.REGION;
    }

    @Override
    public Node create() {
        return new Region();
    }

    public static Region create(float regionSize, Vector3d origin) {
        return new Region(regionSize, origin);
    }

    @Override
    public void add(Particle node, Quadrant quadrant, Region upperNode) {
        final Quadrant quad = evaluateQuadrant(node, this);
        switch (quad) {
            case NW: this.getQuadrant(NW).add(node, quad, this); break;
            case NO: this.getQuadrant(NO).add(node, quad, this); break;
            case SW: this.getQuadrant(SW).add(node, quad, this); break;
            case SO: this.getQuadrant(SO).add(node, quad, this); break;
        }
    }

    public Node getQuadrant(Quadrant quadrant) {
        Node node = Empty.createEmpty();
        switch (quadrant) {
            case NW: node = quadrants[0]; break;
            case NO: node = quadrants[1]; break;
            case SW: node = quadrants[2]; break;
            case SO: node = quadrants[3]; break;
        }
        return node;
    }

    public void setQuadrant(Quadrant quadrant, Node node) {
        switch (quadrant) {
            case NW: quadrants[0] = node; break;
            case NO: quadrants[1] = node; break;
            case SW: quadrants[2] = node; break;
            case SO: quadrants[3] = node; break;
        }
    }

    final public float size() {
        return size;
    }

    final public float origin_x() {
        return origin.x();
    }

    final public float origin_y() {
        return origin.y();
    }
}