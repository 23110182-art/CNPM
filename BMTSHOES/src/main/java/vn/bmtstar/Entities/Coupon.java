package vn.bmtstar.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;


@Entity
@Table(name = "Coupons")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long couponId;

    @Column(name = "code", nullable = false, unique = true, length = 50)
    private String code;
    

    @Column(name = "description", length = 200, columnDefinition = "nvarchar(200)")
    private String description;

    @Column(name = "discount_type", nullable = false, length = 20)
    private String discountType; // percent, amount

    @Column(name = "discount_value",nullable = false, columnDefinition = "decimal(10,2)")
    private Double discountValue;
    
    @Builder.Default
    @Column(name = "min_order_value",columnDefinition = "decimal(10,2)")
    private Double minOrderValue = 0.0;
    
    @Builder.Default
    @Column(name = "start_date",nullable = false)
    private LocalDateTime startDate = LocalDateTime.now();

    @Column(name = "end_date",nullable = false)
    private LocalDateTime endDate;
    
    @Builder.Default
    @Column(name = "status",length = 20)
    private String status = "active"; // active, inactive

    // getter & setter
}

