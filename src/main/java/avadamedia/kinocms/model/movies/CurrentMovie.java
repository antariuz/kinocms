package avadamedia.kinocms.model.movies;

import avadamedia.kinocms.model.common.Image;
import avadamedia.kinocms.model.common.MappedEntity;
import avadamedia.kinocms.model.common.SEO;
import avadamedia.kinocms.model.movies.assist.MovieInfo;
import avadamedia.kinocms.model.movies.assist.MovieType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "current_movie")
public class CurrentMovie extends MappedEntity {

    @Column
    private String name;
    @Lob
    @Column
    private String description;
    @Column(name = "main_image")
    private String mainImage;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "current_movie_id", referencedColumnName = "id")
    private List<Image> images = new ArrayList<>();

    @Column
    private String trailerUrl;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Set<MovieType> movieTypes = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "seo_id")
    private SEO seo;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "movie_info_id")
    private MovieInfo movieInfo;

    @Transient
    public String getImagePath() {
        if (mainImage == null || getId() == null) return null;
        return "/uploaded-images/current-movies/" + getId() + "/" + mainImage;
    }

}
