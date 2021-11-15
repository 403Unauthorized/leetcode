# 51. N 皇后 - Hard
# https://leetcode-cn.com/problems/n-queens/

from typing import List

def solveQueens(n: int) -> List[List[str]]:
    ans = []
    rowCol = [[False] * n] * n
    forward = [False] * n
    backward = [False] * n
    queens = [-1] * n
    def isValid(row: int, col: int) -> bool:
        if rowCol[row][col] or forward[row + col] or backward[abs(col - row)]:
            return False
        return True
    def backtrack(row: int):
        if row == n:
            board = list()
            for i in range(n):
                row[queens[i]] = "Q"
                board.append("".join(row))
                row[queens[i]] = "."
            ans.append(board)
            return
        for col in range(n):
            if not isValid(row, col):
                continue
            rowCol[row][col] = True
            forward[col + row] = True
            backward[abs(row-col)] = True
            queens[row] = col
            backtrack(row + 1)
            rowCol[row][col] = False
            forward[col + row] = False
            backward[abs(row-col)] = False
    
    row = ["." * n] * n 
    backtrack(0)
    return ans

    


