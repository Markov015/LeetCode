class Solution {
    public int addDigits(int num) {
        while (num > 9) {
            num = sumDigits(num);
        }
        return num;
    }

    private int sumDigits(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

class Solution {
    public int addDigits(int num) {
        return (num - 1) % 9 + 1;
    }
}
