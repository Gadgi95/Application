package com.example.application.model;

import com.example.application.HasId;
import com.example.application.ValidEmailAddress;
import com.example.application.View;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.*;
import com.example.application.HasIdAndEmail;
import com.example.application.util.validation.NoHtml;
import org.springframework.util.CollectionUtils;

import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

/**
 * Кроме того, этот блок кода также применяет кэширование к классу «Пользователь», используя нестрогую стратегию чтения-записи.
 * Это означает, что несколько потоков могут читать из кеша одновременно,
 * но только один поток может одновременно записывать в кеш.
 * Это может помочь повысить производительность приложения за счет уменьшения количества запросов к базе данных,
 * которые необходимо выполнить.
 * Важно отметить, что для того, чтобы использовать эти именованные запросы, они должны вызываться в соответствующем контексте,
 * например, в DAO или сервисном уровне приложения.
 * Кроме того, класс должен быть аннотирован @Entity и иметь правильные сопоставления с таблицей базы данных.
 */

//@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Entity
@Table(name = "users")
public class User extends AbstractNamedEntity implements HasId, HasIdAndEmail, ValidEmailAddress {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name = "email", nullable = false, unique = true)
  @Email
  @NotBlank
  @Size(max = 128)
//  @NoHtml(groups = {View.Web.class})  // https://stackoverflow.com/questions/17480809
  private String email;

  @Column(name = "password", nullable = false)
  @NotBlank
  @Size(min = 5, max = 128)
  // https://stackoverflow.com/a/12505165/548473
  private String password;

  @Column(name = "registered", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
  @NotNull
  private Date registered = new Date();

  @Enumerated(EnumType.STRING)
  @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
          uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "role"}, name = "uk_user_roles")})
  @Column(name = "role")
  @ElementCollection(fetch = FetchType.EAGER)
  @Fetch(FetchMode.SUBSELECT)
  @BatchSize(size = 200)
  @JoinColumn(name = "user_id") //https://stackoverflow.com/a/62848296/548473
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Set<Role> roles;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
  @OrderBy("creationDate DESC")
  @OnDelete(action = OnDeleteAction.CASCADE)
  @BatchSize(size = 100)
  private List<Ticket> tickets;

  public User() {
  }

  public User(Integer id, String name, String email, String password, Date registered, Collection<Role> roles) {
    super(name);
    this.id = id;
    this.email = email;
    this.password = password;
    this.registered = registered;
    setRoles(roles);
  }

  @Override
  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public Integer getId() {
    return id;
  }

  @Override
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Date getRegistered() {
    return registered;
  }

  public void setRegistered(Date registered) {
    this.registered = registered;
  }

  //Пароль задается только через конструктор?
  public String getPassword() {
    return password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Collection<Role> roles) {
    this.roles = CollectionUtils.isEmpty(roles) ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
  }

  public List<Ticket> getTickets() {
    return tickets;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", email=" + email +
            ", name=" + name +
            ", roles=" + roles +
            '}';
  }
}