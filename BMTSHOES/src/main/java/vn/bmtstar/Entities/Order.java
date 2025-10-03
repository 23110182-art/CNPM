package vn.bmtstar.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "total_amount", nullable = false, columnDefinition = "decimal(10,2)")
    private Double totalAmount;
    
    @Builder.Default
    @Column(length = 20, nullable = false)
    private String status = "pending"; // default value
    
    @Builder.Default
    @Column(name = "created_at", columnDefinition = "DATETIME")
    private LocalDateTime createdAt = LocalDateTime.now();

    // Một đơn hàng thuộc về 1 user
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    

    // Quan hệ với OrderDetail (sẽ thêm sau)
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    // Quan hệ với Payment (sẽ thêm sau)
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Payment> payments;
}
