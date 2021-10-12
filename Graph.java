// DO NOT EDIT!
public class Graph {

    Node Nodes[];
    String vertices[];
    String edges[][];
    int weights[];
    int nodeCount;

    public Graph(String[] Vertices, String[][] Edges, int[] Weights){
        nodeCount  = Vertices.length;
        Nodes = new Node[nodeCount];
        vertices = Vertices;
        edges = Edges;
        weights = Weights;
    }

    public void buildGraph(){
        for (int i = 0; i < nodeCount; i++){
            Nodes[i] = new Node(vertices[i]);
            for (int j = 0; j < edges.length; j++){
                if (edges[j][0].equals(vertices[i]))
                    Nodes[i].addNeighbour(edges[j][1], weights[j]);
            }
        }
    }

    public void printGraphInfo(){
        // I print as follows - Node : nodeID \n Neighbours : [neighbours, weight]
        for (int n = 0; n < nodeCount; n++){
            System.out.println("Node : "+Nodes[n].getNodeID());
            System.out.println("Neighbours");
            String[][] neighbours = Nodes[n].getNeighbours();
            for (int i = 0; i < neighbours.length; i++){
                System.out.println(""+neighbours[i][0]+" : "+neighbours[i][1]);
            }
            System.out.println("\n");
        } 
    }
}
