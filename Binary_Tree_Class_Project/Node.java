package project1;

public class Node {

    private int value;
    private String charic;
    private Node left;
    private Node right;
    private Node parent;
    private boolean isRoot = false;

    public Node(String charic, int a) {
        this.charic = charic;
        this.value = a;
    }

    public int getValue() {
        return value;
    }

    public void setRoot()
    {
    	isRoot = true;
    }

    public boolean getRoot()
    {
    	return isRoot;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCharic()
    {
    	return charic;
    }

    public void setCharic(String charic)
    {
    	this.charic = charic;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getLeft() {
        return left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getRight() {
        return right;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getParent() {
        return parent;
    }

}
