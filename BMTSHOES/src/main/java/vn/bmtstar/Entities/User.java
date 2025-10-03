package vn.bmtstar.Entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(unique = true, length = 100)
    private String email;

    @Column(length = 20)
    private String phone;
    
    @Builder.Default
    @Column(nullable = false, length = 20)
    private String role = "user";  // default value
    
    @Builder.Default
    @Column(name = "created_at", columnDefinition = "DATETIME")
    private LocalDateTime createdAt = LocalDateTime.now();
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Cart cart;
    
}

