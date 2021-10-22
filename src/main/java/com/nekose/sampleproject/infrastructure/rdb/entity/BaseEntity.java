package com.nekose.sampleproject.infrastructure.rdb.entity;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
  @Column(name = "deleted_flg")
  private Boolean deletedFlg;
  @Column(name = "create_date")
  private Date createDate;
  @Column(name = "update_date")
  private Date updateDate;
  @Column(name = "create_by")
  private String createBy;
  @Column(name = "update_by")
  private String updateBy;
  @Column(name = "version")
  private Long version;
}
