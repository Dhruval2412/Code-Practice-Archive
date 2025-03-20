/* Given an array arr[] of positive integers. Find the number of pairs of integers whose difference equals a given number k.
Note: (a, b) and (b, a) are considered the same. Also, the same numbers at different indices are considered different.

Examples:

Input: arr[] = [1, 5, 3, 4, 2], k = 3
Output: 2
Explanation: There are 2 pairs with difference 3,the pairs are {1, 4} and {5, 2} 
Input: arr[] = [8, 12, 16, 4, 0, 20], k = 4
Output: 5
Explanation: There are 5 pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}.
Constraints:
1 <= arr.size() <= 106
1 <= k <= 106
1 <= arri <= 106
*/

class Solution {
    int countPairsWithDiffK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;

        // Populate the HashMap with the frequency of each number
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Iterate through the array
        for (int num : arr) {
            // Check for (num + k)
            if (map.containsKey(num + k)) {
                count += map.get(num + k);
            }
            // Check for (num - k)
            if (map.containsKey(num - k)) {
                count += map.get(num - k);
            }
            // After counting, we can remove the current number from the map to avoid double counting
            map.put(num, map.get(num) - 1);
            if (map.get(num) == 0) {
                map.remove(num);
            }
        }

        return count;
    }
}
//question from the geeksforgeeks
