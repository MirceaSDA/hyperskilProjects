package tictactoe;

import java.util.*;

public class MainModified {
    private static void printGame(char[][] game) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
    static int xCounter = 0;
    static int oCounter = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        char[][] ticTacToe = new char[3][3];

//        System.out.println("Enter cells: ");
//
//        String string = scanner.nextLine().toUpperCase();

        boolean gameState = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
//                ticTacToe[i][j] = string.charAt(counter);
                ticTacToe[i][j] = ' ';
//                counter++;
            }
        }
        printGame(ticTacToe);

        int coordX = 0;
        int coordY = 0;
        boolean allClear = false;
        boolean validCoordinates = false;

        while(!allClear) {
            while (!validCoordinates) {
                System.out.println("Enter the coordinates: ");
                try {
                    coordX = scanner.nextInt();
                    coordY = scanner.nextInt();
                    scanner.nextLine();
                    if (!checkRange(coordX, coordY)) {
                        continue;
                    }
                    if (ticTacToe[3 - coordY][coordX - 1] == 'X' || ticTacToe[3 - coordY][coordX - 1] == 'O') {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    } else {
                        if (xCounter == oCounter) {
                            ticTacToe[3 - coordY][coordX - 1] = 'X';
                            xCounter++;
                        } else {
                            ticTacToe[3 - coordY][coordX - 1] = 'O';
                            oCounter++;
                        }
                    }
                    switch(checkGameState(ticTacToe)) {
                        case "X win":
                            printGame(ticTacToe);
                            System.out.println("X wins");
                            validCoordinates = true;
                            allClear = true;
                            break;
                        case "O win":
                            printGame(ticTacToe);
                            System.out.println("O wins");
                            validCoordinates = true;
                            allClear = true;
                            break;
                        case "not finished":
                            printGame(ticTacToe);
                            break;
                        case "draw":
                            printGame(ticTacToe);
                            System.out.println("Draw");
                            validCoordinates = true;
                            allClear = true;
                            break;
                    }
                } catch (InputMismatchException exception) {
                    System.out.println("You should enter numbers!");
                    scanner.nextLine();
                }
            }
        }
    }

    private static boolean checkRange(int coordX, int coordY) {
        boolean checkedRange = false;
        if (coordX > 3 || coordY > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
        } else {
            checkedRange = true;
        }
        return checkedRange;
    }
    private static String checkGameState(char[][] ticTacToe) {
        String result = " ";
        int winCounter = 0;
        if (ticTacToe[0][0] == 'X' && ticTacToe[0][1] == 'X' && ticTacToe[0][2] == 'X') {
            result = "X win";
            winCounter++;
        } else if (ticTacToe[1][0] == 'X' && ticTacToe[1][1] == 'X' && ticTacToe[1][2] == 'X') {
            result = "X win";
            winCounter++;
        } else if (ticTacToe[2][0] == 'X' && ticTacToe[2][1] == 'X' && ticTacToe[2][2] == 'X') {
            result = "X win";
            winCounter++;
        } else if (ticTacToe[0][0] == 'X' && ticTacToe[1][0] == 'X' && ticTacToe[2][0] == 'X') {
            result = "X win";
            winCounter++;
        } else if (ticTacToe[0][1] == 'X' && ticTacToe[1][1] == 'X' && ticTacToe[2][1] == 'X') {
            result = "X win";
            winCounter++;
        } else if (ticTacToe[0][2] == 'X' && ticTacToe[1][2] == 'X' && ticTacToe[2][2] == 'X') {
            result = "X win";
            winCounter++;
        } else if (ticTacToe[0][0] == 'X' && ticTacToe[1][1] == 'X' && ticTacToe[2][2] == 'X') {
            result = "X win";
            winCounter++;
        } else if (ticTacToe[0][2] == 'X' && ticTacToe[1][1] == 'X' && ticTacToe[2][0] == 'X') {
            result = "X win";
            winCounter++;
        }
        if (ticTacToe[0][0] == 'O' && ticTacToe[0][1] == 'O' && ticTacToe[0][2] == 'O') {
            result = "O win";
            winCounter++;
        } else if (ticTacToe[1][0] == 'O' && ticTacToe[1][1] == 'O' && ticTacToe[1][2] == 'O') {
            result = "O win";
            winCounter++;
        } else if (ticTacToe[2][0] == 'O' && ticTacToe[2][1] == 'O' && ticTacToe[2][2] == 'O') {
            result = "O win";
            winCounter++;
        } else if (ticTacToe[0][0] == 'O' && ticTacToe[1][0] == 'O' && ticTacToe[2][0] == 'O') {
            result = "O win";
            winCounter++;
        } else if (ticTacToe[0][1] == 'O' && ticTacToe[1][1] == 'O' && ticTacToe[2][1] == 'O') {
            result = "O win";
            winCounter++;
        } else if (ticTacToe[0][2] == 'O' && ticTacToe[1][2] == 'O' && ticTacToe[2][2] == 'O') {
            result = "O win";
            winCounter++;
        } else if (ticTacToe[0][0] == 'O' && ticTacToe[1][1] == 'O' && ticTacToe[2][2] == 'O') {
            result = "O win";
            winCounter++;
        } else if (ticTacToe[0][2] == 'O' && ticTacToe[1][1] == 'O' && ticTacToe[2][0] == 'O') {
            result = "O win";
            winCounter++;
        }
        if (winCounter < 1 && xCounter + oCounter == 9) {
            result = "draw";
        }
        if (winCounter < 1 && xCounter + oCounter < 9) {
            result = "not finished";
        }
//        if (winCounter > 1) {
//            result = "impossible";
//        }
//        if (xCounter - oCounter > 1 || oCounter - xCounter > 1) {
//            result = "impossible";
//        }
        return result;
    }
}