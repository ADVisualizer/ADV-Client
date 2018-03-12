package ch.hsr;

import ch.adv.lib.ADVDefaultStyle;
import ch.adv.lib.ADVStyle;
import ch.adv.lib.array.ADVArray;

import java.util.HashMap;
import java.util.Map;

public class MyArray implements ADVArray<String> {

    private String[] array;
    private Map<Integer, ADVStyle> styleMap;

    public MyArray(int size) {
        this.array = new String[size];
        this.styleMap = new HashMap<>();
    }

    @Override
    public String[] getArray() {
        return array;
    }

    @Override
    public Map<Integer, ADVStyle> getStyleMap() {
        return styleMap;
    }

    public int getSize() {
        return array.length;
    }

    public void set(int index, String value) {
        array[index] = value;
    }

    public void setCurrentItem(int index) {
        ADVStyle blueStyle = new ADVDefaultStyle();
        styleMap.put(index, blueStyle);
    }

}