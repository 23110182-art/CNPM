package vn.bmtstar.Entities;

import jakarta.persistence.*;
import lombok.*;
import vn.bmtstar.Entities.ID.OrderDetailId;

@Entity
@Table(name = "OrderDetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false, columnDefinition = "decimal(10,2)")
    private Double price;
}

