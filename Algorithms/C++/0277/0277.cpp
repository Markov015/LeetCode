/* The knows API is defined for you.
      bool knows(int a, int b); */

class Solution {
public:
    int findCelebrity(int n) {
        for (int i = 0; i < n; i++) {
            bool celebrity = true;
            for (int j = 0; j < n; j++) {
                if (j != i && (knows(i, j) || !knows(j, i))) {
                    celebrity = false;
                    break;
                }
            }
            if (celebrity) {
                return i;
            }
        }
        return -1;
    }
};
