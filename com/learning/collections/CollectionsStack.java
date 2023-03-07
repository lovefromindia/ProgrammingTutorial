package com.learning.collections;

import java.util.Stack;

import java.util.Vector;

public class CollectionsStack {

    public static void main(String[] args) {

        Vector<String> stack = new Stack<>();

//        stack.push("Mihir");
//        stack.push("Mahir");
//        stack.push("Mhir");

        Stack<String> st = new Stack<>();

        st.push("Mihir");

        st.push("Mahir");

        st.push("Mhir");

        System.out.println(st.peek());

        System.out.println(st.pop());

        System.out.println(st);

    }

}
