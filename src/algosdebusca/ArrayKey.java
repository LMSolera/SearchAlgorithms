package algosdebusca;

import java.util.Arrays;

public class ArrayKey {
    private final int[] array;
    
    public ArrayKey (int[] array) {
        this.array = array;
    }
    
    public int[] getArray () {
        return this.array;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayKey arrayKey = (ArrayKey)o;
        return Arrays.equals(array, arrayKey.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }
}
