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

public class Interface extends JFrame implements ActionListener {

    public TelaCriar objetoCriar;
    public TelaEntrar objetoEntrar;
    private JLabel lbTitulo;
    private JButton btCriar, btEntrar, btSair;
    private JPanel pnBotoes, pnTitulo;
    private Container tela;
    public Banco banco;

    Interface() {

        banco = new Banco();
        objetoCriar = new TelaCriar(this, banco);
        objetoEntrar = new TelaEntrar(this, banco);

        this.setTitle("");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 100);
        this.setVisible(true);

        //Criar o Container
        tela = this.getContentPane();
        tela.setLayout(new BorderLayout());

        //Instanciando Componentes
        lbTitulo = new JLabel("*** Banco ***");
        btCriar = new JButton("Criar Conta");
        btEntrar = new JButton("Acessar Conta");
        btSair = new JButton("Sair");

        //Adicionando Paineis
        pnBotoes = new JPanel();
        pnTitulo = new JPanel();

        tela.add(pnTitulo, BorderLayout.CENTER);
        pnTitulo.setBackground(Color.lightGray);

        tela.add(pnBotoes, BorderLayout.SOUTH);
        pnBotoes.setBackground(Color.gray);

        pnTitulo.add(lbTitulo, BorderLayout.CENTER);

        pnBotoes.setLayout(new GridLayout(1, 3));
        pnBotoes.add(btCriar);
        pnBotoes.add(btEntrar);
        pnBotoes.add(btSair);

        //Evento dos Botões
        btCriar.addActionListener(this);
        btEntrar.addActionListener(this);
        btSair.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btSair) {
            System.exit(0);
        }

        if (e.getSource() == btCriar) {
            this.setVisible(false);
            objetoCriar.setVisible(true);
        }

        if (e.getSource() == btEntrar) {
            this.setVisible(false);
            objetoEntrar.setVisible(true);
        }
    }
}
