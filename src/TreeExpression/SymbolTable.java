package TreeExpression;

import java.util.*;

public class SymbolTable {
		
	public SymbolTable() {}

	Map<String, Float> node = new HashMap<String, Float>();
	
	void Set( String ident, float value ) 
	{
		node.put(ident, value);
	}
	
	Float ValueOf( String ident ) {
		return node.get(ident);
	}
}
