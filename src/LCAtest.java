import static org.junit.Assert.*;

import org.junit.Test;


public class LCAtest {

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
		
		assertEquals("Checking Node 2 and Node 4, the LSA should be 2",2,LCA.searchLCA(root,2,4).data);
		assertEquals("Checking Node 4 and Node 5, the LSA should be 2",2,LCA.searchLCA(root,4,5).data);
		assertEquals("Checking Node 4 and Node 3, the LSA should be 1",1,LCA.searchLCA(root,4,3).data);
		
		//assertEquals("Checking Node 6 and Node 3, the LSA should be null",null,LCA.searchLCA(root,6,3).data);
		
		
		
		

	}

}
