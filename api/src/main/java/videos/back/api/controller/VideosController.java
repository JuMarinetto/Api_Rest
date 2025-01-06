package videos.back.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ClientHttpResponseDecorator;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import videos.back.api.entity.Videos;
import videos.back.api.repository.VideosRepository;
import videos.back.api.service.VideosService;

@RestController
@RequestMapping("/videos")
public class VideosController {

	private VideosService service;

	public VideosController(VideosService service) {
		this.service = service;
	}

	@PostMapping("/cad")
	List<Videos> create(@RequestBody Videos videos) {
		return service.create(videos);
	}

	@GetMapping("/pag")
	public Page<Videos> getVideos(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size) {
		return service.getVideos(page, size);
	}

	@GetMapping
	List<Videos> list() {
		return service.list();
	}

	@GetMapping("{id}")
	public ResponseEntity<Videos> getById(@PathVariable Long id) {
		Videos videos = service.getById(id);
		return ResponseEntity.ok(videos);
	}

	@GetMapping("{id}/idcategoria")
	public ResponseEntity<List<Videos>> getVideosByCategoria(@PathVariable Long id) {
		List<Videos> videos = service.getVideosByCategoria(id);
		if (videos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(videos);
	}

	@GetMapping("/search")
	public ResponseEntity<List<Videos>> searchByTitle(@RequestParam("search") String titulo) {
		List<Videos> videos = service.searchByTitle(titulo);
		if (videos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(videos);
	}

	@PutMapping("/update")
	List<Videos> update(@RequestBody @Valid Videos videos) {
		return service.update(videos);
	}

	@DeleteMapping("/delete/{id}")
	List<Videos> delete(@PathVariable("id") Long id) {
		return service.delete(id);
	}
}
