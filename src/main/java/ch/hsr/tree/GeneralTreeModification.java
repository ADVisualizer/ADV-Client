package ch.hsr.tree;

import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.tree.logic.generaltree.GeneralTreeModule;
import ch.hsr.tree.model.SimpleGeneralTreeNode;

public class GeneralTreeModification {
    public static void main(String[] args) throws ADVException {
        ADV.launch(null);
        SimpleGeneralTreeNode root = buildTree();

        GeneralTreeModule module = new GeneralTreeModule(root, "General Tree Modification");
        ADV.snapshot(module);

        SimpleGeneralTreeNode leftleft = new SimpleGeneralTreeNode(4);
        root.getChildren().get(0).addChild(leftleft);
        ADV.snapshot(module);
        SimpleGeneralTreeNode rightleft = root.getChildren().get(1).getChildren().get(0);
        root.getChildren().get(1).removeChild(rightleft);
        ADV.snapshot(module);

        SimpleGeneralTreeNode rootLeft = root.getChildren().get(0);
        root.removeChild(rootLeft);
        ADV.snapshot(module);
    }

    private static SimpleGeneralTreeNode buildTree() {
        SimpleGeneralTreeNode root = new SimpleGeneralTreeNode(1);
        SimpleGeneralTreeNode rootleft = new SimpleGeneralTreeNode(2);
        SimpleGeneralTreeNode rootright = new SimpleGeneralTreeNode(3);
        SimpleGeneralTreeNode leftright = new SimpleGeneralTreeNode(5);
        SimpleGeneralTreeNode rightleft = new SimpleGeneralTreeNode(6);

        root.addChild(rootleft);
        root.addChild(rootright);
        rootleft.addChild(leftright);
        rootright.addChild(rightleft);
        return root;
    }
}
