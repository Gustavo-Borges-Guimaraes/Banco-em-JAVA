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

public class TelaCriar extends JFrame implements ActionListener {

    private Interface objetoInterface;
    private JTextField tfNumero, tfLimite;
    private JLabel lbTitulo, lbNumero, lbLimite;
    private JButton btCriar, btExcluir, btVoltar;
    private JPanel pnBotoes, pnTitulo, pnDados;
    private Container tela;
    public Banco bancoCriar;

    TelaCriar(Interface objetoInterface, Banco bancoCriar) {

        this.bancoCriar = bancoCriar;
        this.objetoInterface = objetoInterface;

        this.setTitle("");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(450, 125);
        this.setVisible(false);

        //Criar o Container
        tela = this.getContentPane();
        tela.setLayout(new BorderLayout());

        //Instanciando Componentes
        lbTitulo = new JLabel("*** Criação/Exclusão de Conta ***");
        btCriar = new JButton("Criar");
        btExcluir = new JButton("Excluir");
        btVoltar = new JButton("Voltar");
        lbNumero = new JLabel("Número da Conta: ");
        tfNumero = new JTextField(10);
        lbLimite = new JLabel("Limite da Conta(apenas para criar): ");
        tfLimite = new JTextField(4);

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

        pnBotoes.setLayout(new GridLayout(1, 3));
        pnBotoes.add(btCriar);
        pnBotoes.add(btExcluir);
        pnBotoes.add(btVoltar);

        pnDados.setLayout(new GridLayout(2, 2));
        pnDados.add(lbNumero);
        pnDados.add(tfNumero);
        pnDados.add(lbLimite);
        pnDados.add(tfLimite);

        //Evento dos Botões
        btCriar.addActionListener(this);
        btExcluir.addActionListener(this);
        btVoltar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btVoltar) {
            this.setVisible(false);
            objetoInterface.setVisible(true);
        }

        if (e.getSource() == btExcluir) {
            if (bancoCriar.excluirConta(Integer.parseInt(tfNumero.getText())) == 1) {
                JOptionPane.showMessageDialog(null, "Conta excluída com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Conta não encontrada, tente novamente!");
            }
        }

        if (e.getSource() == btCriar) {
            if (bancoCriar.criarConta((Integer.parseInt(tfNumero.getText())), (Float.parseFloat(tfLimite.getText()))) == 0) {
                JOptionPane.showMessageDialog(null, "Erro ao criar conta, tente novamente!");
            } else {
                bancoCriar.criarConta((Integer.parseInt(tfNumero.getText())), (Float.parseFloat(tfLimite.getText())));
                bancoCriar.conta.get(bancoCriar.verificaIndex(Integer.parseInt(tfNumero.getText()))).limite *= -1;
                JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
            }
        }
    }
}
