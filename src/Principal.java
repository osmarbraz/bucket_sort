/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplinas: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 *
 * Baseado nos slides 109 da aula 15/09/2017 
 *
 * Página 145 Thomas H. Cormen 3 ed
 *
 * Algoritimo BucketSort/Ordenação por Balde
 *
 * Atenção:
 * Vetor em java inicia em 0, os algoritmos consideram início em 1.
 * A subtração de -1 ocorre somente no local de acesso ao vetor ou matriz 
 * para manter a compatibilidade entre os algoritmos.
 * 
 */
/**
 * @author Osmar de Oliveira Braz Junior
 */
public class Principal {

    /**
     * Retorna o maior elemento do vetor.
     * @param A vetor com os dados 
     * @return Um valor inteiro com o maior elemento do vetor
     */
    public static int maiorElemento(int[] A) {
        int maior = A[1-1];
        for (int i = 1; i <= A.length; i++) {
            if (A[i-1] > maior) {
                maior = A[i-1];
            }
        }
        return maior;
    }
    
    /**
     * Algoritmo BucketSort.
     *
     * Tempo do caso médio:
     * Theta(n) + n*O(2 – 1/n) = Theta(n).
     *
     */
    public static void bucketSort(int[] A) {
        //Quantidade de baldes necessários definidos pelo maior elemento    
        int n = maiorElemento(A);               
        //Cria o vetor de buckets para receber os elementos         // O(n)
        int[] B = new int[n+1];                                
        for (int i = 1; i <= n; i++) {                      
            B[i-1] = 0;
        }
        //Insere A[I] em B                                          // O(n)
        for (int i = 1; i <= A.length; i++) {
            B[A[i-1]]++;            
        }        
        //Concatena as listas de B em A                             // O(n)
        int pos = 0;
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < B[i]; j++) {
                A[pos] = i;
                pos = pos + 1;
            }
        }
    }

    public static void main(String args[]) {

        //Vetor dos dados        
        int A[] = {50, 70, 60, 90, 10, 30, 20, 40};

        //Fim do vetor
        int r = A.length;

        System.out.println(">>> Algoritmo BucketSort/Ordenação por Balde <<<");
        System.out.println("Original: ");
        for (int i = 0; i < r; i++) {
            System.out.println((i + 1) + " - " + A[i]);
        }
        
        bucketSort(A);

        System.out.println("Depois: ");
        for (int i = 0; i < r; i++) {
            System.out.println((i + 1) + " - " + A[i]);
        }
    }
}
