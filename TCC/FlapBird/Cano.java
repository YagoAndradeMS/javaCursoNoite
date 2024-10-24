package FlapBird;

public class Cano {
	
	public double x, y;
	public double vxcano;
	public static int HOLESIZE = 120;
	
	public boolean passed = false; // Verifica se o cano já foi ultrapassado
    public int largura = 52; // Largura do cano, pode ajustar conforme necessário

	
    // Hitbox do Cano
    public Hitbox boxcima;
    public Hitbox boxbaixo;
	
    public Cano(double x, double y, double vx) {
        this.x = x;
        this.y = y;
        this.vxcano = vx;

        // Ajustar a hitbox corretamente
        boxcima = new Hitbox(x, y - 270, x + largura, y);
        boxbaixo = new Hitbox(x, y + Cano.HOLESIZE, x + largura, 502 - 112); // O cano inferior termina no chão
    }

	public boolean isPassed() {  
	       
		 return passed;
		     }

		     public void setPassed(boolean passed) {
		         this.passed = passed;
		     }
	
	public void atualiza(double dt) {
		x += vxcano * dt;
		boxcima.mover(vxcano * dt, 0);
		boxbaixo.mover(vxcano * dt, 0);
	}
	
	public void desenha(Tela t) {
		t.imagem("Flap.png", 604, 0, 52, 270, 0, x, y-270); // Cano de cima
		t.imagem("Flap.png", 660, 0, 52, 242, 0, x, y+HOLESIZE); // Cano de baixo
	}
}
