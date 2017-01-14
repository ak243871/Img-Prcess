import java.io.*;
import java.util.Scanner;
import java.awt.image.*;
import javax.imageio.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

class Img{
	
	String imgname;
	String nameofparticipant;
	String nameofCompetition;
	
	Scanner s1=new Scanner(System.in);
	
	Img(){
		
		System.out.println("ENTER PATH OF THE CERTIFICATE IMAGE");
		imgname=s1.nextLine();
		imageprocess();
		
	}
	
	void imageprocess(){
		
	
	try{
		
		
		File f=new File(imgname);
		
		BufferedImage bi=ImageIO.read(f);
		System.out.println("image reading success");
		
		Graphics g;
		g=bi.getGraphics();
		g.setFont(new Font("ALGERIAN", Font.ITALIC, 64));
		g.setColor(Color.black);
		
		System.out.println("ENTER NAME OF APPLICANT");
		nameofparticipant=s1.nextLine();
		if(nameofparticipant.length()>10){
			g.drawString(nameofparticipant, 640, 495);
		}
		else
		g.drawString(nameofparticipant, 720, 495);
		
		System.out.println("ENTER NAME OF COURSE/COMPETITION");
		nameofCompetition=s1.nextLine();
		
		
		if(nameofCompetition.length()>12){
			g.drawString(nameofCompetition, 640, 665);
		}
		else
		g.drawString(nameofCompetition, 750, 665);
		
		System.out.println("Writing complete!!");
		
		File f1=new File(getNewName());
		ImageIO.write(bi, "PNG", f1);
		System.out.println("Success");
		
		
		
	}catch(Exception ex){
		System.out.println(ex.getMessage());
	}
	
	}

	String getNewName()
    {
        int pos = imgname.lastIndexOf(".");
        return  imgname.substring(0, pos) + "_1" + imgname.substring(pos);
    }

	public static void main(String[] args) {
	
	try {
	
		Img im=new Img();
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
		// TODO: handle exception
	}

}
}
