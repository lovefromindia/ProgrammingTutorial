package com.learning.concurrentcollections;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;

public class LearningConcurrentCollections2 {

    public static void main(String[] args) {

        ConcurrentMap<String,Integer> concurrentMap = new ConcurrentHashMap<>();

        concurrentMap = new ConcurrentSkipListMap<>();

    }

}
