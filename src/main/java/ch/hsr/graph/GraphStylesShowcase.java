package ch.hsr.graph;

import ch.hsr.adv.commons.core.logic.domain.styles.ADVColor;
import ch.hsr.adv.commons.core.logic.domain.styles.ADVStrokeStyle;
import ch.hsr.adv.commons.core.logic.domain.styles.ADVStrokeThickness;
import ch.hsr.adv.commons.core.logic.domain.styles.ADVStyle;
import ch.hsr.adv.commons.core.logic.util.ADVException;
import ch.hsr.adv.lib.bootstrapper.ADV;
import ch.hsr.adv.lib.core.logic.domain.styles.ADVEnumStyle;
import ch.hsr.adv.lib.graph.logic.GraphModule;
import ch.hsr.adv.lib.graph.logic.domain.styles.presets.ADVBackEdgeStyle;
import ch.hsr.adv.lib.graph.logic.domain.styles.presets.ADVCrossEdgeStyle;
import ch.hsr.adv.lib.graph.logic.domain.styles.presets.ADVDiscoveryEdgeStyle;
import ch.hsr.adv.lib.graph.logic.domain.styles.presets.ADVForwardEdgeStyle;
import ch.hsr.graph.model.Edge;
import ch.hsr.graph.model.Graph;
import ch.hsr.graph.model.Vertex;

public class GraphStylesShowcase {

    // styles
    private static final ADVStyle nodeStyle = new ADVEnumStyle(ADVColor.WHITE,
            ADVColor.BLACK,
            ADVStrokeStyle.SOLID,
            ADVStrokeThickness.STANDARD);

    public static void main(String[] args) throws ADVException {
        ADV.launch(args);

        Graph graph = new Graph();
        GraphModule module = new GraphModule("Graph Styles Showcase", graph);

        // ---- 1: insert vertices ---- //
        Vertex<Integer> one = new Vertex<>(1);
        one.setFixedPosX(210);
        one.setFixedPosY(10);
        one.setStyle(nodeStyle);
        Vertex<Integer> two = new Vertex<>(2);
        two.setFixedPosX(220);
        two.setFixedPosY(130);
        two.setStyle(nodeStyle);
        Vertex<Integer> three = new Vertex<>(3);
        three.setFixedPosX(220);
        three.setFixedPosY(80);
        three.setStyle(nodeStyle);
        Vertex<Integer> four = new Vertex<>(4);
        four.setFixedPosX(80);
        four.setFixedPosY(210);
        four.setStyle(nodeStyle);
        Vertex<Integer> five = new Vertex<>(5);
        five.setFixedPosX(10);
        five.setFixedPosY(210);
        five.setStyle(nodeStyle);
        Vertex<Integer> six = new Vertex<>(6);
        six.setFixedPosX(280);
        six.setFixedPosY(210);
        six.setStyle(nodeStyle);
        Vertex<Integer> seven = new Vertex<>(7);
        seven.setFixedPosX(160);
        seven.setFixedPosY(210);
        seven.setStyle(nodeStyle);
        Vertex<Integer> eight = new Vertex<>(8);
        eight.setFixedPosX(110);
        eight.setFixedPosY(10);
        eight.setStyle(nodeStyle);
        Vertex<Integer> nine = new Vertex<>(9);
        nine.setFixedPosX(10);
        nine.setFixedPosY(10);
        nine.setStyle(nodeStyle);
        Vertex<Integer> ten = new Vertex<>(10);
        ten.setFixedPosX(50);
        ten.setFixedPosY(110);
        ten.setStyle(nodeStyle);

        graph.addVertices(one, two, three, four, five, six, seven, eight, nine, ten);

        // ---- 2: insert edges ---- //
        Edge<String> eightNine = new Edge<>(eight, nine, true);
        eightNine.setLabel("Discovery");
        eightNine.setStyle(new ADVDiscoveryEdgeStyle());

        Edge<String> nineEight = new Edge<>(nine, eight, true);
        nineEight.setLabel("Back");
        nineEight.setStyle(new ADVBackEdgeStyle());

        Edge<String> oneEight = new Edge<>(one, eight, true);
        oneEight.setLabel("Discovery");
        oneEight.setStyle(new ADVDiscoveryEdgeStyle());

        Edge<String> oneTen = new Edge<>(one, ten, true);
        oneTen.setLabel("Discovery");
        oneTen.setStyle(new ADVDiscoveryEdgeStyle());

        Edge<String> threeOne = new Edge<>(three, one, true);
        threeOne.setLabel("Back");
        threeOne.setStyle(new ADVBackEdgeStyle());

        Edge<String> threeSix = new Edge<>(three, six, true);
        threeSix.setLabel("Discovery");
        threeSix.setStyle(new ADVDiscoveryEdgeStyle());

        Edge<String> twoSix = new Edge<>(two, six, true);
        twoSix.setLabel("Back");
        twoSix.setStyle(new ADVBackEdgeStyle());

        Edge<String> sixSeven = new Edge<>(six, seven, true);
        sixSeven.setLabel("Discovery");
        sixSeven.setStyle(new ADVDiscoveryEdgeStyle());

        Edge<String> sevenTwo = new Edge<>(seven, two, true);
        sevenTwo.setLabel("Discovery");
        sevenTwo.setStyle(new ADVDiscoveryEdgeStyle());

        Edge<String> tenThree = new Edge<>(ten, three, true);
        tenThree.setLabel("Discovery");
        tenThree.setStyle(new ADVDiscoveryEdgeStyle());

        Edge<String> fourTen = new Edge<>(four, ten, true);
        fourTen.setLabel("Cross");
        fourTen.setStyle(new ADVCrossEdgeStyle());

        Edge<String> fiveTen = new Edge<>(five, ten, true);
        fiveTen.setLabel("Cross");
        fiveTen.setStyle(new ADVCrossEdgeStyle());

        Edge<String> threeSeven = new Edge<>(three, seven, true);
        threeSeven.setLabel("Forward");
        threeSeven.setStyle(new ADVForwardEdgeStyle());

        Edge<String> fourFive = new Edge<>(four, five, true);
        fourFive.setLabel("Forward");
        fourFive.setStyle(new ADVDiscoveryEdgeStyle());


        graph.addEdges(eightNine, nineEight, oneEight, oneTen, threeOne, threeSix, twoSix, sixSeven, sevenTwo,
                tenThree, fourTen, fiveTen, threeSeven, fourFive);

        ADV.snapshot(module, "Insert back reference");
    }

}
