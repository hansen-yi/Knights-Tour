import java.util.Random;

import org.jfugue.player.Player;

import processing.core.PApplet;

public class Processing extends PApplet{
	private Player player= new Player();
	private Square start = new Square(4, 4);
	private int side = 5;
	private Knight test = new Knight(start, side, side);
	private int h=0;
	private Square[] tour = test.solve();
	private Random randy = new Random();
	

	public void settings(){
		size(600, 600);
	}
	
	public void setup(){
		frameRate(1);
		background(0,0,0);
		noStroke();
		
		for (int r=0; r<side;r++) {
			if (r%2==0) {
				for (int k=0; k<side; k++) {
					if (k%2==1) {
						fill(60,85,199);
						rect(k*width/side,r*width/side,width/side,width/side);
					}
					else {
						fill(203,240,247);
						rect(k*width/side,r*width/side,width/side,width/side);
					}
				}
			}
			else {
				for (int k=0; k<side; k++) {
					if (k%2==0) {
						fill(60,85,199);
						rect(k*width/side,r*width/side,width/side,width/side);
					}
					else {
						fill(203,240,247);
						rect(k*width/side,r*width/side,width/side,width/side);
					}
				}				
			}
		}
		if (h>tour.length) {
			player.play("I[Trumpet] Cq Cqq Cqqq");
		}
	}
	
	public void light(int h) {
		for (h=0; h<tour.length;h++) {
			for (int r=0; r<side;r++) {
				if (r%2==0) {
					for (int k=0; k<side; k++) {
						if (k%2==1) {
							fill(20,29,107);
							rect(test.solve()[h].getCol()*width/side,test.solve()[h].getRow()*width/side,width/side,width/side);
						}
						else {
							fill(20,29,107);
							rect(test.solve()[h].getCol()*width/side,test.solve()[h].getRow()*width/side,width/side,width/side);
						}
					}
				}
				else {
					for (int k=0; k<side; k++) {
						if (k%2==0) {
							fill(20,29,107);
							rect(test.solve()[h].getCol()*width/side,test.solve()[h].getRow()*width/side,width/side,width/side);
						}
						else {
							fill(20,29,107);
							rect(test.solve()[h].getCol()*width/side,test.solve()[h].getRow()*width/side,width/side,width/side);
						}
					}				
				}
//				delay(500);
			}
//			delay(1000);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Processing");
	}
	
	public void draw() {
		//repeating unless noloop() enabled
//		noLoop();
//		System.out.println(test.solve()[9]);
//		System.out.println(Arrays.toString(test.solve()));
//		player.play("C");
			if (h<tour.length){
				player.play("I14 Aqq");
				for (int r=0; r<side;r++) {
				if (r%2==0) {
					for (int k=0; k<side; k++) {
						if (k%2==1) {
							fill(20,29,107);
							stroke(255,255,255);
							rect(tour[h].getCol()*width/side,tour[h].getRow()*width/side,width/side,width/side);
						}
						else {
							fill(20,29,107);
							rect(tour[h].getCol()*width/side,tour[h].getRow()*width/side,width/side,width/side);
						}
					}
				}
				else {
					for (int k=0; k<side; k++) {
						if (k%2==0) {
							fill(20,29,107);
							rect(tour[h].getCol()*width/side,tour[h].getRow()*width/side,width/side,width/side);
						}
						else {
							fill(20,29,107);
							rect(tour[h].getCol()*width/side,tour[h].getRow()*width/side,width/side,width/side);
						}
					}				
				}
//				delay(500);
			}}
//			delay(1000);
		h++;
		if (h==tour.length) {
//			noLoop();
//			delay(500);
			rect(0,0,width,width);
//			delay(500);
			textSize(24);
			fill(255,255,255);
			textAlign(CENTER,CENTER);
			text("The Knight's Tour is Complete", width/2, width/2);
//			player.play("V0 I[Trumpet] G3q. G3i G3sss G3i G3q E3i G3q E3i G3qqq V1 I[Trumpet] C4q. C4i C4sss C4i E3i D3i E3ii D3i E3i E3qqq V3 I[Trumpet] G4q. G4i G4sss G4i C4i B4q C4i B4q C4qqq");
			player.play("V0 I[Trumpet] G5q. G5i G5sss G5i G5q E5i G5q E5i G5qqq V1 I[Trumpet] C5q. C5i C5sss C5i E5i D5i E5ii D5i E5i E5qqq V3 I[Trumpet] G4q. G4i G4sss G4i C5i B4q C5i B4q C5qqq");
			h++;
		}
		
		if(h>tour.length)	{
			noStroke();
			frameRate(3);
			for (h=0; h<tour.length;h++) {
				for (int r=0; r<side;r++) {
					if (r%2==0) {
						for (int k=0; k<side; k++) {
							if (k%2==1) {
								fill(randy.nextInt(255),randy.nextInt(255),randy.nextInt(255));
								rect(test.solve()[h].getCol()*width/side,test.solve()[h].getRow()*width/side,width/side,width/side);
							}
							else {
								fill(randy.nextInt(255),randy.nextInt(255),randy.nextInt(255));
								rect(test.solve()[h].getCol()*width/side,test.solve()[h].getRow()*width/side,width/side,width/side);
							}
						}
					}
					else {
						for (int k=0; k<side; k++) {
							if (k%2==0) {
								fill(randy.nextInt(255),randy.nextInt(255),randy.nextInt(255));
								rect(test.solve()[h].getCol()*width/side,test.solve()[h].getRow()*width/side,width/side,width/side);
							}
							else {
								fill(randy.nextInt(255),randy.nextInt(255),randy.nextInt(255));
								rect(test.solve()[h].getCol()*width/side,test.solve()[h].getRow()*width/side,width/side,width/side);
							}
						}				
					}
				}
			}
			fill(255,255,255);
			text("The Knight's Tour is Complete", width/2, width/2);
//			player.play("I[Trumpet] Cq Cqq Cqqq");
		}
		
//		throw new ArrayIndexOutOfBoundsException("Knight's Tour's is Complete");
//		light();
//		delay(500);
//		println(frameCount);
	}
}
 
