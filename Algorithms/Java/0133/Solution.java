/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    private Map<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        return node == null ? null : dfs(node);
    }

    private Node dfs(Node node) {
        if (!map.containsKey(node.val)) {
            Node temp = new Node(node.val);
            map.put(temp.val, temp);
            for (Node neighbor : node.neighbors) {
                temp.neighbors.add(dfs(neighbor));
            }
            return temp;
        } else {
            return map.get(node.val);
        }
    }
}
