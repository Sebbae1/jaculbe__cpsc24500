package StoryEditor;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.LinkedHashMap;
import java.util.ArrayList;

import java.io.File;

public class StoryEditorGUI extends JFrame {
    //I learned there is no need to implement the ActionListener when using anonymous inner classes
    private JTextArea storyBoard;
    private LinkedHashMap<String,ArrayList<String>> words;
    private WordChooser rwc;

    public void setUpMenu(){
        //Creating the Menu Bar
        JMenuBar menuBar = new JMenuBar();
        //Setting the Menu Bar
        setJMenuBar(menuBar);

        //Creating the File Menu
        JMenu fileMenu = new JMenu("File");
        //Adding the File Menu
        menuBar.add(fileMenu);

        //Creating the Help Menu
        JMenu helpMenu = new JMenu("Help");
        //Adding the Help Menu
        menuBar.add(helpMenu);

        //Creating the Open menu item
        JMenuItem openItem = new JMenuItem("Open");
        //Adding a listener to the menu item
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //Create a JFileChooser
                JFileChooser chooser = new JFileChooser();
                //Check if approved
                if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
                    //Try catch getting the words from the WordFileReader in a LinkedHashMap<String,ArrayList<String>>
                    try{
                        words = WordFileReader.fileReader(chooser.getSelectedFile());
                    } catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "An error occurred.");
                    }
                }
            }
        });
        //Adding the Open menu item to the File Menu
        fileMenu.add(openItem);

        //Creating a new Save menu item
        JMenuItem saveItem = new JMenuItem("Save");
        //Adding an action listener
        saveItem.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Try catch to save the text area
                try{
                    //Create a JFileChooser
                    JFileChooser chooser = new JFileChooser();
                    //Check if approved
                    if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
                        //Takes the file and then uploads the storyBoard text into the file to be saved
                        File selectedFile = chooser.getSelectedFile();
                        boolean success = StoryWriter.saveStory(storyBoard.getText(), selectedFile.getAbsolutePath());
                        if(success){
                            //Displays the file was saved
                            JOptionPane.showMessageDialog(null, "Saved.");
                        } else {
                            //Displays the file failed to be saved
                            JOptionPane.showMessageDialog(null, "Failed to Save.");
                        }
                    }
                } catch (Exception ex){
                    //Displays an error message
                    JOptionPane.showMessageDialog(null,"An error occurred.");
                }
            }
        });
        //Adding the Save menu item to the File menu
        fileMenu.add(saveItem);

        //Creating a new Clear menu item
        JMenuItem clearItem = new JMenuItem("Clear");
        //Adding an action listener
        clearItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                //Clears the text
                storyBoard.setText("");
            }
        });
        //Adding the Clear menu item to the File menu
        fileMenu.add(clearItem);

        //Creating a new Exit menu item
        JMenuItem exit = new JMenuItem("Exit");
        //Adding an action listener
        exit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Exits the GUI
                System.exit(0);
            }
        });
        //Adding the Exit menu item to the File menu
        fileMenu.add(exit);

        //Creating a new About menu Item
        JMenuItem about = new JMenuItem("About");
        //Adding an action listener
        about.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //Shows the creation and creator of the GUI
                JOptionPane.showMessageDialog(null,"Story Editor by Sebastian Jaculbe, December 2024");
            }
        });
        //Adding the About menu item to the Help menu
        helpMenu.add(about);
    }

    public void setupGUI(){
        //Creating the base of the GUI
        setBounds(400,200,600,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Close the application upon clicking on the X
        setTitle("Story Editor");
        //Creating the heavyweight of the GUI
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //This part is also from ChatGPT
        JScrollPane scrollPane = new JScrollPane(storyBoard);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        //Adding the scroll pane to the content pane at the center
        contentPane.add(scrollPane, BorderLayout.CENTER);

        //Creating the panel for the west side of the screen
        //This section consists of the Panel, the GridLayout, and the Buttons
        JPanel panelWest = new JPanel();
        GridLayout gridLayout = new GridLayout(3,1);
        panelWest.setLayout(gridLayout);
        //Creating the buttons
        JButton noun = new JButton("Noun");
        noun.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(words!=null){
                    //Create an ArrayList that stores all the noun words
                    ArrayList<String> nouns = words.get("n");
                    if(nouns != null && !nouns.isEmpty()){
                        storyBoard.append(rwc.chooseWord(nouns) + " ");
                    } else {
                        //Displays the list is empty
                        JOptionPane.showMessageDialog(null,"No nouns available.");
                    }
                } else {
                    //Displays the list is empty
                    JOptionPane.showMessageDialog(null, "No words found.");
                }
            }
        });
        JButton verb = new JButton("Verb");
        verb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(words!=null){
                    //Create an ArrayList that stores all the verb words
                    ArrayList<String> verbs = words.get("v");
                    if(verbs != null && !verbs.isEmpty()){
                        storyBoard.append(rwc.chooseWord(verbs) + " ");
                    } else {
                        //Displays the list is empty
                        JOptionPane.showMessageDialog(null, "No verbs available.");
                    }
                } else {
                    //Displays the list is empty
                    JOptionPane.showMessageDialog(null, "No words found.");
                }
            }
        });
        JButton adjective = new JButton("Adjective");
        adjective.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(words!=null){
                    //Create an ArrayList that stores all the adjective words
                    ArrayList<String> adjectives = words.get("a");
                    if(adjectives != null && !adjectives.isEmpty()){
                        storyBoard.append(rwc.chooseWord(adjectives) + " ");
                    } else {
                        //Displays the list is empty
                        JOptionPane.showMessageDialog(null, "No adjectives available.");
                    }
                } else {
                    //Displays the list is empty
                    JOptionPane.showMessageDialog(null, "No words found.");
                }
            }
        });
        //Adding the buttons to the panel
        panelWest.add(noun);
        panelWest.add(verb);
        panelWest.add(adjective);
        contentPane.add(panelWest, BorderLayout.WEST); //Officially, set the panel to the west side of the screen

        //Creating a new text area
        //This section consists of the TextArea
        storyBoard = new JTextArea();
        storyBoard.setEditable(false);      //Prevents the text area from being editable
        //Lines 228 and 229 are from ChatGPT
        storyBoard.setLineWrap(true);           //Enables line wrapping
        storyBoard.setWrapStyleWord(true);      //Wraps lines at word boundaries
        contentPane.add(storyBoard, BorderLayout.CENTER); //Set the layout at the center

        //Creating a new panel for the south side of the screen
        //This section consists of the Panel and the FlowLayout
        JPanel panelSouth = new JPanel();
        FlowLayout flowLayout = new FlowLayout();
        panelSouth.setLayout(flowLayout);

        //Creating a label
        //This section consists of the Label
        JLabel labelEnterText = new JLabel("Enter word: ");
        panelSouth.add(labelEnterText);

        //Creating a text field
        //This section consists of the TextField
        JTextField textFieldEnterText = new JTextField(20);
        panelSouth.add(textFieldEnterText);

        //Creating a button
        //This section consists of the Button with an action listener
        JButton buttonAdd = new JButton("Add");
        buttonAdd.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               String typedText = textFieldEnterText.getText(); //Get the text from the user
               String currentText = storyBoard.getText(); //Get the text from the story board
               //The if statement from ChatGPT to validate the user's input
               if (!typedText.trim().isEmpty()) {
                   storyBoard.setText(" " + currentText + " " + typedText.trim()); //Separate with a space
                   textFieldEnterText.setText(""); //Clear the field
               } else {
                   JOptionPane.showMessageDialog(null, "Please enter a valid word.");
               }
            }
        });

        panelSouth.add(buttonAdd);
        contentPane.add(panelSouth, BorderLayout.SOUTH); //Officially set the panel to the south side of the screen

        //Call the setUpMenu method
        setUpMenu();
    }

    public StoryEditorGUI(){
        words = null;
        rwc = new WordChooser();
        setupGUI();
    }
}