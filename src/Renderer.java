import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.JPanel;

public class Renderer extends JPanel{
	
	private static final long serialVersionUID = 1L;
	public int backgroundSelected;
	
	BufferedImage img = null;
    public Renderer(int theme){
    	this.backgroundSelected = theme;
    }
	
	@Override
	public void paintComponent(Graphics g){
			
            
//            if(this.backgroundSelected == 0){
//                            try {
//                                img = ImageIO.read(new File("\\Users\\Rohit\\BlackBackground.jpg"));
//                            } catch (IOException ex) {
//                                Logger.getLogger(Renderer.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                                    g.drawImage(img,0,0,getWidth(),getHeight(),null);
////				    g.setColor(Color.BLACK);
////                                    g.fillRect(0, 0,700, 700);
////                                    g.setColor(Color.WHITE);
////                                  g.setStroke(new BasicStroke(4));
////                                    g.drawLine(getWidth()/2, 0, getWidth()/2, getHeight());
////                                    g.drawOval(getWidth()/2 - 75, getHeight()/2 - 75, 150, 150);
////				    img = ImageIO.read(new File("C:\\Users\\Afzal_Shama\\git\\Ping-Pong\\src\\images\\ImageFire.jpg"));				
//			}else if(this.backgroundSelected == 1){
//				try {
//				    img = ImageIO.read(new File("C:\\Users\\Afzal_Shama\\git\\Ping-Pong\\src\\images\\ImageFire.jpg"));
//                                    g.drawImage(img,0,0,getWidth(),getHeight(),null);
//				} catch (IOException e) {
//				    e.printStackTrace();
//				}
//			}else if(this.backgroundSelected == 2){
//				try {
//				    img = ImageIO.read(new File("C:\\Users\\Afzal_Shama\\git\\Ping-Pong\\src\\images\\OceanGif.gif"));
//                                    g.drawImage(img,0,0,getWidth(),getHeight(),null);
//				} catch (IOException e) {
//				    e.printStackTrace();
//				}
//			}
//        
//			
			super.paintComponent(g);
			Pong.pong.render((Graphics2D)g);
//			BufferedImage img = ImageIO.read(new File("C:\\Users\\Afzal_Shama\\git\\Ping-Pong\\src\\images\\playgroung.jpg"));
//			JLabel background = new JLabel(new ImageIcon(img));
//			Image img = Toolkit.getDefaultToolkit().createImage("images\\playgroung.jpg");
//	        add(background);
			
//		}
		
	}
		
}
