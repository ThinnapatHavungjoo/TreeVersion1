/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.treeversion1;

/**
 *
 * @author User
 */
class TreeVersion1 {
    public static void main(String[] data) {
        Node1 root = make( make("Global"),
     make (make("Africa"),
         make("Nigeria"),
         make("Egypt") ),
     make("America"),
     make("Asia"),
     make("Europe") );
        System.out.println(root.name);
//        print(root);
        print(root, 0);
    }
    
    static void print(Node1 current) {
        if (current == null) return;
        System.out.println(current.name);
        print(current.firstChild);
        print(current.nextSibling);
    }
    
    static void print(Node1 current, int level) {
        if (current == null) return;
        for (int i = 0; i < level; i++) {
            System.out.print("'  ");
        }
        if (level > 0) {
            System.out.print("-- ");
        }
        System.out.println(current.name);
        print(current.firstChild, level + 1);
        print(current.nextSibling, level);
    }
    
    public static Node1 make(String s) {
        Node1 current = new Node1();
        current.name = s;
        return current;
    }
    
    public static Node1 make(Node1 parent, Node1 ... children) {
        parent.firstChild = children[0];
        for (int i = 0; i < children.length - 1; i++) {
            children[i].nextSibling = children[i + 1];
        }
        parent.firstChild = children[0];
        return parent;
    }
}

class Node1 {
    String name;
    Node1 firstChild;
    Node1 nextSibling;
}
