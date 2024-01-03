package view;

import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author wwwvf
 */
public class Gambar {
    static public void render(JLabel target, String imgPath) {
        File f = new File(String.format("src//upload//%s", imgPath));

        Image img = (new ImageIcon(f.toString())).getImage().getScaledInstance(
            target.getWidth(), target.getHeight(), Image.SCALE_SMOOTH
        );
        
        target.setText("");
        target.setIcon(new ImageIcon(img));
    }
}
