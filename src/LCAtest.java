import static org.junit.Assert.*;

import org.junit.Test;


public class LCAtest {
	
	
	@Test
	public void test_isInTheTree()
	{
		/**
		 *       1
		 *      / \
		 *     2   3
		 *    / \
		 *   4   5
		 */
		
		// create a root node with value 1
		Node root = new Node(1,null,null);
		root.left = new Node(2,null,null);         
		root.right = new Node(3,null,null);       
		root.left.left = new Node(4,null,null);                
		root.left.right = new Node(5,null,null);
		
		LCA.isInTheTree(root, 2);
		assertEquals("Checking for root value in the tree.",true,LCA.inTheTree);
		
		LCA.isInTheTree(root, 4);
		assertEquals("Checking for leaf value in the tree.",true,LCA.inTheTree);
		
		LCA.isInTheTree(root, 5);
		assertEquals("Checking for leaf value in the tree.",true,LCA.inTheTree);
		
		LCA.isInTheTree(root, 6);
		assertEquals("Checking for non existing value in the tree.",false,LCA.inTheTree);
		
		
		
	}

	@Test
	public void testLCA() {
		/**
		 *       1
		 *      / \
		 *     2   3
		 *    / \
		 *   4   5
		 */
		
		
		// create a root node with value 1
		Node root = new Node(1,null,null);
		root.left = new Node(2,null,null);         
		root.right = new Node(3,null,null);       
		root.left.left = new Node(4,null,null);                
		root.left.right = new Node(5,null,null);
		

		assertEquals("Checking Node 2 and Node 4, the LCA should be 2",2,LCA.searchLCA(root,2,4).data);
		assertEquals("Checking Node 4 and Node 5, the LCA should be 2",2,LCA.searchLCA(root,4,5).data);
		assertEquals("Checking Node 4 and Node 3, the LCA should be 1",1,LCA.searchLCA(root,4,3).data);
		
		assertEquals("Checking Node 6 and Node 3, the LCA should be null",null,LCA.searchLCA(root,6,3));
		assertEquals("Checking Node 7 and Node 8, the LCA should be null",null,LCA.searchLCA(root,7,8));
		

	}
	@Test
	public void testDAG_LCA() {
		/**
		 *        1
		 *     /  | \  \
		 *   \/_  | \/  \
		 *  2     |  3   \
		 *   \    |  |   |
		 *    _/  \/ |   |
		 *        4  |   |
		 *           |   |
		 *           \/ \/ 
		 *             5
		 */
		//Create 5 nodes
		DAGNode root = new DAGNode(1);
		DAGNode node2 = new DAGNode(2);
		DAGNode node3 = new DAGNode(3);
		DAGNode node4 = new DAGNode(4);
		DAGNode node5 = new DAGNode(5);
		
		//set nodes' relationship
		root.childNodes.add(node2);
		root.childNodes.add(node3);
		root.childNodes.add(node4);
		root.childNodes.add(node5);
		
		node2.childNodes.add(node4);
		node3.childNodes.add(node5);	
		
		assertEquals("Checking Node 2 and Node 4, the LCA should be 2",2,LCA.searchDAGLCA(root,2,4).data);
		assertEquals("Checking Node 3 and Node 4, the LCA should be 1",1,LCA.searchDAGLCA(root,3,4).data);
		assertEquals("Checking Node 2 and Node 5, the LCA should be 1",1,LCA.searchDAGLCA(root,2,5).data);
		assertEquals("Checking Node 1 and Node 5, the LCA should be 1",2,LCA.searchDAGLCA(root,1,5).data);
		assertEquals("Checking Node 5 and Node 3, the LCA should be 3",3,LCA.searchDAGLCA(root,5,3).data);
		assertEquals("Checking Node 6 and Node 4, the LCA should be null",null,LCA.searchDAGLCA(root,6,4).data);
		assertEquals("Checking Node 6 and Node 8, the LCA should be null",null,LCA.searchDAGLCA(root,6,8).data);
		
		
		
		}

}
