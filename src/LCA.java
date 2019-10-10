import java.util.ArrayList;

public class LCA {
	//The root node of the binary tree.	
	static boolean inTheTree;

	public static ArrayList<Integer> searchDAGLCA(DAGNode root,int value1,int value2)
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		
        int maxDepth = -1;
        int firstResult = 0;
		ArrayList<ancestorRecord> ancestorRecords1 = findAncestorDAG(root,value1);
		ArrayList<ancestorRecord> ancestorRecords2 = findAncestorDAG(root,value2);
		for(int i=0;i<ancestorRecords1.size();i++)
		{
			for(int j=0;j<ancestorRecords2.size();j++)
			{
				if(ancestorRecords1.get(i).value == ancestorRecords2.get(j).value)
				{

					if(ancestorRecords1.get(i).depth > maxDepth)
					{
						maxDepth = ancestorRecords1.get(i).depth;
						firstResult = ancestorRecords1.get(i).value;
					}
				}
			}
		}
		result.add(firstResult);


		return result;
	}
	
	public static ArrayList<ancestorRecord> findAncestorDAG(DAGNode root,int value)
	{
		ArrayList<ancestorRecord> record = new ArrayList<ancestorRecord>();
		int depth = 0;
		findAncestorDAGP(root,value,record,depth);
		return record;
	}
	
	private static DAGNode findAncestorDAGP(DAGNode theNode,int value,ArrayList<ancestorRecord> record,int depth)
	{
		if(theNode == null)
		{
			return null;
		}
		
		if(theNode.data == value)
		{
			ancestorRecord addRecord = new ancestorRecord(value,depth);
			record.add(addRecord);
			return theNode;
		}
		
		DAGNode[] childNode = new DAGNode[theNode.childNodes.size()];
		for(int i=0;i<theNode.childNodes.size();i++)
		{
			childNode[i] = findAncestorDAGP(theNode.childNodes.get(i),value,record,depth+1);
		}
		
		for(int i=0;i<theNode.childNodes.size();i++)
		{
			if(childNode[i] !=null)
			{
				ancestorRecord addRecord = new ancestorRecord(theNode.data,depth);
				record.add(addRecord);
				return findAncestorDAGP(theNode.childNodes.get(i),value,record,depth+1);
			}
		}
		return null;
	}
	
	
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
