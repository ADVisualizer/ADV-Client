package ch.hsr;

import ch.adv.lib.array.ArrayModule;
import ch.adv.lib.array.domain.Coordinate;
import ch.adv.lib.core.domain.ADVRelation;
import ch.adv.lib.core.domain.styles.ADVStyle;

import java.util.*;

public class MyArray implements ArrayModule<String> {

    private final String sessionName;
    private String[] array;
    private Map<Integer, ADVStyle> styleMap = new HashMap<>();
    private Map<Integer, Coordinate> coordsMap = new HashMap<>();
    private List<ADVRelation> advRelations = new ArrayList<>();

    public MyArray(int size, String sessionName) {
        this.array = new String[size];
        this.sessionName = sessionName;
    }

    @Override
    public String[] getArray() {
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

    public int getSize() {
        return array.length;
    }

    public void set(int index, String value) {
        array[index] = value;
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
}