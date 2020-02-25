package dojo.twoSum

import org.scalatest.FunSuite

class CubeCalculatorTest extends FunSuite {
    //Todo need to refact this
  test(
    "twoSum should return first and second index which summation of both equal to target value"
  ) {
    var solution = new Solution()

    val result = solution.twoSum(Array(2, 7, 11, 15), 9)

    assert(result.contains(0) && result.contains(1))
  }

  test(
    "twoSum should return first and second index which summation of both equal to target valueee"
  ) {
    var solution = new Solution()

    val result = solution.twoSum(Array(3, 2, 4), 6)

    assert(result.contains(1) && result.contains(2))
  }

  test(
    "twoSum should return first and second index which summation of both equal to target valueeeeeeeeee"
  ) {
    var solution = new Solution()

    val result = solution.twoSum(Array(3, 3), 6)

    assert(result.contains(0) && result.contains(1))
  }
}
