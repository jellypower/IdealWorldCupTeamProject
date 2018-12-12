import java.awt.Image;
import javax.swing.ImageIcon;

public class EntryComponent implements Comparable<EntryComponent>{
    public ImageIcon image, image2;
    public Image cdImage;
    public String name;
    public int victoryNum;

    public EntryComponent(String imageDir, String imageDir2, String name, int victoryNum){
        image = new ImageIcon(imageDir);
        image2 = new ImageIcon(imageDir2);
        this.name = name;
        this.victoryNum = victoryNum;
        cdImage = image.getImage();
        
        
        
        
        int imageWidth=image.getIconWidth();
        int imageHeight=image.getIconHeight();
        
        
        if(imageWidth>imageHeight) {
        	
        	imageHeight = (int)(imageHeight*(float)700/imageWidth);
        	imageWidth = 700;
        	
        }
        else {
        	imageWidth = (int)(imageWidth*(float)800/imageHeight);
        	imageHeight = 800;
        }
        
        System.out.println("2,"+imageWidth+","+imageHeight);
        
        image.setImage(cdImage.getScaledInstance(
        		imageWidth, 
        		imageHeight, 
        		Image.SCALE_SMOOTH));
        

        //image.setImage(cdImage.getScaledInstance(700, 700, Image.SCALE_SMOOTH));
        /*
        cdImage = image2.getImage();
        image2.setImage(cdImage.getScaledInstance(700, 800, Image.SCALE_SMOOTH));
    	*/
    }
    
    public EntryComponent(EntryComponent E) {
    	this.image = E.image;
    	this.image2 = E.image2;
    	this.name = E.name;
    	this.victoryNum = E.victoryNum;
    	cdImage = image.getImage();
    }

	@Override
	public int compareTo(EntryComponent arg) {
		return victoryNum - arg.victoryNum;

	}
}
