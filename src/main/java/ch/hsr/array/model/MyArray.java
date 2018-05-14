package ch.hsr.array.model;

import ch.hsr.adv.lib.array.logic.ArrayModule;
import ch.hsr.adv.lib.array.logic.domain.Coordinate;
import ch.hsr.adv.lib.core.logic.ADVModule;
import ch.hsr.adv.lib.core.logic.domain.ADVRelation;
import ch.hsr.adv.lib.core.logic.domain.styles.ADVStyle;

import java.util.*;

public class MyArray<T> implements ArrayModule<T> {

    private final String sessionName;
    private T[] array;
    private boolean showObjectRelations = false;
    private final Map<Integer, ADVStyle> styleMap = new HashMap<>();
    private final Map<Integer, Coordinate> coordsMap = new HashMap<>();
    private final List<ADVModule> childModules = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public MyArray(int size, String sessionName) {
        this.array = (T[]) new Object[size];
        this.sessionName = sessionName;
    }

    @Override
    public T[] getArray() {
        return array;
    }

    @Override
    public String getSessionName() {
        return sessionName;
    }

    @Override
    public List<ADVModule> getChildModules() {
        return childModules;
    }

    @Override
    public Map<Integer, ADVStyle> getStyleMap() {
        return styleMap;
    }

    @Override
    public Map<Integer, Coordinate> getCoordinates() {
        return coordsMap;
    }

    @Override
    public boolean showObjectRelations() {
        return showObjectRelations;
    }

    public void setShowObjectRelations(boolean showObjectRelations) {
        this.showObjectRelations = showObjectRelations;
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

    public void setCurrentItem(int index, ADVStyle style) {
        styleMap.put(index, style);
    }

    public void setCoordinates(int index, int x, int y) {
        coordsMap.put(index, new Coordinate(x, y));
    }

    public void clearStyles() {
        styleMap.clear();
    }

}