class ArvoreSintatica{}
/* ArvoreSintatica: Classe base para toda a árvore sintática.
Exp: Classe base para todas as expressões na árvore sintática, que é um tipo de nó na árvore sintática.

Num: Representa um número literal na expressão, herdando de Exp.

Operador: Representa uma operação binária na expressão, com duas sub-expressões (arg1 e arg2), herdando de Exp.

Essas classes juntas formam a estrutura da árvore sintática, 
onde Num representa os nós folha com valores numéricos e Operador representa os nós internos que combinam duas sub-expressões. */

class Exp extends ArvoreSintatica{} 
/*classe base para todas as expressoes na arvore. 
 estende ArvoreSintatica, o que significa que todas as expressoes sao tipos de nos na arvore sintatica. */

class Num extends Exp{
 	int num; // Armazena o valor do numero 
	Num(int num){this.num=num;} // Inicializa num com o valor passado como argumento.
 
}
class Operador extends Exp {
    Exp arg1;
    Exp arg2;
    char operador;

    Operador(Exp a1, Exp a2, char operador) {
        this.arg1 = a1;
        this.arg2 = a2;
        this.operador = operador;
    }
}

/*
class Operador extends Exp{
	Exp arg1; // primeiro argumento (sub-expressao) da operacao
	Exp arg2; // segundo argumento (sub-expressao) da operacao
	Operador (Exp a1, Exp a2) { arg1=a1; arg2=a2;} // Inicializa os campos arg1 e arg2 com as exp passadas como argumentos.
}
*/ 

class Soma extends Operador{
	
	Soma (Exp a1, Exp a2) { super(a1,a2, '+');}
}

class Mult extends Operador{
	Mult (Exp a1, Exp a2) { super(a1,a2, '*');}
}

/* ===================================================== */
/*	Adiconando novas operacoes -> Menos(-) e Divisao (/) */
class Div extends Operador{
	Div (Exp a1, Exp a2) { super(a1, a2, '/'); }
}

class Sub extends Operador{ 
	Sub (Exp a1, Exp a2) { super(a1, a2, '-'); }
}