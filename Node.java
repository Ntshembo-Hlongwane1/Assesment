// DO NOT EDIT!
public class Node {
    
    String neighbours[][];
    String ID;
    int neighbourCount;

    public Node(String name){
        ID = name;
        neighbourCount = 0;
        neighbours = new String[100][2];
    }

    public void addNeighbour(String neighbour, int weight){
        neighbours[neighbourCount] = new String[] {neighbour, Integer.toString(weight)};
        neighbourCount++;
    }

    public String[][] getNeighbours(){
        String[][] arr = new String[neighbourCount][2];
        for (int i = 0; i < neighbourCount; i++ ){
            arr[i] = neighbours[i];
        }
        return arr;
    }

    public int getNeighbourCount(){
        return neighbourCount;
    }

    public String getNodeID(){
        return ID;
    }

}
