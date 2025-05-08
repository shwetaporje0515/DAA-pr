import java.util.Arrays;
import java.util.Random;

public class pr6 {

    private static int deterministicPartition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);
        return i + 1;
    }

    private static int randomizedPartition(int[] arr, int low, int high) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low + 1) + low;
        swap(arr, pivotIndex, high);
        return deterministicPartition(arr, low, high);
    }

    private static void quickSort(int[] arr, int low, int high, boolean useRandomized) {
        if (low < high) {
            int pivotIndex = useRandomized ? randomizedPartition(arr, low, high) : deterministicPartition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1, useRandomized);
            quickSort(arr, pivotIndex + 1, high, useRandomized);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arrSizes = {100, 1000, 10000, 100000};
        Random rand = new Random();

        for (int size : arrSizes) {
            int[] arr = rand.ints(size, 1, 1001).toArray();
            Arrays.sort(arr, 0, arr.length); // Ensure the array is in reverse order for testing

            // Measure deterministic quick sort
            long start = System.nanoTime();
            quickSort(arr.clone(), 0, arr.length - 1, false);
            long deterministicTime = System.nanoTime() - start;

            // Measure randomized quick sort
            start = System.nanoTime();
            quickSort(arr.clone(), 0, arr.length - 1, true);
            long randomizedTime = System.nanoTime() - start;

            System.out.printf("Array size: %d%n", size);
            System.out.printf("Deterministic Quick Sort time: %.6f seconds%n", deterministicTime / 1_000_000_000.0);
            System.out.printf("Randomized Quick Sort time: %.6f seconds%n", randomizedTime / 1_000_000_000.0);
            System.out.println("-".repeat(40));
        }
    }
}