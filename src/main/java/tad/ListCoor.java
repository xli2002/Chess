package tad;

import model.Coordinate;

public class ListCoor {
    private Node head;
    private int size;

    public ListCoor(){
        this.head = null;
        this.size = 0;
    }

    public int size() { return size;}
    public Node getHead() { return head;}
    public boolean isEmpty() { return size==0;}

    public void add(Coordinate elem){
        Node node = new Node(elem);
        if(isEmpty()){
            head=node;
        } else {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public int search(Coordinate elem){
        int result = -1;
        if(isEmpty())
            return result;
        Node node = head;
        for (int i = 0; i < size; i++) {
            if(node.getElem().equals(elem))
                return i;
            node = node.getNext();
        }
        return result;
    }

    public Coordinate[] toArray(){
        Coordinate[] vector = new Coordinate[size];
        Node node = head;
        for (int i = 0; i < size; i++) {
            vector[i] = node.getElem();
            node = node.getNext();
        }
        return vector;
    }

    public Coordinate remove(int index){
        Coordinate result = null;
        if(isEmpty() || index < 0 || index>=size)
            return result;
        Node node;
        if(index==0){
            result = head.getElem();
            head = head.getNext();
        } else {
            Node aux1 = head;
            Node aux2 = head.getNext();
            while(index>1){
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

    public Coordinate get(int index){
        Coordinate result = null;
        if (isEmpty() || index <0 || index>=size)
            return result;
        Node node = head;
        while(index>0){
            node = node.getNext();
            index--;
        }
//        for (int i = 0; i <= index; i++) {
//            node = node.getNext();
//        }
        result = node.getElem();
        return result;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public ListCoor addAll(ListCoor list){
        Node node = list.getHead();
        for (int i = 0; i < list.size(); i++) {
            add(node.getElem());
            node = node.getNext();
        }
        return this;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof ListCoor))
            return false;
        ListCoor list = (ListCoor) obj;

        if(list.size() != this.size)
            return false;

        Node aux1 = this.head;
        Node aux2 = list.getHead();

        while(aux1 != null){
            if(!aux1.equals(aux2))
                return false;
            aux1 = aux1.getNext();
            aux2 = aux2.getNext();
        }
        return true;
    }

    @Override
    public String toString(){
        return "{ size: " + size + ", Element: " + ((head==null) ? "}" : head.toString());
    }

    public boolean contains(Coordinate elem){
        Node node = head;
        for (int i = 0; i < size; i++) {
            if(elem.equals(node.getElem()))
                return true;
            node = node.getNext();
        }
        return false;
    }




    private class Node {
        private Coordinate elem;
        private Node next;

        public Node(){
            this.next= null;
        }

        public Node(Coordinate elem){
            this.elem=elem;
            this.next=null;
        }

        public Node(Coordinate elem, Node next){
            this.elem = elem;
            this.next = next;
        }

        public Node getNext() {
            return next;
        }

        public Coordinate getElem() {
            return elem;
        }

        public void setElem(Coordinate elem) {
            this.elem = elem;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString(){
            return elem + ((next!=null)?", " + next : " }");
        }

        @Override
        public boolean equals(Object obj){
            if(!(obj instanceof Node))
                return false;
            Node node = (Node) obj;
            return (node.getElem().equals(elem));
        }

    }

}
