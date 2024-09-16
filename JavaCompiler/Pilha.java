public class Pilha{
    public static void main(String[]args) throws Exception{
    MaquinaPilha maquina =  new MaquinaPilha(args[0]);
    System.out.println(maquina.executeInstruction());
}
}