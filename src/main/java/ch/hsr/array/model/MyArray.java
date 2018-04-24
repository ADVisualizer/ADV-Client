package ch.hsr.array.model;

import ch.adv.lib.array.logic.ArrayModule;
import ch.adv.lib.array.domain.Coordinate;
import ch.adv.lib.core.logic.domain.ADVRelation;
import ch.adv.lib.core.logic.domain.styles.ADVStyle;

import java.util.*;

public class MyArray<T> implements ArrayModule<T> {

    private final String sessionName;
    private T[] array;
    private boolean showObjectRelations = false;
    private Map<Integer, ADVStyle> styleMap = new HashMap<>();
    private Map<Integer, Coordinate> coordsMap = new HashMap<>();
    private List<ADVRelation> advRelations = new ArrayList<>();

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
    public Map<Integer, ADVStyle> getStyleMap() {
        return styleMap;
    }

    @Override
    public Map<Integer, Coordinate> getCoordinates() {
        return coordsMap;
    }

    @Override
    public List<ADVRelation> getRelations() {
        return advRelations;
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

    public void addRelation(ADVRelation... relations) {
        Arrays.stream(relations).forEach(r -> advRelations.add(r));
    }

    public void clearStyles() {
        styleMap.clear();
    }

    public void clearRelations() {
        advRelations.clear();
    }
}