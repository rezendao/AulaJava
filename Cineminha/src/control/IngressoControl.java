package control;

import javax.swing.JOptionPane;
import model.abstrato.IngressoAbstract;
import model.concreto.IngressoDAO;
import model.concreto.IngressoEnum;
import model.concreto.MeiaBean;
import model.concreto.NormalBean;

public class IngressoControl {

    private static IngressoControl instance;

    public static IngressoControl getInstance() {
        if (instance == null) {
            instance = new IngressoControl();
        }
        return instance;
    }

    public boolean vender() {
        if (contarIngressos() == 20) {
            return false;
        }
        try {
            int identificadorIngresso = contarIngressos() + 1000;
            if (escolherIngresso() == IngressoEnum.Meia) {
                MeiaBean ingressoMeia = new MeiaBean(identificadorIngresso);
                create(ingressoMeia);
            } else {
                NormalBean ingressoNormal = new NormalBean(identificadorIngresso);
                create(ingressoNormal);
            }
            if (contarIngressos() == 20) {
                JOptionPane.showMessageDialog(null, "Ingressos Esgotados!");
            }
            return true;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }

    public void verSaldo() {
        /*total de ingresso, valor somado de todos os tipos de ingresso (meia e inteira)*/
        String texto = "";
        texto += "Cinema: " + Principal.getCinema().getNome() + "\n";
        texto += "Quantidade de ingressos: " + String.valueOf(20 - contarIngressos()) + "\n";
        texto += "Vendidos/Total (R$): \n";
        texto += "Meia\t: [" + contarIngressosMeia() + "] - R$ " + String.valueOf(contarIngressosMeia() * new MeiaBean().getValor()) + "\n";
        texto += "Normal\t: [" + contarIngressosNormal() + "] - R$ " + String.valueOf(contarIngressosNormal() * new NormalBean().getValor()) + "\n";
        JOptionPane.showMessageDialog(null, texto);
    }

    private int contarIngressosMeia() {
        int contador = 0;
        for (IngressoAbstract ingresso : IngressoDAO.getInstance().getListaIngresso()) {
            if (ingresso instanceof MeiaBean) { // se ingresso for uma instância MeiaBean contador++;
                contador++;
            }
        }
        return contador;
    } // Última linha contarIngressosMeia();

    private int contarIngressosNormal() {
        int contador = 0;
        for (IngressoAbstract ingresso : IngressoDAO.getInstance().getListaIngresso()) {
            if (ingresso instanceof NormalBean) { // se ingresso for uma instância NormalBean contador++;
                contador++;
            }
        }
        return contador;
    } // Última linha contarIngressosNormal();

    private int contarIngressos() {
        return IngressoDAO.getInstance().getListaIngresso().size();
    }

    private IngressoEnum escolherIngresso() throws Exception {
        String texto = "Escolha o tipo do ingresso - Meia [M] ou Normal [N]:";
        String opcao = JOptionPane.showInputDialog(texto).toUpperCase();
        switch (opcao) {
            case "M":
                return IngressoEnum.Meia;
            case "N":
                return IngressoEnum.Normal;
            default:
                throw new Exception("Tipo inválido");
        }
    }

    private IngressoAbstract emitirIngresso(IngressoEnum tipoIngresso) {
        if (tipoIngresso == IngressoEnum.Meia) {
            return new MeiaBean();
        } else {
            return new NormalBean();
        }
    } // Fim do Método emitirIngresso;

    private int create(IngressoAbstract ingresso) {
        return IngressoDAO.getInstance().create(ingresso);
    } // Fim do Método create();

} // Fim da Classe
