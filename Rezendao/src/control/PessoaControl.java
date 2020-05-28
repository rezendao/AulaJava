package control;

import java.util.ArrayList;
import model.PessoaBean;
import model.PessoaDAO;

public class PessoaControl {
    //crud

    private static PessoaControl instance = null;

    public static PessoaControl getInstance() {
        if (instance == null) {
            instance = new PessoaControl();
        }
        return instance;
    }

    public void create(PessoaBean pessoaNova) {
        if (pessoaNova.getNome() != null) {
            if (pessoaNova.getNome().length() > 0) {
                PessoaDAO.create(pessoaNova);
            }
        }
    }

    public ArrayList<PessoaBean> listarPessoas() {
        return PessoaDAO.getLISTA();
    }

    public PessoaBean pesquisarPorEmail(String email) throws Exception {
        PessoaBean pessoaPesquisada = PessoaDAO.retrieve(email);
        if (pessoaPesquisada == null) {
            throw new Exception("Pessoa não encontrada");
        }
        return pessoaPesquisada;
    }

    public boolean deletar(String email) throws Exception {
        return PessoaDAO.delete(pesquisarPorEmail(email));
    }
}
