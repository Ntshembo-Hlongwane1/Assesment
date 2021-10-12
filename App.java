//
//// DO NOT EDIT UNLESS SPECIFIED TO DO SO!
//import java.util.*;
//
//// https://www.tutorialspoint.com/json_simple/json_simple_quick_guide.htm
//
//public class App {
//    public static void main(String[] args) throws Exception {
//        System.out.println("Hello, Student!\n");
//
//        // Graph variables
//        String[] vertices = { "A", "B", "C", "D", "E", "F" };
//        String[][] edges = { { "A", "B" }, { "A", "C" }, { "A", "D" }, { "B", "C" }, { "C", "D" }, { "D", "E" },
//                { "E", "A" }, { "E", "F" }, { "F", "D" }, { "F", "B" } };
//        // Bellman graph weights
//        int[] b_weights = { 3, 2, 4, 10, 1, 7, 5, 1, 5, 4 };
//
//        // Djikstra's graph weights
//        int[] g_weights = { -3, 2, 4, 10, -1, 7, 5, -1, 5, 4 };
//
//        // Declare graph build
//        Graph bellman = new Graph(vertices, edges, b_weights);
//        bellman.buildGraph();
//
//        Graph djikstra = new Graph(vertices, edges, g_weights);
//        djikstra.buildGraph();
//
//        // Add code for handling Json file here
//
//        //
//
//        Scanner scanner = new Scanner(System.in);
//        while (true) {
//
//            String[] options = { "1", "2", "3", "4", "5", "6" };
//            List<String> _options = new ArrayList<>(Arrays.asList(options));
//            System.out.println("Choose option to display: \n" + "[1]    Provided Bellman graph information.\n"
//                    + "[2]    Provided Djikstra graph information.\n" + "[3]    Bellman solution.\n"
//                    + "[4]    Djikstra solution.\n" + "[5]    Test Bellman solution on other graph.\n"
//                    + "[6]    Test Djikstra Solution on other graph.\n" + "Any other button to exit.\n");
//
//            String s = scanner.nextLine();
//            switch (s) {
//                case "1":
//                    bellman.printGraphInfo();
//                    break;
//                case "2":
//                    djikstra.printGraphInfo();
//                    break;
//                case "3":
//                    // Now we call the bellman algo
//                    new Bellman(bellman, null).run();
//                    break;
//                case "4":
//                    // Now we call the djikstra algo
//                    new Djikstra(djikstra, null).run();
//                    break;
//                case "5":
//                    System.out.println("Student completes this section!");
//                    // jsonGraph(jsonObject, true);
//                    break;
//                case "6":
//                    System.out.println("Student completes this section!");
//                    // jsonGraph(jsonObject, false);
//                    break;
//            }
//            if (!_options.contains(s)) {
//                scanner.close();
//                break;
//            }
//        }
//
//    }
//
//    // Modify the section below to use graph data from json file
//    /*
//     * public static void jsonGraph(JSONObject obj, boolean flag){
//     * 
//     * // Add your code here //
//     * 
//     * // Do not edit below! if (flag){ Bellman(null, adj_matrix).run(); }else{
//     * Djikstra(null, adj_matrix).run(); }
//     * 
//     * 
//     * }
//     */
//
//}
