package TreeExpression;
import java.util.*;

public class TreeExpression {
	
	Node root;
	
	public TreeExpression() {
		root = null;
	}
	
	void Build( String prefix ) {
		Stack<Node> nodes = new Stack<Node>();
		Node node = null;
		prefix = prefix.replaceAll("[()]","");
		String [] expr = prefix.split("\\s+");
		for(int i = expr.length-1; i >= 0; i--) {
			if(expr[i].equals("-") || expr[i].equals("+") || expr[i].equals("*") || expr[i].equals("^") || expr[i].equals("/")) {
				node = new Node(expr[i]);
				node.setLeft(nodes.pop());
				node.setRight(nodes.pop());
				nodes.push(node);
			}
			else {
				node = new Node(expr[i]);
				nodes.push(node);
			}
		}		
		root = nodes.pop();
	}
	
	public String printPrefixTree() {
		return printTree(root);
	}
	
	String printTree(Node node) {
		if(node == null) return "";
		return node.getKey() + printTree(node.getLeft()) + printTree(node.getRight());
	}
	
	float Eval( SymbolTable st ) {
			return root.getValue(st);
		}

}
