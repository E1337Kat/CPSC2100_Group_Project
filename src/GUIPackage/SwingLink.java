/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Class created by a stackoverflow user which fulfilled every need I had for a hyperlink in java
 * I did add one line that changes the cursor to the hand cursor on hover. and the javadoc comments
 * @author https://stackoverflow.com/users/1600562/ibrabelware
 */
public class SwingLink extends JLabel {
    private static final long serialVersionUID = 8273875024682878518L;
    private String text;
    private URI uri;

    /**
     * Constructs a swinglink element with provided text and URI
     * @param text String you wish to display
     * @param uri Link you wish to follow
     */
    public SwingLink(String text, URI uri){
        super();
        setup(text,uri);
    }

    /**
     * Constructs a swinglink element with provided text and URI
     * @param text String you wish to display
     * @param uri String representing link you wish to follow
     */
    public SwingLink(String text, String uri){
        super();
        URI oURI;
        try {
            oURI = new URI(uri);
        } catch (URISyntaxException e) {
            // converts to runtime exception for ease of use
            // if you cannot be sure at compile time that your
            // uri is valid, construct your uri manually and
            // use the other constructor.
            throw new RuntimeException(e);
        }
        setup(text,oURI);
    }

    /**
     * sets up the JLabel and link
     * @param t String to display
     * @param u URI to link to
     */
    public void setup(String t, URI u){
        text = t;
        uri = u;
        setText(text);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setToolTipText(uri.toString());
        addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    open(uri);
                }
                @Override
                public void mouseEntered(MouseEvent e) {
                    setText(text,false);
                }
                @Override
                public void mouseExited(MouseEvent e) {
                    setText(text,true);
                }
        });
    }

    /**
     * sets text of link
     * @param text text you wish to display
     */
    @Override
    public void setText(String text){
        setText(text,true);
    }

    /**
     * sets text of link and sets link look and feel
     * @param text text to display
     * @param ul boolean for checking underline
     */
    public void setText(String text, boolean ul){
        String link = ul ? "<u>"+text+"</u>" : text;
        super.setText("<html><span style=\"color: #000099;\">"+
                link+"</span></html>");
        this.text = text;
    }

    /**
     * gets the text provided
     * @return string
     */
    public String getRawText(){
        return text;
    }

    /**
     * opens the link in the default browser
     * @param uri link you wish to go to
     */
    private static void open(URI uri) {
        if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                try {
                        desktop.browse(uri);
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(null,
                            "Failed to launch the link, " +
                            "your computer is likely misconfigured.",
                            "Cannot Launch Link",JOptionPane.WARNING_MESSAGE);
                }
        } else {
            JOptionPane.showMessageDialog(null,
                    "Java is not able to launch links on your computer.",
                    "Cannot Launch Link",JOptionPane.WARNING_MESSAGE);
        }
    }
}