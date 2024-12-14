package version2.gui;

        import samplegenerator.Particlegenerator;
        import version2.classes.Baum;
        import version2.classes.Particle;
        import version2.classes.Region;

        import java.awt.Color;
        import java.awt.Dimension;
        import java.awt.Graphics;
        import java.util.List;

        import javax.swing.JFrame;
        import javax.swing.SwingUtilities;

/**
 * Created with IntelliJ IDEA.
 * User: Alexander Breitenstein
 * Date: 26.05.2014
 * Time: 10:44
 */
public class RegionGUI extends JFrame{
    final double region_size = 1000.d;
    final int dimension = (int)region_size;
    List<Particle> particles;
    Baum baum;
    public RegionGUI() {

        particles = Particlegenerator.generate(50, dimension);
        baum = Baum.create(dimension);

        for (Particle particle : particles) {
            baum.add(particle);
        }

        setSize(new Dimension(dimension, dimension));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void paint(Graphics g) {
        final int offset = 40;


        g.setColor(Color.black);
        for (String rectangle : Baum.rectangles) {
            String[] values = rectangle.split(",");
            g.drawRect(offset+(int)(Double.parseDouble(values[0])+0.5),offset+(int)(Double.parseDouble(values[1])+0.5),(int)(Double.parseDouble(values[2])+0.5),(int)(Double.parseDouble(values[2])+0.5));
        }
        int particleSize = 4;
        for (Particle particle : particles) {
            g.setColor(Color.red);
            g.fillOval(offset + (int) (particle.getPosition().x()+0.5), offset + (int) (particle.getPosition().y()+0.5), particleSize, particleSize);
        }

    }

    public static void main(String arg[]) {



        new RegionGUI();
    }
}