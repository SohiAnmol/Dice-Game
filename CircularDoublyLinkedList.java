public class CircularDoublyLinkedList<E> {
    Node<E> head;

    public CircularDoublyLinkedList() {
        this.head = null;
    }

    public int size() {
        int count = 0;
        Node<E> current = this.head;
        while (current != null) {
            count++;
            current = current.next;
            if (current == this.head) {
                break;
            }
        }
        return count;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public Node<E> first() {
        return this.head;
    }

    public Node<E> last() {
        if (this.head == null) {
            return null;
        }
        Node<E> current = this.head;
        while (current.next != this.head) {
            current = current.next;
        }
        return current;
    }

    public void addFirst(E data) {
        Node<E> newNode = new Node<E>(data);
        if (this.head == null) {
            this.head = newNode;
            this.head.next = this.head;
            this.head.prev = this.head;
        } else {
            newNode.next = this.head;
            newNode.prev = this.head.prev;
            this.head.prev.next = newNode;
            this.head.prev = newNode;
            this.head = newNode;
        }
    }

    public void addLast(E data) {
        Node<E> newNode = new Node<E>(data);
        if (this.head == null) {
            this.head = newNode;
            this.head.next = this.head;
            this.head.prev = this.head;
        } else {
            newNode.next = this.head;
            newNode.prev = this.head.prev;
            this.head.prev.next = newNode;
            this.head.prev = newNode;
        }
    }

    public void remove(E data) {
        if (this.head == null) {
            return;
        }
        Node<E> current = this.head;
        do {
            if (current.data.equals(data)) {
                if (current == this.head) {
                    this.head = this.head.next;
                }
                current.prev.next = current.next;
                current.next.prev = current.prev;
                return;
            }
            current = current.next;
        } while (current != this.head);
    }

    public Node<E> removeFirst() {
        if (this.head == null) {
            return null;
        }
        Node<E> removedNode = this.head;
        if (this.head.next == this.head) {
            this.head = null;
        } else {
            this.head.prev.next = this.head.next;
            this.head.next.prev = this.head.prev;
            this.head = this.head.next;
        }
        return removedNode;
    }

    public Node<E> removeLast() { // return the removed node
        if (this.head == null) {
            return null;
        }
        Node<E> removedNode = this.head.prev;
        if (this.head.next == this.head) {
            this.head = null;
        } else {
            this.head.prev.prev.next = this.head;
            this.head.prev = this.head.prev.prev;
        }
        return removedNode;
    }

    public void rotate() {
        if (this.head == null) {
            return;
        }
        this.head = this.head.next;
    }

    public void reverse() {
        if (this.head == null) {
            return;
        }
        Node<E> current = this.head;
        do {
            Node<E> temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = current.prev;
        } while (current != this.head);
        this.head = this.head.next;
    }

    public String toString() {
        String result = "";
        if (this.head == null) {
            return result;
        }
        Node<E> current = this.head;
        do {
            result += current.data.toString() + ", ";
            current = current.next;
        } while (current != this.head);
        return result.substring(0, result.length() - 2);

    }

}
