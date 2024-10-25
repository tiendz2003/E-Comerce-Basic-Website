package Array

import java.util.TreeSet
import kotlin.math.abs

/*Given an integer array nums, return true if any value appears at least twice in the array,
 and return false if every element is distinct.

Example 1:
Input: nums = [1,2,3,1]
Output: true
Explanation:
The element 1 occurs at the indices 0 and 3.
Sử Dụng toSet() để so sánh kích tthuowcs hai list
*/
fun containsDuplicate(nums: IntArray): Boolean {
    val seen = HashSet<Int>()
  for (number in nums){
      if(!seen.add(number))
          return true
  }
    return false
}
fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    val hashMap= mutableMapOf<Int,Int>()
      for (i in nums.indices){
          // hashMap = hashMapOf<Int,Int>(i to nums[i])
          if(hashMap.containsKey(nums[i])){
              if(i - hashMap[nums[i]]!! <=k){
                  return true
              }
          }
          // Cập nhật chỉ số của giá trị trong HashMap
          hashMap[nums[i]] = i
      }

    return false
}
//349. Intersection of Two Arrays
fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    val resultArray = mutableListOf<Int>()
    val nums1Set = nums1.toList()
    val nums2Set = nums2.toList()
    for (nums in nums1Set){
        if(nums2Set.contains(nums)){
            resultArray.add(nums)
        }
    }
    return resultArray.toIntArray()
}
//350. Intersection of Two Arrays II
fun intersec(nums1: IntArray, nums2: IntArray): IntArray {
    val resultArray = mutableListOf<Int>()
    val countMap = mutableMapOf<Int,Int>()
    for (nums in nums1){
        countMap[nums] = countMap.getOrDefault(nums,0)+1
    }

    return resultArray.toIntArray()
}
/*
448. Find All Numbers Disappeared in an Array
Example 1:
Input: nums = [4,3,2,7,8,2,3,1]
Output: [5,6]*/
fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val numsize = nums.size
    val result = mutableListOf<Int>()
    val numsSet = nums.toSet()
    for (i in 1..numsize){
        if(!numsSet.contains(i)){
            result.add(i)
        }
    }
    return result
}
fun twoSum(nums: IntArray, target: Int): IntArray {
    val size = nums.size
    val result = mutableSetOf<Int>()
    for (i in 0..<size){
      for (j in 1..<size)
          if(nums[i]+nums[j] == target && i != j){
              result.add(i)
              result.add(j)
          }
    }
    return result.toIntArray()
}
fun twoSum2(nums: IntArray, target: Int): IntArray {
   val numToIndex = mutableMapOf<Int,Int>()
    for (i in nums.indices){
        val anotherNum = target - nums[i]
        if(numToIndex.containsKey(anotherNum)){
            return intArrayOf(numToIndex[anotherNum]!!,i)
        }
        numToIndex[nums[i]] = i
    }
    return intArrayOf()
}

/*Phân tích:
LeetCode #220: Contains Duplicate III
Điều kiện về chỉ số (abs(i - j) <= indexDiff):
Có nghĩa là chúng ta chỉ cần xét các phần tử nằm trong cửa sổ có độ rộng indexDiff
Ví dụ: nếu indexDiff = 3, khi xét nums[4], chỉ cần xét các phần tử từ nums[1] đến nums[3]
Điều kiện về giá trị (abs(nums[i] - nums[j]) <= valueDiff):
Có nghĩa là chênh lệch giá trị giữa hai phần tử không được vượt quá valueDiff
Ví dụ: nếu valueDiff = 3, thì |nums[i] - nums[j]| phải <= 3*/

fun containsNearbyAlmostDuplicate(nums: IntArray, indexDiff: Int, valueDiff: Int): Boolean {
  val window = TreeSet<Int>()
    for (i in nums.indices){
        val current = nums[i]

        val ceiling = window.ceiling(current)
        if(ceiling != null && ceiling - current <= valueDiff ){
            return true
        }
        val floor = window.floor(current)
        if(floor != null && current - floor <= valueDiff ){
            return true
        }
        window.add(current)
        if(i >= indexDiff){
            window.remove(nums[i - indexDiff])
        }
    }
    return false
}
/*
128. Longest Consecutive Sequence
Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9*/
fun longestConsecutive(nums: IntArray): Int {
    if(nums.isEmpty()){
        return 0
    }
    val numsSet = nums.toSet()
    var maxLength = 1
    for (num in numsSet){
        if(!numsSet.contains(num - 1 )){
            var currentNum = num
            var currentLength = 1
            while (numsSet.contains(currentNum + 1)){
                currentNum++
                currentLength++
            }
            maxLength = maxOf(maxLength,currentLength)
        }
    }

    return maxLength
}
fun canConstruct(ransomNote: String, magazine: String): Boolean {

}
fun main() {
  /*  val nums1 = intArrayOf(1, 2, 2, 1)
    val nums2 = intArrayOf(2)
    println("Intersection: ${intersec(nums1, nums2).joinToString()}") // Output: [2]*/
    val nums = intArrayOf(100,4,200,1,3,2)
    println(longestConsecutive(nums))
   /* val nums3 = intArrayOf(4, 9, 5)
    val nums4 = intArrayOf(9, 4, 9, 8, 4)
    println("Intersection: ${intersection(nums3, nums4).joinToString()}") // Output: [9, 4]

    val nums5 = intArrayOf(1, 3, 5, 7)
    val nums6 = intArrayOf(2, 4, 6, 8)
    println("Intersection: ${intersection(nums5, nums6).joinToString()}") // Output: []

    val nums7 = intArrayOf(1, 2, 3, 4, 5)
    val nums8 = intArrayOf(1, 1, 1, 1, 1)
    println("Intersection: ${intersection(nums7, nums8).joinToString()}") // Output: [1]*/
}
