package dojo.leetcode.medium.maximal_square.solutions

object Solution {
  def maximalSquare(matrix: Array[Array[Char]]): Int = {
    ???
  }

  def findMaximalSqureThatFormFrom(
      row: Int,
      column: Int,
      matrix: Array[Array[Char]]
  ): Int = {
    ???
  }

  def isSquare(
      startingRow: Int,
      startingColumn: Int,
      width: Int,
      matrix: Array[Array[Char]]
  ): Boolean = {

    val rowsToCheck = matrix.slice(startingRow, startingRow + width)

    val isRowsLegit = rowsToCheck.map(row => {
      val columnToCheckFromRow =
        row.slice(startingColumn, startingColumn + width)

      columnToCheckFromRow.foldLeft(true)((left, right) => {
        left && (right == '1')
      })
    })

    isRowsLegit.foldLeft(true)(_ && _)
  }
}
