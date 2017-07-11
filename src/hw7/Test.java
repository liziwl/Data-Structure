package hw7;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args){
        List<Vertex> vertexs = new ArrayList<Vertex>();
        Vertex a = new Vertex("A", 0);
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");
        Vertex g = new Vertex("G");
        vertexs.add(a);
        vertexs.add(b);
        vertexs.add(c);
        vertexs.add(d);
        vertexs.add(e);
        vertexs.add(f);
        vertexs.add(g);
        int[][] edges = {
                {Integer.MAX_VALUE,2,Integer.MAX_VALUE,1,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,3,10,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {4,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,5,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,2,Integer.MAX_VALUE,2,8,4},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,6},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE},
                {Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,1,Integer.MAX_VALUE},
        };
        Graph graph = new Graph(vertexs, edges);
        graph.printGraph();
        graph.search();
        graph.printVertex();
        
    }
}