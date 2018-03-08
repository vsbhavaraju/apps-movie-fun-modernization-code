package org.superbiz.moviefun.albums;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumsController {


    private AlbumsRepository albumsRepository;

    public AlbumsController(AlbumsRepository albumsRepository) {
        this.albumsRepository = albumsRepository;
    }

    @PostMapping
    public void addAlbum(@RequestBody Album album) {
        albumsRepository.addAlbum(album);
    }

    @GetMapping
    public List<Album> index(){
        return albumsRepository.getAlbums();
    }

    @GetMapping("/{id}")
    public Album details(@PathVariable long id){
        return albumsRepository.find(id);
    }

}
