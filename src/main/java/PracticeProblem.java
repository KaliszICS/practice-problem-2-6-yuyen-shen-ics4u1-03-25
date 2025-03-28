import java.util.Arrays;

public class PracticeProblem {

	public static void main(String args[]) {
		bubbleSort(new double[]{2.4, 7.7, 3.2});
		System.out.println(insertionSort(new double[] {155.2, 155.1, 1, 5, 3, 2, 7}));
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
		for (int a = 0; a < nums2.length-1; a++) {
			int smallest = a;
			for (int b = a + 1; b < nums2.length; b++) {
				countCompare++;
				if (nums2[b] < nums2[smallest]) {
				smallest = b;
				countSwap++;
				}
			}
				double temp = nums2[smallest];
				nums2[smallest] = nums2[a];
				nums2[a] = temp;
				countSwap += 3;
			
		}
		return new int[] {countSwap, countCompare};
	}

	public static int[] insertionSort(double[] nums3) {
		int countSwap = 0;
		int countCompare = 0;
		for (int a = 1; a < nums3.length; a++) {
			countSwap++;
			double key = nums3[a];
			int index = a - 1;
			while (index >= 0 && nums3[index] > key){
				countCompare++;
				nums3[index + 1] = nums3[index];
				index--;
				countSwap++;
			}
			nums3[index + 1] = key;
			countSwap++;

		}
		return new int[] {countSwap, countCompare};
	}

	//q2
	public static String leastSwaps(double[] nums4) {
		double[] nums1 = Arrays.copyOf(nums4, nums4.length);
		double[] nums2 = Arrays.copyOf(nums4, nums4.length);
		double[] nums3 = Arrays.copyOf(nums4, nums4.length); 
		int countSwap1 = 0;
		boolean swap = true;
		int[] bubble = bubbleSort(nums1);
		int[] insertion = insertionSort(nums2);
		int[] selection = selectionSort(nums3);

		if ((bubble[0] < insertion[0]) && (bubble[0] < selection[0])) {
			return "Bubble";
		} else if ((insertion[0] < bubble[0]) && (insertion[0] < selection[0])) {
			return "Insertion";
		} else {
			return "Selection";
		}
	}

	//q3 
	public static String leastIterations(double[] nums5) {
		double[] nums1 = Arrays.copyOf(nums5, nums5.length);
		double[] nums2 = Arrays.copyOf(nums5, nums5.length);
		double[] nums3 = Arrays.copyOf(nums5, nums5.length); 
		int countIterations1 = 0;
		boolean swap = true;
		for (int a = 0; a < nums1.length - 1 && swap; a++){
			swap = false;
			for (int b = 0; b < nums1.length - 1 - a; b++){
				if (nums1[b] > nums1[b+1]){
					double temp = nums1[b];
					nums1[b] = nums1[b+1];
					nums1[b+1] = temp;
					swap = true;
				}
				countIterations1++;
			}
		}

		int countIterations2 = 0;
		for (int a = 0; a < nums2.length; a++) {
			int smallest = a;
			for (int b = a + 1; b < nums2.length; b++) {
				if (nums2[b] < nums2[smallest]) {
				smallest = b;
				}
				countIterations2++;
			}
			double temp = nums2[smallest];
			nums2[smallest] = nums2[a];
			nums2[a] = temp;
		}

		int countIterations3 = 0;
		for (int a = 1; a < nums3.length; a++) {
			double key = nums3[a];
			int index = a - 1;
			while (index >= 0 && nums3[index] > key) {
				nums3[index + 1] = nums3[index];
				index--;
				countIterations3++;
			}
			nums3[index + 1] = key;
		}

		if ((countIterations1 <= countIterations2) && (countIterations1 <= countIterations3)) {
			return "Bubble";
		} else if ((countIterations2 <= countIterations1) && (countIterations2 <= countIterations3)) {
			return "Selection";
		} else {
			return "Insertion";
		}
	}
}
