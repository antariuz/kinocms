package avadamedia.kinocms.repository.banners;

import avadamedia.kinocms.model.banners.MainBanner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainBannerRepository extends CrudRepository<MainBanner, Long> {
    @Query(value = "SELECT MIN(id) FROM main_banners", nativeQuery = true)
    Long getFirstId();
}