public class LCA {
	//The root node of the binary tree.	
	static boolean inTheTree;
	
	
	public static Node searchLCA(Node root,int value1,int value2)
	{
		boolean check;
		//check if the value1 is in the tree
		isInTheTree(root,value1);
		check = inTheTree;
		//check if the value2 is in the tree
		isInTheTree(root,value2);
		//if both value are in the tree then start search
		if(check && inTheTree)
		{
			return searchLCAP(root,value1,value2);
		}
		//else just return a null
		else
		{
			return null;
		}
	}
	
	private static Node searchLCAP(Node theNode,int value1,int value2)
	{
		//Search value1 and value2 under the current node
		
		//If couldn't find the value, return null to present didn't find.
		if(theNode == null)
		{
			return null;
		}
		
		//If found the value, return the node to present found.
		if(theNode.data == value1 || theNode.data == value2)
		{
			return theNode;
		}
		
		//Search
		Node leftResult = searchLCAP(theNode.left,value1,value2);
		Node rightResult = searchLCAP(theNode.right,value1,value2);
		
		//If one value is in a side, and the other value is in the other side, then the current node is the LCA.
		if(leftResult != null && rightResult != null)
		{
			return theNode;
		}
		//If both values are in the right side, then set the right child node as the new root node.
		else if(leftResult == null)
		{
			return searchLCAP(rightResult,value1,value2);
		}
		//If both values are in the left side, then set the left child node as the new root node.
		else if(rightResult == null)
		{
			return searchLCAP(leftResult,value1,value2);
		}
		else
		{
			return null;
		}
	}
	
	//a function to check if a given value is inside the given tree, after run this function, check isTheTree to see the result.
	public static void isInTheTree(Node root,int value)
	{
		//use a global variable to check the final result
		inTheTree = false;
		//if the root is null just return null
		if(root!=null)
		{
			isInTheTreeP(root,value);
		}
		
	}
	
	private static void isInTheTreeP(Node theNode,int value)
	{
		//if found the node, then set the flag to true
		if(theNode.data == value)
		{
			inTheTree = true;
		}
		//else go to the child nodes to continue searching
		else
		{
			if(theNode.left !=null && theNode.right !=null)
			{
				isInTheTreeP(theNode.left,value);
				isInTheTreeP(theNode.right,value);
			}
			if(theNode.left == null && theNode.right != null)
			{
				isInTheTreeP(theNode.right,value);
			}
			if(theNode.right == null && theNode.left != null)
			{
				isInTheTreeP(theNode.left,value);
			}
			//if a node has no child node, return
				return;
		}
	}
	

}
