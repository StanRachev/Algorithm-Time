# AlgorithmTime

**AlgorithmTime** program benchmarks various sorting algorithms by measuring their execution time. It allows users to test and compare the performance of different sorting algorithms on integer arrays.

## Features

- **Sort Algorithms Tested**:
  - Bubble Sort
  - Selection Sort
  - Insertion Sort
  - Shell Sort
  - Merge Sort
  - Quick Sort
  - Counting Sort (positive values)
  - Radix Sort

- **Array Input Options**:
  - Custom array input.
  - Random array generation.

- **Performance Measurement**:
  - Measures and displays the execution time of sorting algorithms in seconds.

## Code Structure

- **`Main`**: The entry point of the application.
- **`Interfaces`**: Contains functional interfaces for sorting algorithms.
  - **ISortAlgorithm**
  - **ISortAlgorithmStartEnd**
- **`Util`**: Contains utility classes for managing sorting operations, user interaction and printing arrays.
  - **SortManager**: Manages sorting operations and measures execution time.
  - **UI**: User input and interaction.
  - **Print**: Prints original and sorted array.
  - **ArrayCreator**: Creates custom, random arrays and copying functionality.
- **`SortingAlgorithms`**: Contains the sorting algorithms.

## Usage

1. Run the program from the main class.
2. Select the Type of Sort:
3. Array Input
4. View Results
5. Print original, sorted or both arrays

## Example

1. Test integer array against Bubble, Selection, Insertion, Shell, Merge and Quick sort.
2. Test integer array against Counting sort (only positive values).
3. Test integer array against Radix Sort (only positive and same width values).  
-> 1  
&nbsp;
1. Create custom array.
2. Generate random array (with values 1 - 100_000).  
-> 2  
&nbsp;
- Size of the array (max 100 000)  
-> 10  
&nbsp;  
<pre>
Bubble sort:     0.001234 seconds.  
Selection sort:  0.002345 seconds.  
Insertion sort:  0.003456 seconds.  
Shell sort:      0.004567 seconds.  
Merge sort:      0.005678 seconds.  
Quick sort:      0.006789 seconds.  
</pre>
1. Print original array.
2. Print sorted array.
3. Print both.
4. Exit.  
-> 3  
&nbsp;  
Original array: [2, 5, 6, 1, 9, 4, 7, 10, 8, 3]  
Sorted array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]