package br.com.jogogourmet.panels;

import static java.util.Objects.nonNull;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.jogogourmet.utils.Constants;

public class JogoGourmetPanel {
	
	JFrame mainFrame = new JFrame(Constants.LABEL_APP);
    JPanel mainPanel = new JPanel();
    JLabel label = new JLabel(Constants.QUESTION_01);
    JButton button = new JButton("OK");
    
    String answerGiveUp = new String();
	
    public JogoGourmetPanel() {  
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		label.setBorder(new EmptyBorder(15,0,10,0));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(label);
        mainPanel.add(button);
        mainFrame.add(mainPanel);
        mainFrame.pack();
        mainFrame.setSize(300, 120);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        
        button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (getAnswer(Constants.QUESTION_02) == Constants.ZERO) {
					if (getAnswer(Constants.QUESTION_03) == Constants.ZERO) {
						getAnswerOK();
					}
				} else {
					if (getAnswer(Constants.QUESTION_04) == Constants.ZERO) {
						getAnswerOK();
					} else {
						answerGiveUp = JOptionPane.showInputDialog(Constants.QUESTION_05);
						if (nonNull(answerGiveUp)) {
							answerGiveUp = JOptionPane.showInputDialog(answerGiveUp.concat(Constants.ANSWER_GIVEUP));
						}
					}
				}
			}
		});
    } 
    
    private int getAnswer(String question) {
    	int buttonAnswer = JOptionPane.OK_OPTION;
		return JOptionPane.showConfirmDialog(null, question, Constants.LABEL_CONFIRM, buttonAnswer);
    }
	
	private void getAnswerOK() {
		int buttonAnswerOk = JOptionPane.DEFAULT_OPTION;
		JOptionPane.showConfirmDialog(null, Constants.ANSWER_OK, Constants.LABEL_APP, buttonAnswerOk, JOptionPane.INFORMATION_MESSAGE);
	}

}
