import java.io.Serializable;

public class Node implements Serializable {

    private String name;

    private Node parentNode;

    private Node leftSubNode;

    private Node rightSubNode;

    public Node(String name) {
        this.name = name;
    }

    public void setLeftRightNode(Node leftNode, Node rightNode) {
        this.leftSubNode = leftNode;
        this.rightSubNode = rightNode;

        if (this.leftSubNode != null) {
            this.leftSubNode.parentNode = this;
        }
        if (this.rightSubNode != null) {
            this.rightSubNode.parentNode = this;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getParentNode() {
        return parentNode;
    }

    public void setParentNode(Node parentNode) {
        this.parentNode = parentNode;
    }

    public Node getLeftSubNode() {
        return leftSubNode;
    }

    public void setLeftSubNode(Node leftSubNode) {
        this.leftSubNode = leftSubNode;
    }

    public Node getRightSubNode() {
        return rightSubNode;
    }

    public void setRightSubNode(Node rightSubNode) {
        this.rightSubNode = rightSubNode;
    }
}
