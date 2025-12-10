import java.util.Arrays;
import java.util.Random;

public class SelectionSortDemo {

    /*
     * Basic Selection Sort in ascending order.
     * Idea: for each position i, find the smallest element in the rest of the array
     * and swap it into position i.
     * This is the "textbook" version and it is NOT stable because of the swap.
     */
    public static void selectionSortAscending(int[] arr) {
        int n = arr.length;

        // Move the boundary of the sorted part from left to right
        for (int i = 0; i < n - 1; i++) {

            // Assume the current position has the smallest value
            int minIndex = i;

            // Look for a smaller element in the remaining unsorted portion
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // If we actually found a smaller element, swap it into place
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    /*
     * Selection Sort in DESCENDING order.
     * Very similar to the ascending version, but now I look for the largest element
     * instead of the smallest.
     */
    public static void selectionSortDescending(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int maxIndex = i;

            // Find the largest element in the remaining part of the array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // Swap the largest element into position i
            if (maxIndex != i) {
                int temp = arr[i];
                arr[i] = arr[maxIndex];
                arr[maxIndex] = temp;
            }
        }
    }

    /*
     * "Stable" Selection Sort (optional enhancement).
     * The normal algorithm can move equal elements past each other because of swapping.
     * To keep it stable, I don't swap. Instead, I take the minimum element and
     * shift everything between i and minIndex one step to the right, then insert the min.
     * This keeps equal elements in their original order but still has O(n^2) time.
     */
    public static void selectionSortStable(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            // Find the index of the smallest element from i onward
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Instead of swapping, we "extract" the min and shift others right
            int minValue = arr[minIndex];

            while (minIndex > i) {
                arr[minIndex] = arr[minIndex - 1];
                minIndex--;
            }

            arr[i] = minValue;
        }
    }

    // ---------------- Helper methods for testing ----------------

    private static int[] copy(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }

    // Random array: good for general testing
    private static int[] generateRandomArray(int size, int maxValue) {
        Random r = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = r.nextInt(maxValue);
        }
        return arr;
    }

    // Already sorted ascending (best-case for some algorithms, not really for Selection Sort)
    private static int[] generateSortedAscending(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    // Sorted descending (kind of "opposite" order)
    private static int[] generateSortedDescending(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    // All equal values (uniform input)
    private static int[] generateAllEqual(int size, int value) {
        int[] arr = new int[size];
        Arrays.fill(arr, value);
        return arr;
    }

    // Simple method to check if an array is sorted in ascending order
    private static boolean isSortedAscending(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    // Quick print helper so I don't repeat Arrays.toString everywhere
    private static void printArray(String label, int[] arr) {
        System.out.println(label + Arrays.toString(arr));
    }

    // ---------------- MAIN: run all the required test cases ----------------

    public static void main(String[] args) {

        int size = 15;      // small size so I can see the arrays
        int perfSize = 4000; // slightly larger size for rough timing if I want

        // 1. Random array
        int[] randomArray = generateRandomArray(size, 100);
        System.out.println("=== Random Array (Selection Sort Ascending) ===");
        int[] randomCopy = copy(randomArray);
        printArray("Original: ", randomCopy);
        selectionSortAscending(randomCopy);
        printArray("Sorted  : ", randomCopy);
        System.out.println("Is sorted? " + isSortedAscending(randomCopy));
        System.out.println();

        // 2. Already sorted ascending array
        int[] sortedArray = generateSortedAscending(size);
        System.out.println("=== Already Sorted Ascending Array ===");
        int[] sortedCopy = copy(sortedArray);
        printArray("Original: ", sortedCopy);
        selectionSortAscending(sortedCopy);
        printArray("Sorted  : ", sortedCopy);
        System.out.println("Is sorted? " + isSortedAscending(sortedCopy));
        System.out.println();

        // 3. Array sorted in descending order
        int[] descendingArray = generateSortedDescending(size);
        System.out.println("=== Descending Array (Ascending Selection Sort) ===");
        int[] descCopy = copy(descendingArray);
        printArray("Original: ", descCopy);
        selectionSortAscending(descCopy);
        printArray("Sorted  : ", descCopy);
        System.out.println("Is sorted? " + isSortedAscending(descCopy));
        System.out.println();

        // 4. All elements equal
        int[] equalArray = generateAllEqual(size, 5);
        System.out.println("=== All Elements Equal ===");
        int[] equalCopy = copy(equalArray);
        printArray("Original: ", equalCopy);
        selectionSortAscending(equalCopy);
        printArray("Sorted  : ", equalCopy);
        System.out.println("Is sorted? " + isSortedAscending(equalCopy));
        System.out.println();

        // 5. Edge case: empty array
        int[] emptyArray = new int[0];
        System.out.println("=== Edge Case: Empty Array ===");
        printArray("Original: ", emptyArray);
        selectionSortAscending(emptyArray);
        printArray("Sorted  : ", emptyArray);
        System.out.println("Is sorted? " + isSortedAscending(emptyArray));
        System.out.println();

        // 6. Edge case: single-element array
        int[] singleArray = {42};
        System.out.println("=== Edge Case: Single Element ===");
        printArray("Original: ", singleArray);
        selectionSortAscending(singleArray);
        printArray("Sorted  : ", singleArray);
        System.out.println("Is sorted? " + isSortedAscending(singleArray));
        System.out.println();

        // -------- Optional enhancement: descending sort demo --------
        System.out.println("=== Selection Sort in DESCENDING order (enhancement) ===");
        int[] forDescending = generateRandomArray(size, 100);
        printArray("Original:   ", forDescending);
        selectionSortDescending(forDescending);
        printArray("Descending: ", forDescending);
        System.out.println();

        // -------- Optional enhancement: stable version demo --------
        System.out.println("=== Stable Selection Sort demo (enhancement) ===");
        int[] stableExample = {4, 2, 2, 3, 2, 1};
        printArray("Original: ", stableExample);
        selectionSortStable(stableExample);
        printArray("Stable  : ", stableExample);
        System.out.println();

        // (If you want, you can also time the algorithms like we did for Bubble Sort.
        // For this assignment I focused mainly on correctness and behavior.)
    }
}
