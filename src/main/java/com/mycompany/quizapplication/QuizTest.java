
package com.mycompany.quizapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


public class QuizTest extends JFrame implements ActionListener {
    
    JLabel label;
    JRadioButton radioButtons[] = new JRadioButton[5];
    JButton btnNext, btnResult;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];
    
    QuizTest (String s){
        super (s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for(int i=0; i<5; i++){
            radioButtons[i] = new JRadioButton();
            add(radioButtons[i]);
            bg.add(radioButtons[i]);
        }
        
        btnNext = new JButton("Next");
        btnResult = new JButton("Result");
        btnResult.setVisible(false);
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds(30,40,450,20);
        radioButtons[0].setBounds(50,80,450,20);
        radioButtons[1].setBounds(50,110,200,20);
        radioButtons[2].setBounds(50,140,200,20);
        radioButtons[3].setBounds(50,170,200,20);
        btnNext.setBounds(100,240,100,30);
        btnResult.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
    }
    
    
    void setData() {
        radioButtons[4].setSelected(true);
        
        if(current==0){
            label.setText("Q1 : How many threads can be executed at a time?");
            radioButtons[0].setText("Only one thread");
            radioButtons[1].setText("Multiple threads");
            radioButtons[2].setText("Only main (mian() method) thread");
            radioButtons[3].setText("Two threads");
        }
        
        if(current==1){
            label.setText("Q2 : Which component is used to compile, debug and execute the java programs?");
            radioButtons[0].setText("JRE");
            radioButtons[1].setText("JIT");
            radioButtons[2].setText("JDK");
            radioButtons[3].setText("JVM");
        }
        
        if(current==2){
            label.setText("Q3 : Which one of the following is not a java feature?");
            radioButtons[0].setText("Object-oriented");
            radioButtons[1].setText("Use of pointer");
            radioButtons[2].setText("Portable");
            radioButtons[3].setText("Dynamic and Extensible");
        }
        
        if(current==3){
            label.setText("Q4 : In which process, a local variable has the same name as one of the instance variales?");
            radioButtons[0].setText("Serialization");
            radioButtons[1].setText("Variable Shadowing");
            radioButtons[2].setText("Abstraction");
            radioButtons[3].setText("Multi-threading");
        }
        
        if(current==4){
            label.setText("Q5 : Which package contains the Random class?");
            radioButtons[0].setText("java.util package");
            radioButtons[1].setText("java.lang package");
            radioButtons[2].setText("java.awt package");
            radioButtons[3].setText("java.io package");
        }
        
        if(current==5){
            label.setText("Q6 : Which option is false about the final keyword?");
            radioButtons[0].setText("A final method cannot be overridden in its subclasses.");
            radioButtons[1].setText("A final class cannot be extended.");
            radioButtons[2].setText("A final class cananot extend other classes.");
            radioButtons[3].setText("A final method can be inherited.");
        }
        
        if(current==6){
            label.setText("Q7 : Which of these classes are the direct subclasses of the Throwable class?");
            radioButtons[0].setText("RuntimeException and Error class");
            radioButtons[1].setText("Exception and VirtualMachineError class");
            radioButtons[2].setText("Error and Eception class");
            radioButtons[3].setText("IOException and VirtualMachineError class");
        }
        
        if(current==7){
            label.setText("Q7 : What do you mean by chained exceptions in Java?");
            radioButtons[0].setText("Exceptions occured by the VirtualMachineError");
            radioButtons[1].setText("An exception caused by other exceptions");
            radioButtons[2].setText("Exceptions occur in chains with discarding the debugging information");
            radioButtons[3].setText("None of the above");
        }
        
        if(current==8){
            label.setText(("Q9 : Which of the following is a reserved keyword in java?"));
            radioButtons[0].setText("object");
            radioButtons[1].setText("strictfp");
            radioButtons[2].setText("main");
            radioButtons[3].setText("system");
        }
        
        if(current==9){
            label.setText("Q10 : What is the initial quantity of the ArrayList list?");
            radioButtons[0].setText("5");
            radioButtons[1].setText("10");
            radioButtons[2].setText("0");
            radioButtons[3].setText("100");
        }
    
        label.setBounds(30,40,450,20);
        for(int i=0,j=0; i<=90; i+=30,j++){
            radioButtons[j].setBounds(50,80+i,200,20);
            
    }
    }
    
    boolean checkAns(){
        if(current==0){
            return (radioButtons[1].isSelected());
        }
        
        if(current==1){
            return (radioButtons[2].isSelected());
        }
        
        if(current==2){
            return (radioButtons[1].isSelected());
        }
        
        if(current==3){
            return (radioButtons[1].isSelected());
        }
        
        if(current==4){
            return (radioButtons[0].isSelected());
    
        }
        
        if(current==5){
            return (radioButtons[2].isSelected());
        }
        
        if(current==6){
            return (radioButtons[2].isSelected());
        }
        
        if(current==7){
            return (radioButtons[1].isSelected());
        }
        
        if(current==8){
            return(radioButtons[1].isSelected());
        }
        
        if(current==9){
            return(radioButtons[1].isSelected());
        }
        
        
        return false;
    }
            
    public static void main(String[] agrs){
        new QuizTest("Simple Quiz App");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==btnNext){
           if(checkAns())
               count = count +1;
           current++;
           setData();
           if(current==9){
               btnNext.setEnabled(false);
               btnResult.setVisible(true);
               btnResult.setText("Result");
           }
       }
       
       if(e.getActionCommand().equals("Result")){
           if(checkAns())
               count = count+1;
           current++;
           JOptionPane.showMessageDialog(this, "Correct Answers are "+count);
           System.exit(0);
       }
    }
}
