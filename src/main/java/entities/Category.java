package entities;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "categoryId", nullable = false)
    private int categoryId;

    @Column(name="categoryDescription")
    private String categoryDescription;

    @OneToMany(mappedBy = "categoryId", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Transaction> relationship;

    public Category(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    @Override
    public String toString() {
        return categoryDescription;
    }
}
