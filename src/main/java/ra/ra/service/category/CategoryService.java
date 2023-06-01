package ra.ra.service.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.ra.dao.ICategoryDao;
import ra.ra.model.Category;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryDao categoryDao;
    @Override
    public Iterable<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryDao.findById(id);
    }

    @Override
    public Category save(Category category) {
        return  categoryDao.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryDao.deleteById(id);
    }
}
