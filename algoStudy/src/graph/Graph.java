package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	private Stack<Integer> theStack;
	private Queue<Integer> theQueue;
	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; // array of vertices
	private int adjMat[][]; 	// adjacency matrix
	private int nVerts; 		// current number of vertices

	public Graph()
	{
		vertexList = new Vertex[MAX_VERTS];
		// adjacency matrix

		adjMat = new int[MAX_VERTS][MAX_VERTS];
		//	adjList = new ArrayList<Integer>();

		theStack = new Stack<Integer>();
		theQueue = new LinkedList<Integer>();

		nVerts = 0;
		for(int j=0; j<MAX_VERTS; j++) // set adjacency
			for(int k=0; k<MAX_VERTS; k++) // matrix to 0
				adjMat[j][k] = 0;
	} 

	public void addVertex(char lab) // argument is label
	{
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end)
	{
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVertex(int v)
	{
		System.out.print(vertexList[v].label);
	}

	public void dfs(){

		vertexList[0].wasVisited = true; // begin at vertex 0
		displayVertex(0);
		theStack.push(0);

		while( !theStack.isEmpty() ) // until stack empty,
		{
			// get an unvisited vertex adjacent to stack top
			int v = getAdjUnvisitedVertex( theStack.peek() );
			if(v == -1) // if no such vertex,
				theStack.pop();
			else // if it exists,
			{
				vertexList[v].wasVisited = true; // mark it
				displayVertex(v); // display it
				theStack.push(v); // push it
			}
		}

		for(int j=0; j<nVerts; j++) // reset flags
			vertexList[j].wasVisited = false;
	} // end dfs

	public int getAdjUnvisitedVertex(int v)
	{
		for(int j=0; j<nVerts; j++)
			if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
				return j;
		return -1;
	}


	public void bfs()
	{
		vertexList[0].wasVisited = true;  // begin at vertex 0
		displayVertex(0);
		theQueue.add(0);
		
		int v2;
		while( !theQueue.isEmpty() ) 
		{
			int v1 = theQueue.remove();
			
			// until it has no unvisited neighbors
			while( (v2=getAdjUnvisitedVertex(v1)) != -1 )
			{
				vertexList[v2].wasVisited = true;
				displayVertex(v2);
				theQueue.add(v2);
			}
		}
	
		for(int j=0; j<nVerts; j++) // reset flags
			vertexList[j].wasVisited = false;
	} 

	public static void main(String[] args)
	{
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); // 0 (start for dfs)
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4

		theGraph.addEdge(0, 1); // AB
		theGraph.addEdge(1, 2); // BC
		theGraph.addEdge(0, 3); // AD
		theGraph.addEdge(3, 4); // DE
		System.out.print("Visits: ");
		theGraph.dfs(); // depth-first search
		System.out.println();
		theGraph.bfs();
	}
}

