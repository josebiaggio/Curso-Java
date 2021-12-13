package com.company;

public class Tabuleiro {
    private char[][] tabuleiro = {
            {'_', '|', '_', '|', '_'},
            {'_', '|', '_', '|', '_'},
            {'_', '|', '_', '|', '_'},
    };

    private char[] posicoes = new char[9];

    public char[] getPosicoes() { return posicoes; }

    public boolean registrarPosicao(int posicao, char simbolo) {
        boolean posicaoRegistrada = false;
        for(int i = 0; i < this.posicoes.length; i++) {
            if(posicao - 1 == i) {
                // Verificar se posição do tabuleiro foi preenchida
                if(this.posicoes[i] == 'X' || this.posicoes[i] == 'O') {
                    posicaoRegistrada = false;
                } else {
                    this.posicoes[i] = simbolo;
                    posicaoRegistrada = true;
                }
            }
        }
        return posicaoRegistrada;
    }

    public void mostrar() {
        for(char[] row: this.tabuleiro) {
            for(char column: row) {
                System.out.print(column);
            }
            System.out.println();
        }
    }

    public void atualizar(int posicao, char simbolo) {
        switch (posicao) {
            case 1:
                this.tabuleiro[0][0] = simbolo;
                mostrar();
                break;
            case 2:
                this.tabuleiro[0][2] = simbolo;
                mostrar();
                break;
            case 3:
                this.tabuleiro[0][4] = simbolo;
                mostrar();
                break;
            case 4:
                this.tabuleiro[1][0] = simbolo;
                mostrar();
                break;
            case 5:
                this.tabuleiro[1][2] = simbolo;
                mostrar();
                break;
            case 6:
                this.tabuleiro[1][4] = simbolo;
                mostrar();
                break;
            case 7:
                this.tabuleiro[2][0] = simbolo;
                mostrar();
                break;
            case 8:
                this.tabuleiro[2][2] = simbolo;
                mostrar();
                break;
            case 9:
                this.tabuleiro[2][4] = simbolo;
                mostrar();
                break;
            default:
                break;
        }
    }

    public boolean verificarSeTemVencedor(char simbolo) {
        boolean hasVencedor = false;

        // Verifica linhas
        for(int i = 0; i < 3; i++) {
            if(this.tabuleiro[i][0] == simbolo && this.tabuleiro[i][2] == simbolo && this.tabuleiro[i][4] == simbolo) {
                hasVencedor = true;
                break;
            }
        }

        // Verifica colunas
        for(int i = 0; i < 3; i++) {
            if(this.tabuleiro[0][i * 2] == simbolo && this.tabuleiro[1][i * 2] == simbolo && this.tabuleiro[2][i * 2] == simbolo) {
                hasVencedor = true;
                break;
            }
        }

        // Verifica diagonais
        if(this.tabuleiro[0][0] == simbolo && this.tabuleiro[1][2] == simbolo && this.tabuleiro[2][4] == simbolo) {
            hasVencedor = true;
        } else if(this.tabuleiro[0][4] == simbolo && this.tabuleiro[1][2] == simbolo && this.tabuleiro[2][0] == simbolo) {
            hasVencedor = true;
        }

        return hasVencedor;
    }
}
