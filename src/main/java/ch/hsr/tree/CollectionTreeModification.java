package ch.hsr.tree;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVErrorStyle;
import ch.hsr.adv.lib.core.logic.domain.styles.presets.ADVWarningStyle;
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

        addNewStyledRoots(module);

        simulateForgetChildToModuleAddition(module, root1Child1);

        SimpleGeneralTreeNode newRoot = addRootAndChildren(module);

        removeRootAndChildren(module, newRoot);

        removeRootAndChildrenWithPartlyRemovedChildren(module, newRoot);
    }

    /**
     * here some children of a tree are already removed. this case should illustrate what
     * happens when someone calls removeRoot with a tree of nodes that are partly removed
     * from the module
     * @param module collection tree module
     * @param newRoot the root
     * @throws ADVException snapshot exception
     */
    private static void removeRootAndChildrenWithPartlyRemovedChildren(CollectionTreeModule<Integer> module, SimpleGeneralTreeNode newRoot) throws ADVException {
        module.remove(newRoot.getChildren().get(0));
        module.removeRoot(newRoot);
        ADV.snapshot(module);
    }

    private static void removeRootAndChildren(CollectionTreeModule<Integer> module, SimpleGeneralTreeNode newRoot) throws ADVException {
        module.removeRoot(newRoot);
        ADV.snapshot(module);
    }

    private static SimpleGeneralTreeNode addRootAndChildren(CollectionTreeModule<Integer> module) throws ADVException {
        SimpleGeneralTreeNode newRoot = new SimpleGeneralTreeNode(989);
        SimpleGeneralTreeNode newRootChild1 = new SimpleGeneralTreeNode(9899);
        SimpleGeneralTreeNode newRootChild2 = new SimpleGeneralTreeNode(98910);

        newRoot.addChild(newRootChild1);
        newRoot.addChild(newRootChild2);

        module.addRoot(newRoot);
        ADV.snapshot(module);

        return newRoot;
    }

    /**
     * this method is used to simulate the case when the parent node was
     * not appended to the module, the result is that the children will
     * be root nodes
     * @param module collection tree module
     * @param root1Child1 first child of the root
     * @throws ADVException snapshot exception
     */
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

    private static void addNewStyledRoots(CollectionTreeModule<Integer> module) throws ADVException {
        List<SimpleGeneralTreeNode> newRoots = Arrays.asList(
                new SimpleGeneralTreeNode(2, new ADVWarningStyle()),
                new SimpleGeneralTreeNode(3, new ADVErrorStyle()));
        module.add(newRoots);
        ADV.snapshot(module);
    }
}
