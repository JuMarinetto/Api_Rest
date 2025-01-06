package videos.back.api.security;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import videos.back.api.entity.Videos;
import videos.back.api.service.VideosService;

@RestController
public class MyController {

	private VideosService videoService;
	
	public MyController(VideosService videoService) {
        this.videoService = videoService;
    }
	
	 @GetMapping("/public")
	    public ResponseEntity<List<Videos>> getPublicVideos() {
	        List<Videos> videos = videoService.getFirstThreeVideos();
	        return ResponseEntity.ok(videos);
	    }

    @GetMapping("/protected")
    public ResponseEntity<String> protectedEndpoint() {
        return ResponseEntity.ok("Este é um endpoint protegido. Você está autenticado!");
    }
}
