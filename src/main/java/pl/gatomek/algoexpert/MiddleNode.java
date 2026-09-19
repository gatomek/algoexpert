package pl.gatomek.algoexpert;

public class MiddleNode {
    public LinkedList middleNode(LinkedList linkedList) {
        LinkedList currentNode = linkedList;
        LinkedList middleNode = currentNode;

        int counter = 0;
        while (currentNode != null) {

            if (currentNode.next != null) {
                currentNode = currentNode.next;
            } else {
                break;
            }

            if (counter % 2 == 0) {
                middleNode = middleNode.next;
            }

            counter++;
        }

        return middleNode;
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
}
