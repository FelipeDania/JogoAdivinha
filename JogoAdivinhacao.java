/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula09;

import javax.swing.JOptionPane;

/**
 * 5) Criar um jogo de adivinhação, entre usuario X computador. O computador
 * deve gerar um número aleatório entre 1 a 100 depois o usuário deverá digitar
 * um palpite, se o usuário errar o computador deverá mostrar seu palpite,
 * quando um dos dois acertar deverá aparecer um menu perguntando se deseja
 * jogar novamente. Mostrar o placar do jogo quando alguém acertar. Assim que
 * alguém errar deverá aparecer uma mensagem "Você errou, o número é maior
 * ainda." ou "Você errou, a número é menor ainda." Quando não quiser mais jogar
 * mostrar a mensagem fim do jogo.
 *
 * @author felipedania
 */
public class JogoAdivinhacao {

    public static void main(String[] args) {
        int numMaior;
        int numMenor;
        int numPC;
        int numJoga;
        boolean acerto;
        int numGerado;
        int contador = 0;
        String menu;
        do {
            numMaior = 100;
            numMenor = 0;
            acerto = false;
            numGerado = (int) (Math.random() * 100) + 1;
            do {
                numJoga = Integer.parseInt(JOptionPane.showInputDialog("Digite seu número"));
                if (numGerado == numJoga) {
                    JOptionPane.showMessageDialog(null, "Parabéns você acertou!");
                    acerto = true;
                } else {
                    if (numGerado > numJoga) {
                        JOptionPane.showMessageDialog(null, "Você errou! O número é maior");
                        numMenor = numJoga;
                    } else {
                        JOptionPane.showMessageDialog(null, "Você errou! O número é menor");
                        numMaior = numJoga;
                    }
                }
                if (!acerto) {
                    numPC = (int) (Math.random() * (numMaior - numMenor)) + numMenor;
                    if (numGerado == numPC) {
                        JOptionPane.showMessageDialog(null, "Parabéns PC - acertou");
                        acerto = true;
                    } else {
                        if (numGerado > numPC) {
                            JOptionPane.showMessageDialog(null, "PC errou! O número é maior " + numPC);
                            numMenor = numPC;
                        } else {
                            JOptionPane.showMessageDialog(null, "PC errou! O número é menor " + numPC);
                            numMaior = numPC;
                        }
                    }
                }
            } while (!acerto);
            menu = JOptionPane.showInputDialog("Jogar novamente?" + "\n(S)Sim \n(N)Não");
        } while (menu.equalsIgnoreCase("s"));
    }
}
