import java.awt.*;
import java.nio.DoubleBuffer;

public class Main extends Canvas {

	static Stage stage;

	long lastStartTime = System.currentTimeMillis(); // used only for visualising frame rate

	public void gameLoop(){
		while(true){
			repaint(20);
		}
	}

	private Point subtractPoints(Point a, Point b){
		Point p = new Point();
		p.setLocation(a.getX() - b.getX(), a.getY() - b.getY());
		return p;
	}

	public void paint(Graphics g){
		Point mouseLoc = subtractPoints(MouseInfo.getPointerInfo().getLocation(), this.getLocationOnScreen());
		stage.draw(g, mouseLoc);
	}
	public void update(Graphics g){
		Point mouseLoc = subtractPoints(MouseInfo.getPointerInfo().getLocation(), this.getLocationOnScreen());
		stage.draw(g, mouseLoc);
	}
	public static void main(String[] args){
		System.out.println("Sheep and Wolves");
		stage = new Stage();

		Main p = new Main();
		p.setPreferredSize(new Dimension(1280,720));
		javax.swing.JFrame frame = new javax.swing.JFrame("Sheep and Wolves");
		frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		frame.add(p);
		frame.pack();
		frame.setVisible(true);
		frame.revalidate();
		frame.repaint();
		p.gameLoop();			
	}
}