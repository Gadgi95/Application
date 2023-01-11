package com.example.Application;

import org.springframework.util.Assert;

public interface HasIdAndEmail {
  Integer getId();

  void setId(Integer id);

  default boolean isNew() {
    return getId() == null;
  }

  // doesn't work for hibernate lazy proxy
  default int id() {
    Assert.notNull(getId(), "Entity must has id");
    return getId();
  }

  String getEmail();
  String getEmail();

}
