package Graphs;


import java.util.*;

public class Graph<Node> {

    /* Fields */
    private Map<Node, ArrayList<Edge>> adjList;


    /* Methods */
    public Graph() {
        this.adjList = new HashMap<Node, ArrayList<Edge>>();
    }


    // Node methods.
    public void addNode(Node node) {
        this.adjList.putIfAbsent(node, new ArrayList<>());
    }

    public void removeNode(Node node) {
        this.adjList.remove(node);
    }

    public boolean containsNode(Node node) {

        return this.adjList.containsKey(node);
    }

    public Set getAllNodes() {

        return this.adjList.keySet();
    }

    public List getAllChildrenNodes(Node node) {

        List edges = this.getAllEdges(node);
        List connectedNodes = new ArrayList();

        for (Object edge: edges) {
            edge = (Edge) edge;
            connectedNodes.add(((Edge) edge).to);
        }

        return connectedNodes;
    }


    // Edge methods.
    public boolean addEdge(Node from, Node to, double weight) {

        if (this.containsNode(to) && this.containsNode(from)) {
            this.adjList.get(from).add(new Edge(from, to, weight));
            this.adjList.get(to).add(new Edge(to, from, weight));
            return true;
        }
        return false;
    }

    public boolean removeEdge(Node from, Node to) {

        if (this.containsNode(to) && this.containsNode(from)) {
            this.adjList.get(from).remove(new Edge(to));
            this.adjList.get(to).remove(new Edge(from));
            return true;
        }
        return false;
    }

    public double getEdgeWeight(Node from, Node to) {

        if (this.containsNode(to) && this.containsNode(from)) {

            ArrayList<Edge> connections = this.adjList.get(from);

            for (Edge edge: connections) {
                if (edge.goesTo(to))
                    return edge.getWeight();
            }
        }

        return Double.POSITIVE_INFINITY;
    }

    public boolean setEdgeWeight(Node from, Node to, double weight) {

        if (this.containsNode(to) && this.containsNode(from)) {

            ArrayList<Edge> connections = this.adjList.get(from);

            for (Edge edge: connections) {
                if (edge.goesTo(to)) {
                    edge.setWeight(weight);
                    break;
                }
            }

            connections = this.adjList.get(to);

            for (Edge edge: connections) {
                if (edge.goesTo(from)) {
                    edge.setWeight(weight);
                    break;
                }
            }

            return true;
        }

        return false;
    }

    public List getAllEdges(Node node) {

        if (this.containsNode(node)) {
            return this.adjList.get(node);
        }

        return null;
    }



    /* Classes */
    public class Edge {

        /* Fields */
        private Node from, to;
        private double weight;

        /* Methods */
        public Edge(Node to) {
            this(to, null, 0);
        }
        public Edge(Node from, Node to, double weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }


        public Node getFrom() {
            return from;
        }

        public void setFrom(Node from) {
            this.from = from;
        }

        public Node getTo() {
            return to;
        }

        public void setTo(Node to) {
            this.to = to;
        }

        public double getWeight() {
            return weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

//        public boolean equals(Edge other) {
//            return this.to.equals(other.getTo());
//        }

        public boolean goesTo(Node to) {
            return this.to.equals(to);
        }


        @Override
        public int hashCode() {
            return this.to.hashCode();
        }

        @Override
        public String toString() {
            return String.format("(%1$s --%3$s--> %2$s)", this.from, this.to, this.weight);
        }
    }

}
