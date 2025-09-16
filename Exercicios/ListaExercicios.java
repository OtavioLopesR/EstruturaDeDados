import java.util.Random;
import java.util.Scanner;
/**
 * @author Otavio Lopes Rocha
 */
public class ListaExercicios {
    static Scanner sc = new Scanner(System.in); // Init Scanner
    
    /**
     * 1: Leitor Array 5 Inteiros
     */
    public static void Questao01(){
        int[] vetor = new int[5];
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Insira um numero Inteiro");
            vetor[i] = sc.nextInt();
            sc.nextLine(); // limpa Scanner
        }
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i]+ " ,");
        }
        System.out.println("");
    }
    
    /**
     * 2: Leitor Array 10 numeros reais ordem inversa
     */
    public static void Questao02(){
        float[] vetor = new float[10];
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Insira um numero real");
            vetor[i] = sc.nextFloat();
            sc.nextLine(); // limpa Scanner
        }
        for (int i = vetor.length-1; i >= 0; i--) {
            System.out.print(vetor[i]+ " ,");
        }
        System.out.println("");
    }
    
    /**
     * 3: Leitor 4 notas e Media
     */
    public static void Questao03(){
        float[] notas = new float[4];
        float total = 0f;
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Insira a "+ (i+1) +" nota");
            notas[i] = sc.nextFloat();
            total += notas[i];
            sc.nextLine(); // limpa Scanner
        }
        System.out.print("Notas: ");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i]+" , ");
        }
        System.out.print("Media: "+ (total/notas.length)+"\n");
    }
    
    /**
     * 4: Leitor 10 Chars e mostrar Consoantes
     */
    public static void Questao04(){
        char[] caracteres = new char[10];
        char[] con = new char[10];
        for (int i = 0; i < caracteres.length; i++) {
            System.out.println("Insira um Caractere: ");
            caracteres[i] = sc.next().charAt(0);
            if ("aeiouAEIOU".indexOf(caracteres[i]) == -1) { // Se é consoante
                con[i] = caracteres[i];
            } else
            {
                con[i] = ' ';
            }
        }
        System.out.print("\nConsoantes: ");
        for (char c : con) {
            if (c != ' '){
                System.out.print(c+ " , ");
            }
        }
    }
    
    /**
     * 5: Leitor 20 int, pares e impares
     */
    public static void Questao05(){
        int[] numeros = new int[20];
        int[] pares = new int[20];
        int[] impares = new int[20];
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Insira um numero inteiro");
            numeros[i] = sc.nextInt();
            sc.nextLine(); // limpa Scanner
            //Se numero é par
            if (numeros[i]%2==0){ 
                pares[i] = numeros[i];
                impares[i] = -1;
            }else{
                pares[i] = -1;
                impares[i] = numeros[i];
            }
        }
        System.out.print("\nNumeros: ");
        for (int n : numeros) {
            System.out.print(n+ " , ");
        }
        System.out.print("\nPares: ");
        for (int par : pares) {
            if (par != -1){
                System.out.print(par+ " , ");
            }
        }
        System.out.print("\nImpares: ");
        for (int impar : impares) {
            if (impar != -1){
                System.out.print(impar+ " , ");
            }
        }
        System.out.println("");
    }
    
    /**
     * 6: ler 4 notas 10 Alunos e mostrar media >= 7
     */
    public static void Questao06(){
        
    }
    
    public static void main(String[] args) {
        //Inserir Funcao Aqui para Teste
    }
    
}
