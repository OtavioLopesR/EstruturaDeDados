import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
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
    public static void Questao09(){
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
        System.out.println("Insira as notas | -1 Finalizar");
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
    
    /**
     * 16 : Array de vendedores
     */ 
    public static void Questao16(){
        ArrayList<Float> vendasBrutas = new ArrayList<>();
        int[] quantidade = {0,0,0,0,0,0,0,0,0};
        String[] s = {"R$200 - R$299: ","R$300 - R$399: ","R$400 - R$499: ","R$500 - R$599: ","R$600 - R$699: ","R$700 - R$799: ","R$800 - R$899: ","R$900 - R$999: ","R$1000+: "};
        int n = 1;
        while (true) {            
            System.out.println("Insira a venda bruta do vendedor "+n+" | -1 Finalizar");
            float entrada = sc.nextFloat();
            sc.nextLine();
            if (entrada==-1) break;
            n++;
            vendasBrutas.add(entrada);
            System.out.println("Entrada inserida total pagamento: "+(200+((entrada*9)/100))); //Pagamento = 200+ 9% venda bruta
        }
        for (Float venda : vendasBrutas) {
            float pagamento = 200+((venda*9)/100); //Pagamento = 200+ 9% venda bruta
            if (pagamento>=200 && pagamento <= 299) {
                quantidade[0]++;
            }else if (pagamento>=300 && pagamento <= 399){
                quantidade[1]++;
            }else if (pagamento>=400 && pagamento <= 499){
                quantidade[2]++;
            }else if (pagamento>=500 && pagamento <= 599){
                quantidade[3]++;
            }else if (pagamento>=600 && pagamento <= 699){
                quantidade[4]++;
            }else if (pagamento>=700 && pagamento <= 799){
                quantidade[5]++;
            }else if (pagamento>=800 && pagamento <= 899){
                quantidade[6]++;
            }else if (pagamento>=900 && pagamento <= 999){
                quantidade[7]++;
            }else if (pagamento>=1000){
                quantidade[8]++;
            }
        }
        System.out.println("Quantidade de Vendedores: "+vendasBrutas.size());
        for (int i = 0; i < quantidade.length;i++) {
            System.out.println(s[i]+quantidade[i]);
        }
    }
    
    /**
     * 17 : Competição de salto
     */ 
    public static void Questao17(){
        Float[] saltos = new Float[5];
        while (true) {            
            Float mediaSaltos = 0f;
            System.out.println("Insira o nome do atleta: | em branco - sair");
            String nome = sc.nextLine();
            if (nome.isBlank() || nome.isEmpty()) break;
            for (int i = 0; i < saltos.length; i++) {
                System.out.println("Insira a distancia do "+(i+1)+" salto");
                Float distancia = sc.nextFloat();
                sc.nextLine();
                mediaSaltos+=distancia;
                saltos[i]=distancia;
            }
            mediaSaltos=mediaSaltos/saltos.length;
            System.out.println("\nNome do Atleta: "+nome);
            System.out.print("Saltos: ");
            for (Float salto : saltos) {
                System.out.print(salto+" ");
            }
            System.out.println("\nMedia dos Saltos: "+mediaSaltos+"\n");
        }
    }
    
    /**
     * 18 : Enquete Emissora de televisao
     */ 
    public static void Questao18(){
        try {
            FileWriter arquivo = new FileWriter("Enquete.txt");
            arquivo.write("Enquete:\n");
            int[] votosJogadores = new int[23];
            int totalVotos = 0;
            int jogadorVencedor = 0; // indice do jogador vencedor da enquete
            
            for (int i = 0; i < votosJogadores.length; i++) {
                votosJogadores[i]=0; // inicia votos com 0
            }   
            //Loop de votos
            while (true) {            
                System.out.print("Numero do Jogador | 0 - Sair :");
                int entrada = sc.nextInt();
                sc.nextLine();
                arquivo.write("\nNumero do Jogador | 0 - Sair :"+entrada);
                if (entrada==0) break;
                // Se entrada entre 1 e 23
                if (entrada>=1 && entrada<=23){
                    votosJogadores[entrada-1]++;
                    totalVotos++;
                    // se quantidade de votos do vencedor atual < quantidade de votos do ultimo jogador
                    if (votosJogadores[jogadorVencedor]<votosJogadores[entrada-1]) {
                        jogadorVencedor=entrada-1;// atribui indice do jogador vencedor
                    }
                }else{
                    System.out.println("Informe um valor entre 1 e 23 ou 0 para sair.");
                    arquivo.write("\nInforme um valor entre 1 e 23 ou 0 para sair.");
                }
            }   
            
            System.out.println("\nResultado Da Votação: \n");
            arquivo.write("\n\nResultado Da Votação: \n\n");
            System.out.println("Foram computados "+totalVotos+" votos.");
            arquivo.write("Foram computados "+totalVotos+" votos.");
            System.out.println("Jogador Votos %");
            arquivo.write("\nJogador Votos %");
            
            for (int i=0;i<votosJogadores.length;i++) {
                if (votosJogadores[i]>0) {
                    System.out.printf("%d %d %.0f%%%n",i+1,votosJogadores[i],percentual(votosJogadores[i], totalVotos));
                    arquivo.write(String.format("%n%d %d %.0f%%",i+1,votosJogadores[i],percentual(votosJogadores[i], totalVotos)));
                }
            }   
            System.out.printf("%nO melhor jogador foi o número %d, com %d votos, correspondendo a %.0f%% dos votos%n",jogadorVencedor+1,votosJogadores[jogadorVencedor],percentual(votosJogadores[jogadorVencedor], totalVotos));
            arquivo.write(String.format("%nO melhor jogador foi o número %d, com %d votos, correspondendo a %.0f%% dos votos",jogadorVencedor+1,votosJogadores[jogadorVencedor],percentual(votosJogadores[jogadorVencedor], totalVotos)));
            arquivo.close();
        } catch (IOException ex) {
            System.err.println("Erro ao escrever arquivo");
        }
    }
    
    /**
     * 18 : funcao auxiliar da questao 18
     * @param quantitade - quantidade de votos do jogador
     * @param total - total de votos da enquete
     * @return percentual do total de votos para aquele jogador
     */ 
    public static double percentual(int quantitade,int total){
        if (quantitade == 0 || total == 0) {
            return 0f;
        }else{
            return (quantitade*100)/total;
        }
    }
    
    /**
     * 19 : Enquete Sistemas operacionais
     */ 
    public static void Questao19(){
        int[] votos = {0,0,0,0,0,0};
        String[] sistemas = {"Windows Server", "Unix", "Linux", "Netware","Mac OS","Outro"};
        int sistemaVencedor = 5;
        int totalVotos = 0;
        System.out.println("Qual o melhor sistema operacional para uso em servidores?");
        //Loop de votos
        while (true) {            
            System.out.println("0 - Encerrar Enquete\n1 - Windows Server\n2 - Unix\n3 - Linux\n4 - Netware\n5 - Mac OS\n6 - Outro");
            int entrada = sc.nextInt();
            sc.nextLine();
            if (entrada==0)break;
            if (entrada>=1 && entrada<=6) {
                int indiceSistema = entrada-1;
                System.out.println("Informe a quantidade de votos para "+sistemas[indiceSistema]);
                entrada = sc.nextInt();
                sc.nextLine();
                votos[indiceSistema]+=entrada;
                totalVotos+=entrada;
                //Se quantidade de votos do sistema vencedor < quantidade de votos da ultima entrada
                if (votos[sistemaVencedor]<votos[indiceSistema]){
                    sistemaVencedor=indiceSistema;//Atribui sistema vencedor como ultima entrada
                }
            }else{
                System.out.println("Informe um valor valido");
            }
        }
        System.out.println("\nEnquete Encerrada\n");
        System.out.println("Sistema Operacional | Votos | %");
        System.out.println("-------------------------------");
        for (int i = 0; i < sistemas.length; i++) {
            System.out.printf("%d - %s - %d - %.0f%%%n",i+1,sistemas[i],votos[i],percentual(votos[i], totalVotos));
        }
        System.out.println("-------------------------------");
        System.out.printf("Total %d",totalVotos);
        System.out.printf("%n%nO sistema operacional vencedor foi o %s, com %d votos%n",sistemas[sistemaVencedor],votos[sistemaVencedor]);
    }
    
    /**
     * 20 : Organizacoes Tabajara | Salario e pagamento de abono
     */ 
    public static void Questao20(){
        ArrayList<Float> salarios = new ArrayList<>();
        ArrayList<Float> abonos = new ArrayList<>();
        int n = 0; //numero total de funcionarios processados
        int totalMinimo = 0; //numero total de funcionarios que foram pagos o abono minimo
        float totalGastos = 0f;
        float maiorAbono = 0f; //Maior abono pago a um funcionario
        //Loop de Salarios
        while (true) {            
            System.out.println("Insira o salário bruto do "+(n+1)+" funcionario: | 0 - Finalizar");
            float entrada = sc.nextFloat();
            sc.nextLine();
            if (entrada==0) break;
            n++;
            salarios.add(entrada);
        }
        //Calcular abonos
        for (int i = 0; i < n; i++) {
            float abono = (salarios.get(i)*20)/100;
            // Se é Valor minimo
            if (abono<=100) {
                abono=100;
                totalMinimo++;
            } 
            abonos.add(abono);
            totalGastos+=abono;
            if (maiorAbono<abono) {
                maiorAbono=abono;
            }
        }
        
        System.out.println("\nProjeção de Gastos com Abono: ");
        System.out.println("------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.print("Salário: "+salarios.get(i)+"\n");
        }
        System.out.println("\nSalário - Abono");
        for (int i = 0; i < n; i++) {
            System.out.printf("R$%.2f - R$%.2f%n",salarios.get(i),abonos.get(i));
        }
        System.out.println("\nForam Processados "+n+" Colaboradores");
        System.out.printf("Total Gasto com abonos: R$%.2f%n",totalGastos);
        System.out.println("Valor mínimo pago a "+totalMinimo+" colaboradores");
        System.out.println("Maior Abono pago: "+maiorAbono);
    }
    
    /**
     * 21: Comparador de consumo de combutivel de carros
     */
    public static void Questao21(){
        String[] carros = new String[5];
        Float[] consumos = new Float[5];
        float melhorConsumo = 0;
        int indiceMelhorM = 0;
        for (int i = 0; i < 5; i++) {
            System.out.println("Insira o modelo do "+(i+1)+" carro");
            String modelo = sc.nextLine();
            System.out.println("Insira o KM/L do "+modelo);
            float consumo = sc.nextFloat();
            sc.nextLine();
            carros[i]=modelo;
            consumos[i]=consumo;
            if (melhorConsumo<consumo) {
                melhorConsumo=consumo;
                indiceMelhorM=i;
            }
        }
        
        System.out.println("Comparativo de Consumo de Combustivel");
        for(int i = 0; i < 5; i++){
            System.out.printf("Veiculo %d%nNome: %s%nKM/L: %.2f%n",i+1,carros[i],consumos[i]);
        }
        System.out.println("\nRelatório final");
        for(int i = 0; i < 5; i++){
            System.out.printf("%d - %s - %.2f - %.2f Litros - R$%.2f%n",i+1,carros[i],consumos[i],(1000/consumos[i]),(1000/consumos[i])*2.25f);
        }
        System.out.println("\nO melhor consumo é o do "+carros[indiceMelhorM]);
    }
    
    /**
     * 22: Levantamento de Sucatas
     */
    public static void Questao22(){
        int quantidadeMouses = 0;
        String[] estados = {"Necessita de Esfera","Necessita de Limpeza","Necessita de troca de cabo ou conector","Quebrado ou Inutilizado"};
        int[] qEstados = {0,0,0,0};
        //Loop de Levantamento
        while (true) {       
            System.out.println("Levantamento de Mouses");
            System.out.println("0 - Finalizar\n1 - "+estados[0]+"\n2 - "+estados[1]+"\n3 - "+estados[2]+"\n4 - "+estados[3]);
            int entrada = sc.nextInt();
            sc.nextLine();
            if (entrada==0) break;
            if (entrada>=1 && entrada<=4){
                qEstados[entrada-1]++;
                quantidadeMouses++;
            }else{
                System.err.println("Insira um valor valido");
            }
        }
        
        System.out.println("\nQuantidade de Mouses: "+quantidadeMouses);
        System.out.println("\nSituação | Quantidade | %");
        for (int i = 0; i < 4; i++) {
            System.out.printf("%d - %s - %d - %.0f%%%n",i+1,estados[i],qEstados[i],percentual(qEstados[i], quantidadeMouses));
        }
    }
    
    /**
     * 23: ACME INC, ler arquivo de usuarios e criar relatorio.txt
     */
    public static void Questao23(){
        ArrayList<String> usuarios = new ArrayList<>();
        ArrayList<Double> espacoMB = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("usuarios.txt"));
            String linha;
            // Se ainda há linha valida no arquivo
            while ( (linha=br.readLine()) != null) {                
                String nome = linha.substring(0, 15);
                long bytes = Long.parseLong(linha.substring(15).trim());
                double megaBytes = bytes / (1024 * 1024);
                
                //Adiciona usuario e mp para os arrays
                usuarios.add(nome);
                espacoMB.add(megaBytes);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo usuarios.txt");
        }
        
        double total = espacoMB.stream().mapToDouble(Double::doubleValue).sum();
        double media = total / espacoMB.size();
        try {
            FileWriter fl = new FileWriter("relatorio.txt");
            fl.write("ACME INC.  Uso Do Espaço Em Disco Dos Usuários\n");
            fl.write("----------------------------------------------\n");
            fl.write("Nr. | Usuário | Espaco Utilizado | % Do Uso\n");
            for (int i = 0; i < usuarios.size(); i++) {
                double p = (espacoMB.get(i)*100)/total;
                fl.write(String.format("%d - %s - %.2f - %.2f%%%n",i+1,usuarios.get(i),espacoMB.get(i),p));
            }
            fl.write("");
            fl.write(String.format("Espaço Total Utilizado: %.2fMB%n", total));
            fl.write(String.format("Espaço Médio Utilizado: %.2fMB%n", media));
            fl.close();
        }catch(IOException e){
            System.err.println("Erro ao escrever o arquivo relatorio.txt");
        }
    }
    
    /**
     * 24: Lançamento de Dados
     */
    public static void Questao24(){
        Random rand = new Random();
        int[] qDados = {0,0,0,0,0,0};
        for (int i = 0; i < 100; i++) {
            qDados[rand.nextInt(0,6)]++;
        }
        System.out.println("Rolagem de dados");
        System.out.println("# | vezes rodadas");
        for (int i = 0; i<qDados.length;i++) {
            System.out.print((i+1)+" | "+qDados[i]+"\n");
        }
    }
    
    public static void main(String[] args) {
        //Inserir Funcao Aqui para Teste

        sc.close(); // Close Scanner
    }
    
}
