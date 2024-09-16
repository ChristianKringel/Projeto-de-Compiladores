import java.io.*;
class Compilador{

	public static void main(String[]args)
	{	
		ArvoreSintatica arv=null;
	
		try{

			AnaliseLexica al = new AnaliseLexica(args[0]);
			Parser as = new Parser(al);
		
			arv = as.parseProg();
		
			
			//CodeGen backend = new CodeGen();
			//String codigo = backend.geraCodigo(arv);
			//System.out.println(codigo);
			Interpretador interpretador = new Interpretador();
        	int resultado = interpretador.interpreta(arv);
			System.out.println(resultado);
			/*
			File saida = new File("saida.txt");
			FileWriter fw = new FileWriter(saida);
				fw.write(codigo);
				fw.close();
			//System.out.println(resultado); 
			*/
		}catch(Exception e)
		{			
			System.out.println("Erro de compilação:\n" + e);
		}



	}
}
