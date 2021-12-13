package com.company;

import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tabuleiro tabuleiro = new Tabuleiro();

        System.out.println("Jogo da Velha");
        System.out.println();
        tabuleiro.mostrar();
        System.out.println();

        System.out.println("Opções de jogadores: ");
        System.out.println();
        System.out.println("1 - Jogador 1;");
        System.out.println("2 - Jogador 2;");
        System.out.println();
        System.out.print("Escolha o jogador que deseja jogar: ");
        int jogadorEscolhido = scanner.nextInt();
        String jogadorQueIniciaPartida = null;

        switch (jogadorEscolhido) {
            case 1:
                jogadorQueIniciaPartida = "Jogador 1";
                break;
            case 2:
                jogadorQueIniciaPartida = "Jogador 2";
                break;
            default:
                break;
        }

        System.out.println("Jogador que iniciará a partida: " + jogadorQueIniciaPartida);
        System.out.println();
        System.out.println("Opções de símbolos:");
        System.out.println();
        System.out.println("1 - X;");
        System.out.println("2 - O;");
        System.out.println();
        System.out.printf("%s, escolha o símbolo que deseja jogar: ", jogadorQueIniciaPartida);
        int simboloEscolhido = scanner.nextInt();

        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();

        if(jogadorEscolhido == 1) {
            setSimbolo(simboloEscolhido, jogador1, jogador2);
        } else if(jogadorEscolhido == 2) {
            setSimbolo(simboloEscolhido, jogador2, jogador1);
        }

        char simboloJogador1 = jogador1.getSimbolo();
        char simboloJogador2 = jogador2.getSimbolo();
        System.out.printf("[Jogador 1: '%c'][Jogador 2: '%c']\n", simboloJogador1, simboloJogador2);
        System.out.println();

        char[] posicoesTabuleiro = tabuleiro.getPosicoes();
        boolean posicaoRegistrada = false;
        char simbolo = ' ';
        int jogador = 0;

        for(int i = 1; i <= posicoesTabuleiro.length; i++) {
            if(jogadorEscolhido == 1) {
                if(i % 2 == 1) {
                    jogador = 1;
                } else {
                    jogador = 2;
                }
            } else if (jogadorEscolhido == 2) {
                if(i % 2 == 1) {
                    jogador = 2;
                } else {
                    jogador = 1;
                }
            }

            if(i >= 5) {
                boolean jogador1Vencedor = tabuleiro.verificarSeTemVencedor(simboloJogador1);
                boolean jogador2Vencedor = tabuleiro.verificarSeTemVencedor(simboloJogador2);
                System.out.println();
                if(jogador1Vencedor) {
                    System.out.println("Jogador 1 venceu a partida");
                    break;
                } else if(jogador2Vencedor) {
                    System.out.println("Jogador 2 venceu a partida");
                    break;
                }
            }

            System.out.printf("[Jogada %d][Jogador %d] Insira uma posição: ", i, jogador);
            int posicao = scanner.nextInt();

            if(jogador == 1) {
                posicaoRegistrada = tabuleiro.registrarPosicao(posicao, simboloJogador1);
                simbolo = simboloJogador1;
            } else {
                posicaoRegistrada = tabuleiro.registrarPosicao(posicao, simboloJogador2);
                simbolo = simboloJogador2;
            }

            if(posicaoRegistrada) {
                tabuleiro.atualizar(posicao, simbolo);
            } else {
                System.out.println();
                System.out.println("Jogada inválida. Essa posição já foi preenchida!");
                System.out.println();
                i--;
            }
        }
    }

    public static void setSimbolo(int simboloEscolhido, Jogador jogadorEscolhido, Jogador jogador) {
        switch (simboloEscolhido) {
            case 1:
                jogadorEscolhido.setSimbolo('X');
                jogador.setSimbolo('O');
                break;
            case 2:
                jogadorEscolhido.setSimbolo('O');
                jogador.setSimbolo('X');
                break;
            default:
                break;
        }
    }
}
