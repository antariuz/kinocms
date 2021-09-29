package avadamedia.kinocms.service;

import avadamedia.kinocms.model.banners.BackgroundBanner;

public interface BackgroundBannerService {

    void createBackgroundBanner(BackgroundBanner backgroundBanner);

    void updateBackgroundBanner(BackgroundBanner backgroundBanner);

    void deleteBackgroundBannerById(Long id);

    Iterable<BackgroundBanner> getAllBackgroundBanners();

    BackgroundBanner getBackgroundBannerById(Long id);

    Long getMaxId();

}