public class PracticeProblem {

	public static void main(String args[]) {
		bubbleSort(new double[]{2.4, 7.7, 3.2});
	}

	//q1
	public static int[] bubbleSort(double[] nums1) {
		int countSwap = 0;
		int countCompare = 0;
		boolean swap = true;
		for (int a = 0; a < nums1.length - 1 && swap; a++){
			swap = false;
			for (int b = 0; b < nums1.length - 1 - a; b++){
				countCompare++;
				if (nums1[b] > nums1[b+1]){
					double temp = nums1[b];
					nums1[b] = nums1[b+1];
					nums1[b+1] = temp;
					swap = true;
					countSwap = countSwap + 3;
				}
			}
		}
		return new int[] {countSwap, countCompare};
	}

	public static int[] selectionSort(double[] nums2) {
		int countSwap = 0;
		int countCompare = 0;
		for (int a = 0; a < nums2.length; a++) {
			int smallest = a;
			for (int b = a + 1; b < nums2.length; b++) {
				countCompare++;
				if (nums2[b] < nums2[smallest]) {
				smallest = b;
				}
			}
			double temp = nums2[smallest];
			nums2[smallest] = nums2[a];
			nums2[a] = temp;
			countSwap = countSwap + 3;
		}
		return new int[] {countSwap, countCompare};
	}

	public static int[] insertionSort(double[] nums3) {
		int countSwap = 0;
		int countCompare = 0;
		for (int a = 1; a < nums3.length; a++) {
			double key = nums3[a];
			int index = a - 1;
			while (index >= 0 && nums3[index] > key) {
				nums3[index + 1] = nums3[index];
				index--;
				countCompare++;
				countSwap++;
			}
			nums3[index + 1] = key;

		}
		return new int[] {countSwap, countCompare};
	}

	//q2
	public static String leastSwaps(double[] nums4) {
		int countSwap1 = 0;
		boolean swap = true;
		for (int a = 0; a < nums4.length - 1 && swap; a++){
			swap = false;
			for (int b = 0; b < nums4.length - 1 - a; b++){
				if (nums4[b] > nums4[b+1]){
					double temp = nums4[b];
					nums4[b] = nums4[b+1];
					nums4[b+1] = temp;
					swap = true;
					countSwap1 = countSwap1 + 3;
				}
			}
		}

		int countSwap2 = 0;
		for (int a = 0; a < nums4.length; a++) {
			int smallest = a;
			for (int b = a + 1; b < nums4.length; b++) {
				if (nums4[b] < nums4[smallest]) {
				smallest = b;
				}
			}
			double temp = nums4[smallest];
			nums4[smallest] = nums4[a];
			nums4[a] = temp;
			countSwap2 = countSwap2 + 3;
		}

		int countSwap3 = 0;
		for (int a = 1; a < nums4.length; a++) {
			double key = nums4[a];
			int index = a - 1;
			while (index >= 0 && nums4[index] > key) {
				nums4[index + 1] = nums4[index];
				index--;
				countSwap3++;
			}
			nums4[index + 1] = key;

		}

		if ((countSwap1 < countSwap2) && (countSwap1 < countSwap3)) {
			return "Bubble";
		} else if ((countSwap2 < countSwap1) && (countSwap2 < countSwap3)) {
			return "Selection";
		} else {
			return "Insertion";
		}
	}

	//q3 
	public static String leastIterations(double[] nums5) {
		int countIterations1 = 0;
		boolean swap = true;
		for (int a = 0; a < nums5.length - 1 && swap; a++){
			swap = false;
			for (int b = 0; b < nums5.length - 1 - a; b++){
				if (nums5[b] > nums5[b+1]){
					double temp = nums5[b];
					nums5[b] = nums5[b+1];
					nums5[b+1] = temp;
					swap = true;
				}
				countIterations1++;
			}
		}

		int countIterations2 = 0;
		for (int a = 0; a < nums5.length; a++) {
			int smallest = a;
			for (int b = a + 1; b < nums5.length; b++) {
				if (nums5[b] < nums5[smallest]) {
				smallest = b;
				}
				countIterations2++;
			}
			double temp = nums5[smallest];
			nums5[smallest] = nums5[a];
			nums5[a] = temp;
		}

		int countIterations3 = 0;
		for (int a = 1; a < nums5.length; a++) {
			double key = nums5[a];
			int index = a - 1;
			while (index >= 0 && nums5[index] > key) {
				nums5[index + 1] = nums5[index];
				index--;
			}
			nums5[index + 1] = key;
			countIterations3++;
		}

		if ((countIterations1 < countIterations2) && (countIterations1 < countIterations3)) {
			return "Bubble";
		} else if ((countIterations2 < countIterations1) && (countIterations2 < countIterations3)) {
			return "Selection";
		} else {
			return "Insertion";
		}
	}
}
