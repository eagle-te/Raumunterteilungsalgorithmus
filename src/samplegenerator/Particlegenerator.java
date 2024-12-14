package samplegenerator;

import version2.classes.ElementPointer;
import version2.classes.Particle;
import version2.classes.Vector3d;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander Breitenstein
 * Date: 26.05.2014
 * Time: 08:55
 */
public class Particlegenerator {

    public static List<Particle> generate(int quantity, int regionsize) {

        Set<Particle> particles = new HashSet<Particle>();

        Random r = new Random();

        while (particles.size() < quantity)
            particles.add(Particle.create(ElementPointer.create(Vector3d.create(r.nextInt(regionsize),r.nextInt(regionsize),0),r.nextFloat()*100)));


        return new ArrayList<Particle>(particles);
    }

    public static void main(String[] args) {
        List<Particle> particles = generate(300000, 1000);
//        for (Particle particle : particles) {
//            System.out.println(particle.getElem());
//        }
        System.out.println(particles.size());
    }
}