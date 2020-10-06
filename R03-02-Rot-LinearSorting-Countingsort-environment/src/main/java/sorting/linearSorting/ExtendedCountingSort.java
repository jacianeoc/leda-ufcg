package sorting.linearSorting;

import sorting.AbstractSorting;

/**
 * Classe que implementa do Counting Sort vista em sala. Desta vez este
 * algoritmo deve satisfazer os seguitnes requisitos:
 * - Alocar o tamanho minimo possivel para o array de contadores (C)
 * - Ser capaz de ordenar arrays contendo numeros negativos
 */
public class ExtendedCountingSort extends AbstractSorting<Integer> {

	@Override
	public void sort(Integer[] array, int leftIndex, int rightIndex) {
		
		if (validation(array, leftIndex, rightIndex)) {

			Integer[]aux1 = new Integer[rightIndex - leftIndex + 1];

			
			int min = array[leftIndex];
			int max = array[leftIndex];
			for (int i = leftIndex; i <= rightIndex; i++) {
				if (array[i] < min)
					min = array[i];
				if (array[i] > max)
					max = array[i];
			}

			int[] aux2 = new int[max - min + 1];
			for (int i = leftIndex; i <= rightIndex; i++) {
				aux2[array[i] - min]++;
			}
			
			for (int i = 1; i <= (max - min); i++) {
				aux2[i] += aux2[i - 1];
			}
			
			for (int i = rightIndex; i >= leftIndex; i--) {
				aux2[array[i] - min]--;
				aux1[aux2[array[i] - min]] = array[i];
			}

			
			for (int i = leftIndex; i <= rightIndex; i++)
				array[i] = aux1[i - leftIndex];

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
