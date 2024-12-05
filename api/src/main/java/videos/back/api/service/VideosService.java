package videos.back.api.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import videos.back.api.entity.Videos;
import videos.back.api.repository.VideosRepository;

@Service
public class VideosService {

	private VideosRepository repository;
	
	public VideosService(VideosRepository repository) {
		this.repository = repository;
	}
	
	public List<Videos> create(Videos videos){
		repository.save(videos);
		return list();
	}

	public List<Videos> list() {
		Sort sort = Sort.by("id").ascending().and(
				Sort.by("titulo").ascending());
		return repository.findAll(sort);
	}
	
	public List<Videos> update(Videos videos){
		repository.save(videos);
		return list();
	}
	
	public List<Videos> delete(Long id){
		repository.deleteById(id);
		return list();
	}
	
	public Videos getById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Video não encontrado" + id)); 
	}
	
	public List<Videos> getVideosByCategoria(Long categoria_id){
		return repository.findByCategoriaId(categoria_id);
	}

	public List<Videos> searchByTitle(String titulo) {
	    return repository.findByTituloContainingIgnoreCase(titulo);
	}
}
