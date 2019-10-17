import static org.junit.Assert.*;

import java.util.ArrayList;

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
	public void testLCA1() {
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
		
		

		//Test this with searchDAGLCA function.
		DAGNode node1 = new DAGNode(1);
		DAGNode node2 = new DAGNode(2);
		DAGNode node3 = new DAGNode(3);
		DAGNode node4 = new DAGNode(4);
		DAGNode node5 = new DAGNode(5);
		
		ArrayList<DAGNode> rootList = new ArrayList<DAGNode>();
		node1.childNodes.add(node2);
		node1.childNodes.add(node3);
		node2.childNodes.add(node4);
		node2.childNodes.add(node5);
		rootList.add(node1);	
		int result = LCA.searchDAGLCA(rootList,2,4).get(0);
		assertEquals("Checking Node 2 and Node 4, the LCA should be 2",2,result);
		result = LCA.searchDAGLCA(rootList,4,5).get(0);
		assertEquals("Checking Node 4 and Node 5, the LCA should be 2",2,result);
		result = LCA.searchDAGLCA(rootList,7,8).get(0);
		assertEquals("Checking Node 7 and Node 8, the LCA should be 0",0,result);
		
		
		
		
		


	}
	
	@Test
	public void testLCA2() {
		/**
		 *       1
		 *      / \
		 *     2   3
		 *    / \   \
		 *   4   5   6
		 *  / \     / \
		 * 9   10  7   8
		 */


		// create a root node with value 1
		Node root = new Node(1,null,null);
		root.left = new Node(2,null,null);         
		root.right = new Node(3,null,null);       
		root.left.left = new Node(4,null,null);                
		root.left.right = new Node(5,null,null);
		root.right.right = new Node(6,null,null);
		root.right.right.left = new Node(7,null,null);
		root.right.right.right = new Node(8,null,null);
		root.left.left.left = new Node(9,null,null); 
		root.left.left.right = new Node(10,null,null); 


		assertEquals("Checking Node 2 and Node 4, the LCA should be 2",2,LCA.searchLCA(root,2,4).data);
		assertEquals("Checking Node 4 and Node 5, the LCA should be 2",2,LCA.searchLCA(root,4,5).data);
		assertEquals("Checking Node 4 and Node 3, the LCA should be 1",1,LCA.searchLCA(root,4,3).data);
     	assertEquals("Checking Node 6 and Node 3, the LCA should be 3",3,LCA.searchLCA(root,6,3).data);
		assertEquals("Checking Node 7 and Node 8, the LCA should be 6",6,LCA.searchLCA(root,7,8).data);
		assertEquals("Checking Node 10 and Node 5, the LCA should be 2",2,LCA.searchLCA(root,10,5).data);
		assertEquals("Checking Node 9 and Node 7, the LCA should be 1",1,LCA.searchLCA(root,9,7).data);
		assertEquals("Checking Node 8 and Node 3, the LCA should be 3",3,LCA.searchLCA(root,8,3).data);
		
		assertEquals("Checking Node 11 and Node 3, the LCA should be null",null,LCA.searchLCA(root,11,3));
		assertEquals("Checking Node 14 and Node 12, the LCA should be null",null,LCA.searchLCA(root,14,12));
		
		
		
		
		//Test this with searchDAGLCA function.
		DAGNode node1 = new DAGNode(1);
		DAGNode node2 = new DAGNode(2);
		DAGNode node3 = new DAGNode(3);
		DAGNode node4 = new DAGNode(4);
		DAGNode node5 = new DAGNode(5);
		DAGNode node6 = new DAGNode(6);
		DAGNode node7 = new DAGNode(7);
		DAGNode node8 = new DAGNode(8);
		DAGNode node9 = new DAGNode(9);
		DAGNode node10 = new DAGNode(10);
		
		
		
		ArrayList<DAGNode> rootList = new ArrayList<DAGNode>();
		node1.childNodes.add(node2);
		node1.childNodes.add(node3);
		node2.childNodes.add(node4);
		node2.childNodes.add(node5);
		node3.childNodes.add(node6);
		node4.childNodes.add(node9);
		node4.childNodes.add(node10);
		node6.childNodes.add(node7);
		node6.childNodes.add(node8);
		
		rootList.add(node1);	
		int result = LCA.searchDAGLCA(rootList,2,4).get(0);
		assertEquals("Checking Node 2 and Node 4, the LCA should be 2",2,result);
		result = LCA.searchDAGLCA(rootList,9,7).get(0);
		assertEquals("Checking Node 9 and Node 7, the LCA should be 1",1,result);
		result = LCA.searchDAGLCA(rootList,11,3).get(0);
		assertEquals("Checking Node 11 and Node 3, the LCA should be 0",0,result);

	}	
	
	
	
	
	
	@Test
	public void testDAG_LCA1() {
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
		
		ArrayList<DAGNode> rootList = new ArrayList<DAGNode>();
		
		rootList.clear();
		rootList.add(root);
		int result = LCA.searchDAGLCA(rootList,2,4).get(0);
		assertEquals("Checking Node 2 and Node 4, the LCA should be 2",2,result);
		result = LCA.searchDAGLCA(rootList,3,4).get(0);
		assertEquals("Checking Node 3 and Node 4, the LCA should be 1",1,result);
		result = LCA.searchDAGLCA(rootList,2,5).get(0);
		assertEquals("Checking Node 2 and Node 5, the LCA should be 1",1,result);
		result = LCA.searchDAGLCA(rootList,1,5).get(0);
		assertEquals("Checking Node 1 and Node 5, the LCA should be 1",1,result);
		result = LCA.searchDAGLCA(rootList,5,3).get(0);
		assertEquals("Checking Node 5 and Node 3, the LCA should be 3",3,result);
		result = LCA.searchDAGLCA(rootList,6,4).get(0);
		assertEquals("Checking Node 6 and Node 4, the LCA should be null",0,result);
		result = LCA.searchDAGLCA(rootList,6,8).get(0);
		assertEquals("Checking Node 6 and Node 8, the LCA should be null",0,result);



	}

	@Test
	public void testDAG_LCA2() {
		/**
		 *             1
		 *          /  | \  
		 *        \/_  |  \  
		 *       2     |   \     
		 *        \    |   _\/  
		 *        _\/  \/    3
		 *             4     |
		 *          /  |     |
		 *        \/_  |     |
		 *        5    \/    |
		 *       / \   6     |
		 *      /   \        |
		 *    \/_    \       | 
		 *    7       \      |
		 *             _\/  \/
		 *                8
		 */
		//Create 8 nodes
		DAGNode root = new DAGNode(1);
		DAGNode node2 = new DAGNode(2);
		DAGNode node3 = new DAGNode(3);
		DAGNode node4 = new DAGNode(4);
		DAGNode node5 = new DAGNode(5);
		DAGNode node6 = new DAGNode(6);
		DAGNode node7 = new DAGNode(7);
		DAGNode node8 = new DAGNode(8);

		//set nodes' relationship
		root.childNodes.add(node2);
		root.childNodes.add(node3);
		root.childNodes.add(node4);


		node2.childNodes.add(node4);

		node3.childNodes.add(node8);

		node4.childNodes.add(node5);
		node4.childNodes.add(node6);

		node5.childNodes.add(node7);
		node5.childNodes.add(node8);
		ArrayList<DAGNode> rootList = new ArrayList<DAGNode>();
		
		rootList.clear();
		rootList.add(root);
		int result = LCA.searchDAGLCA(rootList,2,4).get(0);
		assertEquals("Checking Node 2 and Node 4, the LCA should be 2",2,result);
		result = LCA.searchDAGLCA(rootList,5,4).get(0);
		assertEquals("Checking Node 5 and Node 4, the LCA should be 4",4,result);
		result = LCA.searchDAGLCA(rootList,6,2).get(0);
		assertEquals("Checking Node 6 and Node 2, the LCA should be 2",2,result);
		result = LCA.searchDAGLCA(rootList,7,6).get(0);
		assertEquals("Checking Node 7 and Node 6, the LCA should be 4",4,result);
		result = LCA.searchDAGLCA(rootList,8,7).get(0);
		assertEquals("Checking Node 8 and Node 7, the LCA should be 5",5,result);
		result = LCA.searchDAGLCA(rootList,7,3).get(0);
		assertEquals("Checking Node 7 and Node 3, the LCA should be 1",1,result);
		result = LCA.searchDAGLCA(rootList,5,2).get(0);
		assertEquals("Checking Node 5 and Node 2, the LCA should be 2",2,result);
		result = LCA.searchDAGLCA(rootList,9,3).get(0);
		assertEquals("Checking Node 9 and Node 3, the LCA should be null",0,result);
		result = LCA.searchDAGLCA(rootList,11,10).get(0);
		assertEquals("Checking Node 11 and Node 10, the LCA should be null",0,result);



	}


	@Test
	public void testDAG_LCA3() {
		/**
		 *            1
		 *          /   \  
		 *        \/_    _\/  
		 *      2            3    
		 *      |  \     /   |
		 *      |   \   /    |
		 *      |     X      | 
		 *     \/  \/_ _\/   \/
		 *      4            5
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


		node2.childNodes.add(node4);
		node2.childNodes.add(node5);
		node3.childNodes.add(node4);
		node3.childNodes.add(node5);

		ArrayList<DAGNode> rootList = new ArrayList<DAGNode>();
		
		rootList.clear();
		rootList.add(root);
		int result = LCA.searchDAGLCA(rootList,4,5).get(0);
		assertEquals("Checking Node 4 and Node 5, the LCA should be 2 and 3, the first is 2",2,result);
		result = LCA.searchDAGLCA(rootList,4,5).get(1);
		assertEquals("Checking Node 4 and Node 5, the LCA should be 2 and 3, the second is 3",3,result);



	}
	
	
	//Test graph that has multi-root
	//1 2 5 are roots
	@Test
	public void testDAG_LCA4() {
		/**
		 *            
		 *      1            2         5
		 *      |  \     /   |         |
		 *      |   \   /    |         |
		 *      |     X      |         |
		 *     \/  \/_ _\/   \/        \/
		 *      3            4         6
		 */
		//Create 6 nodes
		DAGNode node1 = new DAGNode(1);
		DAGNode node2 = new DAGNode(2);
		DAGNode node3 = new DAGNode(3);
		DAGNode node4 = new DAGNode(4);
		DAGNode node5 = new DAGNode(5);
		DAGNode node6 = new DAGNode(6);
		

		//set nodes' relationship


		node1.childNodes.add(node3);
		node1.childNodes.add(node4);
		node2.childNodes.add(node3);
		node2.childNodes.add(node4);
		node5.childNodes.add(node6);
		
		ArrayList<DAGNode> rootList = new ArrayList<DAGNode>();
		
		rootList.clear();
		rootList.add(node1);
		rootList.add(node2);
		rootList.add(node5);
		

		int result = LCA.searchDAGLCA(rootList,3,4).get(0);
		assertEquals("Checking Node 4 and Node 5, the LCA should be 2 and 3, the first is 1",1,result);
		result = LCA.searchDAGLCA(rootList,3,4).get(1);
		assertEquals("Checking Node 4 and Node 5, the LCA should be 2 and 3, the second is 2",2,result);		
		result = LCA.searchDAGLCA(rootList,3,6).get(0);
		assertEquals("Checking Node 3 and Node 6, since they don't have LCA, the result should be 0",0,result);
		
		
		


	}
	
	
	//Test graph that has multi-root
	//1 2 5 are roots
	@Test
	public void testDAG_LCA5() {
		/**
		 *            
		 *                        1       2
		 *                        |      /|
		 *                        |     / |
		 *                        |    /  |
		 *                        \/ \/_  \/
		 *                3       4       5
		 *                | \   / |      /
		 *                |  \ /  |     /
		 *                |   X   |    /
		 *                \/\/__\/\/ \/_
		 *                6        7
		 */
		//Create 6 nodes
		DAGNode node1 = new DAGNode(1);
		DAGNode node2 = new DAGNode(2);
		DAGNode node3 = new DAGNode(3);
		DAGNode node4 = new DAGNode(4);
		DAGNode node5 = new DAGNode(5);
		DAGNode node6 = new DAGNode(6);
		DAGNode node7 = new DAGNode(7);
		

		//set nodes' relationship


		node1.childNodes.add(node4);
		node2.childNodes.add(node4);
		node2.childNodes.add(node5);
		node3.childNodes.add(node6);
		node3.childNodes.add(node7);
		node4.childNodes.add(node6);
		node4.childNodes.add(node7);
		node5.childNodes.add(node7);
		
		ArrayList<DAGNode> rootList = new ArrayList<DAGNode>();
		
		rootList.clear();
		rootList.add(node1);
		rootList.add(node2);
		rootList.add(node3);
		

		int result = LCA.searchDAGLCA(rootList,6,7).get(0);
		assertEquals("Checking Node 6 and Node 7, the LCA should be 3 and 4, the first is 3",3,result);
		result = LCA.searchDAGLCA(rootList,6,7).get(1);
		assertEquals("Checking Node 6 and Node 7, the LCA should be 3 and 4, the first is 4",4,result);
		


	}
	



}
