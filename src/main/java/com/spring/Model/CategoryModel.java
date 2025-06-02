package com.spring.Model;

import java.time.Instant;
import java.util.List;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category_model")
public class CategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cid", nullable = false)
    private long categoryId;

    @Column(name = "category_name", nullable = false)
    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<ProductModel> products;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private Instant createdTime;

    @CreationTimestamp
    @Column(name = "updated_time")
    private Instant updatedTime;
}



