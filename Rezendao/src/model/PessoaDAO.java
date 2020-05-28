package model;

import java.util.ArrayList;

public class PessoaDAO {

    private static final ArrayList<PessoaBean> LISTA = new ArrayList<>();

    // crud
    public static void create(PessoaBean createPessoa) {
        LISTA.add(createPessoa);
    }

    public static PessoaBean retrieve(String email) {
        for (PessoaBean p : LISTA) {
            if (p.getEmail().equals(email)) {
                return p;
            }
        }
        return null;
    }

    public static ArrayList<PessoaBean> getLISTA() {
        return LISTA;
    }

    public static void update(PessoaBean updatePessoa) {

    }

    public static boolean delete(PessoaBean deletar) {
        LISTA.remove(deletar);
        return true;
    }

}
