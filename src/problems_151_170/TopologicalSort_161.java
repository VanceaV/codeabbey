package problems_151_170;

import java.util.*;

public class TopologicalSort_161 {

  static class Node{
    public final String name;
    public final HashSet<Edge> inEdges;
    public final HashSet<Edge> outEdges;
    public Node(String name) {
      this.name = name;
      inEdges = new HashSet<Edge>();
      outEdges = new HashSet<Edge>();
    }
    public Node addEdge(Node node){
      Edge e = new Edge(this, node);
      outEdges.add(e);
      node.inEdges.add(e);
      return this;
    }
    public String toString() {
      return name;
    }
  }// end of class Node
  static class Edge{
    public final Node from;
    public final Node to;
    public Edge(Node from, Node to) {
      this.from = from;
      this.to = to;
    }
    @Override
    public boolean equals(Object obj) {
      Edge e = (Edge)obj;
      return e.from == from && e.to == to;
    }
  }

  public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int amount=sc.nextInt();
      sc.nextLine();
      
      ArrayList<Node> NodeList = new ArrayList<Node>();
      ArrayList<String> StringList = new ArrayList<String>();
      String scan;
      for(int i=0;i<amount;i++){
          scan=sc.nextLine();
          String []Array=scan.split(" ");
          
          if(!StringList.contains(Array[0])){
              StringList.add(Array[0]);
              Node n=new Node(Array[0]);
              NodeList.add(n);
          }
          
          if(!StringList.contains(Array[1])){
              StringList.add(Array[1]);
              Node n=new Node(Array[1]);
              NodeList.add(n);
          }
          int a=0,b=0;
          
          for(int j=0;j<NodeList.size();j++){
            if(Array[0].equals(NodeList.get(j).name)) a=j;
            if(Array[1].equals(NodeList.get(j).name)) b=j;
          }
          NodeList.get(a).addEdge(NodeList.get(b));    
    }
      sc.close();
    Node[] allNodes=new Node[NodeList.size()];
    
    for(int i=0;i<NodeList.size();i++ ){
        allNodes[i]=NodeList.get(i);
    }
    ArrayList<Node> L = new ArrayList<Node>();
    HashSet<Node> S = new HashSet<Node>(); 
    for(Node n : allNodes){
      if(n.inEdges.size() == 0){
        S.add(n);
      }
    }
    while(!S.isEmpty()){
      Node n = S.iterator().next();
      S.remove(n);
      L.add(n);
      for(Iterator<Edge> it = n.outEdges.iterator();it.hasNext();){
        Edge e = it.next();
        Node m = e.to;
        it.remove();
        m.inEdges.remove(e);
        if(m.inEdges.isEmpty()){
          S.add(m);
        }
      }
    }
   for(Node n:L){
       System.out.print(n+" ");
   }
  }
}
