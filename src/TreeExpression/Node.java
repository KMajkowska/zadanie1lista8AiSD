package TreeExpression;

public class Node {
	
	Node left;
	Node right;
	String k;
	//float value;
	
	Node() {}
	
	Node(String k) {
		this.k = k;
		//value = 0;
	}
	
	String getKey()
	{
		return k;
	}
	
	void setKey(String k) {
		this.k = k;
	}

	void setLeft(Node node) {
		left = node;
	}
	
	void setRight(Node node) {
		right = node;
	}

	Node getLeft() {
		return left;
	}
	
	Node getRight() {
		return right;
	}
	
	float getValue(SymbolTable st) 
	{
		switch(k) {
			case "-":
				return left.getValue(st)-right.getValue(st);
			case "+":
				return left.getValue(st)+right.getValue(st);
			case "*":
				return left.getValue(st)*right.getValue(st);
			case "/":
				return left.getValue(st)/right.getValue(st);
			case "^":
				return (float) (Math.pow(left.getValue(st), right.getValue(st)));
			default:
				if(st.ValueOf(k) != null) 
					return st.ValueOf(k);	
				else 
				{
						float value = Float.parseFloat(k);
						//value = Float.NaN;
						return value;
				}
		}
	}

}
