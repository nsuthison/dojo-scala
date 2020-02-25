package dojo.twoSum

import scala.annotation.tailrec

class Solution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    findTwoSum(nums.toIndexedSeq, target, 0)
  }

  private def findTwoSum(
      indexNums: IndexedSeq[Int],
      target: Int,
      currentIndex: Int
  ): Array[Int] = {
    val anotherNum = target - indexNums.head
    val currentFirstTailIndex = currentIndex + 1

    if (indexNums.tail.contains(anotherNum)) {
      val indexOfAnotherNum = indexNums.indexOf(anotherNum)
      Array(currentIndex, indexNums.tail.indexOf(anotherNum) + currentFirstTailIndex)
    } else {
      findTwoSum(indexNums.tail, target, currentFirstTailIndex)
    }
  }
}
