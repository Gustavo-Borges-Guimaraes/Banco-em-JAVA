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

public class TelaEntrar extends JFrame implements ActionListener {

    private TelaConta telaConta;
    private Interface objetoInterface;
    private JTextField tfNumero;
    private JLabel lbTitulo, lbNumero;
    private JButton btEntrar, btVoltar, btMostrar;
    private JPanel pnBotoes, pnTitulo, pnDados;
    private Container tela;
    public Banco bancoEntrar;

    TelaEntrar(Interface objetoInterface, Banco bancoEntrar) {

        telaConta = new TelaConta(this, bancoEntrar);
        this.bancoEntrar = bancoEntrar;
        this.objetoInterface = objetoInterface;

        this.setTitle("");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 125);
        this.setVisible(false);

        //Criar o Container
        tela = this.getContentPane();
        tela.setLayout(new BorderLayout());

        //Instanciando Componentes
        lbTitulo = new JLabel("*** Entrar na Conta ***");
        btEntrar = new JButton("Entrar");
        btMostrar = new JButton("Mostrar");
        btVoltar = new JButton("Voltar");
        lbNumero = new JLabel("Digite o Número da Conta: ");
        tfNumero = new JTextField(10);

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
        // pnTitulo.add(lbTitulo);

        pnBotoes.setLayout(new GridLayout(1, 3));
        pnBotoes.add(btEntrar);
        pnBotoes.add(btMostrar);
        pnBotoes.add(btVoltar);

        pnDados.setLayout(new GridLayout(1, 1));
        pnDados.add(lbNumero);
        pnDados.add(tfNumero);

        //Evento dos Botões
        btEntrar.addActionListener(this);
        btMostrar.addActionListener(this);
        btVoltar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btVoltar) {
            this.setVisible(false);
            objetoInterface.setVisible(true);
        }

        if (e.getSource() == btMostrar) {
            JOptionPane.showMessageDialog(null, bancoEntrar.conta.toString());
        }

        if (e.getSource() == btEntrar) {
            if (bancoEntrar.verificaIndex(Integer.parseInt(tfNumero.getText())) == -1) {
                JOptionPane.showMessageDialog(null, "Conta não encontrada, tente novamente!");
            } else {
                telaConta.setIndex(bancoEntrar.verificaIndex(Integer.parseInt(tfNumero.getText())));
                bancoEntrar.verificaEspecial(bancoEntrar.verificaIndex(Integer.parseInt(tfNumero.getText())));
                this.setVisible(false);
                telaConta.setVisible(true);
            }
        }
    }
}
