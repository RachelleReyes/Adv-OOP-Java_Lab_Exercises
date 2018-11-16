package modelo;

import java.awt.Color;
import java.awt.Component;
import java.util.Random;

public class Cuadrado implements Runnable{
	private int x;
	private int y;
	private Color color;
	private int size;
	private int dx;
	private int dy;
	private Component panelDibujo;
	//private Random random = new Random();
	
	public int getX() {
		return x;
	}
	public Cuadrado(int x, int y, Color color, int size, int dx, int dy) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.size = size;
		this.dx = dx;
		this.dy = dy;
	}
	
	public Cuadrado(int x, int y, Color color, int size, int dx, int dy, Component panelDibujo) {
		super();
		this.x = x;
		this.y = y;
		this.color = color;
		this.size = size;
		this.dx = dx;
		this.dy = dy;
		this.panelDibujo = panelDibujo;
	}
	
	public Component getPanelDibujo() {
		return panelDibujo;
	}
	public void setPanelDibujo(Component panelDibujo) {
		this.panelDibujo = panelDibujo;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getDx() {
		return dx;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	public int getDy() {
		return dy;
	}
	public void setDy(int dy) {
		this.dy = dy;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	
	public void mover() {
		x+=dx;
		y+=dy;
		if(x+size>panelDibujo.getWidth()) {
			dx = -dx;
			x=panelDibujo.getWidth()-size;
			this.setColor(Color.BLUE);
		}
		if(x<=0) {
			dx = -dx;
			x=0;
			this.setColor(Color.YELLOW);

		}
		if(y+size>panelDibujo.getHeight()) {
			dy = -dy;
			y=panelDibujo.getHeight()-size;
			this.setColor(Color.GREEN);
		}
		if(y<=0) {
			dy = -dy;
			y=0;
			this.setColor(Color.CYAN);
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		//for(int i=0;i<1000;i++) {
		while(true){
			mover();
			panelDibujo.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
