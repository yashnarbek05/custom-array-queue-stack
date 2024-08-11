package array;

import java.util.Arrays;

public class Array<R> {
    private Object[] obgs;

    private int count;

    public Array(int capacity) {
        obgs = new Object[capacity];
    }

    public Array() {
        obgs = new Object[5];
    }


    //50% 100%
    //todo expand
    public void add(Object obg) {
        obgs[count] = obg;//[10, 20, 30, 40, 50]
        count++;//5
    }

    //todo
    //add(idx, num)

    public R get(int idx) {
        if (count <= idx || idx < 0)
            throw new IllegalArgumentException("Ukam haddingni bil");

        return (R) obgs[idx];
    }

    public R remove(int idx) {
        if (count <= idx || idx < 0)
            throw new IllegalArgumentException("Ukam haddingni bil");

        //[10,20,30,40,50]
        Object el = obgs[idx];

        for (int i = idx; i < count - 1; i++) {
            obgs[i] = obgs[i + 1];
        }
        obgs[count - 1] = 0;
        count--;
        return (R) el;
    }
    //remove(num) - int
    //indexOf(num) - int idx if not -1
    //contains(num) - bool

    public int indexOf(Object obg){
        for (int i = 0; i < count; i++) {
            if (obgs[i].equals(obg)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(Object obg){
        return indexOf(obg) != -1;
    }

    public int size() {
        return count;
    }

    //lastIndexOf(num) - int idx if not -1

    //todo override stringbuilder
    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(obgs, 0, count));
    }
}
