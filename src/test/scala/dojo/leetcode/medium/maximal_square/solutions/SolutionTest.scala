package dojo.leetcode.medium.maximal_square.solutions

import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import matchers.should.Matchers._

class SolutionTest extends AnyFlatSpec with GivenWhenThen {

  val maximalSquareTestCases = Array(
    MaximalSquareTestCase(
      testId = 1,
      matrix = Array[Array[Char]](
        Array('1', '0', '1', '0', '0'),
        Array('1', '0', '1', '1', '1'),
        Array('1', '1', '1', '1', '1'),
        Array('1', '0', '0', '1', '0')
      ),
      expectedResult = 4
    ),
    MaximalSquareTestCase(
      testId = 2,
      matrix = Array[Array[Char]](
        Array('0', '1'),
        Array('1', '0')
      ),
      expectedResult = 1
    ),
    MaximalSquareTestCase(
      testId = 3,
      matrix = Array[Array[Char]](
        Array('0')
      ),
      expectedResult = 0
    )
  )
  for (MaximalSquareTestCase(testId, matrix, expectedResult) <- maximalSquareTestCases) {
    s"maximalSquare test case: ${testId.toString}" should "return max sqaure size in the matrix" in {
      Given("matrix")

      When("try to find max sqaure size")
      val result = Solution.maximalSquare(matrix)

      Then("result should be equal to expected")
      result shouldBe expectedResult
    }
  }

  "isSquare" should "return true when all of the block in interested matrix contain 1" in {
    Given("matrix")
    val matrix = Array[Array[Char]](
      Array('1', '0', '1', '0', '0'),
      Array('1', '0', '1', '1', '1'),
      Array('1', '1', '1', '1', '1'),
      Array('1', '0', '0', '1', '0')
    )

    val testCases = Array[IsSquareTestCase](
      IsSquareTestCase(
        matrix,
        1,
        2,
        2,
        true
      ),
      IsSquareTestCase(
        matrix,
        1,
        1,
        2,
        false
      ),
      IsSquareTestCase(
        matrix,
        0,
        0,
        1,
        true
      ),
      IsSquareTestCase(
        matrix,
        0,
        1,
        1,
        false
      ),
      IsSquareTestCase(
        matrix,
        1,
        4,
        2,
        false
      )
    )

    for (testCase <- testCases) {
      When(
        s"try to find max sqaure size from row: ${testCase.startingRow.toString}, column: ${testCase.startingColumn.toString}, width: ${testCase.width.toString}"
      )
      val result = Solution.isSquare(
        testCase.startingRow,
        testCase.startingColumn,
        testCase.width,
        matrix
      )

      Then(s"result should be equal to ${testCase.expected.toString}")
      result shouldBe testCase.expected
    }
  }
}
