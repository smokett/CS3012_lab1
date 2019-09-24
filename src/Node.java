//Class of each node in the binary tree
public	class Node
	{
		//Every node has a left node and a right node
		Node left,right;
		//The data of the node
		int data;
		
		//Constructor of Node
		Node(int data,Node left,Node right)
		{
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
	}
