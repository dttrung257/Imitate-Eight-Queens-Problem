package sample.eightqueenalgo;

import java.util.ArrayList;

import static sample.eightqueenalgo.Controller.*;

public class ImitateAlgorithm {
    static int c = 0;
    static int temp = 0;
    static int countSolution = 0;
    static String actionOfStep = "";
    static ArrayList<Integer> pos;

    private static int[] a = new int[20];
    public static boolean check(int x, int y) {
        for (int i = 1; i < x; i++) {
            if (a[i] == y || Math.abs(i - x) == Math.abs(a[i] - y)) {
                return false;
            }
        }
        return true;
    }

    /** try put. *//*
    public static void Try(int i, int n) {
        for (int j = 1; j <= n; j++) {
            if (check(i, j)) {
                a[i] = j;
                if (c == Controller.step + 1) {
                    break;
                }
                c++;
                Controller.setPositionForImage(j, i - 1, i);
                if (i == n) {
                    for (int k = 1; k <= n; k++) {
                        Integer number = a[k];
                    }
                    Controller.timeline.stop();
                    //System.out.println(Controller.step);
                }
                Try(i + 1, n);
            }
        }
    }*/

    public static void StepOfAlgorithm(int i, int n, int s) {
        for (int j = 1; j <= n; j++) {
            if (check(i, j)) {
                a[i] = j;
                if (temp == step + 1) {
                    break;
                }
                temp++;
                if (countSolution < 91 && step == pos.get(countSolution)) {
                    if (timeline != null) {
                        timeline.stop();
                    }
                    stopped = true;
                    isSolution = true;
                    countSolution++;
                } else if (countSolution == 91 && step == pos.get(91)) {
                    if (timeline != null) {
                        timeline.stop();
                    }
                    stopped = true;
                    isSolution = true;
                }
                if (step == 2056) {
                    if (timeline != null) {
                        timeline.stop();
                    }
                }
                actionOfStep = "Action: Put a Queen in row " + i + " in (" + (8 - i + 1) + "," + Board.integerToCharacter(j) + ")";
                Controller.setPositionForImage(j, i - 1, i);
                /*if (i == n) {
                    for (int k = 1; k <= n; k++) {
                        Integer number = a[k];
                    }
                }*/
                StepOfAlgorithm(i + 1, n, s);
            }
        }
    }

    public static void jumpToStepOfAlgorithm(int i, int n, int s) {
        for (int j = 1; j <= n; j++) {
            if (check(i, j)) {
                a[i] = j;
                if (c == s + 1) {
                    break;
                }
                c++;
                Controller.setPositionForImage(j, i - 1, i);
                /*if (i == n) {
                    for (int k = 1; k <= n; k++) {
                        Integer number = a[k];
                    }
                }*/
                jumpToStepOfAlgorithm(i + 1, n, s);
            }
        }
    }
}
