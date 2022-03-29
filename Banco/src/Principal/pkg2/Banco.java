package Principal.pkg2;

import java.util.ArrayList;

class Banco {

    ContaCorrente obj;
    int index;
    ArrayList<ContaCorrente> conta = new ArrayList<>();

    public int criarConta(int a, float b) {
        int verificador = 0;
        for (ContaCorrente obj : conta) {
            if (a == obj.numero) {
                verificador++;
            }
        }
        if (verificador == 0) {
            if (a > 0 && b >= 0) {
                conta.add(new ContaCorrente(a, b));

            }
            return 1;
        }
        return 0;
    }

    public int excluirConta(int index) {
        if (verificaIndex(index) != -1) {
            conta.get(verificaIndex(index)).movimentacoes.clear();
            conta.remove(verificaIndex(index));
            return 1;
        }
        return 0;
    }

    public int fazerSaque(int index, float saque, boolean info) {
        if ((conta.get(index).saldo - saque) > conta.get(index).limite) {
            conta.get(index).saldo -= saque;
            conta.get(index).movimentacoes.add(new Movimentacao("Saque", saque, info));
            return 1;
        }
        return 0;
    }

    public void fazerDeposito(int index, float deposito, boolean info) {
        conta.get(index).saldo += deposito;
        conta.get(index).movimentacoes.add(new Movimentacao("Depósito", deposito, info));
    }

    //public void fazerEmissao(int index) {
    //System.out.println(conta.get(index).movimentacoes.toString());
    //}
    public int fazerTransferencia(int index1, int index2, float transferencia, boolean info) {
        if (conta.get(index1).saldo - transferencia > conta.get(index1).limite) {
            conta.get(index1).saldo -= transferencia;
            conta.get(verificaIndex(index2)).saldo += transferencia;
            conta.get(index1).movimentacoes.add(new Movimentacao("Transferência(Pagamento)", transferencia, info));
            conta.get(verificaIndex(index2)).movimentacoes.add(new Movimentacao("Transferência(Recebimento)", transferencia, info));
            return 1;
        }
        return 0;
    }

    public int verificaEspecial(int x) {
        if (conta.get(x).saldo < 0) {
            conta.get(x).setEspecial(true);
            return 1;
        }
        return 0;
    }

    public int verificaIndex(int x) {
        int verificador = 0;
        for (ContaCorrente obj : conta) {
            if (x == obj.numero) {
                index = conta.indexOf(obj);
            } else {
                verificador++;
            }
        }
        if (verificador < conta.size()) {
            return index;
        }
        return -1;
    }
}
