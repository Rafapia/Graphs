import Graphs.Graph;
import org.jgrapht.graph.DefaultUndirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

public class Main {

    public static void main(String[] args) {
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


        System.out.println(sa.getConnectedNodes("Admissions"));


        SimpleWeightedGraph<String, DefaultWeightedEdge> saMap = new SimpleWeightedGraph<String, DefaultWeightedEdge>(DefaultWeightedEdge.class);
        saMap.addVertex("Chapel");
        saMap.addVertex("Boys");
    }

}
