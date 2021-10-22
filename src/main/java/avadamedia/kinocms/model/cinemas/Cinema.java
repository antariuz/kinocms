package avadamedia.kinocms.model.cinemas;

import avadamedia.kinocms.model.cinemas.assist.CinemaHall;
import avadamedia.kinocms.model.common.Image;
import avadamedia.kinocms.model.common.MappedEntity;
import avadamedia.kinocms.model.common.SEO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "cinemas")
public class Cinema extends MappedEntity {

    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String conditions;
    @Column(name = "main_image")
    private String mainImage;
    @Column(name = "top_banner")
    private String topBanner;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cinema_id")
    private List<Image> imageList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "cinema_halls_id")
    private List<CinemaHall> cinemaHallList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "seo_id")
    private SEO seo;

    @Transient
    public String getImagePath() {
        if (mainImage == null || getId() == null) return null;
        return "/uploaded-images/cinemas/" + getId() + "/" + mainImage;
    }

}
