package messagetranslator;

// imports for button listener
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// imports for hashmaps, locale and resource bundle
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
// imports for the frame and its components
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
// import for the alert message
import javax.swing.JOptionPane;

// class for running the program
public class MessageTranslator {

    // hashmaps to store the language and country codes for each language
    Map<String, String> language_codes = new HashMap<>();
    Map<String, String> country_codes = new HashMap<>();
    // frame used for adding components
    JFrame frame = new JFrame("Message Translator"); 
    // label for combo box
    JLabel label = new JLabel("Select a language to see a message :");
    // combo box for showing the languages
    JComboBox combo = new JComboBox();
    // button used for showing the message
    JButton button = new JButton("Show Message"); 
    
    // constructor - used for adding key/value pairs to both hashmaps
    public MessageTranslator(){
        language_codes.put("Chinese", "cn");
        language_codes.put("Danish", "dk");
        language_codes.put("Dutch", "nl");
        language_codes.put("English", "en");
        language_codes.put("French", "fr");
        language_codes.put("German", "de");
        language_codes.put("Irish", "ga");
        language_codes.put("Italian", "it");
        language_codes.put("Japanese", "ja");
        language_codes.put("Polish", "pl");
        language_codes.put("Portugese", "pt");
        language_codes.put("Russian", "ru");
        language_codes.put("Spanish", "es");
        language_codes.put("Swedish", "se");
        
        country_codes.put("Chinese", "CN");
        country_codes.put("Danish", "DK");
        country_codes.put("Dutch", "NL");
        country_codes.put("English", "US");
        country_codes.put("French", "FR");
        country_codes.put("German", "DE");
        country_codes.put("Irish", "IE");
        country_codes.put("Italian", "IT");
        country_codes.put("Japanese", "JP");
        country_codes.put("Polish", "PL");
        country_codes.put("Portugese", "PT");
        country_codes.put("Russian", "RU");
        country_codes.put("Spanish", "ES");
        country_codes.put("Swedish", "SE");         
    }
    
    // function to add the components to the frame
    public void populateFrame() {  
       // set the bounds (x, y, width, height) of the label on the frame
        label.setBounds(100, 10, 250, 100);         
        // set the position of the combo box on the frame
        combo.setBounds(100, 80, 130, 30);
        // add each language as an item to the combo box list
        combo.addItem("Chinese");
        combo.addItem("Danish");
        combo.addItem("Dutch");
        combo.addItem("English");
        combo.addItem("French");
        combo.addItem("German");
        combo.addItem("Irish");
        combo.addItem("Italian");
        combo.addItem("Japanese");
        combo.addItem("Polish");
        combo.addItem("Portugese");
        combo.addItem("Russian");
        combo.addItem("Spanish");
        combo.addItem("Swedish");        
        // set the default item to English
        combo.setSelectedItem("English");
        // set the bounds for the button on the frame
        button.setBounds(100, 120, 140, 40);    
        // add each component to the frame
        frame.add(label);
        frame.add(combo);
        frame.add(button);    
        // set the size of the frame
        frame.setSize(400, 300);
        // we don't want a particular layout
        frame.setLayout(null);    
        // this is necessary or else the frame wont appear
        frame.setVisible(true);  
        // the frame size cannot be changed
        frame.setResizable(false);
        // set the x and y position of the frame 
        frame.setLocation(200, 200);     
        // allow the program to stop running when the frame is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        // add a listener for when the button is clicked
        button.addActionListener(new ActionListener() {
           
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // get the selected item from the combo box 
                String value = (String) combo.getSelectedItem();
                // get the language code stored in the hashmap using the language as a key
                String lang = language_codes.get(value);
                // get the country code stored in the hashmap using the language as a key
                String country = country_codes.get(value);
                // set the default locale using the values retrieved from the hashmaps
                Locale.setDefault(new Locale(lang, country));
                // use the locale to find the appropriate file in the messages package
                ResourceBundle bundle = ResourceBundle.getBundle("messages.MessageBundle", Locale.getDefault());
                // get the greeting variable from the file
                String text = bundle.getString("greeting");
                // show an alert message with the greeting
                JOptionPane.showMessageDialog(null, text);                      			
            }          
        });
    }   // end function
                
    
    public static void main(String[] args) {
        // create an instance of the class
        MessageTranslator message = new MessageTranslator();
        // call function to show frame
        message.populateFrame();
    }
    
}   // end class
