import io.jbotsim.core.Link;
import io.jbotsim.core.Topology;
import io.jbotsim.ui.JTopology;
import io.jbotsim.ui.JViewer;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashSet;

public class UniformScattering {

    public static void main(String[] args) {

        Topology tp = new Topology();
        tp.setWirelessStatus(false);

        // grid parameters
        // number of robots/size of grid parameter
        final int k = 3;

        // vision radius
        final int d = 4;

        // length of row/column
        final int n = k * d;

        // total grid nodes
        final int N = (int) Math.pow((n + 1), 2);

        // total robots
        final int K = (int) Math.pow((k + 1), 2);


        // pixels per grid
        final int step_size = 50;

        tp.setDefaultNodeModel(ScatteringNode.class);


        HashSet<Point2D> uniqueCoords = new HashSet<Point2D>();

        while (uniqueCoords.size() < K) {
            int x = (int)Math.floor(Math.random() * n);
            int y = (int)Math.floor(Math.random() * n);
            x *= step_size;
            y *= step_size;
            Point p = new Point(x,y);
            uniqueCoords.add(p);
        }

        for (Point2D p : uniqueCoords) {
            tp.addNode(p.getX(), p.getY());
            System.out.println("New node" + p.toString());
        }

        tp.setSensingRange(2*d*step_size);

        JViewer jv = new JViewer(tp);
        jv.setSize(n*(step_size+1), n*(step_size + 1));
        JTopology jtp = jv.getJTopology();
        // jv.setSize();
        tp.start();

    }
}