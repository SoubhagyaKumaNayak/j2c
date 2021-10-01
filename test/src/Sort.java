public class Sort {
    public static void mergeSort(int[] a) {
        int[] tmpA = new int[a.length];
        mergeSort(a, tmpA, 0, a.length - 1);
    }

    private static void mergeSort(int[] a, int[] tmpA,
            int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            merge(a, tmpA,left, center + 1, right);
            mergeSort(a, tmpA, left, center);
            mergeSort(a, tmpA, center + 1, right);
            
        }
    }

    private static void merge(int[] a, int[] tmpA,
            int leftPos, int rightPos, int rightEnd) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numEle = rightEnd - leftPos + 1;

        // Main loop
        while (leftPos <= leftEnd && rightPos <= rightEnd)
            if (a[leftPos].compareTo(a[rightPos]) <= 0)
                tmpA[tmpPos++] = a[leftPos++];
            else
                tmpA[tmpPos++] = a[rightPos++];

        while (leftPos <= leftEnd)
            tmpA[tmpPos++] = a[leftPos++];

        while (rightPos <= rightEnd)
            tmpA[tmpPos++] = a[rightPos++];

        // Copy tmpArray back
        for (int i = 0; i < numElements; i++, rightEnd--)
            a[rightEnd] = tmpA[rightEnd];
    }

    public static void main(String[] args) {
        mergeSort(args);

        String separator = "";
        for (String s : args) {
            System.out.println(separator + s);
            separator = ", ";
        }
    }
}
