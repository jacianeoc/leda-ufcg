package problems;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {
		if(validation(array, x)){
			int left = 0;
			int right = array.length-1;
			return binaryFloorSearch(array, left, right, x);
		} else {
			return null;
		}
		

	}

	private Integer binaryFloorSearch(Integer[] array, int left, int right, Integer x) {
		if (left > right) {
			return array[right];
		}
		
		if (x < array[left]) {
			return null;
		}

		int mid = (left + right)/2;
		if (array[mid] > x) {
			return binaryFloorSearch(array, left, mid-1, x);
		} else if(array[mid] < x) {
			return binaryFloorSearch(array, mid+1, right, x);
		} else {
			return array[mid];
		}
	}

	private boolean validation(Integer[] array, Integer x) {

		if (array == null)
			return false;
		if (array.length == 0)
			return false;
		//if (x < array.length)
			//return false;
		if (x >= array.length)
			return false;

		return true;
	}
	
}
