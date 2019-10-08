import java.util.ArrayList;

//Class of each node in the DAG
public class DAGNode {
	
	//Every node could have 0 to many child nodes 
	ArrayList<DAGNode> childNodes;
	//The data of the DAGnode
	int data;
	
	//Constructor of Node
	DAGNode(int data)
	{
		this.data = data;
		this.childNodes = new ArrayList<DAGNode>();
	}

}
