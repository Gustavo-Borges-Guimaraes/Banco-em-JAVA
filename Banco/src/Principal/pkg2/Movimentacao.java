package Principal.pkg2;

public class Movimentacao {

    //Atributos
    public String descricao;
    public float valor;
    public boolean debito;

    //Construtor
    public Movimentacao() {
    }

    public Movimentacao(String descricao, float valor, boolean info) {
        this.descricao = descricao;
        this.valor = valor;
        this.debito = info;
    }

    //Getters
    public String getDescricao() {
        return descricao;
    }

    public float getValor() {
        return valor;
    }

    public boolean isInfo() {
        return debito;
    }

    //Setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setInfo(boolean info) {
        this.debito = info;
    }

    //toString
    @Override
    public String toString() {
        if (debito) {
            return "Movimentações:{" + "descricao: " + descricao + "   valor: R$" + valor + "   info: debito \n}";
        } else {
            return "Movimentações:{" + "descricao: " + descricao + "   valor: R$" + valor + "   info: credito \n}";
        }
    }
}
