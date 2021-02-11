package dojo.leetcode.medium.maximal_square.solutions

case class MaximalSquareTestCase(
    matrix: Array[Array[Char]],
    expectedResult: Int
)

case class IsSquareTestCase(
    matrix: Array[Array[Char]],
    startingRow: Int,
    startingColumn: Int,
    width: Int,
    expected: Boolean
)
