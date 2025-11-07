import java.util.List;
import java.util.ArrayList;

/**
    Add a method void depthFirst(Visitor v) to the Tree class of
    Section 17.4 (below).
    Keep visiting until the visit method returns false.
*/
public class Tree
{
    private Node root;

    class Node
    {
        public Object data;
        public List<Node> children;

        /**
            Computes the size of the subtree whose root is this node.
            @return the number of nodes in the subtree
        */
        public int size()
        {
            int sum = 0;
            for (Node child : children) { sum = sum + child.size(); }
            return 1 + sum;
        }
    }

    /**
        Constructs an empty tree.
    */
    public Tree()
    {
        root = null;
    }

    /**
        Constructs a tree with one node and no children.
        @param rootData the data for the root
    */
    public Tree(Object rootData)
    {
        root = new Node();
        root.data = rootData;
        root.children = new ArrayList<>();
    }

    /**
        Adds a subtree as the last child of the root.
    */
    public void addSubtree(Tree subtree)
    {
        root.children.add(subtree.root);
    }

    /**
        Computes the size of this tree.
        @return the number of nodes in the tree
    */
    public int size()
    {
        if (root == null) { return 0; }
        else { return root.size(); }
    }

    // Additional methods will be added in later sections.

    public void depthFirst(Visitor v){
        depthFirst(this.root, v);
    }

    private boolean depthFirst(Node node, Visitor v){
        if (node == null) 
            return true;
        if (!v.visit(node.data)) 
            return false;
        for (Node child : node.children){
            if (!depthFirst(child, v)) 
                return false;
        }
        return true;
    }

    // postorder method

    public void postorder(Visitor v){
        postorder(this.root, v);
    }

    private void postorder(Node node, Visitor v){
        if (node == null) 
            return;
        for (Node child : node.children){
            postorder(child, v);
        }
        v.visit(node.data);
    }


}
