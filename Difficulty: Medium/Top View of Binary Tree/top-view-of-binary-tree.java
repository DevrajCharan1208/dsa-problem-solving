/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    public ArrayList<Integer> topView(Node root) {
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        int min = 0;
        int max = 0;

        q.add(new Info(root,0));
        q.add(null);

        while(!q.isEmpty()){
            Info curr = q.remove();
            if(curr==null){
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                if(!map.containsKey(curr.horizontalDistane)){
                    map.put(curr.horizontalDistane,curr.node);
                }
                if(curr.node.left != null){
                    q.add(new Info(curr.node.left,curr.horizontalDistane-1));
                    min = Math.min(min,curr.horizontalDistane-1);
                }
                if(curr.node.right != null){
                    q.add(new Info(curr.node.right,curr.horizontalDistane+1));
                    max = Math.max(max,curr.horizontalDistane+1);
                }
            }
        }
        for(int i = min;i<=max;i++){
            list.add(map.get(i).data);
        }
        
        return list;
    }
    static class Info{
        Node node;
        int horizontalDistane;

        public Info(Node node, int hd){
            this.node = node;
            this.horizontalDistane = hd;
        }
    }

}