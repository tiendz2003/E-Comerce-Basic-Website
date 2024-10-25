package Array


/*Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.

Example 1:
Input: nums = [1,2,1]
Output: [1,2,1,1,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
- ans = [1,2,1,1,2,1]*/
fun getConcatenation(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n*2)
    for (i in 0 until  n){
        result[i] = nums[i]
        result[i+n] = nums[i]
    }
    return result
}
fun main(){
    val size:IntArray = intArrayOf(3,2,1)

    println( getConcatenation(size).contentToString())


}