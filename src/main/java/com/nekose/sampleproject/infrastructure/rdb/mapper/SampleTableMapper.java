package com.nekose.sampleproject.infrastructure.rdb.mapper;

import com.nekose.sampleproject.infrastructure.rdb.entity.SampleTableEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SampleTableMapper {
    void store(SampleTableEntity entity);

    void update(SampleTableEntity entity);

    void delete(Long id);

    void physicalDelete(SampleTableEntity entity);

    SampleTableEntity findById(Long id);

    List<SampleTableEntity> findByValueAndDeletedFlg(@Param("value") String value,
                                                     @Param("deletedFlg") Boolean deletedFlg);
}
