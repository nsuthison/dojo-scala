package dojo.twoSum

class Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    findTwoSum(nums.toIndexedSeq, target, 0)
  }

  def findTwoSum(
      indexNums: IndexedSeq[Int],
      target: Int,
      index: Int
  ): Array[Int] = {
    val anotherNum = target - indexNums(index)

    if (indexNums.contains(anotherNum)) {
      val indexOfAnotherNum = indexNums.indexOf(anotherNum)
      Array(index, indexNums.indexOf(anotherNum))
    } else {
        findTwoSum(indexNums, target, index+1)
    }
  }
}
