package com.MultipleRow.Repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MultipleRow.Entity.RowEntity;

@Repository
public interface RowRepo extends JpaRepository<RowEntity, UUID> {

    @Query(value = "SELECT * FROM tb_multirow LIMIT 5", nativeQuery = true)
	List<RowEntity> findFirst5Rows();
}
