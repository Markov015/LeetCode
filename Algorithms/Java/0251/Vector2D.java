import java.util.NoSuchElementException;

class Vector2D {
    private int[][] v;
    private int inner = 0;
    private int outer = 0;

    public Vector2D(int[][] v) {
        this.v = v;
    }

    public int next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return v[outer][inner++];
    }

    public boolean hasNext() {
        toNext();
        return outer < v.length;
    }

    private void toNext() {
        while (outer < v.length && inner == v[outer].length) {
            inner = 0;
            ++outer;
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(v);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
