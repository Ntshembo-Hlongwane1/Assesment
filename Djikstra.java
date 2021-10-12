// Student name:
// Student number:

/**
 * Sources:
 * 
 **/

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


public class Djikstra {
    // Initialise necessary variables here.
	Graph graph;
    public Djikstra(Graph graph) {
    	
    }

    public void run() {
        // here you are to implement your algorithm.
    	int verticeLen= graph.vertices.length;
        int[] distance = new int[verticeLen];
        boolean[] visited= new boolean[verticeLen];
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        int minDistance=0;
        pq.add(minDistance); 
        for(int i=0;i<verticeLen;i++){
             distance[i]=Integer.MAX_VALUE;
             visited[i]=false;
        }
        distance[0]=0;
        int idx=0;
        while(!pq.isEmpty() && idx<graph.vertices.length){
             int removedLowestDist =pq.poll();
             
             if(!visited[minDistance]){
                 visited[minDistance]=true;
             }
             for(int i=0;i<graph.edges.length;i++){
                 String checkFor=graph.edges[i][0]; //  
                 String against =graph.vertices[idx];
                 if(checkFor.equals(against)){
                     System.out.println("edge "+ Arrays.toString(graph.edges[i]));
                     int verticesIdx=Arrays.asList(graph.vertices).indexOf(graph.edges[i][1]); //vsecond vertex of edge index
                     if(distance[idx]+graph.weights[i]<distance[verticesIdx]){
                         distance[verticesIdx]=distance[idx]+graph.weights[i];
                         pq.add(distance[verticesIdx]);
                     }
                 }
                 
             }
             idx++;
        }
        System.out.println("distances "+Arrays.toString(distance));
    	
    }

    public void _toString() {
        // Here you are to complete the method as to provide the desired output.

    }
    
    
    
    public static void main(String[] args) {
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
            
            Djikstra dj = new Djikstra(new_graph);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    	
    }
    
    private void build() {
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
            
            Djikstra dj = new Djikstra(new_graph);
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    private static void printEdgeMatrix(String[][] edges) {
    	Arrays.stream(edges).forEach((i) -> {
            Arrays.stream(i).forEach((j) -> System.out.print(j + " "));
            System.out.println();
        });
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
    
}