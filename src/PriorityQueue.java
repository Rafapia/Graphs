
public class PriorityQueue<E> {

    /* Fields */
    private PriorityQueueNode head;
    private int size;

    /* Methods */
    public PriorityQueue() {
        this.head = null;
        this.size = 0;
    }

    public void enqueue(E element, double priority) {

        PriorityQueueNode newNode = new PriorityQueueNode(element, priority);
        this.size++;

        // If head is null, add first.
        if (this.head == null) {
            this.head = newNode;
        }

        // If head is has less importance than new node.
        else if (this.head.getPriority() > newNode.getPriority()) {
            newNode.setNextNode(this.head);
            this.head = newNode;
        }

        // If head is not empty, add to appropriate place.
        else  {
            PriorityQueueNode nextNode = this.head;
            while (nextNode.hasNext() && nextNode.getNextNode().getPriority() <= newNode.getPriority()) {
                nextNode = nextNode.getNextNode();
            }

            newNode.setNextNode(nextNode.getNextNode());
            nextNode.setNextNode(newNode);
        }
    }

    public E dequeue() {

        this.size--;
        if (this.head != null) {
            PriorityQueueNode node = this.head;
            this.head = this.head.getNextNode();

            return (E) node.getContent();
        }

        else {
            return null;
        }
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.getSize()==0;
    }

    public boolean contains(E element) {

        PriorityQueueNode currentNode = this.head;

        while (currentNode != null) {

            if (currentNode.getElement().equals(element)) {
                return true;
            }

            currentNode = currentNode.getNextNode();
        }

        return false;
    }

    public void updatePriority(E element, double priority) {


        // If head holds element.
        if (this.head.getElement().equals(element)) {
            this.enqueue(element, priority);
            return;
        }

        // Else, search through linked list.
        else {

            PriorityQueueNode currentNode = this.head;

            while (!currentNode.equals(null) && !currentNode.getNextNode().equals(null)) {

                if (currentNode.getNextNode().getElement().equals(element)) {
                    currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                    this.enqueue(element, priority);
                    this.size--;
                    break;
                }

                currentNode = currentNode.getNextNode();
            }
        }

    }

    public double getPriority(E element) {

        PriorityQueueNode currentNode = this.head;

        while (!currentNode.equals(null)) {

            if (currentNode.getElement().equals(element)) {
                return currentNode.getPriority();
            }

            currentNode = currentNode.getNextNode();
        }

        return Double.POSITIVE_INFINITY;
    }

    public String toString() {
        String out = "[";
        PriorityQueueNode nextNode = this.head;

        for (int i = 0; i < size; i++) {
            out += nextNode.getContent();
            if (i < size-1) {
                out += ", ";
            }
            nextNode = nextNode.getNextNode();
        }

        out += "]";

        return out;
    }


    /* Classes */
    private class PriorityQueueNode<E> {

        /* Fields */
        private E element;
        private double priority;
        private PriorityQueueNode nextNode;


        /* Methods */
        public PriorityQueueNode(E element, double priority) {
            this.element = element;
            this.priority = priority;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public double getPriority() {
            return priority;
        }

        public void setPriority(double priority) {
            this.priority = priority;
        }

        public PriorityQueueNode getNextNode() {
            return this.nextNode;
        }

        public void setNextNode(PriorityQueueNode nextNode) {
            this.nextNode = nextNode;
        }

        public E getContent() {
            return this.element;
        }

        public boolean hasNext() {
            return (this.nextNode != null);
        }

        @Override
        public int hashCode() {
            return this.element.hashCode();
        }
    }
}
