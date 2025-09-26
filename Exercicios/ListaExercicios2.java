import java.util.ArrayList;
import java.util.InputMismatchException;
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
     * @return array gerado
     */
    public static int[] Questao01(int tamanho){
        // Cria um array de tamanho n vazio
        Random rand = new Random();
        int[] inteiros = new int[tamanho];
        // Atribui os elementos do array como um inteiro aleatorio
        for (int i = 0; i < inteiros.length; i++) {
            inteiros[i] = rand.nextInt();
        }
        imprimirArrayInt(inteiros, "Array: ");
        return inteiros;
    }
    
    /**
     * 2: preencha um array com os quadrados de 1 a n
     * @param n valor maximo
     * @return array criado
     */
    public static int[] Questao02(int n){
        // Cria um array de tamanho n vazio
        int[] inteiros = new int[n];
        // Atribui os elementos como quadrado do i
        for (int i = 0; i < inteiros.length; i++) {
            inteiros[i] = (int) Math.pow(i+1, 2);
        }
        imprimirArrayInt(inteiros, "Array: ");
        return inteiros;
    }
    
    /**
     * 3: 2 mas em ordem inversa
     * @param n valor maximo
     * @return array criado
     */
    public static int[] Questao03(int n){
        // Cria um array de tamanho n vazio
        int[] inteiros = new int[n];
        // Atribui os elementos como quadrado do i
        for (int i = inteiros.length-1; i >= 0; i--) {
            inteiros[i] = (int) Math.pow(n-i, 2);
        }
        imprimirArrayInt(inteiros, "Array: ");
        return inteiros;
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
     * @return array modificado
     */
    public static int[] Questao08(int[] a, int n){
        // Imprime o array antes de multiplicar
        imprimirArrayInt(a, "Array antes: ");
        // multiplica o array
        for (int i = 0; i < a.length; i++) {
            a[i] = a[i] * n;
        }
        // Imprime o array depois de multiplicar
        imprimirArrayInt(a, "Array multiplicado por "+n+":");
        return a;
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
     * @return array alterado
     */
    public static int[] Questao10(int[] a){
        for (int i = 0; i < a.length; i++) {
            if (a[i]<0) a[i]=0;
        }
        // Imprime o array
        imprimirArrayInt(a, "Array: ");
        return a;
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
     * @return está presente
     */
    public static boolean Questao12(int[] a, int n){
        boolean presente = false;
        System.out.print("Array: ");
        for (int i : a) {
            System.out.print(i + " ");
            // se não esta presente atribui presente
            if (!presente) presente = i==n;
        }
        if (presente) {
            System.out.printf("%nO número %d está presente no array%n",n);
            return presente;
        }else{
            System.out.printf("%nO número %d não está presente no array%n",n);
            return presente;
        }
    }
    
    /**
     * 13: Copiar elementos de um array para outro
     * @param a array a ser clonado
     * @param b array a ser atribuido
     * @return array clonado
     */
    public static int[] Questao13(int[] a, int[] b){
        b = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        // Imprime o array a
        imprimirArrayInt(a, "Array A: ");
        // Imprime o array b
        imprimirArrayInt(b, "Array B: ");
        return b;
    }
    
    /**
     * 14: Ordenar em order crescente os elementos de um array
     * @param a array a ser ordenado
     * @return array ordenado
     */
    public static int[] Questao14(int[] a){
        // Imprime o array antes de ordenar
        imprimirArrayInt(a, "Array desordenado: ");
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1; j++) {
                if (a[j]>a[j+1]){
                    int aux = a[j];
                    a[j] = a[j+1];
                    a[j+1] = aux;
                }
            }
            
        }
        // Imprime o array depois de ordenar
        imprimirArrayInt(a, "Array ordenado: ");
        return a;
    }
    
    /**
     * 15: Criar um array e preencher com aleatorios e entao ordernar em ordem decrescente
     * @param n tamanho do array
     * @return array criado
     */
    public static int[] Questao15(int n){
        Random rand = new Random();
        int[] a = new int[n];
        for (int i = 0; i < a.length; i++) {
            a[i] = rand.nextInt(-10000,10000);
        }
        // Imprime o array antes de ordenar
        imprimirArrayInt(a, "Array gerado: ");
        //Ordena o array em ordem descrescente
        for (int i = 0; i < a.length-1; i++) {
            for (int j = 0; j < a.length-1; j++) {
                if (a[j]<a[j+1]){
                    int aux = a[j];
                    a[j] = a[j+1];
                    a[j+1] = aux;
                }
            }
        }
        // Imprime o array depois de ordenar
        imprimirArrayInt(a, "Array ordenado: ");
        return a;
    }
    
    /**
     * 16: Encontrar ocorrencia e imprimir indice
     * @param a array a ser pesquisado
     * @param n item a ser encontrado 
     */
    public static void Questao16(int[] a,int n){
        // indice que o item foi encontrado -1 caso não encontre
        int indice = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i]==n) {
                indice = i;
                break;
            } 
        }
        // Imprime o array depois de ordenar
        imprimirArrayInt(a, "Array: ");
        System.out.println("Item pesquisado: "+n);
        switch (indice) {
            case -1 -> System.out.println("Item não encontrado");
            default -> System.out.printf("Item encontrado no indice: %d%n",indice);
        }
    }
    
    /**
     * 17: verificar se dois arrays são iguais
     * @param a 1º array a ser verificado
     * @param b 2º array a ser verificado
     * @return são iguais
     */
    public static boolean Questao17(int[] a, int[] b){
        if (a.length!=b.length) {
            System.out.println("Os Arrays não são iguais");
            return false;
        } 
        for (int i = 0; i < a.length; i++) {
            if(a[i]!=b[i]){
                System.out.println("Os Arrays não são iguais");
                return false;
            }
        }
        System.out.println("Os arrays são iguais");
        return true;
    }
    /**
     * 18: multiplicar dois arrays e armazenar em terceiro
     * @param a 1º array a ser multiplicado
     * @param b 2º array a ser multiplicado
     * @return array criado
     */
    public static int[] Questao18(int[] a, int[] b) {
        //se os dois arrays tem tamanho igual
        if (a.length==b.length){
            // Imprime os array antes de multiplicar
            imprimirArrayInt(a, "Array A: ");
            imprimirArrayInt(b, "Array B: ");
            //Cria Array C
            int[] c = new int[a.length];
            for (int i = 0; i < a.length; i++) {
                //multiplica os elementos dos dois arrays
                c[i] = a[i] * b[i];
            }
            imprimirArrayInt(c, "Array C: ");
            return c;
        }else{
            System.out.println("Os arrays não tem tamanhos iguais");
            return null;
        }
    }
    
    /**
     * 19: inicializar um array de strings inverter e imprimir antes e depois
     * @param n tamanho do array
     */
    public static void Questao19(int n){
        String[] aStrings = new String[n];
        for (int i = 0; i < aStrings.length; i++) {
            System.out.println("Insira a "+(i+1)+"ª String: ");
            String s = sc.nextLine();
            aStrings[i] = s;
        }
        System.out.print("Strings: ");
        for (String s : aStrings) {
            System.out.print(s + " ");
        }
        System.out.println("");
        //Inverte os elementos
        int inicio = 0;
        int fim = n-1;
        while (inicio<fim) {            
            String s = aStrings[inicio];
            aStrings[inicio] = aStrings[fim];
            aStrings[fim] = s;
            
            inicio++;
            fim--;
        }
        //Imprime os elementos invertidos
        System.out.print("Strings invertidas: ");
        for (String s : aStrings) {
            System.out.print(s + " ");
        }
        System.out.println("");
    }
    
    /**
     * 20:Remover todas ocorrencias de um item especifico em um array de strings
     * @param a Array a ser modificado
     * @param s String a ser retirado
     * @return array modificado
     */
    public static String[] Questao20(String[] a, String s){
        System.out.print("Strings: ");
        for (String sa : a) {
            System.out.print(sa + " ");
        }
        System.out.println("");
        for (int i = 0; i < a.length; i++) {
            if(a[i].equals(s)){
                a[i] = "";
            }
        }
        System.out.print("Strings alteradas: ");
        for (String sa : a) {
            if(!sa.isBlank() || !sa.isEmpty()){
                System.out.print(sa + " ");
            }
        }
        System.out.println("");
        return a;
    }
    
    /**
     * 21:Subistituir todas vogais em um array de chars por
     * @param a Array a ser modificado
     * @return array modificado
     */
    public static char[] Questao21(char [] a) {
        char[] vogais = {'a','i','e','o','u'};
        System.out.print("chars: ");
        for (char sa : a) {
            System.out.print(sa + " ");
        }
        System.out.println("");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < vogais.length; j++) {
                if (Character.toLowerCase(a[i])==vogais[j]) {
                    a[i] = '*';
                }
            }
        }
        System.out.print("chars alteradas: ");
        for (char sa : a) {
            System.out.print(sa + " ");
        }
        System.out.println("");
        return a;
    }
    
    /**
     * 22:Contar numero de ocorrencias de vogais em um array de chars
     * @param a Array a ser pesquisado
     */
    public static void Questao22(char [] a) {
        char[] vogais = {'a','i','e','o','u'};
        int total = 0;
        System.out.print("chars: ");
        for (char sa : a) {
            System.out.print(sa + " ");
        }
        System.out.println("");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < vogais.length; j++) {
                if (Character.toLowerCase(a[i])==vogais[j]) {
                    total++;
                }
            }
        }
        System.out.println("Total de vogais encotrado: "+total);
    }
    
    /**
     * 23:Criar novo array a partir de dois arrays
     * @param a Array a
     * @param b Array b
     * @return novo array
     */
    public static int[] Questao23(int[] a, int[] b) {
        int[] c = new int[a.length+b.length];
        int i = 0;
        for (int j : a) {
            c[i] = j;
            i++;
        }
        for (int j : b){
            c[i] = j;
            i++;
        }
        imprimirArrayInt(c, "Array c: ");
        return c;
    }
    
    /**
     * 24:Inserir item em posição especifica no array
     * @param a Array a ser modificado
     * @return Array modificado
     */
    public static int[] Questao24(int[] a) {
        imprimirArrayInt(a, "Array: ");

        System.out.print("Insira o indice: ");
        int indice = sc.nextInt();
        sc.nextLine();
        System.out.print("Insira o valor: ");
        int valor = sc.nextInt();
        sc.nextLine();
        a[indice] = valor;
        imprimirArrayInt(a, "Array modificado: ");
        return a;

    }
    
    /**
     * 25:Verificar se um array é palindromo
     * @param a Array a ser verificado
     * @return é palindromo
     */
    public static boolean Questao25(int[] a) {
        imprimirArrayInt(a, "Array: ");
        int inicio = 0;
        int fim = a.length-1;
        while (inicio<fim){
            if (a[inicio]!=a[fim]){
                System.out.println("O array não é palindromo");
                return false;
            }
            inicio++;
            fim--;
        }
        System.out.println("O array é palindromo");
        return true;
    }
    
    /**
     * 26:Criar um array com os primeiros n numeros primos
     * @param n tamanho do array
     * @return array criado
     */
    public static int[] Questao26(int n) {
        int[] a = new int[n];
        int i = 0;
        int numero = 0;
        
        while (i<n){
            boolean palindromo = true;
            if (numero < 2){
                palindromo = false;
            }
            for (int j = 2; j < Math.sqrt(numero); j++) {
                if (palindromo && numero % j == 0) palindromo = false;
            }
            if (palindromo) {
                a[i]=numero;
                i++;
            }
            numero++;
        }
        imprimirArrayInt(a, " numeros primos até "+n+": ");
        return a;
    }
    
    /**
     * 27:Criar um array com os primeiros x numeros perfeitos menores que n
     * @param n maximo
     * @return ArrayList criado
     */
    public static ArrayList<Integer> Questao27(int n) {
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            int soma = 0;
            for (int j = 1; j < i ; j++) {
                if (i % j==0) {
                    soma+=j;
                }
            }
            if (soma == i) {
                a.add(i);
            }
        }
        System.out.print("Numeros perfeitos menores que "+n+": ");
        for (Integer x : a) {
            System.out.print(x+ " ");
        }
        System.out.println("");
        return a;
    }
    
    /**
     * 28:Preencer um array com os primeiros n numeros da sequencia de fibonacci
     * @param n numero maximo
     * @return array criado
     */
    public static int[] Questao28(int n){
        if (n<=0) {
            System.err.println("Não é possivel criar sequencia de fibonacci | n<=0");
            return null;
        }
        int[] fibo = new int[n];
        //preencer primeiros termos
        if (n >= 1) fibo[0] = 0;
        if (n >= 2) fibo[1] = 1;
        //gera proximos termos
        for (int i = 2; i < n; i++) {
            fibo[i] = fibo[i-1]+fibo[i-2];
        }
        imprimirArrayInt(fibo, "Primeiros "+n+" numeros da sequencia de fibonacci: ");
        return fibo;
    }
    
    /**
     * 29:Preencer um array com os primeiros n numeros da sequencia de lucas
     * @param n numero maximo
     * @return array criado
     */
    public static int[] Questao29(int n){
        if (n<=0) {
            System.err.println("Não é possivel criar sequencia de lucas | n<=0");
            return null;
        }
        int[] l = new int[n];
        //preencer primeiros termos
        if (n >= 1) l[0] = 2;
        if (n >= 2) l[1] = 1;
        //gera proximos termos
        for (int i = 2; i < n; i++) {
            l[i] = l[i-1]+l[i-2];
        }
        imprimirArrayInt(l, "Primeiros "+n+" numeros da sequencia de lucas: ");
        return l;
    }
    
    /**
     * 30:Remover items repetidos de um array
     * @param a array a ser pesquisado
     * @param n item procurado
     * @return array modificado
     */
    public static int[] Questao30(int[] a, int n){
        ArrayList<Integer> b = new ArrayList<>();
        imprimirArrayInt(a, "Array antes de remover "+n+": ");
        for (int i = 0; i < a.length; i++) {
            // adiciona item atual ao topo do array
            b.add(a[i]);
            // Se item atual == item procurado
            if (a[i]==n){
                //remove item do topo
                b.remove(b.size()-1);
            }
        }
        //converte ArrayList<Integer> para int []
        a = b.stream().mapToInt(Integer::intValue).toArray();
        //imprime array
        imprimirArrayInt(a, "Array apos remover "+n+": ");
        //retorna array modificado
        return a;
    }
    
    /**
     * 31: Rotacionar os items de um array um para a esquerda
     * @param a array a ser modificado
     * @return array modificado
     */
    public static int[] Questao31(int[] a){
        imprimirArrayInt(a, "Array antes de rotacionar: ");
        // salva o primeiro item para ir para o topo do array
        int primeiro = a[0];
        for (int i = 0; i < a.length-1; i++) {
            a[i] = a[i+1];
        }
        a[a.length-1]=primeiro;
        imprimirArrayInt(a, "array depois de rotacionar: ");
        return a;
    }
    
    /**
     * 32: Busca binaria em array ordenado
     * @param a array a ser pesquisado
     * @param n valor a ser encontrado
     * @return indice do item encontrado
     */
    public static int Questao32(int[] a, int n){
        //ordena em ordem crescente os elementos do array
        a = Questao14(a);
        int inicio = 0;
        int fim = a.length-1;
        while (inicio<=fim) {            
            int meio = (inicio + fim) / 2;
            if (a[meio]==n) {
                System.out.println("Item encontrado no indice: "+meio);
                return meio;
            }else if (a[meio]<n){
                inicio = meio+1;
            }else{
                fim = meio-1;
            }
        }
        return -1; // Valor não encontrado
    }
    
    /**
     * 33: Inserir elemento no topo de um array imprimir antes e depois
     * @param a array a ser modificado
     * @param n valor a ser inserido
     * @return array modificado
     */
    public static int[] Questao33(int[] a, int n){
        imprimirArrayInt(a, "Array antes de inserir: ");
        int [] b = new int[a.length+1];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        b[b.length-1]=n;
        imprimirArrayInt(b, "Array apos inserir: ");
        return b;
    }
    
    /**
     * 34: Inserir elemento em posição especifa, aumentando o array
     * @param a array a ser modificado
     * @param n valor a ser inserido
     * @param indice indice para inserir item
     * @return array modificado
     */
    public static int[] Questao34(int[] a, int n, int indice){
        imprimirArrayInt(a, "Array antes de inserir: ");
        //copia o array
        int [] b = new int[a.length+1];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        //move os items do array para direita
        for (int i = b.length-1; i >= indice; i--) {
            if (i-1>=0){
                b[i] = b[i-1];
            }
        }
        //insere item no indice
        b[indice]=n;
        imprimirArrayInt(b, "Array apos inserir: ");
        return b;
    }
    
    /**
     * 35: Remover elemento em posicao especifica do array diminuindo o array
     * @param a array a ser modificado
     * @param indice indice para inserir item
     * @return array modificado
     */
    public static int[] Questao35(int[] a, int indice){
        imprimirArrayInt(a, "Array antes de remover: ");
        if (indice < 0 || indice >= a.length){
            System.err.println("Indice invalido");
            return null;
        }
        // Cria novo array
        int [] b = new int[a.length-1];
        // Remove elemento
        for (int i = 0,j = 0; i < a.length; i++) {
            if (i!=indice){
                b[j++]=a[i];
            }
        }
        imprimirArrayInt(b, "Array apos remover: ");
        return b;
    }

    /**
     * função auxiliar para imprimir um array de inteiros
     * @param a Array a ser imprimido
     * @param x Texto do array
     */
    public static void imprimirArrayInt(int[] a, String x){
        System.out.print(x);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    
    public static void main(String[] args) {
        //Variaveis auxiliares
        int[] vetorA = {1, 2, 3, 2, 1};
        int[] vetorB = {5, 4, 3, 2, 1};
        String[] strings = {"1", "2", "A", "B", "C"};
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'i'};

        try {
            //Inserir função aqui para teste
            

        } catch (InputMismatchException e) {
            System.err.println("Valor invalido");
        } catch (IndexOutOfBoundsException e) {
            System.err.println("insira um indice valido");
        }

        sc.close(); // close scanner
    }
}
