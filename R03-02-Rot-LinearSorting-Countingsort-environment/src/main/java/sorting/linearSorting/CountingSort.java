package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa a estratégia de Counting Sort vista em sala. Procure
 * evitar desperdicio de memoria alocando o array de contadores com o tamanho
 * sendo o máximo inteiro presente no array a ser ordenado.
 *
 * Voce pode assumir que o maior inteiro armazenado não chega a 100.
 *
 */
public class CountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if (validation(array, leftIndex, rightIndex)) {

			Integer[] aux1 = new Integer[rightIndex - leftIndex + 1];

			
			int max = array[leftIndex];
			for (int i = leftIndex; i <= rightIndex; i++) {
				if (array[i] > max)
					max = array[i];
			}
			
			int[] aux2 = new int[max + 1];
			for(int i=leftIndex; i<=rightIndex; i++){
				aux2[array[i]]++;
			}
			
			for(int i=1; i<=max; i++){
				aux2[i] += aux2[i-1];
			}

			for(int i=rightIndex; i>=leftIndex; i--){
				aux2[array[i]]--;
				aux1[aux2[array[i]]] = array[i];
			}

			for (int i = leftIndex; i <= rightIndex; i++) {
				array[i] = aux1[i - leftIndex];
			}
		}
	}
	private boolean validation(Integer[] array, int leftIndex, int rightIndex) {

		if (array == null)
			return false;
		if (array.length == 0)
			return false;
		if (leftIndex < 0 || rightIndex < 0)
			return false;
		if (leftIndex >= rightIndex)
			return false;
		if (rightIndex >= array.length)
			return false;

		return true;
	}

}
