package ch.hsr.tree;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVSuccessStyle;
import ch.hsr.adv.lib.tree.logic.binaryarraytree.BinaryArrayTreeModule;

import java.util.ArrayList;
import java.util.Arrays;

public class BinaryArrayTreeShowcase {
    public static void main(String[] args) throws ADVException {
        ADV.launch(null);
        showBinaryArrayTreeWithArray();

//        showBinaryArrayTreeWithList();
    }

    private static void showBinaryArrayTreeWithList() throws ADVException {
        ArrayList<Double> nodeList = getNodeList();

        BinaryArrayTreeModule<Double> module = new BinaryArrayTreeModule<>(nodeList, "Simple List Showcase");
//        module.setShowArray(true);
        ADV.snapshot(module);

        setStyle(module);

        changeList(nodeList, module);

        changeListSize(nodeList, module);

        removeAndAddNode(nodeList, module);

        removeParentListElement(nodeList, module);
    }

    private static void removeParentListElement(ArrayList<Double> nodeList, BinaryArrayTreeModule<Double> module) throws ADVException {
        nodeList.set(1, null);
        snapshotList(module, nodeList);
    }

    private static void removeAndAddNode(ArrayList<Double> nodeList, BinaryArrayTreeModule<Double> module) throws ADVException {
        nodeList.set(2, null);
        snapshotList(module, nodeList);
        nodeList.set(2, 1.1);
        snapshotList(module, nodeList);
    }

    private static void changeListSize(ArrayList<Double> nodeList, BinaryArrayTreeModule<Double> module) throws ADVException {
        module.setShowArray(true);
        snapshotList(module, nodeList);
        nodeList.set(4, null);
        snapshotList(module, nodeList);
        nodeList.set(5, null);
        snapshotList(module, nodeList);
        nodeList.subList(4, nodeList.size()).clear();
        snapshotList(module, nodeList);
    }

    private static void changeList(ArrayList<Double> nodeList, BinaryArrayTreeModule<Double> module) throws ADVException {
        nodeList.set(4, 1.11);
        snapshotList(module, nodeList);
        nodeList.set(6, null);
        snapshotList(module, nodeList);
    }

    private static void snapshotList(BinaryArrayTreeModule<Double> module, ArrayList<Double> nodeList) throws ADVException {
        module.setArray(nodeList);
        ADV.snapshot(module);
    }

    private static ArrayList<Double> getNodeList() {
        ArrayList<Double> nodeList = new ArrayList<>();
        nodeList.add(null);
        nodeList.add(1.0);
        nodeList.add(1.1);
        nodeList.add(1.2);
        nodeList.add(null);
        nodeList.add(1.12);
        nodeList.add(1.21);
        nodeList.add(null);
        return nodeList;
    }

    private static void showBinaryArrayTreeWithArray() throws ADVException {
        Double[] nodeArray = getNodeArray();

        BinaryArrayTreeModule<Double> module = new BinaryArrayTreeModule<>(nodeArray, "Simple Array Showcase");
//        module.setShowArray(true);
        ADV.snapshot(module);

        setStyle(module);

        changeArray(module, nodeArray);

        changeArraySize(nodeArray, module);

        removeAndAddNode(nodeArray, module);

        removeParentArrayElement(nodeArray, module);
    }

    private static void removeParentArrayElement(Double[] nodeArray, BinaryArrayTreeModule<Double> module) throws ADVException {
        nodeArray[1] = null;
        snapshotArray(module, nodeArray);
    }

    private static void removeAndAddNode(Double[] nodeArray, BinaryArrayTreeModule<Double> module) throws ADVException {
        nodeArray[2] = null;
        snapshotArray(module, nodeArray);
        nodeArray[2] = 1.1;
        snapshotArray(module, nodeArray);
    }

    private static void changeArraySize(Double[] nodeArray, BinaryArrayTreeModule<Double> module) throws ADVException {
        module.setShowArray(true);
        snapshotArray(module, nodeArray);
        nodeArray[4] = null;
        snapshotArray(module, nodeArray);
        nodeArray[5] = null;
        snapshotArray(module, nodeArray);
        Double[] changedArray = Arrays.copyOf(nodeArray, 4);
        snapshotArray(module, changedArray);
    }

    private static Double[] getNodeArray() {
        Double[] nodeArray = new Double[8];
        nodeArray[1] = 1.0;
        nodeArray[2] = 1.1;
        nodeArray[5] = 1.12;
        nodeArray[3] = 1.2;
        nodeArray[6] = 1.21;
        return nodeArray;
    }

    private static void changeArray(BinaryArrayTreeModule<Double> module, Double[] nodeArray) throws ADVException {
        nodeArray[4] = 1.11;
        snapshotArray(module, nodeArray);
        nodeArray[6] = null;
        snapshotArray(module, nodeArray);
    }

    private static void snapshotArray(BinaryArrayTreeModule<Double> module, Double[] nodeArray) throws ADVException {
        module.setArray(nodeArray);
        ADV.snapshot(module);
    }

    private static void setStyle(BinaryArrayTreeModule<Double> module) throws ADVException {
        module.setStyle(1, new ADVSuccessStyle());
        ADV.snapshot(module);
    }
}
