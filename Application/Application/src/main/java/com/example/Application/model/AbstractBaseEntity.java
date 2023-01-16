package com.example.Application.model;

import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import org.hibernate.Hibernate;
import com.example.Application.HasId;



/*

Этот код определяет класс AbstractBaseEntity, который предназначен для использования
в качестве суперкласса для других сущностей в приложении.
Он включает в себя некоторые базовые функции, общие для всех сущностей,
такие как поле идентификатора, которое автоматически создается последовательностью базы данных,
а также методы получения и установки для поля идентификатора.

Он также определяет методы equals и hashCode на основе поля ID,
что позволяет легко сравнивать объекты по ID.

Он определяет интерфейс HasId, который должен быть реализован сущностями.
И он устанавливает AccessType полей и определяет поле id для сущностей,
которые генерируются с помощью стратегии SEQUENCE, и устанавливает генератор
последовательности «global_seq» с распределениемSize 1 и начальным значением START_SEQ.
 */

@MappedSuperclass
// http://stackoverflow.com/questions/594597/hibernate-annotations-which-is-better-field-or-property-access
@Access(AccessType.FIELD)
//@JsonAutoDetect(fieldVisibility = ANY, getterVisibility = NONE, isGetterVisibility = NONE, setterVisibility = NONE)
public abstract class AbstractBaseEntity implements HasId {

  public static final int START_SEQ = 100000;

  @Id
  @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1, initialValue = START_SEQ)
  //    @Column(name = "id", unique = true, nullable = false, columnDefinition = "integer default nextval('global_seq')")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
//  See https://hibernate.atlassian.net/browse/HHH-3718 and https://hibernate.atlassian.net/browse/HHH-12034
//  Proxy initialization when accessing its identifier managed now by JPA_PROXY_COMPLIANCE setting
  @ApiModelProperty(hidden = true)
  protected Integer id;

  protected AbstractBaseEntity() {
  }

  protected AbstractBaseEntity(Integer id) {
    this.id = id;
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
  public String toString() {
    return getClass().getSimpleName() + ":" + id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || !getClass().equals(Hibernate.getClass(o))) {
      return false;
    }
    AbstractBaseEntity that = (AbstractBaseEntity) o;
    return id != null && id.equals(that.id);
  }

  @Override
  public int hashCode() {
    return id == null ? 0 : id;
  }
}