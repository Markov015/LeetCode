class Solution {
    public Boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Map<Character, Boolean> map = new HashMap<>();
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (Character.isDigit(ch)) {
                    if (!map.containsKey(ch)) {
                        map.put(ch, true);
                    } else {
                        return false;
                    }
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            Map<Character, Boolean> map = new HashMap<>();
            for (int i = 0; i < 9; i++) {
                char ch = board[i][j];
                if (Character.isDigit(ch)) {
                    if (!map.containsKey(ch)) {
                        map.put(ch, true);
                    } else {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                Map<Character, Boolean> map = new HashMap<>();
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        char ch = board[i + r][j + c];
                        if (Character.isDigit(ch)) {
                            if (!map.containsKey(ch)) {
                                map.put(ch, true);
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
