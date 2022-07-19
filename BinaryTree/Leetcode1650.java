public class Leetcode1650 {
    // this one is very similiar to leetcode 160. Use two pointer to find the start of intersection in two linked list.
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p, b = q;
        while(a != b){
            if(a == null) a = q;
            else a = a.parent;
            if(b == null) b = p;
            else b = b.parent;
        }
        return a;
    }
}
