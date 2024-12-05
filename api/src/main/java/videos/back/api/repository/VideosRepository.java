package videos.back.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import videos.back.api.entity.Videos;

public interface VideosRepository extends JpaRepository<Videos, Long>{

	List<Videos> findByCategoriaId(Long categoria_id);
	
	List<Videos> findByTituloContainingIgnoreCase(String titulo);
}
