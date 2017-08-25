package aula05ex02;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class JanelaRadio extends JFrame {
    
    private final JTextField mensagem = new JTextField("Universidade Federal de Juiz de Fora");
    private final JRadioButton rbPLano;
    private final JRadioButton rbNegrito;
    private final JRadioButton rbItalico;
    private final JRadioButton rbNegritoItalico;
    
    public JanelaRadio() throws HeadlessException {
        super("RadioButton Test");
        setLayout(new FlowLayout());
        add(mensagem);
        rbPLano = new JRadioButton ("Plano", true);
        add(rbPLano);
        rbNegrito = new JRadioButton ("Negrito", false);
        rbItalico = new JRadioButton ("Italico", false);
        rbNegritoItalico = new JRadioButton ("Negrito-Italico", false);
        add(rbNegrito);
        add(rbItalico);
        add(rbNegritoItalico);
        
        ButtonGroup bgEstilo = new ButtonGroup();
        bgEstilo.add(rbPLano);
        bgEstilo.add(rbNegrito);
        bgEstilo.add(rbItalico);
        bgEstilo.add(rbNegritoItalico);
        
        Font fPLana = new Font (Font.SERIF, Font.PLAIN,14);
        Font fNegrito = new Font (Font.SERIF, Font.BOLD,14);
        Font fItalico = new Font (Font.SERIF, Font.ITALIC,14);
        Font fNegritoItalico = new Font (Font.SERIF, Font.BOLD + Font.ITALIC,14);
        
        rbPLano.addItemListener(new EstiloRadio(fPLana));
        rbNegrito.addItemListener(new EstiloRadio(fNegrito));
        rbItalico.addItemListener(new EstiloRadio(fItalico));
        rbNegritoItalico.addItemListener(new EstiloRadio(fNegritoItalico));
        
   
}

    private class EstiloRadio implements ItemListener {
        private Font fonte;
        
        public EstiloRadio(Font fPLana) {
            this.fonte = fPLana;
        }

        @Override
        public void itemStateChanged(ItemEvent e) {
        mensagem.setFont(fonte);
             
        }
    }
    
}