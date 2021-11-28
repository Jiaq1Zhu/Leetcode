package BinaryTree;

public class Leetcode1628 {
    abstract class Node {
        String val;
        Node left,right;
        public abstract int evaluate();
        // define your fields here
    };
    
    class TreeNode extends Node{
        public TreeNode(String val){
            this.val = val;
        }
        public int evaluate(){
            if(Character.isDigit(val.charAt(0)))return Integer.parseInt(val);
            int left = this.left.evaluate(), right = this.right.evaluate();
            switch(val){
                case "+":return left + right;
                case "-":return left - right;
                case "*":return left * right;
                case "/":return left / right;
            }
            return 0;
        }
    }
    
    
    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input 
     * and returns the expression tree represnting it as a Node.
     */
    
    class TreeBuilder {
        Node buildTree(String[] postfix) {
            Stack<Node> stack = new Stack<>();
            for(String p:postfix){
                if(Character.isDigit(p.charAt(0))){
                    Node node = new TreeNode(p);
                    stack.push(node);
                }else{
                    Node right = stack.pop(),left = stack.pop();
                    Node root = new TreeNode(p);
                    root.right = right;
                    root.left = left;
                    stack.push(root);
                }
            }
            return stack.peek();
        }
    };
    
}
