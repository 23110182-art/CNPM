package vn.bmtstar.Entities.ID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCouponId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name = "order_id")
	private Long orderId;
	
	@Column(name = "coupon_id")  // quan trọng để match
    private Long couponId;
    
 // BẮT BUỘC: equals & hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderCouponId)) return false;
        OrderCouponId that = (OrderCouponId) o;
        return Objects.equals(orderId, that.orderId) &&
               Objects.equals(couponId, that.couponId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, couponId);
    }


}

