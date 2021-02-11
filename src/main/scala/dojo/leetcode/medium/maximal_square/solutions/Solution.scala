package dojo.leetcode.medium.maximal_square.solutions

import scala.annotation.tailrec

object Solution {
  def maximalSquare(matrix: Array[Array[Char]]): Int = {

    val maxSquareMatrix = matrix.zipWithIndex.map {
      case (row, rowIdx) =>
        row.zipWithIndex.map {
          case (column, columnIdx) =>
            findMaximalSqureThatFormFrom(rowIdx, columnIdx, 0, matrix)
        }
    }

    def getMax(a: Int, b: Int): Int = {
      if (b > a) b else a
    }

    maxSquareMatrix.foldLeft(0)((foldLeftRowResult, row) =>
      getMax(
        foldLeftRowResult,
        row.foldLeft(0)((foldLeftColumnResult, column) =>
          getMax(foldLeftColumnResult, column)
        )
      )
    )
  }

  @tailrec
  def findMaximalSqureThatFormFrom(
      row: Int,
      column: Int,
      currentSize: Int,
      matrix: Array[Array[Char]]
  ): Int = {
    if (isSquare(row, column, currentSize, matrix)) {
      findMaximalSqureThatFormFrom(row, column, currentSize + 1, matrix)
    } else {
      val lastLegitSize = currentSize - 1
      lastLegitSize * lastLegitSize
    }
  }

  def isSquare(
      startingRow: Int,
      startingColumn: Int,
      width: Int,
      matrix: Array[Array[Char]]
  ): Boolean = {

    if (isSquareToCheckOutOfRange(startingRow, startingColumn, width, matrix))
      false
    else {
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

  def isSquareToCheckOutOfRange(
      startingRow: Int,
      startingColumn: Int,
      width: Int,
      matrix: Array[Array[Char]]
  ): Boolean = {
    val isRowToCheckOutOfRange = startingRow + width > matrix.length
    val isColumnToCheckOutOfRange = startingColumn + width > matrix(0).length

    isRowToCheckOutOfRange || isColumnToCheckOutOfRange
  }
}
