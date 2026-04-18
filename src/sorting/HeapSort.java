package sorting;

/**
 * Heap is a partial order, NOT a fully sorted structure
 * Only this is guaranteed:
 * Root element = smallest (min heap) OR largest (max heap)
 * In heap the parent of a node at index 'i' can be found at index [(i-1)/2]
 * 👉 But:
 * Rest of elements are NOT fully sorted
 * <p>
 * Steps -
 * 1.) First convert the array into a Max heap using heapify process (log n time complexity). This step will push the largest element at root.
 * 2.) Then swap the root element(also the largest) with the last element of the heap and reduce the heap size by 1. This step pushes the largest element at end
 * 3.) Then again heapify the root element to maintain the max heap property. This step will push the second-largest element at root.
 * 4.) Repeat steps 2 and 3 until the heap size is equal to 1.
 */

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {9, 4, 3, 8, 10, 2, 5};

        heapSort(arr);

        for (int j : arr)
            System.out.print(j + " ");
    }

    private static void heapSort(int[] arr) {
        int len = arr.length;

        // len / 2 - 1 is the index of last non-leaf node as root node is [(i-1)/2]
        for (int i = len / 2 - 1; i >= 0; i--)
            heapify(arr, len, i);

        for (int i = len - 1; i > 0; i--) {
            // Move current root to end
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;


            // call max heapify on the reduced heap after removing the last element which is already in its correct position as it is the largest element
            heapify(arr, i, 0);
        }

    }

    /**
     * @index - index of the node which is a root of a tree or subtree
     * @len - size of the heap (It acts as boundary condition for heapify process as we are reducing the heap size in each iteration of heap sort)
     * This heapify is a top-down approach, i.e. once the root is swapped with the largest element among its children,
     * we need to recursively heapify the affected subtree to maintain the max heap property.
     */
    private static void heapify(int[] arr, int len, int index) {
        int largest = index;

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != index) {
            int tmp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = tmp;

            // Recursively heapify the affected subtree
            heapify(arr, len, largest);
        }

    }

}
