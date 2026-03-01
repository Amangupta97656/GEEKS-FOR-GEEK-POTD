class Solution{
void pushZerosToEnd(int[] arr) {
    int idx = 0; // Pointer for the next non-zero element

    // Step 1: Shift all non-zero elements to the front
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] != 0) {
            arr[idx++] = arr[i];
        }
    }

    // Step 2: Fill the rest of the array with zeros
    while (idx < arr.length) {
        arr[idx++] = 0;
    }
}
}
