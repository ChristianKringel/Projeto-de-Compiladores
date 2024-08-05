class Interpretador extends ArvoreSintatica{
    // nova classe que transforma os argumentos para ter uma resposta interpretada das operacoes
    public int interpreta(ArvoreSintatica arv) throws Exception {
        if (arv instanceof Num) {
            return ((Num) arv).num;
        } else if (arv instanceof Operador) {
            Operador noOp = (Operador) arv;
            int esq = interpreta(noOp.arg1);
            int dir = interpreta(noOp.arg2);
            
            switch (noOp.operador) {
                case '+':
                    return esq + dir;
                case '-':
                    return esq - dir;
                case '*':
                    return esq * dir;
                case '/':
                    if (dir == 0) throw new Exception("Divisão por zero");
                    return esq / dir;
                default:
                    throw new Exception("Operador desconhecido: " + noOp);
            }
        } else {
            throw new Exception("Nó desconhecido na árvore sintática");
        }
    }
}