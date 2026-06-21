class Solution {
    
    private  static void dfsUtil(ArrayList<ArrayList<Integer>> graph,ArrayList<Integer> res, int curr, boolean[] vis){
        //visit
        res.add(curr);
        vis[curr] = true;

        for(int i = 0; i<  graph.get(curr).size();i++){
                    int edge = graph.get(curr).get(i);
                    if(!vis[edge]){
                        dfsUtil(graph,res, edge, vis);
                    } 
        }

    }
    
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<>();
        dfsUtil(adj, res, 0, new boolean[adj.size()]);
        
        return res;
    }
}