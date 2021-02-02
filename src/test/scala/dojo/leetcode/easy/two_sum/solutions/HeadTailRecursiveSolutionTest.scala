package dojo.leetcode.easy.two_sum.solutions

import org.scalatest.funsuite.AnyFunSuite

class HeadTailRecursiveSolutionTest extends AnyFunSuite {
  val testCases = Seq(
    TestCase(
      testId = 1,
      nums = Array(2, 7, 11, 15),
      targetNumber = 9,
      expectedIndices = Array(0, 1)
    ),
    TestCase(
      testId = 2,
      nums = Array(3, 2, 4),
      targetNumber = 6,
      expectedIndices = Array(1, 2)
    ),
    TestCase(
      testId = 3,
      nums = Array(3, 3),
      targetNumber = 6,
      expectedIndices = Array(0, 1)
    )
  )

  for (TestCase(testId, nums, targetNumber, expectedIndices) <- testCases) {
    test(
      s"Test case ${testId.toString()} : twoSum should return array of first and second index which summation of both equal to target number: ${targetNumber.toString}"
    ) {
      val solution = new HeadTailRecursiveSolution()

      val result = solution.twoSum(nums, targetNumber)

      for (index <- expectedIndices) {
        assert(result.contains(index))
      }
    }
  }
}
