package version1.classes;

/**
 * Created by abg628 on 30.04.14.
 */
public interface Baum {

    public int size();

    void add(Knoten knoten);

    public Interaction traverse(Knoten knoten);
}
