package com.nekose.sampleproject.infrastructure.rdb;

import com.nekose.sampleproject.application.repository.SampleDataRepository;
import com.nekose.sampleproject.infrastructure.rdb.entity.SampleTableEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SampleTableRepositoryImpl implements PanacheRepository<SampleTableEntity>, SampleDataRepository {

    @Override
    public Long store(SampleTableEntity entity) {
        persist(entity);
        entity.setVersion(1L);
        Date now = new Date();
        entity.setCreateDate(now);
        entity.setUpdateDate(now);
        return entity.getId();
    }

    @Override
    public Long update(SampleTableEntity entity) {
        entity.setVersion(entity.getVersion() + 1L);
        entity.setUpdateDate(new Date());
        persist(entity);
        return entity.getId();
    }

    @Override
    public void delete(Long id) {
        getById(id).ifPresent(e -> {
            e.setDeletedFlg(true);
            update(e);
        });
    }

    @Override
    public void physicalDelete(Long id) {
        deleteById(id);
    }

    @Override
    public Optional<SampleTableEntity> getById(Long id) {
        return findByIdOptional(id);
    }

    @Override
    public List<SampleTableEntity> findByNameAndValueAndDeletedFlg(String name, String value, Boolean deletedFlg) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("value", value);
        params.put("deletedFlg", deletedFlg);
        return list("name = :name and value = :value and deletedFlg = :deletedFlg", params);
    }
}
