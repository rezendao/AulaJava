package view;

import control.PessoaControl;
import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.PessoaBean;

public class PessoaView {

    public static void main(String[] args) {
        iniciarCadastro();
    }

    private static void iniciarCadastro() {
        String texto = ""
                + "1) Cadastrar\n"
                + "2) Listar\n"
                + "3) Pesquisar\n"
                + "4) Deletar\n"
                + "5) Sair";

        int opcao = 0;
        while (opcao == 0 || opcao < 5) {
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(null, texto));
            } catch (HeadlessException | NumberFormatException ex) {
                opcao = 0;
            }

            switch (opcao) {
                case 1:
                    cadastrar();
                    break;
                case 2:
                    listar();
                    break;
                case 3:
                    pesquisar();
                    break;
                case 4:
                    deletar();
                    break;
                case 5:
                    sair();
                    break;
                default:
                    opcao = 0;
                    break;
            }
        }

    }

    private static String inputString(String Mensagem) {
        return JOptionPane.showInputDialog(Mensagem);
    }

    private static int inputInt(String Mensagem) {
        try {
            return Integer.parseInt(inputString(Mensagem));
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    private static void cadastrar() {
        PessoaBean nova = new PessoaBean(
                inputString("Qual o nome?"),
                inputInt("Qual a idade?"),
                inputString("Qual o email?"));

        PessoaControl.getInstance().create(nova);
    }

    private static void listar() {
        ArrayList<PessoaBean> pessoas = PessoaControl.getInstance().listarPessoas();
        System.out.println("Pessoas cadastradas: " + pessoas.size());
        for (PessoaBean pessoa : pessoas) {
            System.out.println(pessoa.getNome() + " tem " + pessoa.getIdade() + " anos e seu email é: " + pessoa.getEmail());
        }
    }

    private static void pesquisar() {
        String emailPesquisa = inputString("Qual o email de pesquisa?");

        PessoaBean resultadoPesquisa;
        try {
            resultadoPesquisa = PessoaControl.getInstance().pesquisarPorEmail(emailPesquisa);
            System.out.println(""
                    + "Encontramos: "
                    + resultadoPesquisa.getNome()
                    + " com "
                    + resultadoPesquisa.getIdade());

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    private static void deletar() {
        try {
            if (PessoaControl.getInstance().deletar(inputString("Qual o email para deletar?")) == true) {
                JOptionPane.showMessageDialog(null, "Excluído");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir.\n" + ex.getMessage());
        }
    }

    private static void sair() {
        System.out.println("Estamos saindo do sistema");
        System.exit(0);
    }

}
