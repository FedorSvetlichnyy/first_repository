package day18;

import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        Node root = new Node();
        root.setValue(20);
        addNode(14, root);
        addNode(11, root);
        addNode(16, root);
        addNode(5, root);
        addNode(8, root);
        addNode(15, root);
        addNode(18, root);
        addNode(23, root);
        addNode(22, root);
        addNode(27, root);
        addNode(24, root);
        addNode(150, root);
        dfs(root);

    }

    public static void printTree(Node rootNode) { // ����� ��� ������ ������ � �������
        Stack globalStack = new Stack(); // ����� ���� ��� �������� ������
        globalStack.push(rootNode);
        int gaps = 32; // ��������� �������� ���������� ����� ����������
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// ����� ��� �������� ������ ������ ������
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // ��������� ���� ��� ������� �������� ��������
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // ������ � ����� ����� ���� ��������
                Node temp = (Node) globalStack.pop(); // ����� ���������, ��� ���� ������ ��� �� �����
                if (temp != null) {
                    System.out.print(temp.getValue()); // ������� ��� �������� � �������
                    localStack.push(temp.getLeftChild()); // ���������� � ��������� ����, ���������� �������� ��������
                    localStack.push(temp.getRightChild());
                    if (temp.getLeftChild() != null ||
                            temp.getRightChild() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - ���� ������� ������
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// ��� �������� �� ��������� ������� ���������� ����� ���������� ������ ��� �����������
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // ���������� ��� �������� �� ���������� ����� � ����������
        }
        System.out.println(separator);// �������� �����
    }
    public static ArrayList<Integer> array = new ArrayList<>();

    public static void dfs(Node node){
        dfsModified(node);
        Collections.sort(array);
        for(int counter: array){
            System.out.print(counter + " ");
        }
    }

    public static void dfsModified(Node node) {
        if (node != null) {
            array.add(node.getValue());
            dfsModified(node.getLeftChild());
            dfsModified(node.getRightChild());
        }
    }



    public static void addNode(int value, Node rootNode) { // ����� ������� ������ ��������
        Node newNode = new Node(); // �������� ������ ����
        newNode.setValue(value); // ������� ������
        if (rootNode == null) { // ���� �������� ���� �� ����������
            rootNode = newNode;// �� ����� ������� � ���� �������� ����
        } else { // �������� ���� �����
            Node currentNode = rootNode; // �������� � ��������� ����
            Node parentNode;
            while (true) // �� ����� ���������� ����� �� �����
            {
                parentNode = currentNode;
                if (value == currentNode.getValue()) {   // ���� ����� ������� � ������ ��� ����, �� ��������� ���
                    return;    // ������ ������� �� ������
                } else if (value < currentNode.getValue()) {   // �������� �����?
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null) { // ���� ��� ��������� ����� �������,
                        parentNode.setLeftChild(newNode); //  �� �������� ����� � ����� �� ������
                        return;
                    }
                } else { // ��� �������?
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) { // ���� ��� ��������� ����� �������,
                        parentNode.setRightChild(newNode);  //�� �������� ������
                        return; // � �����
                    }
                }
            }
        }
    }

}

class Node {
    private int value; // ���� ����
    private Node leftChild; // ����� ���� �������
    private Node rightChild; // ������ ���� �������

    public void printNode() { // ����� �������� ���� � �������
        System.out.println("��������� ���� ����� ��������: " + value);
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(final Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(final Node rightChild) {
        this.rightChild = rightChild;
    }
}