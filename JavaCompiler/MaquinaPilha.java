import java.io.*;
import java.util.*;

class MaquinaPilha {
    BufferedReader arquivo;

    public MaquinaPilha(String arqv) throws Exception{
        this.arquivo = new BufferedReader(new FileReader(arqv));
    }

    public Integer executeInstruction() throws Exception{
        String instruction;
        Stack<Integer> pilha = new Stack<Integer>();
        

    while((instruction = arquivo.readLine()) != null){
        String[] parts = instruction.split(" ");
        for(String token : parts){
            //System.out.println(token);
        switch (token) {
            case "PUSH":
                pilha.push(Integer.parseInt(parts[1]));
                break;
            case "SUM":
                int a = pilha.pop();
                int b = pilha.pop();
                pilha.push(a + b);
                break;

            case "SUB":
                a = pilha.pop();
                b = pilha.pop();
                pilha.push(b - a);
                break;

            case "MULT":
                a = pilha.pop();
                b = pilha.pop();
                pilha.push(a * b);
                break;

            case "DIV":
                a = pilha.pop();
                b = pilha.pop();
                pilha.push(b / a);
                break;
            case "PRINT":
                //System.out.println(pilha.peek());
                return (Integer)pilha.pop();

            default: 
                break;
                }
            }
        
        }
    return 1;
    }
}