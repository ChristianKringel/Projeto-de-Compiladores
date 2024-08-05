import java.io.*;
import java.util.*;

public class MaquinaPilha {
    private Stack<Integer> pilha;

    public MaquinaPilha() {
        pilha = new Stack<>();
    }

    public void readInstructions(String arquivo) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(arquivo));
        String row;
        while ((row = reader.readLine()) != null)
            executeInstruction(row);
        reader.close();
    }

    public int executeInstruction(String instruction){
        String[] parts = instruction.split(" ");
        String command = parts[0];

        switch (command) {
            case "PUSH":
                int valor = Integer.parseInt(parts[1]);
                pilha.push(valor);
                break;

            case "POP":
                pilha.pop();

            case "+":
                int a = pilha.pop();
                int b = pilha.pop();
                return pilha.push(a + b);

            case "-":
                a = pilha.pop();
                b = pilha.pop();
                return pilha.push(a - b);

            case "*":
                a = pilha.pop();
                b = pilha.pop();
                return pilha.push(a * b);

            case "/":
                a = pilha.pop();
                b = pilha.pop();
                if (a == 0)
                    // throw new Exception("Divisão por zero");
                return pilha.push(a / b);

            default: 
                System.out.println("Erro");
                return 0;
                //throw new Exception("Operador desconhecido");

        }

    }
}