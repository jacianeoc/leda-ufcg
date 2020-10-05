package sorting.divideAndConquer.quicksort3;

import sorting.AbstractSorting;
import util.Util;

/**
 * A classe QuickSortMedianOfThree representa uma variação do QuickSort que
 * funciona de forma ligeiramente diferente. Relembre que quando o pivô
 * escolhido divide o array aproximadamente na metade, o QuickSort tem um
 * desempenho perto do ótimo. Para aproximar a entrada do caso ótimo, diversas
 * abordagens podem ser utilizadas. Uma delas é usar a mediana de 3 para achar o
 * pivô. Essa técnica consiste no seguinte:
 * 1. Comparar o elemento mais a esquerda, o central e o mais a direita do intervalo.
 * 2. Ordenar os elementos, tal que: A[left] < A[center] < A[right].
 * 3. Adotar o A[center] como pivô.
 * 4. Colocar o pivô na penúltima posição A[right-1].
 * 5. Aplicar o particionamento considerando o vetor menor, de A[left+1] até A[right-1].
 * 6. Aplicar o algoritmo na particao a esquerda e na particao a direita do pivô.
 */
public class QuickSortMedianOfThree<T extends Comparable<T>> extends
		AbstractSorting<T> {

	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(leftIndex < rightIndex){
			int pos_pivot = particionar(array, leftIndex, rightIndex);
			sort(array, leftIndex, pos_pivot - 1 );
			sort(array, pos_pivot + 1, rightIndex);
		}
	}
    
    private  int particionar(T[] array, int inicio, int fim){
        //procura a mediana entre inicio, meio e fim
        int meio = (inicio + fim)/2;
        T a = array[inicio];
        T b = array[meio];
        T c = array[fim];
        int medianaIndice; //índice da mediana
       
        if(a.compareTo(b) < 0){
            if(b.compareTo(c) < 0){
                //a < b && b < c
                medianaIndice = meio;
            }else{                
                if(a.compareTo(c) < 0){
                    //a < c && c <= b
                    medianaIndice = fim;
                }else{
                    //c <= a && a < b
                    medianaIndice = inicio;
                }
            }
        }else{
            if(c.compareTo(b) < 0){
                //c < b && b <= a
                medianaIndice = meio;
            }else{
                if(c.compareTo(a) < 0){
                    //b <= c && c < a
                    medianaIndice = fim;
                }else{
                    //b <= a && a <= c
                    medianaIndice = inicio;
                }
            }
        }
       
        Util.swap(array, medianaIndice, fim);
        
       
        //o pivo é o elemento final
        T pivo = array[fim];
        int i = inicio - 1;
    
        for(int j = inicio; j <= fim - 1; j++){
            if(array[j].compareTo(pivo) < 0 || array[j].compareTo(pivo) == 0){
                i = i + 1;
                Util.swap(array, i, j);
            }
        }
        //coloca o pivô na posição de ordenação
        Util.swap(array, i + 1, fim);
        return i + 1; //retorna a posição do pivô
    }
}
