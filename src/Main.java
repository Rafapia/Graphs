import Graphs.Graph;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Graph<String> sa = new Graph<>();

        sa.addNode("Chapel");
        sa.addNode("Alumni");
        sa.addNode("Girls");
        sa.addNode("VA");
        sa.addNode("US Classes");
        sa.addNode("Teacher Lot");
        sa.addNode("Senior Lot");
        sa.addNode("Security");
        sa.addNode("Rock");
        sa.addNode("Cohen Center");
        sa.addNode("Dining Hall");
        sa.addNode("Science");
        sa.addNode("Boys");
        sa.addNode("Admissions");

        sa.addEdge("Chapel", "Boys", 4);
        sa.addEdge("Chapel", "Alumni", 2);
        sa.addEdge("Chapel", "Cohen Center", 5);
        sa.addEdge("Boys", "Science", 1);
        sa.addEdge("Science", "Dining Hall", 1);
        sa.addEdge("Dining Hall", "Cohen Center", 2);
        sa.addEdge("Dining Hall", "Rock", 3);
        sa.addEdge("Rock", "Security", 1);
        sa.addEdge("Rock", "Cohen Center", 2);
        sa.addEdge("Security", "Admissions", 1);
        sa.addEdge("Security", "Senior Lot", 1);
        sa.addEdge("Security", "Teacher Lot", 3);
        sa.addEdge("Senior Lot", "Admissions", 2);
        sa.addEdge("Admissions", "Alumni", 4);
        sa.addEdge("Admissions", "US Classes", 1);
        sa.addEdge("US Classes", "Teacher Lot", 1);
        sa.addEdge("US Classes", "VA", 1);
        sa.addEdge("VA", "Girls", 1);
        sa.addEdge("Teacher Lot", "Girls", 2);
        sa.addEdge("Girls", "Alumni", 3);


        Dijkstra<String> d = new Dijkstra<>(sa);


        System.out.println(d.findShortestPath("Teacher Lot", "Boys"));













        // Randomized distances.
//        WeighedGraph<String> saRand = new WeighedGraph<>();
//
//        saRand.addNode("Chapel");
//        saRand.addNode("Alumni");
//        saRand.addNode("Girls");
//        saRand.addNode("VA");
//        saRand.addNode("US Classes");
//        saRand.addNode("Teacher Lot");
//        saRand.addNode("Senior Lot");
//        saRand.addNode("Security");
//        saRand.addNode("Rock");
//        saRand.addNode("Cohen Center");
//        saRand.addNode("Dining Hall");
//        saRand.addNode("Science");
//        saRand.addNode("Boys");
//        saRand.addNode("Admissions");
//
//        saRand.addRandomlyWeighedEdge("Chapel", "Boys");
//        saRand.addRandomlyWeighedEdge("Chapel", "Alumni");
//        saRand.addRandomlyWeighedEdge("Chapel", "Cohen Center");
//        saRand.addRandomlyWeighedEdge("Boys", "Science");
//        saRand.addRandomlyWeighedEdge("Science", "Dining Hall");
//        saRand.addRandomlyWeighedEdge("Dining Hall", "Cohen Center");
//        saRand.addRandomlyWeighedEdge("Dining Hall", "Rock");
//        saRand.addRandomlyWeighedEdge("Rock", "Security");
//        saRand.addRandomlyWeighedEdge("Rock", "Cohen Center");
//        saRand.addRandomlyWeighedEdge("Security", "Admissions");
//        saRand.addRandomlyWeighedEdge("Security", "Senior Lot");
//        saRand.addRandomlyWeighedEdge("Security", "Teacher Lot");
//        saRand.addRandomlyWeighedEdge("Senior Lot", "Admissions");
//        saRand.addRandomlyWeighedEdge("Admissions", "Alumni");
//        saRand.addRandomlyWeighedEdge("Admissions", "US Classes");
//        saRand.addRandomlyWeighedEdge("US Classes", "Teacher Lot");
//        saRand.addRandomlyWeighedEdge("US Classes", "VA");
//        saRand.addRandomlyWeighedEdge("VA", "Girls");
//        saRand.addRandomlyWeighedEdge("Teacher Lot", "Girls");
//        saRand.addRandomlyWeighedEdge("Girls", "Alumni");
//
//        System.out.println(sa.getConnectedNodes("Admissions") + "\n\n");


//        String input = "Security";
//        while (!input.equals("q")) {
//
//            // If valid node, show options.
//            if (sa.containsVertex(input)) {
//                String currentNode = input;
//                System.out.println("Currently at " + currentNode);
//                System.out.print("Connected nodes: ");
//
//                for (WeighedGraph.Edge connectedNode : sa.getWeighedConnectedNodes(currentNode)) {
//                    System.out.print("(" + connectedNode.getTargetNode() + " - " + connectedNode.getWeight() + ") ");
//                }
//
//                System.out.println();
//            } else if (input.equals("q")) {
//                break;
//            }
//
//            System.out.print("\nNext node: ");
//            input = in.nextLine();
//        }


//        PriorityQueue<String> pq = new PriorityQueue<>();
//        pq.enqueue("Two", 2);
//        pq.enqueue("One", 1);
//        pq.enqueue("Three", 3);
//        pq.enqueue("Five", 5);
//        pq.enqueue("Four", 4);
//        pq.enqueue("Zero", 0);
//
//        System.out.println(pq.getPriority("Zero"));
//
//        System.out.println(pq);
//
//        pq.dequeue();
//        pq.dequeue();
//        pq.dequeue();
//        pq.dequeue();
//        pq.dequeue();

    }

}
