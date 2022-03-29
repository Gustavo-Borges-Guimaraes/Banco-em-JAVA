package Principal.pkg2;

import java.util.ArrayList;

public class ContaCorrente {

    //Atributos
    protected int numero;
    protected float saldo, limite;
    protected boolean especial;
    ArrayList<Movimentacao> movimentacoes = new ArrayList<>();

    //Construtor
    public ContaCorrente(int numero, float limite) {
        this.numero = numero;
        this.limite = limite;
    }

    //Getters
    public int getNumero() {
        return numero;
    }

    public float getSaldo() {
        return saldo;
    }

    public float getLimite() {
        return limite;
    }

    public boolean isEspecial() {
        return especial;
    }

    public ArrayList<Movimentacao> getMovimentacoes() {
        return movimentacoes;
    }

    //Setters
    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    public void setMovimentacoes(ArrayList<Movimentacao> movimentacoes) {
        this.movimentacoes = movimentacoes;
    }

    //toString
    @Override
    public String toString() {
        if (especial) {
            return "ContaCorrente{" + "numero: " + numero + "   saldo: R$" + saldo + "   limite: " + limite + "   conta especial \n}";
        } else {
            return "ContaCorrente{" + "numero: " + numero + "   saldo: R$" + saldo + "   limite: " + limite + "   conta normal \n}";
        }
    }
}
