Two-Pointer Technique - O(n) time and O(1) space
The idea of this technique is to begin with two corners of the given array. We use two index variables left and right to traverse from both corners.

Initialize: left = 0, right = n - 1
Run a loop while left < right, do the following inside the loop

Compute current sum, sum = arr[left] + arr[right]
If the sum equals the target, we’ve found the pair.
If the sum is less than the target, move the left pointer to the right to increase the sum.
If the sum is greater than the target, move the right pointer to the left to decrease the sum.
>>>>>>>>>>>>>>.Co-Pilot>>>>>>>>>>>>>>>
>
I'll explain the Two-Pointer technique, list common variants, cover edge cases and complexity, and then show three clear Java examples (runnable) with short usage notes.
Plan / checklist
Explain the idea and when to use two pointers
Describe common variants and complexity
List edge cases and quick tips
Provide three Java examples (sorted-two-sum, remove-duplicates-in-place, max-area) in one runnable file
Show how to compile and run the example
**What the Two-Pointer technique is (short)**
Two pointers = using two indices that move through the input (usually an array or list) to achieve an O(n) pass with O(1) extra space.
Typical use-cases: arrays or sequences where order (often sorted) or relative positions matter. Works well for problems where you can make a greedy decision by moving one pointer at a time.
Common variants
Opposite-ends (left, right)
Start left = 0, right = n - 1
Move left or right inward based on comparison (e.g., sum too small → left++, sum too big → right--).
Examples: two-sum on sorted array, container-with-most-water.
Fast/slow (also called slow-fast)
One pointer moves faster (e.g., step 2) and the other slower (step 1).
Useful for cycle detection (Floyd), finding middle of linked list, removing nth-from-end patterns.
Slow-write / fast-read (read and write pointers)
One pointer reads all elements, another writes values to compact the array in-place.
Examples: remove duplicates, move zeros.
Complexity
Time: O(n) for a single pass (sometimes O(n log n) if you must sort first).
Space: O(1) extra (in-place). If array must be sorted and you sort it first, sorting cost applies.
>>>>When to use vs when not to use>>>
Use: when array is sorted or when relative positions matter and you can decide pointer movement greedily.
Use hash-based approaches (O(n) time, O(n) extra) if array is unsorted and you need arbitrary pair detection without sorting and order can't be changed.
Edge cases to watch
Empty or null arrays
Single-element arrays
All duplicates
Negative numbers (if logic assumes non-negative)
When input must remain unmodified (use a copy or other strategy)
Java examples (all in one file). This file demonstrates:
findPairWithSumSorted: opposite-ends two-sum on sorted array
removeDuplicatesSorted: slow-write pattern
maxArea: container with most water (opposite-ends greedy)
You can copy this into a file named TwoPointerExamples.java and run it.
// TwoPointerExamples.java
public class TwoPointerExamples {

    // 1) Two-sum for a sorted array: find any pair of values that sums to target.
    // Returns an int[] of the pair values (not indices), or null if none.
    public static int[] findPairWithSumSorted(int[] arr, int target) {
        if (arr == null || arr.length < 2) return null;
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            if (sum == target) {
                return new int[]{arr[l], arr[r]};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return null;
    }

    // 2) Remove duplicates from a sorted array in-place.
    // Returns the new length after removing duplicates (similar to LeetCode 26).
    // The first 'len' elements of the array will contain the unique values.
    public static int removeDuplicatesSorted(int[] nums) {
        if (nums == null) return 0;
        int n = nums.length;
        if (n == 0) return 0;
        int write = 1; // position to write next unique
        for (int read = 1; read < n; read++) {
            if (nums[read] != nums[write - 1]) {
                nums[write] = nums[read];
                write++;
            }
        }
        return write;
    }

    // 3) Container With Most Water (maximize area) - opposite ends greedy.
    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) return 0;
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            int area = h * (r - l);
            if (area > max) max = area;
            // Move the pointer at the smaller height inward to possibly find larger area
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    // Simple demonstration in main
    public static void main(String[] args) {
        // Example 1: sorted two-sum
        int[] sorted = {1, 2, 3, 4, 6, 8};
        int target = 10;
        int[] pair = findPairWithSumSorted(sorted, target);
        System.out.println("Two-sum (sorted) target " + target + ": " +
            (pair == null ? "none" : pair[0] + " + " + pair[1]));

        // Example 2: remove duplicates in-place
        int[] dup = {0, 0, 1, 1, 1, 2, 2, 3, 3};
        int newLen = removeDuplicatesSorted(dup);
        System.out.print("After removeDuplicatesSorted, length = " + newLen + ", values = ");
        for (int i = 0; i < newLen; i++) {
            System.out.print(dup[i] + (i + 1 < newLen ? "," : ""));
        }
        System.out.println();

        // Example 3: max area
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println("Max area = " + maxArea(heights));
    }
}
How to compile and run (zsh / macOS)
Save as TwoPointerExamples.java
Compile and run with javac/java:
javac TwoPointerExamples.java
java TwoPointerExamples
Expected output
Two-sum (sorted) target 10: 2 + 8 (or 4 + 6 depending on array)
After removeDuplicatesSorted, length = 4, values = 0,1,2,3
Max area = 49
Notes, tips and variations
If your input is not sorted and you want two-sum, either:
Sort first (O(n log n)) then use two pointers, or
Use a HashMap for O(n) time and O(n) space to get indices.
For linked lists, use fast/slow pointers to find middle or detect cycles (Floyd's algorithm).
For in-place array transformations, prefer the read/write pointer pattern when you need to compact or partition the array.
Always check for null/empty inputs and document whether your function mutates the input array.
If you'd like, I can:
Add this file into your repo (I can create the Java file and run it here).
Convert these examples into JUnit tests and add them to your Maven project.
Show a two-pointer example for linked lists (e.g., find middle or detect cycle).
Which of those would you like next?