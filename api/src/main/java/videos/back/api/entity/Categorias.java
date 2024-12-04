package videos.back.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "categoria")
public class Categorias {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String tituloCategotia;
	
	public Categorias() {
		
	}
	
	public Categorias(String tituloCategotia) {
		this.tituloCategotia = tituloCategotia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTituloCategotia() {
		return tituloCategotia;
	}

	public void setTituloCategotia(String tituloCategotia) {
		this.tituloCategotia = tituloCategotia;
	}
	
}
