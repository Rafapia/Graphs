import Graphs.Graph;
import org.jgrapht.graph.DefaultUndirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Graph<String> sa = new Graph<String>();

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


        // Randomized distances.
        Graph<String> saRand = new Graph<String>();

        saRand.addNode("Chapel");
        saRand.addNode("Alumni");
        saRand.addNode("Girls");
        saRand.addNode("VA");
        saRand.addNode("US Classes");
        saRand.addNode("Teacher Lot");
        saRand.addNode("Senior Lot");
        saRand.addNode("Security");
        saRand.addNode("Rock");
        saRand.addNode("Cohen Center");
        saRand.addNode("Dining Hall");
        saRand.addNode("Science");
        saRand.addNode("Boys");
        saRand.addNode("Admissions");

        saRand.addRandWeighedEdge("Chapel", "Boys");
        saRand.addRandWeighedEdge("Chapel", "Alumni");
        saRand.addRandWeighedEdge("Chapel", "Cohen Center");
        saRand.addRandWeighedEdge("Boys", "Science");
        saRand.addRandWeighedEdge("Science", "Dining Hall");
        saRand.addRandWeighedEdge("Dining Hall", "Cohen Center");
        saRand.addRandWeighedEdge("Dining Hall", "Rock");
        saRand.addRandWeighedEdge("Rock", "Security");
        saRand.addRandWeighedEdge("Rock", "Cohen Center");
        saRand.addRandWeighedEdge("Security", "Admissions");
        saRand.addRandWeighedEdge("Security", "Senior Lot");
        saRand.addRandWeighedEdge("Security", "Teacher Lot");
        saRand.addRandWeighedEdge("Senior Lot", "Admissions");
        saRand.addRandWeighedEdge("Admissions", "Alumni");
        saRand.addRandWeighedEdge("Admissions", "US Classes");
        saRand.addRandWeighedEdge("US Classes", "Teacher Lot");
        saRand.addRandWeighedEdge("US Classes", "VA");
        saRand.addRandWeighedEdge("VA", "Girls");
        saRand.addRandWeighedEdge("Teacher Lot", "Girls");
        saRand.addRandWeighedEdge("Girls", "Alumni");

        System.out.println(sa.getConnectedNodes("Admissions") + "\n\n");


        String input = "Security";
        while (!input.equals("q")) {

            // If valid node, show options.
            if (sa.isNode(input)) {
                String currentNode = sa.getNode(input);
                System.out.println("Currently at " + currentNode);
                System.out.print("Connected nodes: ");

                for (Graph.Edge connectedNode : sa.getWeighedConnectedNodes(currentNode)) {
                    System.out.print("(" + connectedNode.getVertex().getNode() + " - " + connectedNode.getWeight() + ") ");
                }

                System.out.println();
            } else if (input.equals("q")) {
                break;
            }

            System.out.print("\nNext node: ");
            input = in.nextLine();
        }
    }

}
