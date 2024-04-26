
public class LinkedList<T>
{
    private Node<T> head;
    private int size;

    //default constructor
    public LinkedList()
    {
        head = null;
        size = 0;
    }

    //made node class static for memory reasons
    private static class Node<T>
    {
        private final T data;
        private Node<T> next;

        public Node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

    public void add(T data)
    {
        Node<T> newNode = new Node<>(data);
        if (head == null)
            head = newNode;
        else
        {
            Node<T> current = head;
            while (current.next != null)
                current = current.next;
            current.next = newNode;
        }
        size++;
    }

    public T remove(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds");

        Node<T> current = head;
        if (index == 0)
        {
            head = current.next;
            size--;
            return current.data;
        }
        else
        {
            for (int i = 0; i < index - 1; i++)
                current = current.next;

            T data = current.next.data;
            current.next = current.next.next;
            size--;
            return data;
        }
    }

    public T get(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index out of bounds");

        Node<T> current = head;
        for (int i = 0; i < index; i++)
            current = current.next;

        return current.data;
    }

    public int size()
    {
        return size;
    }
}
