package vn.bmtstar.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "Payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Integer paymentId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;  // liên kết đến Orders

    @Column(name = "method",nullable = false, length = 20)
    private String method; // COD, Banking, CreditCard, Paypal
    
    @Builder.Default
    @Column(name = "status",length = 20)
    private String status = "pending"; // pending, success, failed
    
    @Column(name = "paid_at")
    private LocalDateTime paidAt;

}

