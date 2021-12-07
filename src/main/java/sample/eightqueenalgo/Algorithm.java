package sample.eightqueenalgo;

import java.util.ArrayList;

public class Algorithm {
    /**
     * attributes.
     */
    private ArrayList<Integer> coordinates = new ArrayList<>();
    private int[] a = new int[20];
    int count = 0;
    ArrayList<Integer> positions;

    /** Constructor. */
    Algorithm() {
        positions = new ArrayList<>();
        this.count = 0;
    }

    public ArrayList<Integer> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(ArrayList<Integer> coordinates) {
        this.coordinates = coordinates;
    }

    /** Check if (x, y) can put a queen. */
    public boolean check(int x, int y) {
        for (int i = 1; i < x; i++) {
            if (a[i] == y || Math.abs(i - x) == Math.abs(a[i] - y)) {
                return false;
            }
        }
        return true;
    }

    /** try put. */
    public void Try(int i, int n) {
        for (int j = 1; j <= n; j++) {
            if (check(i, j)) {
                a[i] = j;
                count++;
                if (i == n) {
                    for (int k = 1; k <= n; k++) {
                        Integer number = a[k];
                        coordinates.add(number);
                    }
                    positions.add(count - 1);
                }
                Try(i + 1, n);
            }
        }
    }

    public static ArrayList<Integer> positionOfSolution() {
        Algorithm algo = new Algorithm();
        algo.Try(1, 8);
        return algo.positions;
    }
}
