package com.nekose.sampleproject.infrastructure.rdb;

import com.nekose.sampleproject.application.repository.SampleDataRepository;
import com.nekose.sampleproject.infrastructure.rdb.entity.SampleTableEntity;
import com.nekose.sampleproject.infrastructure.rdb.mapper.SampleTableMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SampleTableRepository implements SampleDataRepository {
    private final SqlSession sqlSession;

    @Override
    public Long store(SampleTableEntity entity) {
        return sqlSession.getMapper(SampleTableMapper.class).store(entity);
    }

    @Override
    public Long update(SampleTableEntity entity) {
        return sqlSession.getMapper(SampleTableMapper.class).update(entity);
    }

    @Override
    public void delete(Long id) {
        sqlSession.getMapper(SampleTableMapper.class).delete(id);
    }

    @Override
    public void physicalDelete(Long id) {
        sqlSession.getMapper(SampleTableMapper.class).physicalDelete(id);
    }

    @Override
    public Optional<SampleTableEntity> findById(Long id) {
        return sqlSession.getMapper(SampleTableMapper.class).findById(id);
    }

    @Override
    public List<SampleTableEntity> findByValueAndDeletedFlg(String value, Boolean deletedFlg) {
        return sqlSession.getMapper(SampleTableMapper.class).findByValueAndDeletedFlg(value, deletedFlg);
    }
}
