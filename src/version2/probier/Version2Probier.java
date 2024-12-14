package version2.probier;

import samplegenerator.Particlegenerator;
import version2.classes.Baum;
import version2.classes.Particle;

import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander Breitenstein
 * Date: 26.05.2014
 * Time: 09:23
 */
public class Version2Probier {
    public static void main(String[] args) {
        final float region_size = 1000.f;
        final int number_of_particles = 10 * 9 + 6 * 300;
        Baum baum = Baum.create(region_size);
        List<Particle> particles = Particlegenerator.generate(number_of_particles, (int) region_size);
        System.out.println("n log(n)");
        long endtime = 0;
        long starttime = System.currentTimeMillis();
        for (Particle particle : particles) {
            baum.add(particle);
        }
        for(Particle particle : particles){
            
        }
        endtime = System.currentTimeMillis();
        System.out.println("Differenz in Millisekunden: " + (endtime - starttime));


        System.out.println("n²");
        starttime = System.currentTimeMillis();
        for (Particle particle : particles) {
            for (Particle particle1 : particles) {

            }
        }
        endtime = System.currentTimeMillis();

        System.out.println("Differenz in MilliSekunden: " + (endtime - starttime));

        System.out.println(baum.size());
        System.out.println(Baum.rectangles.size());
    }
}