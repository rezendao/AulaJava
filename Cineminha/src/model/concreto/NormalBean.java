package model.concreto;

import model.abstrato.IngressoAbstract;

public class NormalBean extends IngressoAbstract {

    public NormalBean(int identificador) {
        super(identificador);
        this.valor = 20;
    }

    public NormalBean() {
        this.valor = 20;
    }

}
