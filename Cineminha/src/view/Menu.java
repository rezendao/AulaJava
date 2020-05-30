package view;

import control.IngressoControl;
import javax.swing.JOptionPane;
import model.concreto.CinemaBean;

public class Menu {

    private static Menu instance = null;

    public static Menu getInstance() {
        if (instance == null) {
            instance = new Menu();
        }
        return instance;
    }

    public void mostrar(CinemaBean cinema) {
        String texto = "";
        texto += "Cinema: " + cinema.getNome() + "\n";
        texto += "[1] - Vende Ingresso\n";
        texto += "[2] - Ver Saldo\n";
        texto += "[0] - Sair\n";

        String opcao = null;
        while (opcao != "0") {
            opcao = String.valueOf(JOptionPane.showInputDialog(texto));
            switch (opcao) {
                case "1":
                    IngressoControl.getInstance().vender();
                    break;
                case "2":
                    IngressoControl.getInstance().verSaldo();
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    opcao = null;
                    break;
            }
        }
    }
}
