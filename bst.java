package com.prep;

import java.util.Scanner;

class BSTNode
{
	BSTNode left, right;
	int data;
	
	public BSTNode()
	{
		left = null;
		right = null;
		data = 0;
	}
	
	public BSTNode(int n)
	{
		left = null;
		right = null;
		data = n;
	}
	
	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}

class BST
{
	private BSTNode root;
	
	public BST()
	{
		root = null;
	}
	
	public boolean isEmpty()
	{
		return root == null;
	}
	
	public void insert(int data)
	{
		root = insert(root, data);
	}
	
	private BSTNode insert(BSTNode node, int data)
	{
		if (node == null)
		{
			node = new BSTNode(data);
		}
		else
		{
			if(data <= node.getData())
				node.left = insert(node.left, data);
			else
				node.right = insert(node.right, data);
		}
		
		return node;
	}
	
	public boolean search(int val)
	{
		return search(root, val);
	}
	
	private boolean search(BSTNode r, int val)
	{
		boolean found = false;
		
		while((r!= null) && !found)
		{
			int rval = r.getData();
			if (val < rval)
				r = r.getLeft();
			else if(val > rval)
				r = r.getRight();
			else
			{
				found = true;
				break;
			}
		}
		
		return found;
	} 
	
	private BSTNode delete(BSTNode root, int k)
	{
		BSTNode p, p2, n;
		
		if (root.getData() == k)
		{
			BSTNode lt, rt;
			lt = root.getLeft();
			rt = root.getRight();
			
			if(lt == null && rt == null)
				return null;
			else if(lt == null)
			{
				p = rt;
				return p;
			}
			else if(rt == null)
			{
				p = lt;
				return p;
			}
			else
			{
				p2 = rt;
				p = rt;
				while(p.getLeft() != null)
					p = p.getLeft();
				p.setLeft(lt);
				return p2;
			}
		}
			
		if(k < root.getData())
		{
			n = delete(root.getLeft(), k);
			root.setLeft(n);				
		}
		else
		{
			n = delete(root.getRight(), k);
			root.setRight(n);
		}
		
		return root;
	}
	
	public void delete(int k)
	{
		if(isEmpty())
			System.out.println("Tree Empty");
		else if(search(k) == false)
			System.out.println("Sorry " + k + " is not present");
		else
		{ 
			root = delete(root, k);
			System.out.println(k + "deleted from the tree");
		}
	}
	
	/* Function for in-order traversal */
    public void inorder()
    {
        inorder(root);
    }
    
    public int size()
    {
    	Integer val = 0;
    	
    	size_order(root, val);
    	
    	return val.intValue();
    	
    }
    
    private void size_order(BSTNode r, Integer v)
    {
    	if (r != null)
        {
            inorder(r.getLeft());
            v += 1;
            inorder(r.getRight());
        }
    }
    
    private void inorder(BSTNode r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            System.out.print(r.getData() +" ");
            inorder(r.getRight());
        }
    }
	
	
}

public class BinarySearchTree {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		BST bst = new BST();
		System.out.println("Binary Search Tree Test \n");
		char ch;
		
		do
		{
			System.out.println("Binary Search Tree Operations \n");
			System.out.println("1. Insert ");
			System.out.println("2. Delete ");
			System.out.println("3. Size ");
					
			int choice = scan.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter integer element to insert :");
				bst.insert(scan.nextInt());
				break;
				
			case 2:
				System.out.println("Enter integer element to delete :");
				bst.delete(scan.nextInt());
				break;
				
			case 3:
				System.out.println("Fetching size of BST  : " + bst.size());
				break;
				
			default :
				System.out.println("Wrong Entry : ");
				break;
					
			}
			
			//Display Tree
			System.out.println("In-order ");
			bst.inorder();
			System.out.println("Do you want to continue (Type y or n) \n");
			ch = scan.next().charAt(0);
		}while(ch =='Y' || ch =='y');
		
	}

}
 
