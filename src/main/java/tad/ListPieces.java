package tad;

import model.Coordinate;
import model.Piece;

public class ListPieces {

    private Node head;
    private int size;

    public ListPieces() {
        this.head = null;
        this.size = 0;
    }

    public int size() {
        return size;
    }

    public Node getHead() {
        return head;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Piece elem) {
        Node node = new Node(elem);
        if (isEmpty()) {
            head = node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public int search(Piece elem) {
        int result = -1;
        if (isEmpty())
            return result;
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (node.getElem().equals(elem))
                return i;
            node = node.getNext();
        }
        return result;
    }

    public Piece[] toArray() {
        Piece[] vector = new Piece[size];
        Node node = head;
        for (int i = 0; i < size; i++) {
            vector[i] = node.getElem();
            node = node.getNext();
        }
        return vector;
    }

    public Piece remove(int index) {
        Piece result = null;
        if (isEmpty() || index < 0 || index >= size)
            return result;
        Node node;
        if (index == 0) {
            result = head.getElem();
            head = head.getNext();
        } else {
            Node aux1 = head;
            Node aux2 = head.getNext();
            while (index > 1) {
                aux1 = aux2;
                aux2 = aux2.getNext();
                index--;
            }
            result = aux2.getElem();
            aux1.setNext(aux2.getNext());
        }
        size--;
        return result;
    }

    public Piece get(int index) {
        Piece result = null;
        if (isEmpty() || index < 0 || index >= size)
            return result;
        Node node = head;
        while (index > 0) {
            node = node.getNext();
            index--;
        }
//        for (int i = 0; i <= index; i++) {
//            node = node.getNext();
//        }
        result = node.getElem();
        return result;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public ListPieces addAll(ListPieces list) {
        Node node = list.getHead();
        for (int i = 0; i < list.size(); i++) {
            add(node.getElem());
            node = node.getNext();
        }
        return this;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListPieces))
            return false;
        ListPieces list = (ListPieces) obj;

        if (list.size() != this.size)
            return false;

        Node aux1 = this.head;
        Node aux2 = list.getHead();

        while (aux1 != null) {
            if (!aux1.equals(aux2))
                return false;
            aux1 = aux1.getNext();
            aux2 = aux2.getNext();
        }
        return true;
    }

    @Override
    public String toString() {
        return "{ size: " + size + ", Element: " + ((head == null) ? "}" : head.toString());
    }

    public boolean contains(Piece elem) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (elem.equals(node.getElem()))
                return true;
            node = node.getNext();
        }
        return false;
    }

    public int count(Piece.Type type) {
        Node aux = head;
        int count = 0;
        while (aux != null) {
            if (aux.getElem().getType().equals(type))
                count++;
            aux = aux.getNext();
        }
        return count;
    }

    private class Node {
        private Piece elem;
        private Node next;

        public Node() {
            this.next = null;
        }

        public Node(Piece elem) {
            this.elem = elem;
            this.next = null;
        }

        public Node(Piece elem, Node next) {
            this.elem = elem;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public Piece getElem() {
            return elem;
        }

        public void setElem(Piece elem) {
            this.elem = elem;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return elem + ((next != null) ? ", " + next : " }");
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Node))
                return false;
            Node node = (Node) obj;
            return (node.getElem().equals(elem));
        }

    }
}
