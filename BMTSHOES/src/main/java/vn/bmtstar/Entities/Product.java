package vn.bmtstar.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(nullable = false, length = 100, columnDefinition = "nvarchar(100)")
    private String name;

    @Lob
    @Column(columnDefinition = "NTEXT")
    private String description;

    @Column(nullable = false, columnDefinition = "decimal(10,2)")
    private Double price;

    @Column(columnDefinition = "INT DEFAULT 0")
    private Integer stock;

    @Column(length = 10)
    private String size;

    @Column(name = "image_url", length = 255)
    private String imageUrl;

    	@Builder.Default
    @Column(name = "created_at", columnDefinition = "DATETIME")
    private LocalDateTime createdAt = LocalDateTime.now();

    // Quan hệ nhiều sản phẩm thuộc 1 category
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Quan hệ với OrderDetail (sẽ thêm sau khi tạo bảng OrderDetails)
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
}

