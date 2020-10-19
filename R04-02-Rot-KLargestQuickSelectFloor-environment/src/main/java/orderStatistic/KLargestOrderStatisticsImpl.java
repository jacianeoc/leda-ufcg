package orderStatistic;

import util.Util;

/**
 * Uma implementacao da interface KLargest que usa estatisticas de ordem para 
 * retornar um array com os k maiores elementos de um conjunto de dados/array.
 * 
 * A k-esima estatistica de ordem de um conjunto de dados eh o k-esimo menor
 * elemento desse conjunto. Por exemplo, considere o array [4,8,6,9,12,1]. 
 * A 3a estatistica de ordem eh 6, a 6a estatistica de ordem eh 12.
 * 
 * Note que, para selecionar os k maiores elementos, pode-se pegar todas as 
 * estatisticas de ordem maiores que k. 
 * 
 * Requisitos do algoritmo:
 * - DEVE ser in-place. Voce pode modificar o array original
 * - Voce DEVE usar alguma ideia de algoritmo de ordenacao visto em sala 
 *   para calcular estatisticas de ordem. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class KLargestOrderStatisticsImpl<T extends Comparable<T>> implements KLargest<T>{

	@Override
	public T[] getKLargest(T[] array, int k) {
		if(validation(array, k)){
			//so essa aqui
			
			int n = array.length-1;
			for (int i = 0; i <= n; i++) {
				if(array[i].compareTo(orderStatistics(array, i)) > 0){
					Util.swap(array, i, getIndex(array, orderStatistics(array, i)));
				}
					
			}
			
			return array;
		} else {
			return null;
		}
	}



	/**
	 * Metodo que retorna a k-esima estatistica de ordem de um array, usando
	 * a ideia de algum algoritmo de ordenacao visto em sala. Caso nao exista 
	 * a k-esima estatistica de ordem, entao retorna null.
	 * 
	 * Obs: o valor de k deve ser entre 1 e N.
	 * 
	 * @param array
	 * @param k
	 * @return
	 */
	public T orderStatistics(T[] array, int k){
		
		if(validation(array, k)) {
			sort(array,0,array.length-1);
			return array[k-1];
		}else {
			return null;
		}
			
	}
	//usando como base o selection sort :) 
	private void sort(T[]array, int leftIndex, int rightIndex) {
		for(int i=leftIndex; i <= rightIndex; i++){
			int smaller = i;
			for(int j=smaller+1; j<=rightIndex; j++){
				if(array[smaller].compareTo(array[j]) > 0){
					smaller = j;
				}
			}
			if(smaller != i){
				Util.swap(array, i, smaller);
			}
		}
		
	}
	private int getIndex(T[]arr, T element) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i].compareTo(element)== 0)
				index = i;
		}
		return index;
	}

	
	private boolean validation(T[] array, Integer k) {

		if (array == null)
			return false;
		if (array.length == 0)
			return false;
		
		if (k > array.length)
			return false;

		return true;
	}
}
