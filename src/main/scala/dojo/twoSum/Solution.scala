package dojo.twoSum

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
    val tail = indexNums.tail

    if (tail.contains(anotherNum)) {
      val indexOfAnotherNum = tail.indexOf(anotherNum) + currentFirstTailIndex
      Array(currentIndex, indexOfAnotherNum)
    } else {
      findTwoSum(tail, target, currentFirstTailIndex)
    }
  }
}
