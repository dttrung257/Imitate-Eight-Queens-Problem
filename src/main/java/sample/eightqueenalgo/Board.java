package sample.eightqueenalgo;

import java.util.ArrayList;

public class Board {
    /**
     * attributes.
     */
    public static final int WIDTH = 8;
    public static final int HEIGHT = 8;

    public static String integerToCharacter(int number) {
        return switch (number) {
            case 1 -> "A";
            case 2 -> "B";
            case 3 -> "C";
            case 4 -> "D";
            case 5 -> "E";
            case 6 -> "F";
            case 7 -> "G";
            case 8 -> "H";
            default -> "";
        };
    }

    public static Integer characterToInteger(char ch) {
        return switch (ch) {
            case 'A' -> 1;
            case 'B' -> 2;
            case 'C' -> 3;
            case 'D' -> 4;
            case 'E' -> 5;
            case 'F' -> 6;
            case 'G' -> 7;
            case 'H' -> 8;
            default -> 0;
        };
    }

    public static ArrayList<String> solutionForSelection(int select) {
        Algorithm algorithm = new Algorithm();
        algorithm.Try(1, 8);
        ArrayList<String> solution = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < algorithm.getCoordinates().size(); i++) {
            if (i % 8 == 0 && algorithm.getCoordinates().get(i) == select) {
                for (int j = i + 1; j < i + 8; j++) {
                    temp.add(algorithm.getCoordinates().get(j));
                }
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            String str = "";
            if (i % 7 == 6) {
                str += ++count + ", (8," +
                        integerToCharacter(select) + ") ";
                str += "(7," +
                        integerToCharacter(temp.get(i - 6)) + ") ";
                str += "(6," +
                        integerToCharacter(temp.get(i - 5)) + ") ";
                str += "(5," +
                        integerToCharacter(temp.get(i - 4)) + ") ";
                str += "(4," +
                        integerToCharacter(temp.get(i - 3)) + ") ";
                str += "(3," +
                        integerToCharacter(temp.get(i - 2)) + ") ";
                str += "(2," +
                        integerToCharacter(temp.get(i - 1)) + ") ";
                str += "(1," +
                        integerToCharacter(temp.get(i)) + ")";
            }
            if (!str.equals("")) {
                solution.add(str);
            }
        }
        return solution;
    }

    public static String displaySolutionInLabel(ArrayList<Integer> a) {
        return  "(8," + integerToCharacter(a.get(0)) + ") "
                + "(7, " + integerToCharacter(a.get(1)) + ") "
                + "(6, " + integerToCharacter(a.get(2)) + ") "
                + "(5, " + integerToCharacter(a.get(3)) + ") "
                + "(4, " + integerToCharacter(a.get(4)) + ") "
                + "(3, " + integerToCharacter(a.get(5)) + ") "
                + "(2, " + integerToCharacter(a.get(6)) + ") "
                + "(1, " + integerToCharacter(a.get(7)) + ") ";
    }

    public static ArrayList<String> allSolutionInListView() {
        ArrayList<String> solution = new ArrayList<>();
        Algorithm algorithm = new Algorithm();
        algorithm.Try(1, 8);
        int count = 0;
        for (int i = 0; i < algorithm.getCoordinates().size(); i++) {
            String str = "";
            if (i % 8 == 7) {
                str += ++count + ", (8," +
                        integerToCharacter(algorithm.getCoordinates().get(i - 7)) + ") ";
                str += "(7," +
                        integerToCharacter(algorithm.getCoordinates().get(i - 6)) + ") ";
                str += "(6," +
                        integerToCharacter(algorithm.getCoordinates().get(i - 5)) + ") ";
                str += "(5," +
                        integerToCharacter(algorithm.getCoordinates().get(i - 4)) + ") ";
                str += "(4," +
                        integerToCharacter(algorithm.getCoordinates().get(i - 3)) + ") ";
                str += "(3," +
                        integerToCharacter(algorithm.getCoordinates().get(i - 2)) + ") ";
                str += "(2," +
                        integerToCharacter(algorithm.getCoordinates().get(i - 1)) + ") ";
                str += "(1," +
                        integerToCharacter(algorithm.getCoordinates().get(i)) + ")";
            }
            if (!str.equals("")) {
                solution.add(str);
            }
        }
        return solution;
    }

    public static ArrayList<Integer> handleSolution(String solution) {
        ArrayList<Integer> res = new ArrayList<>();
        if (solution.length() == 50) {
            for (int i = 0; i < 8; i++) {
                Integer number = characterToInteger(solution.charAt(6 + 6 * i));
                res.add(number);
            }
        } else if (solution.length() == 51) {
            for (int i = 0; i < 8; i++) {
                Integer number = characterToInteger(solution.charAt(7 + 6 * i));
                res.add(number);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /*Algorithm algorithm = new Algorithm();
        algorithm.Try(1, 8);
        for (int i = 0; i < algorithm.getCoordinates().size(); i++) {
            System.out.print(algorithm.getCoordinates().get(i).toString() + " ");
            if (i % 8 == 7) {
                System.out.print("\n");
            }
        }*/
    }
}
