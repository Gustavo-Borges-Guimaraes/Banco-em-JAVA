package Principal.pkg2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class TelaConta extends JFrame implements ActionListener {

    private TelaEntrar objetoTelaEntrar;
    private JTextField tfValor, tfConta;
    private JLabel lbTitulo, lbValor, lbConta;
    private JButton btSaque, btDeposito, btTransferencia, btEmissao, btDebito, btCredito, btVoltar, btSair;
    private JPanel pnBotoes, pnTitulo, pnDados;
    private Container tela;
    public Banco bancoTela;
    public int index;
    public boolean debito;

    TelaConta(TelaEntrar objetoTelaEntrar, Banco bancoTela) {

        this.bancoTela = bancoTela;
        this.objetoTelaEntrar = objetoTelaEntrar;

        this.setTitle("");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(450, 250);
        this.setVisible(false);

        //Criar o Container
        tela = this.getContentPane();
        tela.setLayout(new BorderLayout());

        //Instanciando Componentes
        lbTitulo = new JLabel("*** Conta Corrente ***");
        //lbInfo = new JLabel("Sua conta: "+bancoTela.conta.get(index).numero+"\tSeu saldo: R$"+bancoTela.conta.get(index).saldo+"\nSeu limite: R$"+bancoTela.conta.get(index).limite+"\tEstá no especial: "+bancoTela.conta.get(index).especial);
        btSaque = new JButton("Saque");
        btDeposito = new JButton("Depósito");
        btTransferencia = new JButton("Transferência");
        btEmissao = new JButton("Emissão");
        btDebito = new JButton("Débito");
        btCredito = new JButton("Crédito");
        btVoltar = new JButton("Voltar");
        btSair = new JButton("Sair");
        lbValor = new JLabel("Digite o Valor: ");
        tfValor = new JTextField(5);
        lbConta = new JLabel("Digite a Conta(transferência apenas): ");
        tfConta = new JTextField(10);

        //Adicionando Paineis
        pnBotoes = new JPanel();
        pnTitulo = new JPanel();
        pnDados = new JPanel();

        tela.add(pnTitulo, BorderLayout.NORTH);
        pnTitulo.setBackground(Color.white);

        tela.add(pnBotoes, BorderLayout.SOUTH);
        pnBotoes.setBackground(Color.gray);

        tela.add(pnDados, BorderLayout.CENTER);
        pnDados.setBackground(Color.lightGray);

        pnTitulo.add(lbTitulo, BorderLayout.CENTER);

        pnBotoes.setLayout(new GridLayout(4, 2));
        pnBotoes.add(btSaque);
        pnBotoes.add(btDeposito);
        pnBotoes.add(btTransferencia);
        pnBotoes.add(btEmissao);
        pnBotoes.add(btDebito);
        pnBotoes.add(btCredito);
        pnBotoes.add(btVoltar);
        pnBotoes.add(btSair);

        pnDados.setLayout(new GridLayout(2, 2));
        pnDados.add(lbValor);
        pnDados.add(tfValor);
        pnDados.add(lbConta);
        pnDados.add(tfConta);

        //Evento dos Botões
        btSaque.addActionListener(this);
        btDeposito.addActionListener(this);
        btTransferencia.addActionListener(this);
        btEmissao.addActionListener(this);
        btDebito.addActionListener(this);
        btCredito.addActionListener(this);
        btVoltar.addActionListener(this);
        btSair.addActionListener(this);

        btSaque.setEnabled(false);
        btDeposito.setEnabled(false);
        btTransferencia.setEnabled(false);
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btSair) {
            System.exit(0);
        }

        if (e.getSource() == btVoltar) {
            this.setVisible(false);
            objetoTelaEntrar.setVisible(true);
        }

        if (e.getSource() == btSaque) {
            System.out.println(bancoTela.conta.get(index).limite);
            if ((bancoTela.fazerSaque(index, Float.parseFloat(tfValor.getText()), debito) == 1)) {
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso, saldo atual :" + bancoTela.conta.get(index).saldo + " !");
            } else {
                JOptionPane.showMessageDialog(null, "Operação não realizada, saldo insuficiente/atingiu o limite!");
            }
            bancoTela.verificaEspecial(index);
        }

        if (e.getSource() == btDeposito) {
            bancoTela.fazerDeposito(index, Float.parseFloat(tfValor.getText()), debito);
            bancoTela.verificaEspecial(index);
        }

        if (e.getSource() == btTransferencia) {
            if ((bancoTela.fazerTransferencia(index, Integer.parseInt(tfConta.getText()), Float.parseFloat(tfValor.getText()), debito)) == 1) {
                JOptionPane.showMessageDialog(null, "Operação realizada com sucesso, saldo atual :" + bancoTela.conta.get(index).saldo + " !");
            } else {
                JOptionPane.showMessageDialog(null, "Operação não realizada, saldo insuficiente/atingiu o limite!");
            }
            bancoTela.verificaEspecial(index);
            bancoTela.verificaEspecial(bancoTela.verificaIndex(Integer.parseInt(tfConta.getText())));
        }
        if (e.getSource() == btEmissao) {
            JOptionPane.showMessageDialog(null, bancoTela.conta.get(index).movimentacoes.toString());
        }
        if (e.getSource() == btDebito) {
            debito = true;
            btSaque.setEnabled(true);
            btDeposito.setEnabled(true);
            btTransferencia.setEnabled(true);
        }
        if (e.getSource() == btCredito) {
            debito = false;
            btSaque.setEnabled(true);
            btDeposito.setEnabled(true);
            btTransferencia.setEnabled(true);
        }
    }
}
