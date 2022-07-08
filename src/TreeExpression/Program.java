package TreeExpression;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Program {
	
	TreeExpression tree;
	SymbolTable symbol;
	public Program()
	{
		tree = new TreeExpression();
		symbol = new SymbolTable();
	}
	public void ReadFromFile(String fname)
	{
		/*try (BufferedReader breader = new BufferedReader(new InputStreamReader(new FileInputStream(fname), StandardCharsets.UTF_8)))
		{
			Scanner scan =  new Scanner(new FileInputStream(fname));
			while(scan.hasNext())
			{
				String s = scan.next();
				if(s.contains("PRINT"))
				{
					String variable 
				}
				else
				{
										
				}
			}
		}catch(IOException Exception){
			System.out.println("Blad");
		}*/
	}
	
	void ReadFromFile2( String fname ) {
		// wczytuje program ze wskazanego pliku i buduje strukturê
		// danych reprezentuj¹c¹ kolejne instrukcje
		// z wykorzystaniem TreeExpr
			try {
				Scanner scan = new Scanner(new FileReader(fname));
				while(scan.hasNext()) {
					String word = scan.next();
					if(word.equals("PRINT")) {
						String variable = scan.next();
						System.out.println(symbol.ValueOf(variable));
					}
					else if(word.equals("DO")) {
						String variable = scan.next();
						scan.nextLine();
						String prefix = scan.nextLine();
						tree = new TreeExpression();
						tree.Build(prefix);
						symbol.Set(variable, tree.Eval(symbol));
					}
					else {
						scan.next();
						if(scan.hasNextFloat()) {
							Float value = scan.nextFloat();
							symbol.Set(word, value);
						}
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	public void Execute()
	{
		float result;
		result = tree.Eval(symbol);
		//System.out.println(tree.printPrefixTree());
		//System.out.println(result);
	}

}
