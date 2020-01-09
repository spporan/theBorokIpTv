package com.example.theborokiptv.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TvModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("slug")
    @Expose
    private String slug;
    @SerializedName("release_year")
    @Expose
    private Integer releaseYear;
    @SerializedName("rating")
    @Expose
    private Object rating;
    @SerializedName("runtime")
    @Expose
    private Object runtime;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("source_id")
    @Expose
    private Integer sourceId;
    @SerializedName("play_with")
    @Expose
    private Integer playWith;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("modified_at")
    @Expose
    private String modifiedAt;
    @SerializedName("listGenres")
    @Expose
    private List<GenreModel> listGenres = null;
    @SerializedName("listPeople")
    @Expose
    private List<Object> listPeople = null;
    @SerializedName("listStudio")
    @Expose
    private List<Object> listStudio = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Object getRating() {
        return rating;
    }

    public void setRating(Object rating) {
        this.rating = rating;
    }

    public Object getRuntime() {
        return runtime;
    }

    public void setRuntime(Object runtime) {
        this.runtime = runtime;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    public Integer getPlayWith() {
        return playWith;
    }

    public void setPlayWith(Integer playWith) {
        this.playWith = playWith;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public List<GenreModel> getListGenres() {
        return listGenres;
    }

    public void setListGenres(List<GenreModel> listGenres) {
        this.listGenres = listGenres;
    }

    public List<Object> getListPeople() {
        return listPeople;
    }

    public void setListPeople(List<Object> listPeople) {
        this.listPeople = listPeople;
    }

    public List<Object> getListStudio() {
        return listStudio;
    }

    public void setListStudio(List<Object> listStudio) {
        this.listStudio = listStudio;
    }

}