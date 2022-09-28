package test.gif;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;


//"C:/Users/Shaco/Desktop/testgif1.gif"

/*public class TestGifsAnimation {
    public static void main(String[] args) throws IOException {
        JLabel label = new JLabel("test");
        //находит файл только из дирекории текущего класса
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(Solution.class.getResource("C:/Users/Shaco/Desktop/testgif1.gif")));
        icon.setImageObserver(label);
        label.setIcon(icon);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(icon.getIconWidth(), icon.getIconHeight());

        frame.add(label);

        frame.setVisible(true);
    }
}*/


public class TestGifsAnimation
{
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                JLabel jLabel = new JLabel("test");
                //судя по всему находит файл из любой директории
                Image image = Toolkit.getDefaultToolkit().createImage("C:/Users/Shaco/Desktop/testgif.gif");
                ImageIcon imageIcon = new ImageIcon(image);
                imageIcon.setImageObserver(jLabel);
                jLabel.setIcon(imageIcon);

                JFrame frame = new JFrame("test");
                frame.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());

                frame.add(jLabel);

                frame.setVisible(true);
            }
        });
    }
}
