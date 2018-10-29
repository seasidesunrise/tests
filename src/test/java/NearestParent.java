
public class NearestParent {
    public static void main(String[] args) throws Exception {
        Node node1 = new Node("1");
        Node node2 = new Node("2");
        Node node3 = new Node("3");
        Node node4 = new Node("4");
        Node node5 = new Node("5");
        Node node6 = new Node("6");
        Node node7 = new Node("7");

        node1.setLeftRightNode(node2, node3);
        node2.setLeftRightNode(node4, node5);
        node4.setLeftRightNode(node7, null);
        node3.setLeftRightNode(null, node6);


        Node rootNode = node1;
        Node nodea = node7;
        Node nodeb = node5;
//        Node nodea = node7;
//        Node nodeb = node6;


        Node nodeaParent = nodea;
        Node nodebParent = nodeb;
        Node nearestParent = rootNode;

        while (nodeaParent != rootNode) {
            if (nodebParent.equals(rootNode)) {
                nodeaParent = nodeaParent.getParentNode();
                nodebParent = nodeb;
            }
            if (nodeaParent.equals(nodeb)) {
                System.out.println("Nearest Parent is:" + nodeaParent.getName());
                nearestParent = nodeaParent;
                break;
            }
            else if (nodeaParent.equals(nodeb.getParentNode())) {
                System.out.println("Nearest Parent is:" + nodeaParent.getName());
                nearestParent = nodeaParent;
                break;
            }
            nodebParent = nodebParent.getParentNode();
        }

        System.out.println("Nearest Parent is:" + nearestParent.getName());
    }

}
