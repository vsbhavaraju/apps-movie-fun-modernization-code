package org.superbiz.moviefun.albumsui;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestOperations;
import org.superbiz.moviefun.moviesui.MovieInfo;

import java.util.List;

public class AlbumClient {


    private static ParameterizedTypeReference<List<AlbumInfo>> albumListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
    };

    private String albumsUrl;
    private RestOperations restOperations;

    public AlbumClient(String albumsUrl, RestOperations restOperations) {
        this.albumsUrl = albumsUrl;
        this.restOperations = restOperations;
    }

    public void addAlbum(AlbumInfo albumInfo){
        restOperations.postForEntity(albumsUrl, albumInfo, AlbumInfo.class);

    }

    public AlbumInfo find(long id){
        return restOperations.getForEntity(albumsUrl + "/" + id, AlbumInfo.class).getBody();
    }

    public List<AlbumInfo> getAlbums(){
        return restOperations.exchange(albumsUrl, HttpMethod.GET, null,albumListType).getBody();
    }

    public void deleteAlbum(AlbumInfo albumInfo){
        restOperations.delete(albumsUrl + "/" + albumInfo.getId());
    }

    public void updateAlbum(AlbumInfo albumInfo){
        restOperations.put(albumsUrl,albumInfo,AlbumInfo.class);
    }


}
