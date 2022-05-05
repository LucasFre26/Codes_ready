
public class Vagao {
	public String elemento;
	public Vagao prox;
	
	public Vagao() {
		this(null);
	}

	public Vagao(String elemento) {
      this.elemento = elemento;
      this.prox = null;
	}
}
