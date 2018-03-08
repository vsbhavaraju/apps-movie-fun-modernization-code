package org.superbiz.moviefun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.superbiz.moviefun.albumsui.AlbumClient;
import org.superbiz.moviefun.albumsui.AlbumFixtures;
import org.superbiz.moviefun.albumsui.AlbumInfo;
import org.superbiz.moviefun.moviesui.MovieFixtures;
import org.superbiz.moviefun.moviesui.MovieInfo;
import org.superbiz.moviefun.moviesui.MoviesClient;

import java.util.Map;

@Controller
public class HomeController {

    private final MoviesClient moviesClient;
    private final AlbumClient albumClient;
    private final MovieFixtures movieFixtures;
    private final AlbumFixtures albumFixtures;

    public HomeController(MoviesClient moviesClient, AlbumClient albumClient, MovieFixtures movieFixtures, AlbumFixtures albumFixtures) {
        this.moviesClient = moviesClient;
        this.albumClient = albumClient;
        this.movieFixtures = movieFixtures;
        this.albumFixtures = albumFixtures;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/setup")
    public String setup(Map<String, Object> model) {
        for (MovieInfo movie : movieFixtures.load()) {
            moviesClient.addMovie(movie);
        }

        for (AlbumInfo album : albumFixtures.load()) {
            albumClient.addAlbum(album);
        }

        model.put("movies", moviesClient.getMovies());
        model.put("albums", albumClient.getAlbums());

        return "setup";
    }
}
