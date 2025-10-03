package vn.bmtstar.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "Promotions")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "promo_id")
    private Long promoId;

    @Column(name = "promo_name",nullable = false, length = 100, columnDefinition = "nvarchar(100)")
    private String promoName;

    @Column(name = "discount_type",nullable = false, length = 20)
    private String discountType; // percent, amount

    @Column(name = "discount_value",nullable = false, columnDefinition = "decimal(10,2)")
    private Double discountValue;
    
    @Builder.Default
    @Column(name = "start_date",nullable = false)
    private LocalDateTime startDate = LocalDateTime.now();;

    @Column(name = "end_date",nullable = false)
    private LocalDateTime endDate;
    
    @Builder.Default
    @Column(length = 20)
    private String status = "active"; // active, inactive

}

