class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        for i in range(9):
            map = {}
            for j in range(9):
                s = board[i][j]
                if s.isdigit():
                    if s in map:
                        return False
                    else:
                        map[s] = True
        for j in range(9):
            map = {}
            for i in range(9):
                s = board[i][j]
                if s.isdigit():
                    if s in map:
                        return False
                    else:
                        map[s] = True

        for i in range(0, 9, 3):
            for j in range(0, 9, 3):
                map = {}
                for r in range(3):
                    for c in range(3):
                        s = board[i + r][j + c]
                        if s.isdigit():
                            if s in map:
                                return False
                            else:
                                map[s] = True
        return True
