package Graphs;

import java.util.*;

public class Graph<Node> {

    /* Fields */
    Map<Node, Vertex> adjacencyList;
    Random rand = new Random();


    /* Methods */
    public Graph() {
        this.adjacencyList = new HashMap<Node, Vertex>();
    }

    public boolean addNode(Node node) {
        try {
            this.adjacencyList.putIfAbsent(node, new Vertex<Node>(node));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeNode(Node node) {
        try {
            this.adjacencyList.values().stream().forEach(vertex -> vertex.removeEdge(node));
            this.adjacencyList.remove(new Vertex<Node>(node));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addEdge(Node from, Node to, double weight) {
        try {
            this.adjacencyList.get(from).addEdge(new Edge(this.adjacencyList.get(to), weight));
            this.adjacencyList.get(to).addEdge(new Edge(this.adjacencyList.get(from), weight));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean addRandWeighedEdge(Node from, Node to) {
        try {
            double w = rand.nextDouble()*5;
            this.adjacencyList.get(from).addEdge(new Edge(this.adjacencyList.get(to), w));
            this.adjacencyList.get(to).addEdge(new Edge(this.adjacencyList.get(from), w));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removeEdge(Node from, Node to) {
        try {
            this.adjacencyList.get(new Vertex<Node>(from)).removeEdge(to);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public List<Node> getConnectedNodes(Node node) {

         return this.adjacencyList.get(node).getConnections();
    }

    public List<Edge> getWeighedConnectedNodes(Node node) {

        return this.adjacencyList.get(node).getWeighedConnections();
    }

    public Node getNode(Node node) {

        return (Node) this.adjacencyList.get(node).getNode();
    }

    public boolean isNode(Node node) {
        return this.adjacencyList.containsKey(node);
    }


    /* Classes */
    public class Vertex<Node> {

        /* Fields */
        private Node node;
        private List<Edge> edges;

        /* Methods */
        public Vertex(Node node) {
            this.node = node;
            this.edges = new ArrayList<Edge>();
        }

        public void addEdge(Edge edge) {
            this.edges.add(edge);
        }

        public void removeEdge(Node node) {
            this.edges.remove(new Edge(new Vertex(node), 0));
        }

        public List<Node> getConnections() {
            List<Node> connections = new ArrayList<>();
            this.edges.forEach(vertex -> connections.add((Node) vertex.toVertex.getNode()));

            return connections;
        }

        public List<Edge> getWeighedConnections() {
            List<Edge> connections = new ArrayList<>();
            this.edges.forEach(vertex -> connections.add(vertex));

            return connections;
        }

        public Node getNode() {
            return this.node;
        }

        @Override
        public int hashCode() {
            return this.node.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }
    }


    public class Edge {

        /* Fields */
        private Vertex toVertex;
        private double weight;

        /* Methods */
        public Edge(Vertex toVertex, double weight) {
            this.toVertex = toVertex;
            this.weight = weight;
        }

        public Vertex getVertex() {
            return this.toVertex;
        }

        public double getWeight(){
            return this.weight;
        }

        public void setWeight(double weight) {
            this.weight = weight;
        }

        @Override
        public int hashCode() {
            return this.toVertex.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return super.equals(obj);
        }

        @Override
        public String toString() {
            return this.toVertex.toString() + " -> " + this.weight;
        }
    }

}
