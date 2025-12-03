package com.saas_kit_java.backend.domain.user;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Garante que o Hibernate gere UUID v4 corretamente
    private UUID id;

    @Column(nullable = false) // Nome é obrigatório
    private String name;

    @Column(unique = true, nullable = false) // Email único e obrigatório
    private String email;

    @Column(nullable = false) // Senha obrigatória
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false) // Role obrigatória
    private Role role;

    @Column(nullable = false, updatable = false) // Data obrigatória e não pode mudar
    private LocalDateTime createdAt;

    // Gatilho automático: Preenche a data antes de salvar no banco
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // --- Métodos do UserDetails (Mantidos iguais) ---

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}