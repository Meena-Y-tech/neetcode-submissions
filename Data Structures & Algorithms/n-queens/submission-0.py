class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        col = set()
        posDg = set() # r+c
        negDg = set() # r-c

        result = []
        board = [["."]  * n for i in range(n)]

        def backtrack(r):
            if r == n:
                copy = ["".join(row) for row in board]
                result.append(copy)
                return 

            for c in range(n):
                if c in col or (r+c) in posDg or (r-c) in negDg:
                    continue

                col.add(c)
                posDg.add(r+c)
                negDg.add(r-c)
                board[r][c] = "Q"

                backtrack(r + 1)

                col.remove(c)
                posDg.remove(r+c)
                negDg.remove(r-c)
                board[r][c] = "."


        backtrack(0)
        return result