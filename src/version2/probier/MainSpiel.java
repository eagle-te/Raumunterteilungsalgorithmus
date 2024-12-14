package version2.probier;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander Breitenstein
 * Date: 24.06.2014
 * Time: 00:11
 */
public class MainSpiel {

    public static void main(String[] args) {

        int customslots = 10000;
        int currentIndex = 0;
        Integer mapentry = 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();


        
        for (int i = 0; i < customslots; i++) {
            for (int j = 0; j < customslots; j++) {

                for (int x = 0; x < customslots; i++) {
                    for (int y = 0; y < customslots; j++) {

                        if (Math.pow(i, 2) + Math.pow(j, 3) == Math.pow(y, 2) + Math.pow(x, 3)) {
                            System.out.println("Equal: ");
                            System.out.println("i: "+i);
                            System.out.println("j: "+j);
                            System.out.println("y: "+y);
                            System.out.println("x: "+x);
                        }


                    }
                }


            }
        }


    }
}