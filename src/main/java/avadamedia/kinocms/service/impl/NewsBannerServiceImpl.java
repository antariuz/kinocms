package avadamedia.kinocms.service.impl;

import avadamedia.kinocms.model.banners.NewsBanner;
import avadamedia.kinocms.repository.NewsBannerRepository;
import avadamedia.kinocms.service.NewsBannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class NewsBannerServiceImpl implements NewsBannerService {

    private final NewsBannerRepository repository;

    @Override
    public void createNewsBanner(NewsBanner newsBanner) {
        repository.save(newsBanner);
    }

    @Override
    public void updateNewsBanner(NewsBanner newsBanner) {
        repository.save(newsBanner);
    }

    @Override
    public void deleteNewsBannerById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Iterable<NewsBanner> getAllNewsBanners() {
        return repository.findAll();
    }

    @Override
    public NewsBanner getNewsBannerById(Long id) {
        return repository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

}