package project1;

import java.util.ArrayList;

public class BinaryTree {

	private Node root;
	private Node current;
	private ArrayList<Node> list = new ArrayList<>();
	private ArrayList<Node> list1 = new ArrayList<>();

	public BinaryTree() {
		current = root;
	}

	public void returnToRoot()
	{
		current = root;
	}

	public void SetRoot(Node n)
	{
		root = n;
		current = root;
		root.setRoot();
	}

	public Node getRoot()
	{
		return root;
	}

	public String getCurrentLocation() {
		return current.getCharic();
	}

	public Node getCurrent()
	{
		return current;
	}

	public String getPastInfo()
	{
		Node traversal = current;
		String returnal = "";
		int counter = 0;

		while(traversal.getParent() != null)
		{

			if(traversal == traversal.getParent().getLeft())
			{
				if(counter == 0)
				{
					returnal +=("not " + traversal.getParent().getCharic());
				}
				else
				{
					returnal +=(", not " + traversal.getParent().getCharic());
				}
			}
			else if(traversal == traversal.getParent().getRight())
			{
				if(counter == 0)
				{
					returnal +=("" + traversal.getParent().getCharic());
				}
				else
				{
					returnal += ", " + traversal.getParent().getCharic();
				}
			}
			++counter;
			traversal = traversal.getParent();
		}

		return returnal;
	}

	public void insert(int newValue, String charic) {
		if (root == null)
		{
			root = new Node(charic,newValue);
			root.setRoot();
		} else {
			Node currentNode = root;
			boolean placed = false;
			while (!placed) {
				if (newValue < currentNode.getValue()) {
					if (currentNode.getLeft() == null) {
						currentNode.setLeft(new Node(charic,newValue));
						currentNode.getLeft().setParent(currentNode);
						placed = true;
					} else {
						currentNode = currentNode.getLeft();
					}
				} else {
					if (currentNode.getRight() == null) {
						currentNode.setRight(new Node(charic,newValue));
						currentNode.getRight().setParent(currentNode);
						placed = true;
					} else {
						currentNode = currentNode.getRight();
					}
				}
			}
		}
	}



	public void newLeaf(Node prevLeaf, Node newLeaf, Node newStem)
	{
		if(prevLeaf == prevLeaf.getParent().getRight())
		{
			newStem.setParent(prevLeaf.getParent());
			newStem.setLeft(prevLeaf);
			newStem.setRight(newLeaf);
			prevLeaf.setParent(newStem);
			newStem.getParent().setRight(newStem);
		}
		else
		{
			newStem.setParent(prevLeaf.getParent());
			newStem.setLeft(prevLeaf);
			newStem.setRight(newLeaf);
			prevLeaf.setParent(newStem);
			newStem.getParent().setLeft(newStem);
		}
	}

	public void moveDownLeft()
	{
		current = current.getLeft();
	}

	public boolean checkLeft()
	{
		if(current.getLeft()  != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void moveDownRight()
	{
		current = current.getRight();
	}

	public boolean checkRight()
	{
		if(current.getRight()  != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void moveUp() {
		if (current != root) {
			current = current.getParent();
		}
	}

	public void goHome() {
		current = root;
	}

	public boolean insertLeft(String directory)
	{
		if (directory != null && !directory.equals(" "))
		{
			Node newFile = new Node(directory, -1);
			newFile.setParent(current);
			current.setLeft(newFile);
			return true;
		}
		return false;
	}


	public boolean insertRight(String directory)
	{
		if (directory != null && !directory.equals(" "))
		{
			Node newFile = new Node(directory, -1);
			newFile.setParent(current);
			current.setRight(newFile);
			return true;
		}
		return false;
	}



	public ArrayList<Node> depthFirst(Node n)
	{
		if(n != null)
		{
			depthFirst(n.getLeft());
			list.add(n);
			depthFirst(n.getRight());
		}

		return list;
	}

	public ArrayList<Node> depthFirstAdd(Node n)
	{
		if(n != null)
		{
			list1.add(n);
			depthFirstAdd(n.getLeft());
			depthFirstAdd(n.getRight());
		}

		return list1;
	}
}
