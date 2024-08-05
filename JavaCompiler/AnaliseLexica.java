import java.io.*;

enum TokenType{ NUM,SOMA, MULT,SUB, DIV, APar,FPar, EOF}

class Token{ // agora a classe possui uma string ao inves de char 
  String  lexema;
  TokenType token;

 Token (String  l, TokenType t)
 	{ lexema=l;token = t;}	

}

class AnaliseLexica {
    BufferedReader arquivo;

    AnaliseLexica(String a) throws Exception {
        this.arquivo = new BufferedReader(new FileReader(a));
    }

    Token getNextToken() throws Exception {
        //Token token;
        int eof = -1;
        char currchar;
        int currchar1;

        do {
            currchar1 = arquivo.read();
            currchar = (char) currchar1;
        } while (currchar == '\n' || currchar == ' ' || currchar == '\t' || currchar == '\r');

        if (currchar1 != eof && currchar1 != 10) {
            StringBuilder lexemaBuilder = new StringBuilder(); // 

            if (currchar >= '0' && currchar <= '9') {
                lexemaBuilder.append(currchar); // concatena os caracteres em uma string 

                arquivo.mark(1);  // Marca a posicao
                currchar1 = arquivo.read();
                currchar = (char) currchar1;

                while (currchar >= '0' && currchar <= '9') {
                    lexemaBuilder.append(currchar);
                    arquivo.mark(1);  // Marca a posicao
                    currchar1 = arquivo.read();
                    currchar = (char) currchar1;
                }

				// Retorna ultima pos marcada que nao eh digito
                arquivo.reset();

                return new Token(lexemaBuilder.toString(), TokenType.NUM);
            } else {
                switch (currchar) {
                    case '(':
                        return new Token(Character.toString(currchar), TokenType.APar);	// transforma tudo de caractere para string
                    case ')':
                        return new Token(Character.toString(currchar), TokenType.FPar);
                    case '+':
                        return new Token(Character.toString(currchar), TokenType.SOMA);
                    case '*':
                        return new Token(Character.toString(currchar), TokenType.MULT);

					/* ===================================================== */
					/*	Adiconando novas operacoes -> Menos(-) e Divisao (/) */
                    case '/':
                        return new Token(Character.toString(currchar), TokenType.DIV);
                    case '-':
                        return new Token(Character.toString(currchar), TokenType.SUB);

					// caso padrao
                    default:
                        throw new Exception("Caractere inválido: " + ((int) currchar));
                }
            }
        }

        arquivo.close();
        return new Token(Character.toString((char) eof), TokenType.EOF);	// agora o retorno eh uma string convertida atraves dos caracteres 
    }
}
