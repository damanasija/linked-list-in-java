import java.util.Scanner;

//to insert, use function as insert(int);
//to display items in the list, use print();
//to get size of the list, use getSize();

public class LL {

    private node root = null;
    private int size = 0;

    public void insert(int data) {
        this.root = insert(root, data);
        this.size++;
    }

    private node insert(node n, int data) {
        if(n == null) {
            n = createNode(data);
            return n;
        }
        n.next = insert(n.next, data);
        return n;
    }

    private node createNode(int data) {
        return new node(data);
    }

    public void print() {
        node temp = root;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.print("\n");
    }

    public int getSize() {
        return this.size;
    }
    public static void main(String[] args) {
        LL list = new LL();
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = kb.nextInt();
        System.out.println("Input numbers: ");
        for(int i = 0; i < size; i++) {
            int data = kb.nextInt();
            list.insert(data);
        }
        System.out.println("Size = " + (int)list.getSize());
        list.print();
    }
}

class node {

    int data;
    node next;

    node(int data) {
        this.data = data;
        this.next = null;
    }   
}
