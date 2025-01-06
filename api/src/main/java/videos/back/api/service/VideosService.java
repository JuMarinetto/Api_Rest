package videos.back.api.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	
	public List<Videos> getFirstThreeVideos() {
	    Sort sort = Sort.by("id").ascending();
	    List<Videos> videos = repository.findAll(sort);
	    return videos.subList(0, Math.min(3, videos.size())); 
	}
	
	 public Page<Videos> getVideos(int page, int size) {
	        Page<Videos> videosPage = repository.findAll(PageRequest.of(page, size));
	        return videosPage.map(video -> new Videos(video.getTitulo(), video.getUrl(), video.getDescricao(), video.getCategoria()));
	    }
}
