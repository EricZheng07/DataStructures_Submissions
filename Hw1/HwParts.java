public class HwParts {

    //HW Methods 
    //Bubble Sort
    public static void bubbleSort(int[] arr) {
        
        for(int i = 0; i < arr.length; i++) {
            int temp = 0;
            for(int j = 1; j < arr.length-i; j++) {
                if(arr[j-1] > arr[j]) {
                    temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
    }
    //Merge Sort
    public static void mergeSort(int[] arr, int first, int last) {
        if(first < last) { 
            int middle = (first+last)/2 ;
            mergeSort(arr, first, middle);
            mergeSort(arr, middle+1, last);

            merge(arr,first, middle, last);
        }
    }
        public static void merge(int[] arr, int start, int middle, int end) {
    int leftSize = middle - start + 1;
    int rightSize = end - middle;
    int j = 0; // Pointer for left subarray
    int k = 0; // Pointer for right subarray
    int[] arrRef = arr.clone();

    for (int i = start; i <= end; i++) {
        //Check sub arrays 
        if (j >= leftSize) {
            arr[i] = arrRef[middle + 1 + k];
            k++;
        } else if (k >= rightSize) {
            arr[i] = arrRef[start + j];
            j++;
        }

        //Compare if needed
        else if (arrRef[start + j] <= arrRef[middle + 1 + k]) {
            arr[i] = arrRef[start + j];
            j++;
        } else {
            arr[i] = arrRef[middle + 1 + k];
            k++;
        }
    }
}
    //Linear Search
    public static int linearSearch(int[] arr, int element) {
        for(int i =0; i < arr.length; i++) {
            if (element == arr[i])
                return i;
        }
        return -1;        
    }
    //Binary Search
    public static int binarySearch(int[] arr, int element) {
        int left = 0;
        int right = arr.length-1;
        int middle;
        while (right >= left) {
            middle = left + (right-left)/2;
            if(arr[middle] == element)
                return middle;
            if(element < arr[middle])
                right = middle-1;
            else   
                left = middle+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        
        //Part 1
            /*
            Name: Eric Zheng
            Programing language: Java
            IDE: Visual Studio Code
            */

        //Part 2
            //Define Arrays
            int[] arr = {43,2,88,12,32,56,90,76,6,10,24,1};
            int[] arrCopy1 = {43,2,88,12,32,56,90,76,6,10,24,1};
            //Print Array
            System.out.println("Original Array: ");
            for(int i: arr) {
                System.out.printf("%d ",i);
            }
            System.out.println();

        //Part 3
            //Call bubble sort
            bubbleSort(arr);
            //Print Array
            System.out.println("Bubble Sorted Array: ");
            for(int i: arr) {
                System.out.printf("%d ",i);
            }
            System.out.println();

        //Part 4
            /*
            1. Worst case for bubble sort is if the array is sorted in reverse. 
            A swap is executed n more times for each element, giving O(n^2) time complexity
            2. Bubble sort has this time complexity because it swaps after every true comparison. 
            3. Assuming worst case senario of O(n^2), processing a data set of 10 elements will require 
            100 comparisions but processing a set of 1,000 elements will require 1,000,000 comparisions.  
            */
        
        //Part 5
            int firstIndex = 0;
            int lastIndex = arr.length-1;
            //Call merge sort
            mergeSort(arrCopy1, firstIndex, lastIndex);
            //Print array
            System.out.println("Merge Sorted Array: ");
            for(int i: arrCopy1) {
                System.out.printf("%d ",i);
            }
            System.out.println();

        //Part 6
            /*
            4. Time complexity for merge sort is O(nlog(n))
            5. Merge Sort will generally perform better than bubble sort when the amount of data becomes large since it has 
            a better time complexity compared to bubble sort. 
            6.  Merge sort Worst Case: O(nlog(n)
                Bubble sort Worst Case: O(n^2)            
            */

        //Part 7-8
            //Linear search algorithum implemented 
            //Find elements 2, 88, and 67 <beginning, end, not-in-set>
            int index1 = linearSearch(arr, 2);
            int index2 = linearSearch(arr, 88);
            int index3 = linearSearch(arr, 67);
            System.out.printf("\nUsing Linear Search: \n2 %s\n88 %s\n67 %s\n", 
                index1 != -1 ? "was found at index " + index1 : "was not in the dataset",
                index2 != -1 ? "was found at index " + index2 : "was not in the dataset",
                index3 != -1 ? "was found at index " + index3 : "was not in the dataset"
            ); 

        //Part 9-10
            //Binary Search algorithum implemented 
            //Find elements 1, 76, and 69 <beginning, end, not-in-set>
            int index4 = binarySearch(arr, 1);
            int index5 = binarySearch(arr, 76);
            int index6 = binarySearch(arr, 69);
            System.out.printf("\nUsing Binary Search: \n1 %s\n76 %s\n69 %s\n", 
                index4 != -1 ? "was found at index " + index4 : "was not in the dataset",
                index5 != -1 ? "was found at index " + index5 : "was not in the dataset",
                index6 != -1 ? "was found at index " + index6 : "was not in the dataset"
            ); 

        //Part 11
            /*
            7. Time complexity for linear search is exactly O(n). This is because each element denoted 
            by the nth term is accessed exactly once for the algorithum in a worst case senario. 

            8. Time compextity for binary search is O(log(n)). This is because for an array of size n, 
            each accessed element cuts the remaining elements to check in half, resulting in a logarithmic checking of
            elements and a log(n) time complexity. 
            */

        //Part 12
            /*
            |     Algorithm     |     Purpose     |     Big O     |
            |-----------------------------------------------------|
            | Bubble Sort       | Sorting         | O(n^2)        |
            | Merge Sort        | Sorting         | O(nlog(n))    |
            | Linear Search     | Searching       | O(n)          |
            | Binary Search     | Searching       | O(log(n))     |
            |-----------------------------------------------------|		        
            */

        //Part 13
            //Execute the code and the terminal shall answer
    }
}