import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

class employee
{
  String name,department,designation;
  double basicsalary;
  void getDetails(String name,String department,double basicsalary,String designation)  //assigning the values entered in UI to specific employee 
  {
     this.name=name;
     this.department=department;
     this.basicsalary=basicsalary;
     this.designation=designation;
     if(designation.equals("Manager"))                                      //if designation is manager the his gross salary is
     {                                                                      //basic salary+(20% of basic salary)+(25% of basic salary)
        basicsalary+=((0.2*basicsalary)+(0.25*basicsalary));                //where HRA is 20% and DA is 25%
        this.basicsalary=basicsalary;
     }
     if(designation.equals("Accountant"))                                   //if designation is accountant the his gross salary is
     {                                                                      //basic salary+(10% of basic salary)+(15% of basic salary)
        basicsalary+=((0.1*basicsalary)+(0.15*basicsalary));                //where HRA is 10% and DA is 15%
        this.basicsalary=basicsalary;
     }
     if(designation.equals("Clerk"))                                         //if designation is clerk the his gross salary is
     {                                                                       //basic salary+(10% of basic salary)+(10% of basic salary)
        basicsalary+=((0.1*basicsalary)+(0.1*basicsalary));                  //where HRA is 10% and DA is 10%
        this.basicsalary=basicsalary;
     }
     
     
  }
}



  
class SFrame
  {
    private static boolean isNumeric(String str) {                       //methos checking whether the field of basic salary is numeric values
                                                                         //return true if it is numeric else false 
    	 char[] charArray = str.toCharArray(); 

    	 for(int i=0; i < charArray.length; i++){

    	 	if(!Character.isDigit(charArray[i]))
    	 		return false;
    	 }

    	 return true ;

    }

    SFrame()
    {
    ArrayList<employee> emp=new ArrayList<employee>();                 //arraylist of employee
    
    JFrame jf=new JFrame("Salary Managment System");                   //JFrame (it adds panel to itself)                                      
    JPanel p=new JPanel();                                             //JPanel(it adds all the fields and labels to itself)
   
    JLabel name1=new JLabel("Name ");                                  //label for employee name
    JTextField name2=new JTextField(10);                               //textfield for entering employee name
    p.add(name1);
    p.add(name2);


    JLabel designation1=new JLabel("Designation ");                     //label for employee designation
    JTextField designation2=new JTextField(20);                         //textfield for entering employee designation
    p.add(designation1);
    p.add(designation2);

    JLabel department1=new JLabel("Department ");                         //label for employee department
    JTextField department2=new JTextField(20);                            //textfield for entering employee department
    p.add(department1);
    p.add(department2);
   
    JLabel basicsalary1=new JLabel("Salary");                              //label for employee basic salary
    JTextField basicsalary2=new JTextField(10);                            //textfield for entering employee basic salary
    p.add(basicsalary1);
    p.add(basicsalary2);
    
    JButton submit=new JButton("Submit");                                   //button for submitting and adding employee in the arraylist
    JButton details=new JButton("Details");                                 //button for details of employees to display in textarea
    p.add(submit);
    p.add(details);

    JTextArea elist=new JTextArea(20,20);                                     //textarea for displaying the details of employees and if any errors occured
    p.add(elist);

    
 
   submit.addActionListener(new ActionListener(){                         //when submit button is pressed it will take the text from name,designation,
    public void actionPerformed(ActionEvent ae)                           //department,basic salary fields and the basic salary field will check for whether
    {  
                                                                         //the entered value is numberic or not , if not then it will display an error message in text area
       employee e=new employee();
       String name3=name2.getText();
       String designation3=designation2.getText();
       String department3=department2.getText();
       String basicsalary3=basicsalary2.getText();
       if(isNumeric(basicsalary3)==true)
       {
           
           double salary=Double.parseDouble(basicsalary2.getText());
            e.getDetails(name3,department3,salary,designation3);
            emp.add(e);  
       }
       else
       {
         elist.append("->Basic salary should be in numeric digits\n Please enter the Basic Salary in numeric value");
       }
       
      
    }
   });

   details.addActionListener(new ActionListener(){                           //when details button is pressed it will display all the employee details
   public void actionPerformed(ActionEvent ae)                                //in the textarea
   {
      employee e;
      elist.setText("");
      elist.append("Details of all the employees\n");
      for(int i=0;i<emp.size();i++)
      {
         e=emp.get(i);
         elist.append("\nName->"+e.name+"\n");
         elist.append("Department->"+e.department+"\n");
         elist.append("Designation->"+e.designation+"\n");
         elist.append("Gross Salary->"+e.basicsalary+"\n");
         elist.append("-------------------------------");
       
      }
   }
   });

    
    jf.add(p);
    jf.setSize(500,500);
    jf.setVisible(true);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                 //this will work when you close the frame the program automatically gets terminated 

  }
}


  
 class mainprogram
{
  
  public static void main(String args[])
  {
    employee e=new employee();                                      //creating object for employee class
    SFrame s=new SFrame();                                           //creating object for SFrame class
  }

}