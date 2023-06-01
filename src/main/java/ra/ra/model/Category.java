package ra.ra.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;


@Entity

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long catalog_id;
    private String name;
    @OneToMany(mappedBy = "category", targetEntity = Blog.class,fetch = FetchType.EAGER)
    @JsonIgnoreProperties("category")
    private List<Blog> blogs;

    public Category(Long id, String name, List<Blog> blogs) {
        this.catalog_id = id;
        this.name = name;
        this.blogs = blogs;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    public Category() {
    }

    public Long getId() {
        return catalog_id;
    }

    public void setId(Long id) {
        this.catalog_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
