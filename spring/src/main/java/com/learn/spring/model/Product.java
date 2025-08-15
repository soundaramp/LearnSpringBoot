package com.learn.spring.model;
import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="employee_details")
public class Product {
            @Id
            private Long id;
            @Nonnull
            private String name;
            private double price;
            private int productCount;
            private boolean availability;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productCount=" + productCount +
                ", availability=" + availability +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(@Nonnull String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductCount(int productCount) {
        setAvailability(productCount > 0);
        this.productCount = productCount;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    @Nonnull
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getProductCount() {
        return productCount;
    }

    public boolean isAvailability() {
        return availability;
    }

}
