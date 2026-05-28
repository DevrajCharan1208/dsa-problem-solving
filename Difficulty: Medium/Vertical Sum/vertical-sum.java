/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        ArrayList<Integer> result = new ArrayList<>();
        
        calculateVerticalSum(root, 0, map);
        
        for (int sum : map.values()) {
            result.add(sum);
        }
        
        return result;
    }

    private void calculateVerticalSum(Node node, int hd, TreeMap<Integer, Integer> map) {
        if (node == null) {
            return;
        }

        map.put(hd, map.getOrDefault(hd, 0) + node.data);

        calculateVerticalSum(node.left, hd - 1, map);
        calculateVerticalSum(node.right, hd + 1, map);
    }
}