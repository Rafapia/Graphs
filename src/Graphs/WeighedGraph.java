package Graphs;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultUndirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class WeighedGraph<NodeType> {

    /* Fields */
    private Graph<NodeType, DefaultWeightedEdge> graph;
    private Random rand = new Random();


    /* Methods */
    public WeighedGraph() {
        this.graph = new DefaultUndirectedWeightedGraph<NodeType, DefaultWeightedEdge>(DefaultWeightedEdge.class);
    }


    public boolean addVertex(NodeType node) {
        return this.graph.addVertex(node);
    }

    public boolean removeVertex(NodeType node) {
        return this.graph.removeVertex(node);
    }

    public boolean addWeighedEdge(NodeType from, NodeType to, double weight) {
        try {
            DefaultWeightedEdge edgeTo = new DefaultWeightedEdge();
            this.graph.addEdge(from, to, edgeTo);
            this.graph.setEdgeWeight(edgeTo, weight);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addRandomlyWeighedEdge(NodeType from, NodeType to, double minWeight, double maxWeight) {
        try {
            DefaultWeightedEdge edge = new DefaultWeightedEdge();
            this.graph.addEdge(from, to, edge);
            this.graph.setEdgeWeight(edge, (rand.nextDouble()*(maxWeight-minWeight)+minWeight));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addRandomlyWeighedEdge(NodeType from, NodeType to) {
        try {
            DefaultWeightedEdge edge = new DefaultWeightedEdge();
            this.graph.addEdge(from, to, edge);
            this.graph.setEdgeWeight(edge, (rand.nextDouble()*10));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeEdge(NodeType from, NodeType to) {
        try {
            this.graph.removeEdge(from, to);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean setEdgeWeight(NodeType from, NodeType to, double weight) {
        try {
            this.graph.setEdgeWeight(from, to, weight);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean containsVertex(NodeType node) {
        return this.graph.containsVertex(node);
    }

    public boolean containsEdge(NodeType from, NodeType to) {
        return this.graph.containsEdge(from, to);
    }

    public double getEdgeWeight(NodeType from, NodeType to) {
        return this.graph.getEdgeWeight(this.graph.getEdge(from, to));
    }

    public List<NodeType> getConnectedNodes(NodeType node) {

        List<NodeType> connected = new ArrayList<NodeType>();

        for (DefaultWeightedEdge edge: this.graph.outgoingEdgesOf(node)) {
            connected.add(this.graph.getEdgeTarget(edge));
        }

        return connected;
    }

    public List<Edge> getWeighedConnectedNodes(NodeType node) {

        List<Edge> connected = new ArrayList<Edge>();

        for (DefaultWeightedEdge edge: this.graph.outgoingEdgesOf(node)) {
            if (this.graph.getEdgeSource(edge).equals(node)) {
                NodeType connectedNode = this.graph.getEdgeTarget(edge);
                connected.add(new Edge(connectedNode, this.getEdgeWeight(node, connectedNode)));
            } else if (this.graph.getEdgeTarget(edge).equals(node)) {
                NodeType connectedNode = this.graph.getEdgeSource(edge);
                connected.add(new Edge(connectedNode, this.getEdgeWeight(connectedNode, node)));
            }
        }

        return connected;
    }

    public Set<NodeType> getAllVertices() {

        return this.graph.vertexSet();
    }


    /* Classes */
    public class Edge<NodeType> {

        /* Fields */
        private NodeType targetNode;
        private double weight;

        /* Methods */
        public Edge(NodeType to, double weight) {
            this.targetNode = to;
            this.weight = weight;
        }

        public NodeType getTargetNode() {
            return targetNode;
        }

        public void setTargetNode(NodeType targetNode) {
            this.targetNode = targetNode;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + this.targetNode + " - " + this.weight + ")";
        }
    }
}
