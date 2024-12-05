package videos.back.api.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import videos.back.api.entity.Categorias;
import videos.back.api.repository.CategoriasRepository;

@Service
public class CategoriasService {

	private CategoriasRepository repository;
	
	public CategoriasService(CategoriasRepository repository) {
		this.repository = repository;
	}
	
	public List<Categorias> list(){
		Sort sort = Sort.by("id").ascending();
		return repository.findAll(sort);
	}
	
	public List<Categorias> create(Categorias categorias){
		repository.save(categorias);
		return list();
	}
	
	public List<Categorias> update( Categorias categorias){
		repository.save(categorias);
		return list();
	}
	
	public List<Categorias> delete(Long id){
		repository.deleteById(id);
		return list();
	}
	
	public Categorias findCategoriaById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria com ID " + id + " não encontrada."));
    }
	
	public Categorias getCategoriaById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Categoria não encontrada" + id));
	}
	
	
}
