package com.application.todoapp.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    @Column(updatable = false, nullable = false)
    private Integer id;

    @NotNull
    @NotBlank
    private String roleName;

    @NotNull
    @NotBlank
    private String roleDescription;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

//    @OneToMany(mappedBy = "role")
//    @ToString.Exclude
//    @EqualsAndHashCode.Exclude
//    @JsonManagedReference
//    private List<UserEntity> users;
}
