package ch.hsr.array.model;

public class MyArray<T> {

    private T[] array;

    @SuppressWarnings("unchecked")
    public MyArray(T[] array) {
        this.array = array;
    }

    public int getSize() {
        return array.length;
    }

    public void set(int index, T value) {
        array[index] = value;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] getArray() {
        return array;
    }

    /**
     * Change the size of the array. Looses content if the new array's length is smaller than the old array's length
     *
     * @param newArray new array to be set
     */
    public void changeSize(T[] newArray) {
        int minLenght = Math.min(array.length, newArray.length);
        System.arraycopy(array, 0, newArray, 0, minLenght);

        this.array = newArray;
    }
}