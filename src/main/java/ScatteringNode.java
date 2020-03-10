
import io.jbotsim.core.Color;
import io.jbotsim.core.Node;
import io.jbotsim.core.Message;

import java.util.ArrayList;
import java.util.List;

public class ScatteringNode extends Node {

    @Override
    public double distance(Node n2) {
        return Math.abs(this.getX() - n2.getX()) + Math.abs(this.getY() - n2.getY());
    }

    @Override
    public void onStart() {
        // JBotSim executes this method on each node upon initialization
        List<Node> neighbours = getSensedNodes();
        if (neighbours.isEmpty()) {
            setColor(Color.BLACK);
        }
        else {
            setColor(Color.RED);
        }
    }

    @Override
    public void onSelection() {
        // JBotSim executes this method on a selected node
    }

    @Override
    public void onClock() {
        // JBotSim executes this method on each node in each round
    }

    @Override
    public void onMessage(Message message) {
        // JBotSim executes this method on a node every time it receives a message
    }
}