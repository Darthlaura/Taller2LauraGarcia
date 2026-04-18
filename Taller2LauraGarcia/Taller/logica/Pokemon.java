package logica;


public class Pokemon {
	
	private String tipoPokemon; 
	private String habitat;
	private double porcentajeAparicion; 
	private int vida; 
	private int ataque;
	private int defensa;
	private int ataqueEspecial; 
	private int defensaEspecial; 
	private int velocidad; 
	private String tipo; 
	private boolean estado;
	
	
	public Pokemon(String tipoPokemon, String habitat, double porcentajeAparicion, int vida, int ataque, int defensa,
			int ataqueEspecial, int defensaEspecial, int velocidad, String tipo) {
		this.tipoPokemon = tipoPokemon;
		this.habitat = habitat;
		this.porcentajeAparicion = porcentajeAparicion;
		this.vida = vida;
		this.ataque = ataque;
		this.defensa = defensa;
		this.ataqueEspecial = ataqueEspecial;
		this.defensaEspecial = defensaEspecial;
		this.velocidad = velocidad;
		this.tipo = tipo;
		this.estado = false;
	}


	public String getTipoPokemon() {
		return tipoPokemon;
	}


	public String getHabitat() {
		return habitat;
	}


	public double getPorcentajeAparicion() {
		return porcentajeAparicion;
	}


	public int getVida() {
		return vida;
	}


	public int getAtaque() {
		return ataque;
	}


	public int getDefensa() {
		return defensa;
	}


	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}


	public int getDefensaEspecial() {
		return defensaEspecial;
	}


	public int getVelocidad() {
		return velocidad;
	}


	public String getTipo() {
		return tipo;
	}


	public boolean isEstado() {
		return estado;
	}
	
	
	
	
}
	