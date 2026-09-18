package pl.gatomek.algoexpert;

import java.util.ArrayList;
import java.util.List;

// todo: add non-recursive method

public class DepthFirstSeach {
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            array.add(name);

            for (Node n : children) {
                array = n.depthFirstSearch(array);
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
