package dojo.leetcode.easy.two_sum.solutions

// Question: https://leetcode.com/problems/two-sum/
class HeadTailRecursiveSolution {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    findTwoSum(nums.toIndexedSeq, target, 0)
  }

  private def findTwoSum(
      indexNums: IndexedSeq[Int],
      target: Int,
      currentIndex: Int
  ): Array[Int] = {
    val anotherNum = target - indexNums.headOption.getOrElse(0)
    val currentFirstTailIndex = currentIndex + 1
    val tail = indexNums.drop(1)

    if (tail.contains(anotherNum)) {
      val indexOfAnotherNum = tail.indexOf(anotherNum) + currentFirstTailIndex
      Array(currentIndex, indexOfAnotherNum)
    } else {
      findTwoSum(tail, target, currentFirstTailIndex)
    }
  }
}
