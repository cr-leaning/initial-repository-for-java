// TODO Resolve mybatis setup
//package com.nekose.sampleproject.infrastructure.rdb.mapper;
//
//import com.nekose.sampleproject.infrastructure.rdb.entity.SampleTableEntity;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//
//import java.util.List;
//import java.util.Optional;
//
//@Mapper
//public interface SampleTableMapper {
//    long store(SampleTableEntity entity);
//
//    long update(SampleTableEntity entity);
//
//    void delete(Long id);
//
//    void physicalDelete(Long id);
//
//    Optional<SampleTableEntity> findById(Long id);
//
//    List<SampleTableEntity> findByNameAndValueAndDeletedFlg(@Param("name") String name,
//                                                            @Param("value") String value,
//                                                            @Param("deletedFlg") Boolean deletedFlg);
//}
