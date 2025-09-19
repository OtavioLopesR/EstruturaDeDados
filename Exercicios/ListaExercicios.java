import java.util.ArrayList;
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
        float[] mediaAlunos = new float[10];
        int maior = 0; // numero de alunos com media >= 7
        for (int i = 0; i < mediaAlunos.length; i++) {
            float total = 0f;
            for (int j = 0; j < 4; j++) {
                System.out.println("Insira a "+ (j+1)+(" nota do aluno"));
                total += sc.nextFloat();
                sc.nextLine();
            }
            mediaAlunos[i] = total/4;
        }
        for (float m : mediaAlunos) {
            // se media >= 7
            if (m>=7){
                maior++;
            }
        }
        System.out.print("\nNumero de alunos com media: "+maior+"\n");
    }
    
    /**
     * 7: ler 5 inteiros mostar a soma e multiplicacao
     */
    public static void Questao07(){
        int[] numeros = new int[5];
        int totalS = 0;
        int totalM = 1; // TotalS = total soma, TotalM = total multiplicacao
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Insira um numero inteiro: ");
            int e = sc.nextInt();
            sc.nextLine();
            numeros[i] = e;
            totalS += e;
            totalM *= e;
        }
        System.out.print("Numeros: ");
        for (int n : numeros) {
            System.out.print(n+ " , ");
        }
        System.out.println("\nTotal Soma: " + totalS);
        System.out.println("Total Multiplicacao: " + totalM);
    }
    
    /**
     * 8: Ler Idade e Altura de 5 pessoas e imprimir na ordem inversa
     */
    public static void Questao08(){
        int[] idade = new int[5];
        float[] altura = new float[5];
        for (int i = 0; i < altura.length; i++) {
            System.out.println("Insira a idade da pessoa: ");
            idade[i] = sc.nextInt();
            sc.nextLine();
            System.out.println("Insira a altura da pessoa: ");
            altura[i] = sc.nextFloat();
            sc.nextLine();
        }
        for (int i = altura.length-1; i >= 0; i--) {
            System.out.println("Idade: " + idade[i]);
            System.out.println("Altura: " + altura[i]);
        }
    }
    
    /**
     * 9: ler 10 numeros inteiros e mostrar a soma dos quadrados
     */
    public static void Questao9(){
        int[] numeros = new int[10];
        int total = 0;
        for (int i = 0; i < numeros.length; i++) {
            System.out.println("Insira um numero: ");
            numeros[i] = sc.nextInt();
            sc.nextLine();
            total += (numeros[i]*numeros[i]);
        }
        System.out.print("\nNumeros: ");
        for (int n : numeros) {
            System.out.print(n+ " , ");
        }
        System.out.println("\nTotal da soma dos quadrados: "+total);
    }
    
    /**
     * 10 : 2 vetores intercalados 
     */
    public static void Questao10(){
        int[] vetor1 = new int[10];
        int[] vetor2 = new int[10];
        int[] novoVetor = new int[20];
        for (int i = 0; i < vetor1.length; i++) {
            System.out.println("Insira vetor1, indice: "+i);
            vetor1[i] = sc.nextInt();
            sc.nextLine();
        }
        for (int i = 0; i < vetor1.length; i++) {
            System.out.println("Insira vetor2, indice: "+i);
            vetor2[i] = sc.nextInt();
            sc.nextLine();
        }
        for (int i = 0 , j = 0; i < vetor1.length; i++) {
            novoVetor[j++] = vetor1[i];
            novoVetor[j++] = vetor2[i];
        }
        System.out.println("");
        for (int i : novoVetor) {
            System.out.print(i+" , ");
        }
    }
    
    /**
     * 11 : 3 vetores intercalados 
     */
    public static void Questao11(){
        int[] vetor1 = new int[10];
        int[] vetor2 = new int[10];
        int[] vetor3 = new int[10];
        int[] novoVetor = new int[30];
        for (int i = 0; i < vetor1.length; i++) {
            System.out.println("Insira vetor1, indice: "+i);
            vetor1[i] = sc.nextInt();
            sc.nextLine();
        }
        for (int i = 0; i < vetor1.length; i++) {
            System.out.println("Insira vetor2, indice: "+i);
            vetor2[i] = sc.nextInt();
            sc.nextLine();
        }
        for (int i = 0; i < vetor1.length; i++) {
            System.out.println("Insira vetor3, indice: "+i);
            vetor3[i] = sc.nextInt();
            sc.nextLine();
        }
        for (int i = 0 , j = 0; i < vetor1.length; i++) {
            novoVetor[j++] = vetor1[i];
            novoVetor[j++] = vetor2[i];
            novoVetor[j++] = vetor3[i];
        }
        System.out.println("");
        for (int i : novoVetor) {
            System.out.print(i+" , ");
        }
    }
    
    /**
     * 12 : 30 alunos e altura media
     */
    public static void Questao12(){
        int[] idadeAlunos = new int[30];
        float[] alturaAlunos = new float[30];
        float mediaAltura = 0f;
        int numeroAlunos = 0;
        for (int i = 0; i < 30; i++) {
            System.out.println("Insira a idade do "+ (i+1) + " aluno");
            int idade = sc.nextInt();
            sc.nextLine();
            System.out.println("Insira a altura do "+ (i+1) + " aluno");
            float altura = sc.nextFloat();
            sc.nextLine();
            mediaAltura+=altura;
            idadeAlunos[i] = idade;
            alturaAlunos[i] = altura;
        }
        mediaAltura = mediaAltura/30;
        for (int i = 0; i < 30; i++) {
            if (idadeAlunos[i]>13){
                if (alturaAlunos[i]<mediaAltura){
                    numeroAlunos++;
                }
            }
        }
        System.out.println("Numero de alunos: "+numeroAlunos + " Altura Media: "+mediaAltura);
    }
    
    /**
     * 13 : temperatura anual acima da media
     */
    public static void Questao13(){
        String[] meses = {"Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro"};
        float[] temp = new float[12]; // Temperaturas
        float tempMedia = 0f;
        for (int i = 0; i < 12; i++) {
            System.out.println("Insira temperatura media de "+meses[i]);
            temp[i] = sc.nextFloat();
            sc.nextLine();
            tempMedia+= temp[i];
        }
        tempMedia=tempMedia/12;
        System.out.println("Temperatura media: "+tempMedia+" , Meses acima da media: ");
        for (int i = 0; i < 12; i++) {
            if (temp[i]>=tempMedia) {
                System.out.printf("%s: %.2fºC\n", meses[i],temp[i]);
            }
        }
    }
    
    /**
     * 14 : 5 perguntas sobre um crime
     */ 
    public static void Questao14(){
        String[] perguntas = {"Telefonou para a vitima?","Esteve no Local?","Mora perto da vítima?","Devia para a vítima?","Já trabalhou com a vítima?"};
        int numeroSim = 0;
        System.out.println("0 = não | 1 = sim");
        for (String p : perguntas) {
            System.out.println(p);
            int entrada = sc.nextInt();
            sc.nextLine();
            if (entrada==1) {
                numeroSim++;
            }
        }
        switch (numeroSim) {
            case 2 -> System.out.println("Suspeito");
            case 3, 4 -> System.out.println("Cúmplice");
            case 5 -> System.out.println("Assasino");
            default -> { System.out.println("Não é suspeito");
            }
        }
    }
    
    /**
     * 15 : inserção de notas 
     */ 
    public static void Questao15(){
        ArrayList<Float> notas = new ArrayList<>();
        float soma = 0f;
        float media = 0f;
        int acimaMedia = 0;
        int abaixo7 = 0;
        System.out.println("Insira as notas | -1 Sair");
        while (true) {   
            System.out.print("Nota: ");
            float nota = sc.nextFloat();
            sc.nextLine();
            if (nota==-1f) break;
            notas.add(nota);
        }
        System.out.println("Quantidade de notas inseridas: "+notas.size());
        // notas em ordem
        System.out.print("Notas em ordem: ");
        for (float nota : notas) {
            System.out.print(nota+ " ");
            soma+=nota;
            media+=nota;
            if (nota<7) abaixo7++;
        }
        //Quantidade notas acima da media
        media=media/notas.size();
        for (float nota : notas) {
            if (nota>media) acimaMedia++;
        }
        // notas em ordem inversa
        System.out.println("\nNotas em ordem inversa");
        for (int i = notas.size()-1; i >=0; i--) {
            System.out.println(notas.get(i));
        }
        System.out.println("Media: "+media+" quantidade de notas acima da media: "+acimaMedia);
        System.out.println("Quantidade de notas abaixo de 7: "+abaixo7);
        System.out.println("Progama encerrado");
    }
    
    public static void main(String[] args) {
        //Inserir Funcao Aqui para Teste

        sc.close(); // Close Scanner
    }
    
}
