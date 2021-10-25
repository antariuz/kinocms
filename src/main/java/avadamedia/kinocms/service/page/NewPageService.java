package avadamedia.kinocms.service.page;

import avadamedia.kinocms.model.pages.NewPage;

public interface NewPageService {

    void createNewPage(NewPage newPage);

    void updateNewPage(NewPage newPage);

    void deleteNewPageById(Long id);

    Iterable<NewPage> getAllNewPages();

    NewPage getNewPageById(Long id);

    Long getLastId();

}