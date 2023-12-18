import java.util.LinkedList;
import java.util.Queue;

class Solution{
    private boolean isBinaryTreeValid(int root, int[] leftChild, int[] rightChild){
        boolean[] visited = new boolean[leftChild.length];
        Queue<Integer> q = new LinkedList<>();
        visited[root] = true;
        q.offer(root);
        // bfs from the root, check if we have cycle or non-connected cell
        while(!q.isEmpty()){
            int cur = q.poll();
            if(leftChild[cur] != -1){
                if(visited[leftChild[cur]])return false;
                q.offer(leftChild[cur]);
                visited[leftChild[cur]] = true;
            }
            if(rightChild[cur] != -1){
                if(visited[rightChild[cur]])return false;
                q.offer(rightChild[cur]);
                visited[rightChild[cur]] = true;
            }
        }
        // check non-connected cell.
        for(boolean visit:visited){
            if(!visit)return false;
        }
        return true;
    }


    private int findRoot(int n, int[] leftChild,int[] rightChild){
        // find the node that has no parent which is root node
        boolean[] childCount = new boolean[n];
        for(int child:leftChild){
            if(child != -1){
                childCount[child] = true;
            }
            
        }
         for(int child:rightChild){
            if(child != -1){
                if(childCount[child])return -1;
                else childCount[child] = true;
            }
        }
        int root = -1;
        for(int i = 0;i < n;i++){
            if(!childCount[i]){
                if(root != -1)return -1;
                root = i;
            }
        }
        return root;
    }

    public boolean vlidateBinaryTreeNode(int n, int[] leftChild, int[] rightChild){
        int root = findRoot(n, leftChild, rightChild);
        if(root == -1)return false;
        return isBinaryTreeValid(root, leftChild, rightChild);
    }
}