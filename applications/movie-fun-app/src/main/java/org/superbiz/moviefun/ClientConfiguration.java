package org.superbiz.moviefun;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;
import org.superbiz.moviefun.albumsui.AlbumClient;
import org.superbiz.moviefun.moviesui.MoviesClient;

@Configuration
public class ClientConfiguration {

    @Value("${movies.url}") String moviesUrl;

    @Value("${albums.url}") String albumsUrl;


    @Bean
    public RestOperations restOperations() {
        return new RestTemplate();
    }

    @Bean
    public MoviesClient moviesClient(RestOperations restOperations) {
        return new MoviesClient(moviesUrl, restOperations);
    }
    @Bean
    public AlbumClient albumClient(RestOperations restOperations) {
        return new AlbumClient(albumsUrl, restOperations);
    }
}
