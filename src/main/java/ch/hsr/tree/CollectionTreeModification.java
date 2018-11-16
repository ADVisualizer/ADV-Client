package ch.hsr.tree;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.tree.logic.collectiontree.CollectionTreeModule;
import ch.hsr.tree.model.SimpleGeneralTreeNode;

import java.util.Arrays;
import java.util.List;

public class CollectionTreeModification {
    public static void main(String[] args) throws ADVException {
        ADV.launch(null);

        CollectionTreeModule<Integer> module = new CollectionTreeModule<>("Collection Tree Modification");

        SimpleGeneralTreeNode root1 = new SimpleGeneralTreeNode(10);
        SimpleGeneralTreeNode root2 = new SimpleGeneralTreeNode(11);
        SimpleGeneralTreeNode root1Child1 = new SimpleGeneralTreeNode(101);
        SimpleGeneralTreeNode root1Child2 = new SimpleGeneralTreeNode(102);
        SimpleGeneralTreeNode root2Child1 = new SimpleGeneralTreeNode(111);
        SimpleGeneralTreeNode child1Child1 = new SimpleGeneralTreeNode(1111);

        root1.addChild(root1Child1);
        root1.addChild(root1Child2);
        root2.addChild(root2Child1);
        root2Child1.addChild(child1Child1);

        module.add(root1);
        module.add(root2);
        module.add(root1Child1);
        module.add(root1Child2);
        module.add(root2Child1);
        module.add(child1Child1);

        ADV.snapshot(module);

        modifyForest(module, root1Child2, child1Child1);

        addNewRoots(module);

        simulateForgetChildToModuleAddition(module, root1Child1);
    }

    private static void simulateForgetChildToModuleAddition(CollectionTreeModule<Integer> module, SimpleGeneralTreeNode root1Child1) throws ADVException {
        SimpleGeneralTreeNode parent = new SimpleGeneralTreeNode(5);
        SimpleGeneralTreeNode child1 = new SimpleGeneralTreeNode(51);
        SimpleGeneralTreeNode child2 = new SimpleGeneralTreeNode(52);
        root1Child1.addChild(parent);
        parent.addChild(child1);
        parent.addChild(child2);
        module.add(child1);
        module.add(child2);
        ADV.snapshot(module);
    }

    private static void modifyForest(CollectionTreeModule<Integer> module, SimpleGeneralTreeNode root1Child2, SimpleGeneralTreeNode child1Child1) throws ADVException {
        module.remove(child1Child1);
        ADV.snapshot(module);

        SimpleGeneralTreeNode newChild = new SimpleGeneralTreeNode(1021);
        root1Child2.addChild(newChild);
        module.add(newChild);
        ADV.snapshot(module);
    }

    private static void addNewRoots(CollectionTreeModule<Integer> module) throws ADVException {
        List<SimpleGeneralTreeNode> newRoots = Arrays.asList(
                new SimpleGeneralTreeNode(2), new SimpleGeneralTreeNode(3));
        module.add(newRoots);
        ADV.snapshot(module);
    }
}
