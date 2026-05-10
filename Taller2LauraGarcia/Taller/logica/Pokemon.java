package logica;
//Autor: Laura Garcia 
//Rut: 26427249-k
//Paracelo c2 

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
	private String estado;
	
	
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
		this.estado = "Vivo";
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


	public String getEstado() {
		return estado;
	}
	
	
	
	
	public void setEstado(String estado) {
		this.estado = estado;
	}


	//metodo para sumar las estadisticas del pokemon
	public int calcularStatusTotales() {
		return vida + ataque + defensa + ataqueEspecial + defensaEspecial + velocidad; 
	}
	
	
	
	
	public Pokemon copiarPokemon() {
	    Pokemon copia = new Pokemon(
	            this.tipoPokemon,
	            this.habitat,
	            this.porcentajeAparicion,
	            this.vida,
	            this.ataque,
	            this.defensa,
	            this.ataqueEspecial,
	            this.defensaEspecial,
	            this.velocidad,
	            this.tipo
	    );

	    copia.setEstado(this.estado);

	    return copia;
	}
}
	