package br.edu.ifrs.riogrande.tads.carloslucas.app.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@ToString(onlyExplicitlyIncluded = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @ToString.Include
  Integer id;

  @Column(name = "role", length = 20, nullable = false, unique = true)
  @ToString.Include
  String role;

  @ManyToMany
  @JoinTable(name = "roles_has_permissions", 
    joinColumns = @JoinColumn(name = "role_id", nullable = false), 
    inverseJoinColumns = @JoinColumn(name = "permission_id", nullable = false) )
  private List<Permission> permissions;

  public List<Permission> getPermissions() {
    return permissions;
  }

 // public void setPermissions(List<Permission> permissions) {
 //   this.permissions = permissions;
  //}
}