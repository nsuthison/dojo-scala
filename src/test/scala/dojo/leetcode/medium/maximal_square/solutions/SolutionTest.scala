package dojo.leetcode.medium.maximal_square.solutions

import org.scalatest._
import org.scalatest.flatspec.AnyFlatSpec
import matchers.should.Matchers._

class SolutionTest extends AnyFlatSpec with GivenWhenThen {
  "maximalSquare" should "return max sqaure size in the matrix" in {
    Given("matrix")
    val matrix = Array[Array[Char]](
      Array('1', '0', '1', '0', '0'),
      Array('1', '0', '1', '1', '1'),
      Array('1', '1', '1', '1', '1'),
      Array('1', '0', '0', '1', '0')
    )

    When("try to find max sqaure size")
    //val result = Solution.maximalSquare(matrix)

    Then("result should be equal to expected")
    //result shouldBe 4
  }
}
