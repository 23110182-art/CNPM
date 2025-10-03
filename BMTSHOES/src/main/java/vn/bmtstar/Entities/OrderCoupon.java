package vn.bmtstar.Entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.bmtstar.Entities.ID.OrderCouponId;

@Entity
@Table(name = "OrderCoupons")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCoupon {

    @EmbeddedId
    private OrderCouponId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("couponId")
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;
    
    
}

