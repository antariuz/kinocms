package avadamedia.kinocms.service;

import avadamedia.kinocms.model.banners.NewsBanner;

public interface NewsBannerService {

    void createNewsBanner(NewsBanner newsBanner);

    void updateNewsBanner(NewsBanner newsBanner);

    void deleteNewsBannerById(Long id);

    Iterable<NewsBanner> getAllNewsBanners();

    NewsBanner getNewsBannerById(Long id);

}