package version1.probier;

import version1.classes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * User: Alex
 * Date: 22.05.2014
 * Time: 00:28
 */
public class Version1Probier {

    private static Random random = new Random();

    public static void main(String[] args) {
        Baum baum = BaumImpl.create(100.d);
        baum.add(KnotenImpl.create().initializeParticle(ElementPointer.create(Vector3d.create(1.d, 54.d, 0.d), 32.d),100.d));
        List<Knoten> knotens = new ArrayList<Knoten>();
        for (int i = 0; i < 1000; i++) {
            knotens.add(KnotenImpl.create().initializeParticle(
                    ElementPointer.create(Vector3d.create(rD(), rD(), rD()), rD()),
                    100.d));
        }
        for (Knoten knoten : knotens) {
            baum.add(knoten);
        }
        System.out.println(baum);
    }

    static double rD() {
        return random.nextDouble() * 100;
    }
}
