package codigo;

import java.awt.Color;
import java.awt.event.MouseEvent;

import acm.graphics.GImage;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class Arkanoid extends GraphicsProgram {

	static final int ANCHO_LADRILLO = 35;
	static final int ALTO_LADRILLO = 15;
	static final int ANCHO_PANTALLA = 520;
	
	Bola bola1 = new Bola(10, 10, Color.RED);
	Cursor miCursor = new Cursor(0, 400, 60, 10, Color.GREEN);
	
	GImage fondo = new GImage("imagenes/fondo.png");
	GRect fondoMarcador = new GRect(300, 600);
	Marcador miMarcador = new Marcador(20, 40);
	
	public void init(){
		fondoMarcador.setFilled(true);
		add(fondoMarcador, ANCHO_PANTALLA- 30,0);
		add(fondo);
		addMouseListeners();
		add(bola1, 50, 100);
		add(miCursor);
		setSize(ANCHO_PANTALLA + 300 ,500);
	}
	
	public void run(){
		creaPiramide();
		miMarcador.addMarcador(this);
		while (true){
			bola1.muevete(this); //paso el objeto arkanoid que se est? ejecutando
			pause(10);
			miCursor.muevete(ANCHO_PANTALLA - 30, (int) bola1.getX());
		}
	}
	
	public void mouseMoved(MouseEvent evento){
		miCursor.muevete(ANCHO_PANTALLA - 30, evento.getX());
	}
	
	
	
	private void creaPiramide(){
		int numeroLadrillos = 13;
		int desplazamiento_inicial_X = 20;
		int desplazamiento_inicial_Y = 15;
		
		for (int j=0; j<numeroLadrillos; j++){
			for (int i=j; i<numeroLadrillos; i++){
				Ladrillo3 miLadrillo = new Ladrillo3("imagenes/ladrillo1.png");

				add(miLadrillo
					,ANCHO_LADRILLO*i - ANCHO_LADRILLO/2*j + desplazamiento_inicial_X
					,ALTO_LADRILLO*j + desplazamiento_inicial_Y );
			}
		}
	}
	
	
}
