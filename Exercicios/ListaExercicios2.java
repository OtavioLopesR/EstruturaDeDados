import java.util.Scanner;
import java.util.Random;
/**
 * @author Otávio Lopes Rocha
 */
public class ListaExercicios2 {
    static Scanner sc = new Scanner(System.in); // Init Scanner
    
    /**
     * 1: declare um array de inteiros e imprima seus elementos
     * @param tamanho tamanho do array
     */
    public static void Questao01(int tamanho){
        // Cria um array de tamanho n vazio
        Random rand = new Random();
        int[] inteiros = new int[tamanho];
        // Atribui os elementos do array como um inteiro aleatorio
        for (int i = 0; i < inteiros.length; i++) {
            inteiros[i] = rand.nextInt();
        }
        System.out.print("Array: ");
        for (int i : inteiros) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
    /**
     * 2: preencha um array com os quadrados de 1 a n
     * @param n valor maximo
     */
    public static void Questao02(int n){
        // Cria um array de tamanho n vazio
        int[] inteiros = new int[n];
        // Atribui os elementos como quadrado do i
        for (int i = 0; i < inteiros.length; i++) {
            inteiros[i] = (int) Math.pow(i+1, 2);
        }
        System.out.print("Array: ");
        for (int i : inteiros) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
    /**
     * 3: 2 mas em ordem inversa
     * @param n valor maximo
     */
    public static void Questao03(int n){
        // Cria um array de tamanho n vazio
        int[] inteiros = new int[n];
        // Atribui os elementos como quadrado do i
        for (int i = inteiros.length-1; i >= 0; i--) {
            inteiros[i] = (int) Math.pow(n-i, 2);
        }
        // Imprime o array de inteiros
        for (int inteiro : inteiros) {
            System.out.println(inteiro);
        }
    }
    
    /**
     * 4: encontrar o menor e maior valor dentro de um array
     * @param a array a ser pesquisado
     */
    public static void Questao04(int[] a){
        // declara o menor como maior valor possivel de um inteiro
        int menor = Integer.MAX_VALUE; 
        // declara o maior como menor valor possivel de um inteiro
        int maior = Integer.MIN_VALUE;
        for (int i : a) {
            // atribui maior ou menor
            if (i<menor) menor = i;
            if (i>maior) maior = i;
        }
        System.out.printf("O maior número encontrado no array foi %d, o menor número foi %d%n", maior,menor);
    }
    
    /**
     * 5: encontrar o segundo maior valor dentro de um array
     * @param a array a ser pesquisado
     */
    public static void Questao05(int[] a){
        // declara o maior como menor valor possivel de um inteiro
        int[] maior = {Integer.MIN_VALUE,Integer.MIN_VALUE};
        for (int i : a) {
            // atribui primeiro maior
            if (i>maior[0]) maior[0] = i;
        }
        for (int i : a) {
            // atribui segundo maior
            if (i<maior[0] && i>maior[1]) maior[1] = i;
        }
        System.out.printf("O segundo maior número encontrado no array foi %d%n", maior[1]);
    }
    
    /**
     * 6: calcular e mostrar a soma de todos os elementos de um array
     * @param a array a ser somado
     */
    public static void Questao06(int[] a){
        int soma = 0;
        for (int i : a) {
            soma+=i;
        }
        System.out.printf("Total da soma dos elementos do array: %d%n", soma);
    }
    
    /**
     * 7: calcular e mostrar a soma de todos os elementos em posição par de um array
     * @param a array a ser somado
     */
    public static void Questao07(int[] a){
        int soma = 0;
        for (int i = 0 ; i < a.length ;i++) {
            if (i%2==0) soma+=a[i];
        }
        System.out.printf("Total da soma dos elementos em posição par do array: %d%n", soma);
    }
    
    /**
     * 8: Multiplicar todos os elementos de um array por n e mostrar o antes e depois;
     * @param a array a ser multiplicado
     * @param n valor o qual o array é multiplicado
     */
    public static void Questao08(int[] a, int n){
        // Imprime o array antes de multiplicar
        System.out.print("Array: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        // multiplica o array
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * n;
        }
        System.out.println("");
        // Imprime o array depois de multiplicar
        System.out.printf("Array multiplicado por %d: ",n);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
    /**
     * 9: Calcular e imprimir numero de elementos pares de um array
     * @param a array a ser pesquisado
     */
    public static void Questao09(int[] a){
        int totalPar = 0;
        for (int i : a) {
            if (i%2==0) totalPar++;
        }
        System.out.printf("Total de números pares encontrado no array: %d%n",totalPar);
    }
    
    /**
     * 10: Subistituir todos elementos negativos de um array por 0
     * @param a array a ser alterado
     */
    public static void Questao10(int[] a){
        for (int i = 0; i < a.length; i++) {
            if (a[i]<0) a[i]=0;
        }
        // Imprime o array
        System.out.print("Array: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
    
    /**
     * 11: Encontra a media dos elementos de um array e a imprime
     * @param a array a ser pesquisado
     */
    public static void Questao11(int[] a){
        float media = 0f;
        // Imprime o array
        System.out.print("Array: ");
        for (int i : a) {
            System.out.print(i + " ");
            media+=i;
        }
        media=media/a.length;
        System.out.printf("%nMedia da soma dos elementos: %.2f%n",media);
    }
    
    /**
     * 12: verificar e informar se um item está presente no array
     * @param a array a ser pesquisado
     * @param n valor a ser encontrado
     */
    public static void Questao12(int[] a, int n){
        boolean presente = false;
        System.out.print("Array: ");
        for (int i : a) {
            System.out.print(i + " ");
            // se não esta presente atribui presente
            if (!presente) presente = i==n;
        }
        if (presente) {
            System.out.printf("%nO número %d está presente no array%n",n);
        }else{
            System.out.printf("%nO número %d não está presente no array%n",n);
        }
    }
    
    /**
     * 13: Copiar elementos de um array para outro
     * @param a array a ser clonado
     * @param b array a ser atribuido
     */
    public static void Questao13(int[] a, int[] b){
        b=a;
        // Imprime o array a
        System.out.print("Array a: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("");
        // Imprime o array b
        System.out.print("Array b: ");
        for (int i : b) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
    /**
     * 14: Ordenar em order crescente os elementos de um array
     * @param a array a ser ordenado
     */
    public static void Questao14(int[] a){
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1; j++) {
                if (a[j]>a[j+1]){
                    int aux = a[j];
                    a[j] = a[j+1];
                    a[j+1] = aux;
                }
            }
            
        }
        // Imprime o array
        System.out.print("Array: ");
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        //Inserir função aqui para teste
        
        sc.close(); // close scanner
    }
}
