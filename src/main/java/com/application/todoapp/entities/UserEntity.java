package com.application.todoapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
    @Id
    @Column(length = 36, columnDefinition = "varchar", updatable = false, nullable = false)
    private UUID id;

    @Version
    private Integer version;

    @NotNull
    @NotBlank
    private String email;

    @NotNull
    @NotBlank
    private String fullName;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String phone;

    private LocalDateTime isDelete;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<TaskEntity> tasks;

    @ManyToOne
    @JoinColumn(name = "roleId")
    @ToString.Exclude
    private RoleEntity role;
}
