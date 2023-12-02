/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package list_box;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.event.*;
public class City extends JFrame implements ListSelectionListener{
   static JList<String> list;
    static JLabel label;
    
    public static void main(String[] args) {
      JFrame frame=new JFrame("List Box");
	frame.setSize(500,500);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLayout(null);
	frame.getContentPane().setBackground(Color.white);
     
	String lang[]={"Riyadh","Jeddah","Dammam","Abha","Jizan ","Al Jouf"};
	list=new JList<String>(lang);
	list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	list.setBounds(150,100,150,150);
	frame.add(list);
	//Create a label
	label=new JLabel("Select items from list");
	label.setBounds(0,0,500,50);
	frame.add(label);
	//Create an object
	List_Box obj=new List_Box();
	//Add ListSelectionListener to list
        list.addListSelectionListener(obj);
	//Display the frame
        frame.setVisible(true);
    }
    //Function to display the items selected
    public void valueChanged(ListSelectionEvent e)
    {
	//Get index of items selected
	int index[]=list.getSelectedIndices();
	//Get the items selected from their indices
	String str="";
	for(int i=0;i<index.length;i++)
		str=str+list.getModel().getElementAt(index[i])+", ";
	        str=str.replaceAll(", $", "");
	//Change label to items selected
	label.setText("Items Selected : "+str);
    }      
}