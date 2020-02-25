import Graphs.Graph;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra<Node> {

    /* Fields */
    private Graph graph;
    private PriorityQueue<PathNode> pq;
    private ArrayList<PathNode> visited;


    /* Methods */
    public Dijkstra(Graph graph) {
        this.graph = graph;
    }


    public ArrayList findShortestPath(Node from, Node to) {

        // If graph does not contain either nodes, return null;
        if (!this.graph.containsNode(from) || !this.graph.containsNode(to))
            return null;

        // Setup working variables to keep track of visited nodes and pending nodes.
        this.pq = new PriorityQueue<>();
        this.visited = new ArrayList<>();

        PathNode currentNode = new PathNode(from, null, 0);


        // Add starting node to PQ.
        this.pq.enqueue(currentNode, currentNode.getDistance());


        // Main loop.
        while (!this.pq.isEmpty()) {

            // Get current Node.
            currentNode = pq.dequeue();
            if (!this.visited.contains(currentNode))
                this.visited.add(currentNode);

            // Add all children nodes.
            for (Node node: (ArrayList<Node>) this.graph.getAllChildrenNodes(currentNode.getCurrent())) {

                PathNode pathNode = new PathNode(node, currentNode.getCurrent(),
                        currentNode.getDistance() + this.graph.getEdgeWeight(currentNode.getCurrent(), node));

                // If not already visited, add to pq.
                if (!this.visited.contains(pathNode)) {

                    // If not in pq, add.
                    if (!this.pq.contains(pathNode)) {
                        this.pq.enqueue(pathNode, pathNode.getDistance());
                    }
                    // If already in pq and new distance is smaller, update distance.
                    else if(this.pq.getPriority(pathNode) > pathNode.getDistance()){
                        this.pq.updatePriority(pathNode, pathNode.getDistance());
                    }
                }
            }
        }

        // Create ArrayList to store nodes.
        ArrayList<Node> path = new ArrayList<>();
        Node n = to;

        // Go back each node and pick final path.
        while (n != null) {

            for (PathNode node: this.visited) {
                if (node.getCurrent().equals(n)) {
                    path.add(0, n);
                    n = node.getPrevious();
                    break;
                }
            }
        }


        return path;
    }



    /* Classes */
    public class PathNode {

        /* Fields */
        private double distance;
        private Node current, previous;


        /* Methods */
        public PathNode(Node current, Node previous, double distance) {
            this.current = current;
            this.previous = previous;
            this.distance = distance;
        }


        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public Node getCurrent() {
            return current;
        }

        public void setCurrent(Node current) {
            this.current = current;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public String toString() {
            return String.format("(%1$s --%3$s--> %2$s)", this.previous, this.current, this.distance);
        }

        @Override
        public int hashCode() {
            return this.current.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return this.getCurrent().hashCode() == ((PathNode) obj).getCurrent().hashCode();
        }
    }
}
