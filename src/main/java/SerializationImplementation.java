import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Darion Higgins on 7/16/2019
 * TSO2438
 */
public class SerializationImplementation {
    //This problem was asked by Google.
    //Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
    //For example, given the following Node class
    //class Node:
    //    def __init__(self, val, left=None, right=None):
    //        self.val = val
    //        self.left = left
    //        self.right = right
    //The following test should pass:
    //node = Node('root', Node('left', Node('left.left')), Node('right'))
    //assert deserialize(serialize(node)).left.left.val == 'left.left'

    public static void main(String[] args) {
        new SerializationImplementation().test();
    }

    void test() {
        Node node = new Node("root", new Node("left", new Node("left.left")), new Node("right"));
        System.out.println(Node.deserialize(Node.serialize(node)).left.left.val.equals("left.left"));

        System.out.println(node.equals(Node.deserialize(Node.serialize(node))));
        System.out.println(node);
        System.out.println(Node.deserialize(Node.serialize(node)));

        Node node2 = new Node("root", new Node("left"), new Node("right", null, new Node("Right")));
        System.out.println(node2);
        System.out.println(Node.deserialize(Node.serialize(node2)));
    }

    static class Node {
        String val;
        Node left;
        Node right;

        public Node() {
        }

        Node(String val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public Node(String val, Node left) {
            this.val = val;
            this.left = left;
        }

        public Node(String val) {
            this.val = val;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(val, node.val) &&
                    Objects.equals(left, node.left) &&
                    Objects.equals(right, node.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, left, right);
        }

        private String toString(int i) {
            String indent = "\n";
            for (int j = 0; j < i; j++) {
                indent += "\t";
            }
            return indent + "Node{" + indent + "\t" +
                    (
                            (val != null ? ("val='" + val + "\' ") : "") +
                                    (left != null ? (indent + "\tleft=" + left.toString(i + 2) + " ") : "") +
                                    (right != null ? (indent + "\tright=" + right.toString(i + 2) + " ") : "")
                    ).trim() +
                    '}';
        }

        @Override
        public String toString() {
            return toString(0);
        }

        static String serialize(Node node) {
            if (node == null) return "";
            return String.format("{%s:%s:%s}", node.val, serialize(node.left), serialize(node.right));
        }

        static Node deserialize(String serializedNode) {
            if (serializedNode.equals(":")) return null;

            int left = serializedNode.indexOf("{");
            int right = serializedNode.lastIndexOf("}");
            String nodeVal = serializedNode.substring(left + 1, right);
            String val = nodeVal.substring(0, nodeVal.indexOf(":"));
            String children = nodeVal.substring(nodeVal.indexOf(":") + 1);
            List<String> parts = groups(children);

            Node node = new Node(val);
            if (parts.size() > 0) node.left = deserialize(parts.get(0));
            if (parts.size() > 1 && !parts.get(1).equals(":")) node.right = deserialize(parts.get(1));
            if (parts.size() > 2) node.right = deserialize(parts.get(2));
            return node;
        }

        static List<String> groups(String str) {
            int l = 0;
            int r = 0;
            List<String> groups = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (String s : str.split("")) {
                sb.append(s);
                l += s.equals("{") ? 1 : 0;
                r += s.equals("}") ? 1 : 0;

                if (l == r) {
                    l = 0;
                    r = 0;

                    groups.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
            return groups;
        }
    }
}
