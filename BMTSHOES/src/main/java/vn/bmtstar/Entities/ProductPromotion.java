package vn.bmtstar.Entities;

import jakarta.persistence.*;
import lombok.*;
import vn.bmtstar.Entities.ID.ProductPromotionId;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "ProductPromotions")
public class ProductPromotion {

    @EmbeddedId
    private ProductPromotionId id;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @MapsId("promoId")
    @JoinColumn(name = "promo_id")
    private Promotion promotion;


}

