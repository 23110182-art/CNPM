package vn.bmtstar.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long cartId;
    
    @Builder.Default
    @Column(name = "created_at", columnDefinition = "DATETIME")
    private LocalDateTime createdAt = LocalDateTime.now();

    // Quan hệ 1-1 với User
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Quan hệ 1-nhiều với CartItem
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items;
}

