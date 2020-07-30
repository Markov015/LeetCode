class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        for (int i = 0; i < 9; i++) {
            map<char, bool> mp;
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (isdigit(ch)) {
                    if (mp[ch] == false) {
                        mp[ch] = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        for (int j = 0; j < 9; j++) {
            map<char, bool> mp;
            for (int i = 0; i < 9; i++) {
                char ch = board[i][j];
                if (isdigit(ch)) {
                    if (mp[ch] == false) {
                        mp[ch] = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                map<char, bool> mp;
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        char ch = board[i + r][j + c];
                        if (isdigit(ch)) {
                            if (mp[ch] == false) {
                                mp[ch] = true;
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
};
