# Sorted-and-Array-Lists
A Java program comparing time and space complexity of Sorted and Array Lists

## Analysis
### 1. Big-O and Big-Omega Notation
#### Sorted List PQ:
- Big-O and Big-Omega is O(n) in tightest bound.
- In worst case scenario, the updated object Job will be inserted near the end of the list.
- We spend O(n) time to find the correct index, then O(n) again inside the list to insert it,
as the list is sorted.

#### Array List Based Heap PQ:
- Big-O and Big-Omega is O(logn) in tightest bound.
- Inserting and removing elements takes O(logn) in a heap-based PQ.


### 2. Space Complexity
#### Sorted List PQ:
- Space complexity is O(n^2) as we will have to build the sorted List with each entry of the initial array.
- Then, when adding the Jobs object to the list, we will have to traverse the list again to find the proper index.

#### Array List Based Heap PQ:
- Space complexity is O(n) as we will have to build the heap with the Job objects, going through all the elements in the initial array.
- However, adding and removing do not affect the space complexity further.
