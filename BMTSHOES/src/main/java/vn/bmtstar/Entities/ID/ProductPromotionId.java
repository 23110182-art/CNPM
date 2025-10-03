package vn.bmtstar.Entities.ID;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;






@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductPromotionId implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	private Long productId;
    private Long promoId;
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPromotionId that = (ProductPromotionId) o;
        return Objects.equals(productId, that.productId) &&
               Objects.equals(promoId, that.promoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, promoId);
    }

}

