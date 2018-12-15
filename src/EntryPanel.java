import java.awt.*;
import javax.swing.*;

import sun.java2d.loops.ScaledBlit;

public class EntryPanel extends JPanel {
    private Point pt;
    private JLabel normal;
    private int velocity;
    private JLabel nameLabel;
    private EntryComponent E;

    public EntryPanel(int x, int y, EntryComponent E){
        pt = new Point();
        pt.x = x;
        pt.y = y;
        this.E = E;
        this.setLayout(null);
        this.setBounds(pt.x,pt.y,700,800);
        setBackground(Color.BLACK);
        nameLabel = new JLabel(this.E.name);
        normal = new JLabel(this.E.image);
        velocity = 0;
        normal.setBounds(
        		this.getWidth()/2-E.image.getIconWidth()/2,
        		this.getHeight()/2-E.image.getIconHeight()/2,
        		E.image.getIconWidth(),
        		E.image.getIconHeight());
        
        

        nameLabel.setFont(new Font("궁서체", Font.BOLD, 30));
        nameLabel.setSize(700, 50);
        nameLabel.setLocation(this.getWidth()/2-nameLabel.getWidth()/2,600);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setForeground(Color.orange);
        nameLabel.setOpaque(true);
        nameLabel.setBackground(new Color(0,0,0,150));
        this.add(nameLabel);
        this.add(normal);
    }

    public EntryPanel(){
    	setLayout(null);
    	setBackground(Color.BLACK);
    	nameLabel = new JLabel();
        normal = new JLabel();
        velocity = 0;
        normal.setBounds(0,0,700,800);
        

        nameLabel.setFont(new Font("궁서체", Font.BOLD, 30));
        nameLabel.setSize(700, 50);
        nameLabel.setLocation(0,600);
        nameLabel.setHorizontalAlignment(JLabel.CENTER);
        nameLabel.setForeground(Color.ORANGE);
        nameLabel.setOpaque(true);
        nameLabel.setBackground(new Color(0,0,0,150));
        this.add(nameLabel);
        this.add(normal);
    }
    
    public EntryPanel(EntryComponent E){
    	setBackground(Color.BLACK);
    	this.E = E;
    	nameLabel = new JLabel(this.E.name);
        normal = new JLabel(this.E.image);
        velocity = 0;
        normal.setBounds(
        		this.getWidth()/2-E.image.getIconWidth()/2,
        		this.getHeight()/2-E.image.getIconHeight()/2,
        		E.image.getIconWidth(),
        		E.image.getIconHeight());

        nameLabel.setFont(new Font("궁서체", Font.BOLD, 30));
        nameLabel.setBounds(300,710,180,40);
        nameLabel.setForeground(Color.ORANGE);
        this.add(nameLabel);
        this.add(normal);
    }
    

    public int getVelocity(){
        return this.velocity;
    }

    public void setVelocity(int velocity){
        this.velocity = velocity;
    }

    public int getPtX(){
        return this.pt.x;
    }

    public void setPtX(int x){
        this.pt.x = x;
    }

    public int getPtY(){
        return this.pt.y;
    }

    public void setPtY(int y){
        this.pt.y = y;
    }

    public Point getPt(){
        return this.pt;
    }
    
    public void setEntryComponent(EntryComponent param){
        E = param;
        nameLabel.setText(E.name);
        normal.setIcon(E.image);
        normal.setBounds(
        		this.getWidth()/2-E.image.getIconWidth()/2,
        		this.getHeight()/2-E.image.getIconHeight()/2,
        		E.image.getIconWidth(),
        		E.image.getIconHeight());
        
        
        
        //repaint();
    }
    
    public EntryComponent getEntryComponent() {
    	return this.E;
    }
    
    public void setSizeofElement() {
    	
    	normal.setVisible(false);
    	nameLabel.setVisible(false);
    }
    
    public void setReturnSize() {
    	normal.setVisible(true);
    	nameLabel.setVisible(true);
    }
    
}
