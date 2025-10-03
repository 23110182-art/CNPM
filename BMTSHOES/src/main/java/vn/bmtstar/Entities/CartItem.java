package vn.bmtstar.Entities;

import jakarta.persistence.*;
import lombok.*;
import vn.bmtstar.Entities.ID.CartItemId;

@Entity
@Table(name = "CartItems")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CartItem {
    @EmbeddedId
    private CartItemId id;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private Integer quantity;
}

