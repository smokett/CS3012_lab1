public class LCA {
	//The root node of the binary tree.	
	
	
	public static Node searchLCA(Node root,int value1,int value2)
	{
		return searchLCAP(root,value1,value2);
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
		Node leftResult = searchLCA(theNode.left,value1,value2);
		Node rightResult = searchLCA(theNode.right,value1,value2);
		
		//If one value is in a side, and the other value is in the other side, then the current node is the LCA.
		if(leftResult != null && rightResult != null)
		{
			return theNode;
		}
		//If both values are in the right side, then set the right child node as the new root node.
		else if(leftResult == null)
		{
			return searchLCA(rightResult,value1,value2);
		}
		//If both values are in the left side, then set the left child node as the new root node.
		else if(rightResult == null)
		{
			return searchLCA(leftResult,value1,value2);
		}
		else
		{
			return null;
		}
	}
	

}
