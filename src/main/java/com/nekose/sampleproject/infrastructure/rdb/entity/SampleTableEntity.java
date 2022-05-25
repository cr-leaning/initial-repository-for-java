package com.nekose.sampleproject.infrastructure.rdb.entity;

import com.nekose.sampleproject.constant.DataStatus;
import com.nekose.sampleproject.controller.request.SampleRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SampleTableEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String value;
    @NotNull
    @Column(name = "data_status")
    private DataStatus status;
    @Column(name = "data_information")
    private String information;

    public static SampleTableEntity from(SampleRequest request) {
        return SampleTableEntity.builder()
                .name(request.getName())
                .value(request.getValue())
                .status(request.getDataStatusInfo().getStatus())
                .information(request.getDataStatusInfo().getInformation())
                .build();
    }

    public static SampleTableEntity from(Long id, SampleRequest request) {
        var entity = SampleTableEntity.from(request);
        entity.setId(id);
        return entity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SampleTableEntity that = (SampleTableEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
