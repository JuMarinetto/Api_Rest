package videos.back.api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import videos.back.api.entity.Categorias;
import videos.back.api.service.CategoriasService;

@RestController
@RequestMapping("/categoria")
public class CategoriasController {

	private CategoriasService service;
	
	public CategoriasController(CategoriasService service) {
		this.service = service;
	}
	
	@PostMapping("/cada")
	List<Categorias> create(@RequestBody Categorias categorias){
		return service.create(categorias);
	}
	
	@GetMapping
	List<Categorias> list(){
		return service.list();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Categorias> getCategoriaById(@PathVariable Long id){
		Categorias categorias = service.findCategoriaById(id);
		return ResponseEntity.ok(categorias);
	}
	
	@PutMapping
	List<Categorias> update(@RequestBody Categorias categorias){
		return service.update(categorias);
	}
	
	@DeleteMapping("/del/{id}")
	List<Categorias> delete(@PathVariable("id") Long id){
		return service.delete(id);
	}
}
