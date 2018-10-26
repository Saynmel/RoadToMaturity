package com.sanmel.practice;

import java.util.Scanner;

/**
 * @ Description:
 * @ Author: yanhao
 * @ Date: 2018/10/26 15:49
 **/
public class Gomoku {
    private static final int BOARD_SIZE = 15;
    private String[][] board = new String[15][15];
    private static final String BLACK_PIECE = "●";
    private static final String WHITE_PIECE = "○";
    private static final int VICTORY_NUM = 5;

    public static void main(String[] args) {
        Gomoku gomoku = new Gomoku();
        gomoku.initBoard();
        gomoku.printBoard();
        gomoku.startGame();
    }

    /**
     * 初始化棋盘
     */
    private void initBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (i == 0) {
                    if (j == 0) {
                        board[i][j] = "┌─";
                    } else if (j == BOARD_SIZE - 1) {
                        board[i][j] = "┐";
                    } else {
                        board[i][j] = "┬─";
                    }
                } else if (i == BOARD_SIZE - 1) {
                    if (j == 0) {
                        board[i][j] = "└─";
                    } else if (j == BOARD_SIZE - 1) {
                        board[i][j] = "┘";
                    } else {
                        board[i][j] = "┴─";
                    }
                } else {
                    if (j == 0) {
                        board[i][j] = "├─";
                    } else if (j == BOARD_SIZE - 1) {
                        board[i][j] = "┤";
                    } else {
                        board[i][j] = "┼─";
                    }
                }
            }
        }
    }

    /**
     * 打印棋盘
     */
    private void printBoard() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
    }

    /**
     * 电脑下棋
     */
    private PieceEntity computerFalling() {
        int x = 15 - (int) (Math.random() * 10);
        int y = 15 - (int) (Math.random() * 10);
        if (x > 14 || y > 14 || x < 0 || y < 0) {
            return computerFalling();
        }
        if (board[x][y].contains(BLACK_PIECE) || board[x][y].contains(WHITE_PIECE)) {
            return computerFalling();
        } else {
            if (y != BOARD_SIZE - 1) {
                board[x][y] = BLACK_PIECE + "─";
            } else {
                board[x][y] = BLACK_PIECE;
            }
            return new PieceEntity(x, y, BLACK_PIECE);
        }
    }

    /**
     * 玩家下棋
     */
    private PieceEntity palyerFalling() {
        System.out.print("请输入下棋得x-y坐标(“,”分隔):");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.contains(",")) {
            String[] inputs = input.split(",");
            try {
                int x = Integer.parseInt(inputs[1].trim());
                int y = Integer.parseInt(inputs[0].trim());
                if (x > 14 || y > 14 || x < 0 || y < 0) {
                    System.out.println("请输入正确的坐标值!");
                    return palyerFalling();
                }
                if (board[x][y].contains(BLACK_PIECE) || board[x][y].contains(WHITE_PIECE)) {
                    System.out.println("该位置已经有棋子了！请重新输入！");
                    return palyerFalling();
                } else {
                    if (y != BOARD_SIZE - 1) {
                        board[x][y] = WHITE_PIECE + "─";
                    } else {
                        board[x][y] = WHITE_PIECE;
                    }
                    return new PieceEntity(x, y, WHITE_PIECE);
                }
            } catch (Exception e) {
                System.out.println("error info:" + e.getMessage());
                System.out.println("请输入正确的坐标值!");
                return palyerFalling();
            }
        } else {
            System.out.println("请输入正确的坐标值!");
            return palyerFalling();
        }
    }

    private boolean check(PieceEntity piece) {
        int x = piece.getX();
        int y = piece.getY();
        String p = piece.getPiece();
        if (x > 3 && board[x - 4][y].contains(p) && board[x - 3][y].contains(p) && board[x - 2][y].contains(p) && board[x - 1][y].contains(p)) {
            return true;
        } else if (x > 2 && x < BOARD_SIZE - 1 && board[x + 1][y].contains(p) && board[x - 3][y].contains(p) && board[x - 2][y].contains(p) && board[x - 1][y].contains(p)) {
            return true;
        } else if (x > 1 && x < BOARD_SIZE - 2 && board[x + 1][y].contains(p) && board[x + 2][y].contains(p) && board[x - 2][y].contains(p) && board[x - 1][y].contains(p)) {
            return true;
        } else if (x > 0 && x < BOARD_SIZE - 3 && board[x + 1][y].contains(p) && board[x + 2][y].contains(p) && board[x + 3][y].contains(p) && board[x - 1][y].contains(p)) {
            return true;
        } else if (x < BOARD_SIZE - 4 && board[x + 1][y].contains(p) && board[x + 2][y].contains(p) && board[x + 3][y].contains(p) && board[x + 4][y].contains(p)) {
            return true;
        } else if (y > 3 && board[x][y - 4].contains(p) && board[x][y - 3].contains(p) && board[x][y - 2].contains(p) && board[x][y - 1].contains(p)) {
            return true;
        } else if (y > 2 && y < BOARD_SIZE - 1 && board[x][y + 1].contains(p) && board[x][y - 3].contains(p) && board[x][y - 2].contains(p) && board[x][y - 1].contains(p)) {
            return true;
        } else if (y > 1 && y < BOARD_SIZE - 2 && board[x][y + 1].contains(p) && board[x][y + 2].contains(p) && board[x][y - 2].contains(p) && board[x][y - 1].contains(p)) {
            return true;
        } else if (y > 0 && y < BOARD_SIZE - 3 && board[x][y + 1].contains(p) && board[x][y + 2].contains(p) && board[x][y + 3].contains(p) && board[x][y - 1].contains(p)) {
            return true;
        } else if (y < BOARD_SIZE - 4 && board[x][y + 1].contains(p) && board[x][y + 2].contains(p) && board[x][y + 3].contains(p) && board[x][y + 4].contains(p)) {
            return true;
        } else if (x > 3 && y > 3 && board[x - 4][y - 4].contains(p) && board[x - 3][y - 3].contains(p) && board[x - 2][y - 2].contains(p) && board[x - 1][y - 1].contains(p)) {
            return true;
        } else if (x > 2 && y > 2 && x < BOARD_SIZE - 1 && y < BOARD_SIZE - 1 && board[x + 1][y + 1].contains(p) && board[x - 3][y - 3].contains(p) && board[x - 2][y - 2].contains(p) && board[x - 1][y - 1].contains(p)) {
            return true;
        } else if (x > 1 && y > 1 && x < BOARD_SIZE - 2 && y < BOARD_SIZE - 2 && board[x + 1][y + 1].contains(p) && board[x + 2][y + 2].contains(p) && board[x - 2][y - 2].contains(p) && board[x - 1][y - 1].contains(p)) {
            return true;
        } else if (x > 0 && y > 0 && x < BOARD_SIZE - 3 && y < BOARD_SIZE - 3 && board[x + 1][y + 1].contains(p) && board[x + 2][y + 2].contains(p) && board[x + 3][y + 3].contains(p) && board[x - 1][y - 1].contains(p)) {
            return true;
        } else {
            return x < BOARD_SIZE - 4 && y < BOARD_SIZE - 4 && board[x + 1][y + 1].contains(p) && board[x + 2][y + 2].contains(p) && board[x + 3][y + 3].contains(p) && board[x + 4][y + 4].contains(p);
        }
    }

    private void startGame() {
        boolean result = false;
        while (true) {
            PieceEntity playPiece = palyerFalling();
            result = check(playPiece);
            if (result) {
                printBoard();
                System.out.println("游戏结束！恭喜'" + playPiece.getPiece() + "'获胜!");
                break;
            }
            PieceEntity compPiece = computerFalling();
            result = check(compPiece);
            if (result) {
                printBoard();
                System.out.println("游戏结束！恭喜'" + playPiece.getPiece() + "'获胜!");
                break;
            }
            printBoard();
        }
    }
}

class PieceEntity {
    private int x;
    private int y;
    private String piece;

    public PieceEntity() {
    }

    public PieceEntity(int x, int y, String piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }
}
