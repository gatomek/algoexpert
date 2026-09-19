package pl.gatomek.algoexpert;

public class RemoveDuplicatesFromLinkedList {
    private void stepOver(LinkedList currentNode) {
        LinkedList nextNode = currentNode.next;
        if (nextNode == null) {
            return;
        }

        final int currentValue = currentNode.value;
        final int nextValue = nextNode.value;

        if (currentValue != nextValue) {
            stepOver(nextNode);
        } else {
            currentNode.next = nextNode.next;
            nextNode.next = null;
            stepOver(currentNode);
        }
    }

    public LinkedList removeDuplicatesFromLinkedListRecursive(LinkedList linkedList) {
        stepOver(linkedList);
        return linkedList;
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList currentNode = linkedList;
        while (currentNode != null) {

            LinkedList nextNode = currentNode.next;
            if (nextNode == null) {
                break;
            }

            int currentValue = currentNode.value;
            int nextValue = nextNode.value;

            if (currentValue != nextValue) {
                currentNode = nextNode;
            }
            else {
                currentNode.next = nextNode.next;
                nextNode.next = null;
            }
        }

        return linkedList;
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
