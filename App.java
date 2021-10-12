
// DO NOT EDIT UNLESS SPECIFIED TO DO SO!
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// https://www.tutorialspoint.com/json_simple/json_simple_quick_guide.htm

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, Student!\n");
        Graph bellman = null;
        Graph djikstra = null;
        

        // Add code for handling Json file here
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("graphs.json")) {

            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            
            JSONObject obj = (JSONObject) jsonObject.get("Graph_2");
            
            int end = Integer.parseInt(obj.get("end").toString());
            ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> matrix = (ArrayList<ArrayList<Integer>>) obj.get("graph");         
            
         
            for (int i=0; i<end+1; i++) {
            	graph.add(matrix.get(i));
            }

            graph = truncateElements(graph, 0, end+1);
            char[] possible_vertices = {'A', 'B', 'C', 'D', 'E','F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S','T', 'U', 'V', 'W','X', 'Y', 'Z'};
           
            //Vertices
            ArrayList<Character> vertices =  new ArrayList<Character>();
            for (int i=0; i<end+1; i++) {
            	vertices.add(possible_vertices[i]);
            }
            	
            //Edges
            ArrayList<ArrayList<Character>> edges = new ArrayList<ArrayList<Character>>();
            for (int i=0; i<end+1; i++) {
            	for (int j=0; j<end+1; j++) {
            		ArrayList<Integer>current_array = graph.get(i);
            		long current_value = ((Number)current_array.get(j)).longValue();
            			
            		if (current_value > 0) {
            			edges.add(new ArrayList<Character>(Arrays.asList(vertices.get(i), vertices.get(j))));
            		}
            	}
            }
            
            //Weights
            ArrayList<Integer> weights = new ArrayList<Integer>();
            for (int i=0; i<end+1; i++) {
            	for (int j=0; j<end+1; j++) {
            		ArrayList<Integer>current_array = graph.get(i);
            		long current_value = ((Number)current_array.get(j)).longValue();
            			
            		if (current_value > 0) {
            			weights.add((int) current_value);
            		}
            	}
            }
            

            int [] update_weight_array = convertWeightArrayList(weights);
            String[] update_vertices_array = convertVerticesArrayList(vertices);
            String[][] update_edges_array = convertEdgesArrayList(edges);
            
            Graph new_graph =  new Graph(update_vertices_array, update_edges_array, update_weight_array);
         // Declare graph build
            bellman = new Graph(update_vertices_array, update_edges_array, update_weight_array);
            bellman.buildGraph();

            djikstra = new Graph(update_vertices_array, update_edges_array, update_weight_array);
            djikstra.buildGraph();
            
            Djikstra dj = new Djikstra(new_graph);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    	

       

        Scanner scanner = new Scanner(System.in);
        while (true) {

            String[] options = { "1", "2", "3", "4", "5", "6" };
            List<String> _options = new ArrayList<>(Arrays.asList(options));
            System.out.println("Choose option to display: \n" + "[1]    Provided Bellman graph information.\n"
                    + "[2]    Provided Djikstra graph information.\n" + "[3]    Bellman solution.\n"
                    + "[4]    Djikstra solution.\n" + "[5]    Test Bellman solution on other graph.\n"
                    + "[6]    Test Djikstra Solution on other graph.\n" + "Any other button to exit.\n");

            String s = scanner.nextLine();
            switch (s) {
                case "1":
                    bellman.printGraphInfo();
                    break;
                case "2":
                    djikstra.printGraphInfo();
                    break;
                case "3":
                    // Now we call the bellman algo
                    new Bellman(bellman).run();
                    break;
                case "4":
                    // Now we call the djikstra algo
                    new Djikstra(djikstra).run();
                    break;
                case "5":
                    System.out.println("Student completes this section!");
                    // jsonGraph(jsonObject, true);
                    break;
                case "6":
//                    System.out.println("Student completes this section!");
//                     jsonGraph(jsonObject, false);
                    break;
            }
            if (!_options.contains(s)) {
                scanner.close();
                break;
            }
        }

    }
    
    private static String[][] convertEdgesArrayList(ArrayList<ArrayList<Character>> edges){
    	String[][] updated_edges_array = new String[edges.size()][2];
    	
    	for (int i=0; i<edges.size(); i++) {
    		String[] temp = new String[2];
    		for(int j=0; j<2; j++) {
    			temp[j] = edges.get(i).get(j).toString(); 
    		}
    		updated_edges_array[i] = temp;
    	}
    	return updated_edges_array;
    }
    
    private static String[] convertVerticesArrayList(ArrayList<Character> vertices) {
    	String[] update_vertices_array = new String[vertices.size()];
    	
    	for (int i=0; i<vertices.size(); i++) {
    		update_vertices_array[i] = vertices.get(i).toString();
    	}
    	
    	return update_vertices_array;
    }
    
    private static int[] convertWeightArrayList(ArrayList<Integer> weights) {
    	int [] new_weights = new int[weights.size()];
    	
    	for (int i=0; i<weights.size(); i++) {
    		new_weights[i] = weights.get(i);
    	}
    	return new_weights;
    }
   
    
    private  static ArrayList<ArrayList<Integer>> truncateElements(ArrayList<ArrayList<Integer>> graph, int start, int end) {
    	for (int i=0; i<end; i++) {
    		graph.set(i,  new ArrayList(graph.get(i).subList(start, end)));
    	}
    	return graph;
    }

    // Modify the section below to use graph data from json file
    /*
     * public static void jsonGraph(JSONObject obj, boolean flag){
     * 
     * // Add your code here //
     * 
     * // Do not edit below! if (flag){ Bellman(null, adj_matrix).run(); }else{
     * Djikstra(null, adj_matrix).run(); }
     * 
     * 
     * }
     */
    
//    public static void jsonGraph(JSONObject obj, boolean flag) {
//    	 int end = Integer.parseInt(obj.get("end").toString());
//         ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
//         ArrayList<ArrayList<Integer>> matrix = (ArrayList<ArrayList<Integer>>) obj.get("graph");         
//         
//      
//         for (int i=0; i<end+1; i++) {
//         	graph.add(matrix.get(i));
//         }
//
//         graph = truncateElements(graph, 0, end+1);
//         char[] possible_vertices = {'A', 'B', 'C', 'D', 'E','F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S','T', 'U', 'V', 'W','X', 'Y', 'Z'};
//        
//         //Vertices
//         ArrayList<Character> vertices =  new ArrayList<Character>();
//         for (int i=0; i<end+1; i++) {
//         	vertices.add(possible_vertices[i]);
//         }
//         	
//         //Edges
//         ArrayList<ArrayList<Character>> edges = new ArrayList<ArrayList<Character>>();
//         for (int i=0; i<end+1; i++) {
//         	for (int j=0; j<end+1; j++) {
//         		ArrayList<Integer>current_array = graph.get(i);
//         		long current_value = ((Number)current_array.get(j)).longValue();
//         			
//         		if (current_value > 0) {
//         			edges.add(new ArrayList<Character>(Arrays.asList(vertices.get(i), vertices.get(j))));
//         		}
//         	}
//         }
//         
//         //Weights
//         ArrayList<Integer> weights = new ArrayList<Integer>();
//         for (int i=0; i<end+1; i++) {
//         	for (int j=0; j<end+1; j++) {
//         		ArrayList<Integer>current_array = graph.get(i);
//         		long current_value = ((Number)current_array.get(j)).longValue();
//         			
//         		if (current_value > 0) {
//         			weights.add((int) current_value);
//         		}
//         	}
//         }
//         
//
//         int [] update_weight_array = convertWeightArrayList(weights);
//         String[] update_vertices_array = convertVerticesArrayList(vertices);
//         String[][] update_edges_array = convertEdgesArrayList(edges);
//         
//         Graph new_graph = new Graph(update_vertices_array, update_edges_array, update_weight_array);
//         new_graph.buildGraph();
//         
//         Djikstra dj = new Djikstra(new_graph);
//         dj.run();
//    }

}
