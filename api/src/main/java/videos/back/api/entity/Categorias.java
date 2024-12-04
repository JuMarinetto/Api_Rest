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
	private String titulo_categoria;
	
	public Categorias() {
		
	}
	
	public Categorias(String titulo_categoria) {
		this.titulo_categoria = titulo_categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo_categoria() {
		return titulo_categoria;
	}

	public void setTitulo_categoria(String titulo_categoria) {
		this.titulo_categoria = titulo_categoria;
	}

	
	
}
