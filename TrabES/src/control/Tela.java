package control;

import javax.swing.JOptionPane;


public class Tela {
	//Serve para capturar uma String por uma tela
	//msg - mensagem a ser escrita antes da captura
	public static String scanString(String msg)
	{
		return (JOptionPane.showInputDialog(msg));
	}

	//Serve para capturar um inteiro por uma tela
	//msg - mensagem a ser escrita antes da captura
	public static int scanInt(String msg)
	{
		return (Integer.parseInt(JOptionPane.showInputDialog(msg)));
	}

	//Serve para capturar um double por uma tela
	//msg - mensagem a ser escrita antes da captura
	public static double scanDouble(String msg)
	{
		return (Double.parseDouble(JOptionPane.showInputDialog(msg)));
	}
	
	public static void print(Object obj)
	{
		JOptionPane.showMessageDialog(null, obj);
	}
}
