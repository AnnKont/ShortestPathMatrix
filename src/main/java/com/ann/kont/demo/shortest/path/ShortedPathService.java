package com.ann.kont.demo.shortest.path;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortedPathService {

    /**
     * Get the shortest distance from S to D avoiding all the obstacles
     */
    public int getPath(char[][] matrix) {
        Node node = findStartNode(matrix);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (matrix[currentNode.x][currentNode.y] == 'D') {
                return currentNode.distance;
            } else {
                matrix[currentNode.x][currentNode.y] = 0;
                List<Node> nodes = getNeighbours(currentNode, matrix);
                queue.addAll(nodes);
            }
        }

        return -1;
    }

    /**
     * Find start point
     */
    private Node findStartNode(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'S') {
                    return new Node(i, j, 0);
                }
            }
        }
        throw new RuntimeException("No start node");
    }

    /**
     * Get all neighbours that can be visited
     */
    private List<Node> getNeighbours(Node node, char[][] matrix) {
        List<Node> nodes = new LinkedList<>();

        if (node.x - 1 >= 0 && node.x - 1 < matrix.length && matrix[node.x - 1][node.y] != '0') {
            Node newNode = new Node(node.x - 1, node.y, node.distance + 1);
            nodes.add(newNode);
        }
        if (node.x + 1 < matrix.length && matrix[node.x + 1][node.y] != '0') {
            Node newNode = new Node(node.x + 1, node.y, node.distance + 1);
            nodes.add(newNode);
        }
        if (node.y - 1 >= 0 && node.y - 1 < matrix[node.x].length && matrix[node.x][node.y - 1] != '0') {
            Node newNode = new Node(node.x, node.y - 1, node.distance + 1);
            nodes.add(newNode);
        }
        if (node.y + 1 < matrix[node.x].length && matrix[node.x][node.y + 1] != '0') {
            Node newNode = new Node(node.x, node.y + 1, node.distance + 1);
            nodes.add(newNode);
        }
        return nodes;
    }

    class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}