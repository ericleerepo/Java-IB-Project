import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;

public class MainPage extends JFrame
{
    private static JTextField textfield_income = new JTextField(6);
    private static JTextField textfield_expenseamount = new JTextField(6);
    private static JTextField textfield_expensename = new JTextField(6);
    private static JPasswordField textfield_password = new JPasswordField(6);
    
    private static JLabel Intro = new JLabel();
    private static JLabel IncomeOutput = new JLabel();
    private static JLabel EnterIncome = new JLabel();
    private static JLabel EnterExpenseN = new JLabel();
    private static JLabel EnterExpenseA = new JLabel();
    private static JLabel Close = new JLabel();
    private static JLabel text = new JLabel();
    private static JLabel correct = new JLabel();
    private static JLabel incorrect = new JLabel();

    public MainPage(){
        super("Expense Calculator");
        Container c = getContentPane();
        c.setBackground(Color.PINK);
        c.setLayout(new GridLayout(2,1));
    }

    private static class UserPick1 implements ActionListener{
        public void actionPerformed(ActionEvent h){
            MainPage2 window2 = new MainPage2();
            window2.setBounds(300,300,1000,400);
            window2.setDefaultCloseOperation(EXIT_ON_CLOSE);

            JPanel Income = new JPanel();
            Income.setLayout(new FlowLayout());
            Income.setBackground(Color.PINK);
            IncomeOutput.setText("User1 Income: " + user1_income());
            IncomeOutput.setForeground(Color.BLUE);
            Income.add(IncomeOutput);
            window2.add(Income);

            JPanel Expense = new JPanel();
            ArrayList<String> listOfExpenses = user1_expenses();
            Expense.setLayout(new GridLayout(listOfExpenses.size()+2,1));
            Expense.setBackground(Color.PINK);
            text.setText("User1 Expenses: ");
            Expense.add(text);

            if (listOfExpenses.size() == 0){
                JLabel ExpenseOutput = new JLabel();
                ExpenseOutput.setText("No Expenses Yet");
                Expense.add(ExpenseOutput);
            }
            else {
                for(int i = 0; i<listOfExpenses.size(); i++){

                    JLabel ExpenseOutput = new JLabel();
                    String holder = listOfExpenses.get(i);
                    ExpenseOutput.setText(holder);
                    Expense.add(ExpenseOutput); 

                }
            }
            window2.add(Expense);

            JPanel Buttons = new JPanel();
            Buttons.setBackground(Color.PINK);
            Buttons.setLayout(new FlowLayout());
            JButton button_obj3 = new JButton("Change Income");
            Buttons.add(button_obj3);
            button_obj3.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent i){
                        MainPageIncome window3 = new MainPageIncome();
                        window3.setBounds(300,300,1000,300);

                        JPanel Enter = new JPanel();
                        Enter.setBackground(Color.PINK);
                        Enter.setLayout(new FlowLayout());

                        EnterIncome.setText("Enter New Income");
                        Enter.add(EnterIncome);

                        File myObj = new File(user1Income);
                        myObj.delete();
                        Enter.add(textfield_income);
                        user1_income();

                        window3.add(Enter);

                        JButton button_obj4 = new JButton("Save New Income");
                        window3.add(button_obj4);
                        button_obj4.addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent j){
                                    try{
                                        FileWriter myWriter = new FileWriter(user1Income);
                                        myWriter.append(textfield_income.getText());
                                        myWriter.close();
                                    } catch (IOException f) {
                                        System.out.println("Failed to Save");
                                    }

                                    Expense.removeAll();
                                    ArrayList<String> listOfExpenses = user1_expenses();
                                    Expense.setLayout(new GridLayout(listOfExpenses.size()+2,1));
                                    text.setText("User1 Expenses: ");
                                    Expense.add(text);
                                    if (listOfExpenses.size() == 0){
                                        JLabel ExpenseOutput = new JLabel();
                                        ExpenseOutput.setText("No Expenses Yet");
                                        Expense.add(ExpenseOutput);
                                    }
                                    else {
                                        for(int i = 0; i<listOfExpenses.size(); i++){

                                            JLabel ExpenseOutput = new JLabel();
                                            String holder = listOfExpenses.get(i);
                                            ExpenseOutput.setText(holder);
                                            Expense.add(ExpenseOutput); 

                                        }
                                    }
                                    IncomeOutput.setText("Your Income: " +user1_income());

                                    window2.revalidate();
                                    window2.repaint();

                                }

                            });
                        Close.setText("Close this window when done and saved.");
                        window3.add(Close);

                        window3.setVisible(true);
                    }
                });

            JButton button_obj4 = new JButton("Reset Expenses");
            Buttons.add(button_obj4);
            button_obj4.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent j){
                        File myObj = new File(user1Expense);
                        myObj.delete();
                        Expense.removeAll();
                        ArrayList<String> listOfExpenses = user1_expenses();
                        Expense.setLayout(new GridLayout(listOfExpenses.size()+2,1));
                        text.setText("User1 Expenses: ");
                        Expense.add(text);
                        if (listOfExpenses.size() == 0){
                            JLabel ExpenseOutput = new JLabel();
                            ExpenseOutput.setText("No Expenses Yet");
                            Expense.add(ExpenseOutput);
                        }
                        else {
                            for(int i = 0; i<listOfExpenses.size(); i++){

                                JLabel ExpenseOutput = new JLabel();
                                String holder = listOfExpenses.get(i);
                                ExpenseOutput.setText(holder);
                                Expense.add(ExpenseOutput); 

                            }
                        }
                        window2.revalidate();
                        window2.repaint();
                    }
                });

            JButton button_obj5 = new JButton("Add an Expense");
            Buttons.add(button_obj5);
            button_obj5.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent j){
                        MainPageExpense window4 = new MainPageExpense();
                        window4.setBounds(300,300,1000,300);

                        JPanel Enter = new JPanel();
                        Enter.setBackground(Color.PINK);
                        Enter.setLayout(new FlowLayout());

                        EnterExpenseN.setText("Enter Expense Name");

                        Enter.add(EnterExpenseN);
                        Enter.add(textfield_expensename);

                        EnterExpenseA.setText("Enter Expense Amount");
                        Enter.add(EnterExpenseA);
                        Enter.add(textfield_expenseamount);

                        window4.add(Enter);

                        JButton button_obj4 = new JButton("Save Expense");
                        window4.add(button_obj4);
                        button_obj4.addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent j){
                                    try{
                                        File myObj = new File(user1Income);
                                        File myObj2 = new File(user1Expense);
                                        Scanner myReader = new Scanner(myObj);
                                        String income = "";
                                        String expenseA = "";
                                        expenseA=(textfield_expenseamount.getText());
                                        while(myReader.hasNextLine()){
                                            income = myReader.nextLine();

                                        }
                                        myReader.close();
                                        double i = Integer.parseInt(income);
                                        double e = Integer.parseInt(expenseA);
                                        double p = e/i*100; 
                                        FileWriter myWriter = new FileWriter(user1Expense, true);
                                        myWriter.append(textfield_expensename.getText() + ", " +expenseA + ", " + String.valueOf(p)+"% of income |");
                                        myWriter.close();
                                    } catch (IOException e) {
                                        System.out.println("Expense could not be added");
                                    }

                                    Expense.removeAll();
                                    ArrayList<String> listOfExpenses = user1_expenses();
                                    Expense.setLayout(new GridLayout(listOfExpenses.size()+2,1));
                                    text.setText("User1 Expenses: ");
                                    Expense.add(text);
                                    if (listOfExpenses.size() == 0){
                                        JLabel ExpenseOutput = new JLabel();
                                        ExpenseOutput.setText("No Expenses Yet");
                                        Expense.add(ExpenseOutput);
                                    }
                                    else {
                                        for(int i = 0; i<listOfExpenses.size(); i++){

                                            JLabel ExpenseOutput = new JLabel();
                                            String holder = listOfExpenses.get(i);
                                            ExpenseOutput.setText(holder);
                                            Expense.add(ExpenseOutput); 

                                        }
                                    }

                                    window2.revalidate();
                                    window2.repaint();
                                }
                            });
                        Close.setText("Close this window when done and saved.");
                        window4.add(Close);

                        window4.setVisible(true);
                    }
                });
            window2.add(Expense);
            window2.add(Buttons);
            window2.setVisible(true);
        }
    }

    static String user1Income = "user1 income.txt";
    public static String user1_income(){
        try{
            File myObj = new File(user1Income);
            if(!myObj.exists()){
                myObj.createNewFile();
                System.out.println("File successfully created.");
            }
            else{
                Scanner myReader = new Scanner(myObj);
                while(myReader.hasNextLine()){
                    String something = myReader.nextLine();
                    return something;
                }
                myReader.close();
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
        }
        return "No data yet";
    }

    static String user1Expense = "user1 expenses.txt";
    public static ArrayList user1_expenses(){
        ArrayList<String> listOfExpenses = new ArrayList<String>();
        try{
            File myObj = new File(user1Expense);
            if(!myObj.exists()){
                myObj.createNewFile();
                System.out.println("File successfully created.");
            }
            else{
                FileReader fr = new FileReader("user1 expenses.txt");
                String s = new String();
                char ch;
                while (fr.ready()) {
                    ch = (char)fr.read();
                    if (ch == '|') {
                        listOfExpenses.add(s.toString());
                        s = new String();
                    }
                    else {
                        s += ch;
                    }
                }
                if (s.length() > 0) {
                    listOfExpenses.add(s.toString());
                }
                String[] array= listOfExpenses.toArray(new String[0]);

                return listOfExpenses;
            }
        }catch(IOException e){
            System.out.println("An error occurred .");
        }
        return listOfExpenses;
    }

    public static void Calculator(){
        MainPage window = new MainPage();
        window.setBounds(300,300,1100,200);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Intro.setText("Welcome to the Expense Calcualtor! This will help you keep track of your income and expenses to see how you are using your money. Pick a user to load and edit a profile.");
        window.add(Intro);

        JPanel users = new JPanel();
        users.setLayout(new GridLayout (1,2));

        JButton button_obj3 = new JButton ("User 1");
        button_obj3.addActionListener(new Password());
        users.add(button_obj3);

        JButton button_obj4 = new JButton ("User 2");
        button_obj4.addActionListener(new Password2());
        users.add(button_obj4);

        window.add(users);

        window.setVisible(true);
    }

    static String something=""; 
    static String user1Password = "user1 password.txt";
    private static class Password implements ActionListener{
        public void actionPerformed(ActionEvent a){
            MainPageIncome window5 = new MainPageIncome();
            window5.setBounds(300,300,1000,300);

            try{
                File myObj = new File(user1Password);
                if(!myObj.exists()){
                    myObj.createNewFile();
                    System.out.println("File successfully created.");
                    text.setText("Create your Password");
                    window5.add(text);
                    window5.add(textfield_password);
                    JButton button_obj4 = new JButton("Save New Password");

                    window5.add(button_obj4);
                    button_obj4.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent j){
                                try{
                                    FileWriter myWriter = new FileWriter(user1Password, true);
                                    myWriter.append(textfield_password.getText());
                                    myWriter.close();
                                    text.setText("It is safe to close this window");
                                }catch(IOException e){
                                    System.out.println("An error occurred.");
                                }
                            }
                        });
                }
                else{
                    Scanner myReader = new Scanner(myObj);

                    while(myReader.hasNextLine()){
                        something = myReader.nextLine();
                    }
                    myReader.close();
                    text.setText("Type in your Password");
                    window5.add(text);
                    window5.add(textfield_password);
                    textfield_password.setText("");

                    JButton button_obj4 = new JButton("Enter");
                    window5.add(button_obj4);
                    button_obj4.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent x){

                                if (textfield_password.getText().equals(something)){
                                    window5.setVisible(false);
                                    MainPage window6 = new MainPage();
                                    window6.setBounds(300,300,1000,100);
                                    correct.setText("Correct Password");
                                    window6.add(correct);
                                    JButton button_obj5 = new JButton("Continue to Expense Calculator");
                                    window6.add(button_obj5);

                                    button_obj5.addActionListener(new UserPick1());
                                    window6.setVisible(true);
                                }
                                else{
                                    incorrect.setText("Password is Incorrect");
                                    window5.add(incorrect);
                                    window5.revalidate();
                                    window5.repaint();
                                }
                            }

                        });
                }
            }catch(IOException e){
                System.out.println("An error occurred.");
            }
            window5.setVisible(true);

        }
    }

    static String something2=""; 
    static String user2Password = "user2 password.txt";
    private static class Password2 implements ActionListener{
        public void actionPerformed(ActionEvent a){
            MainPageIncome window5 = new MainPageIncome();
            window5.setBounds(300,300,1000,400);

            try{
                File myObj = new File(user2Password);
                if(!myObj.exists()){
                    myObj.createNewFile();
                    System.out.println("File successfully created.");
                    text.setText("Create your Password");
                    window5.add(text);
                    window5.add(textfield_password);
                    JButton button_obj4 = new JButton("Save New Password");

                    window5.add(button_obj4);
                    button_obj4.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent j){
                                try{
                                    FileWriter myWriter = new FileWriter(user2Password, true);
                                    myWriter.append(textfield_password.getText());
                                    myWriter.close();
                                    text.setText("It is safe to close this window");
                                }catch(IOException e){
                                    System.out.println("An error occurred.");
                                }
                            }
                        });
                }
                else{
                    Scanner myReader = new Scanner(myObj);

                    while(myReader.hasNextLine()){
                        something = myReader.nextLine();
                    }
                    myReader.close();
                    text.setText("Type in your Password");
                    window5.add(text);
                    window5.add(textfield_password);
                    textfield_password.setText("");

                    JButton button_obj4 = new JButton("Enter");
                    window5.add(button_obj4);
                    button_obj4.addActionListener(new ActionListener(){
                            @Override
                            public void actionPerformed(ActionEvent x){

                                if (textfield_password.getText().equals(something)){
                                    window5.setVisible(false);
                                    MainPage window6 = new MainPage();
                                    window6.setBounds(300,300,1000,100);
                                    correct.setText("Correct Password");
                                    window6.add(correct);
                                    JButton button_obj5 = new JButton("Continue to Expense Calculator");
                                    window6.add(button_obj5);

                                    button_obj5.addActionListener(new UserPick2());
                                    window6.setVisible(true);
                                }
                                else{
                                    incorrect.setText("Password is Incorrect");
                                    window5.add(incorrect);
                                    window5.revalidate();
                                    window5.repaint();
                                }
                            }

                        });
                }
            }catch(IOException e){
                System.out.println("An error occurred.");
            }
            window5.setVisible(true);

        }
    }
    static String user2Income = "user2 income.txt";
    public static String user2_income(){
        try{
            File myObj = new File(user2Income);
            if(!myObj.exists()){
                myObj.createNewFile();
                System.out.println("File successfully created.");
            }
            else{
                Scanner myReader = new Scanner(myObj);
                while(myReader.hasNextLine()){
                    String something = myReader.nextLine();
                    return something;
                }
                myReader.close();
            }
        }catch(IOException e){
            System.out.println("An error occurred.");
        }
        return "No data yet";
    }
    
    static String user2Expense = "user2 expenses.txt";
    public static ArrayList user2_expenses(){
        ArrayList<String> listOfExpenses = new ArrayList<String>();
        try{
            File myObj = new File(user2Expense);
            if(!myObj.exists()){
                myObj.createNewFile();
                System.out.println("File successfully created.");
            }
            else{
                FileReader fr = new FileReader("user2 expenses.txt");

                // Created a string to store each character
                // to form word
                String s = new String();
                char ch;

                // checking for EOF
                while (fr.ready()) {
                    ch = (char)fr.read();

                    // Used to specify the delimiters
                    if (ch == '|') {

                        // Storing each string in arraylist
                        listOfExpenses.add(s.toString());

                        // clearing content in string
                        s = new String();
                    }
                    else {
                        // appending each character to string if the
                        // current character is not delimiter
                        s += ch;
                    }
                }
                if (s.length() > 0) {

                    // appending last line of strings to list
                    listOfExpenses.add(s.toString());
                }
                // storing the data in arraylist to array
                String[] array= listOfExpenses.toArray(new String[0]);

                return listOfExpenses;
            }
        }catch(IOException e){
            System.out.println("An error occurred bozo.");
        }
        return listOfExpenses;
    }
    
    private static class UserPick2 implements ActionListener{
        public void actionPerformed(ActionEvent h){
            MainPage2 window2 = new MainPage2();
            window2.setBounds(300,300,1000,400);
            window2.setDefaultCloseOperation(EXIT_ON_CLOSE);

            JPanel Income = new JPanel();
            Income.setLayout(new FlowLayout());
            Income.setBackground(Color.PINK);
            IncomeOutput.setText("User2 Income: " + user2_income());
            IncomeOutput.setForeground(Color.BLUE);
            Income.add(IncomeOutput);
            window2.add(Income);

            JPanel Expense = new JPanel();
            ArrayList<String> listOfExpenses = user2_expenses();
            Expense.setLayout(new GridLayout(listOfExpenses.size()+2,1));
            Expense.setBackground(Color.PINK);
            text.setText("User2 Expenses: ");
            Expense.add(text);

            if (listOfExpenses.size() == 0){
                JLabel ExpenseOutput = new JLabel();
                ExpenseOutput.setText("No Expenses Yet");
                Expense.add(ExpenseOutput);
            }
            else {
                for(int i = 0; i<listOfExpenses.size(); i++){

                    JLabel ExpenseOutput = new JLabel();
                    String holder = listOfExpenses.get(i);
                    ExpenseOutput.setText(holder);
                    Expense.add(ExpenseOutput); 

                }
            }
            window2.add(Expense);

            JPanel Buttons = new JPanel();
            Buttons.setBackground(Color.PINK);
            Buttons.setLayout(new FlowLayout());
            JButton button_obj3 = new JButton("Change Income");
            Buttons.add(button_obj3);
            button_obj3.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent i){
                        MainPageIncome window3 = new MainPageIncome();
                        window3.setBounds(300,300,1000,300);

                        JPanel Enter = new JPanel();
                        Enter.setBackground(Color.PINK);
                        Enter.setLayout(new FlowLayout());

                        EnterIncome.setText("Enter New Income");
                        Enter.add(EnterIncome);

                        File myObj = new File(user2Income);
                        myObj.delete();
                        Enter.add(textfield_income);
                        user2_income();

                        window3.add(Enter);

                        JButton button_obj4 = new JButton("Save New Income");
                        window3.add(button_obj4);
                        button_obj4.addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent j){
                                    try{
                                        FileWriter myWriter = new FileWriter(user2Income);
                                        myWriter.append(textfield_income.getText());
                                        myWriter.close();
                                    } catch (IOException f) {
                                        System.out.println("Failed to Save");
                                    }

                                    Expense.removeAll();
                                    ArrayList<String> listOfExpenses = user2_expenses();
                                    Expense.setLayout(new GridLayout(listOfExpenses.size()+2,1));
                                    text.setText("User2 Expenses: ");
                                    Expense.add(text);
                                    if (listOfExpenses.size() == 0){
                                        JLabel ExpenseOutput = new JLabel();
                                        ExpenseOutput.setText("No Expenses Yet");
                                        Expense.add(ExpenseOutput);
                                    }
                                    else {
                                        for(int i = 0; i<listOfExpenses.size(); i++){

                                            JLabel ExpenseOutput = new JLabel();
                                            String holder = listOfExpenses.get(i);
                                            ExpenseOutput.setText(holder);
                                            Expense.add(ExpenseOutput); 

                                        }
                                    }
                                    IncomeOutput.setText("Your Income: " +user2_income());

                                    window2.revalidate();
                                    window2.repaint();

                                }

                            });
                        Close.setText("Close this window when done and saved.");
                        window3.add(Close);

                        window3.setVisible(true);
                    }
                });

            JButton button_obj4 = new JButton("Reset Expenses");
            Buttons.add(button_obj4);
            button_obj4.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent j){
                        File myObj = new File(user2Expense);
                        myObj.delete();
                        Expense.removeAll();
                        ArrayList<String> listOfExpenses = user2_expenses();
                        Expense.setLayout(new GridLayout(listOfExpenses.size()+2,1));
                        text.setText("User2 Expenses: ");
                        Expense.add(text);
                        if (listOfExpenses.size() == 0){
                            JLabel ExpenseOutput = new JLabel();
                            ExpenseOutput.setText("No Expenses Yet");
                            Expense.add(ExpenseOutput);
                        }
                        else {
                            for(int i = 0; i<listOfExpenses.size(); i++){

                                JLabel ExpenseOutput = new JLabel();
                                String holder = listOfExpenses.get(i);
                                ExpenseOutput.setText(holder);
                                Expense.add(ExpenseOutput); 

                            }
                        }
                        window2.revalidate();
                        window2.repaint();
                    }
                });

            JButton button_obj5 = new JButton("Add an Expense");
            Buttons.add(button_obj5);
            button_obj5.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent j){
                        MainPageExpense window4 = new MainPageExpense();
                        window4.setBounds(300,300,1000,300);

                        JPanel Enter = new JPanel();
                        Enter.setBackground(Color.PINK);
                        Enter.setLayout(new FlowLayout());

                        EnterExpenseN.setText("Enter Expense Name");

                        Enter.add(EnterExpenseN);
                        Enter.add(textfield_expensename);

                        EnterExpenseA.setText("Enter Expense Amount");
                        Enter.add(EnterExpenseA);
                        Enter.add(textfield_expenseamount);

                        window4.add(Enter);

                        JButton button_obj4 = new JButton("Save Expense");
                        window4.add(button_obj4);
                        button_obj4.addActionListener(new ActionListener(){
                                @Override
                                public void actionPerformed(ActionEvent j){
                                    try{
                                        File myObj = new File(user2Income);
                                        File myObj2 = new File(user2Expense);
                                        Scanner myReader = new Scanner(myObj);
                                        String income = "";
                                        String expenseA = "";
                                        expenseA=(textfield_expenseamount.getText());
                                        while(myReader.hasNextLine()){
                                            income = myReader.nextLine();

                                        }
                                        myReader.close();
                                        double i = Integer.parseInt(income);
                                        double e = Integer.parseInt(expenseA);
                                        double p = e/i*100; 
                                        FileWriter myWriter = new FileWriter(user2Expense, true);
                                        myWriter.append(textfield_expensename.getText() + ", " +expenseA + ", " + String.valueOf(p)+"% of income |");
                                        myWriter.close();
                                    } catch (IOException e) {
                                        System.out.println("Expense could not be added");
                                    }

                                    Expense.removeAll();
                                    ArrayList<String> listOfExpenses = user2_expenses();
                                    Expense.setLayout(new GridLayout(listOfExpenses.size()+2,1));
                                    text.setText("User2 Expenses: ");
                                    Expense.add(text);
                                    if (listOfExpenses.size() == 0){
                                        JLabel ExpenseOutput = new JLabel();
                                        ExpenseOutput.setText("No Expenses Yet");
                                        Expense.add(ExpenseOutput);
                                    }
                                    else {
                                        for(int i = 0; i<listOfExpenses.size(); i++){

                                            JLabel ExpenseOutput = new JLabel();
                                            String holder = listOfExpenses.get(i);
                                            ExpenseOutput.setText(holder);
                                            Expense.add(ExpenseOutput); 

                                        }
                                    }

                                    window2.revalidate();
                                    window2.repaint();
                                }
                            });
                        Close.setText("Close this window when done and saved.");
                        window4.add(Close);

                        window4.setVisible(true);
                    }
                });
            window2.add(Expense);
            window2.add(Buttons);
            window2.setVisible(true);
        }
    }
    
    
}
