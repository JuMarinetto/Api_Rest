package videos.back.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import videos.back.api.entity.Videos;

public interface VideosRepository extends JpaRepository<Videos, Long>{

}
