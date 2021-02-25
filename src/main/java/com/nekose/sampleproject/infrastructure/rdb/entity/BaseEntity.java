package com.nekose.sampleproject.infrastructure.rdb.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {
  private Boolean deletedFlg;
  private Date createDate;
  private Date updateDate;
  private String createBy;
  private String updateBy;
  private Long version;
}
