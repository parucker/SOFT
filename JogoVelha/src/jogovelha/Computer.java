package jogovelha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrador
 */
import java.util.Random;

public class Computer extends Player {

    Random gerador = new Random();

    public Computer(int player) {
        super(player);
        System.out.println("Player 'Computer' created");
    }

    @Override
    public void play(Board board) {
        Try(board);
        board.setPosition(attempt, player);
    }

    @Override
    public void Try(Board board) {
        int flag = 0;
        while (flag == 0) {
            if (umaPosicaoVit(board)) {
                break;
            } else {
                if (umaPosicaoDer(board)) {
                    break;
                } else {
                    attempt[0] = gerador.nextInt(3);
                    attempt[1] = gerador.nextInt(3);
                    if (checkTry(attempt, board)) {
                        flag++;
                    }
                }
            }
        }
    }

    public boolean umaPosicaoDer(Board board) {
        int posicao = 0;
        for (int column = 0; column < 3; column++) {
            posicao = board.checkColumnsCompLoose(column);
            if (posicao != 5) {
                attempt[0] = posicao;
                attempt[1] = column;

                return true;

            }
        }
        for (int line = 0; line < 3; line++) {
            posicao = board.checkLinesCompLoose(line);
            if (posicao != 5) {
                attempt[0] = line;
                attempt[1] = posicao;

                return true;

            }
        }
        if (board.checkDiagonalsPriCompLoose() == 0) {
            attempt[0] = 0;
            attempt[1] = 0;

            return true;

        }
        if (board.checkDiagonalsPriCompLoose() == 1) {
            attempt[0] = 1;
            attempt[1] = 1;

            return true;

        }
        if (board.checkDiagonalsPriCompLoose() == 2) {
            attempt[0] = 2;
            attempt[1] = 2;

            return true;

        }
        if (board.checkDiagonalSegCompLoose() == 0) {
            attempt[0] = 0;
            attempt[1] = 2;

            return true;

        }
        if (board.checkDiagonalSegCompLoose() == 1) {
            attempt[0] = 1;
            attempt[1] = 1;

            return true;

        }
        if (board.checkDiagonalSegCompLoose() == 2) {
            attempt[0] = 2;
            attempt[1] = 0;

            return true;

        }
        return false;
    }

    public boolean umaPosicaoVit(Board board) {
        int posicao;
        int cont = 0;
        for (int column = 0; column < 3; column++) {
            posicao = board.checkColumnsComp(column);
            if (posicao != 5) {
                attempt[0] = posicao;
                attempt[1] = column;
                return true;
            }
        }
        for (int line = 0; line < 3; line++) {
            posicao = board.checkLinesComp(line);
            if (posicao != 5) {
                attempt[0] = line;
                attempt[1] = posicao;
                return true;
            }
        }
        if (board.checkDiagonalsPriComp() == 0) {
            attempt[0] = 0;
            attempt[1] = 0;

            return true;

        }
        if (board.checkDiagonalsPriComp() == 1) {
            attempt[0] = 1;
            attempt[1] = 1;

            return true;

        }
        if (board.checkDiagonalsPriComp() == 2) {
            attempt[0] = 2;
            attempt[1] = 2;

            return true;

        }
        if (board.checkDiagonalSegComp() == 0) {
            attempt[0] = 0;
            attempt[1] = 2;

            return true;

        }
        if (board.checkDiagonalSegComp() == 1) {
            attempt[0] = 1;
            attempt[1] = 1;

            return true;
        }
        if (board.checkDiagonalSegComp() == 2) {
            attempt[0] = 2;
            attempt[1] = 0;

            return true;

        }
        return false;
    }
}
