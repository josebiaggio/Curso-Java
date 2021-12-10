package com.company;

import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        char[][] tabuleiro = {
                {'_', '|', '_', '|', '_'},
                {'_', '|', '_', '|', '_'},
                {'_', '|', '_', '|', '_'},
        };
        char[] posicoesTabuleiro = new char[9];
        int jogada = 0;
        int jogador = 0;
        char jogador1 = 'X';
        char jogador2 = 'O';
        boolean posicaoRegistrada = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Jogo da Velha");
        printTabuleiro(tabuleiro);

        for(int i = 1; i <= posicoesTabuleiro.length; i++) {
            if(i % 2 == 0) {
                jogador = 2;
            } else {
                jogador = 1;
            }

            System.out.printf("[Jogada %d][Jogador %d] Insira uma posição: ", i, jogador);
            jogada = scanner.nextInt();

            if(jogador == 1) {
                posicaoRegistrada = registrarPosicao(posicoesTabuleiro, jogada, jogador1);
            } else {
                posicaoRegistrada = registrarPosicao(posicoesTabuleiro, jogada, jogador2);
            }

            if(posicaoRegistrada == true) {
                atualizarTabuleiro(jogada, jogador, tabuleiro);
            } else {
                i--;
            }
        }
    }

    public static void printTabuleiro(char[][] tabuleiro) {
        for(char[] row: tabuleiro) {
            for(char column: row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }

    public static boolean registrarPosicao(char[] posicoesTabuleiro, int posicao, char jogador) {
        boolean posicaoRegistrada = false;
        for(int i = 1; i <= posicoesTabuleiro.length; i++) {
            if(posicao == i) {
                // Verificar se posição do tabuleiro foi preenchida
                if(posicoesTabuleiro[i] == 'X' || posicoesTabuleiro[i] == 'O') {
                    posicaoRegistrada = false;
                } else {
                    posicoesTabuleiro[i] = jogador;
                    posicaoRegistrada = true;
                }
            }
        }
        return posicaoRegistrada;
    }

    public static void atualizarTabuleiro(int posicao, int jogador, char[][] tabuleiro) {
        char character;

        // Jogador 1 = 'X'
        // Jogador 2 = 'O'

        if(jogador == 1) {
            character = 'X';
        } else {
            character = 'O';
        }

        switch (posicao) {
            case 1:
                tabuleiro[0][0] = character;
                printTabuleiro(tabuleiro);
                break;
            case 2:
                tabuleiro[0][2] = character;
                printTabuleiro(tabuleiro);
                break;
            case 3:
                tabuleiro[0][4] = character;
                printTabuleiro(tabuleiro);
                break;
            case 4:
                tabuleiro[1][0] = character;
                printTabuleiro(tabuleiro);
                break;
            case 5:
                tabuleiro[1][2] = character;
                printTabuleiro(tabuleiro);
                break;
            case 6:
                tabuleiro[1][4] = character;
                printTabuleiro(tabuleiro);
                break;
            case 7:
                tabuleiro[2][0] = character;
                printTabuleiro(tabuleiro);
                break;
            case 8:
                tabuleiro[2][2] = character;
                printTabuleiro(tabuleiro);
                break;
            case 9:
                tabuleiro[2][4] = character;
                printTabuleiro(tabuleiro);
                break;
            default:
                break;
        }
    }
}
