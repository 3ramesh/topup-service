package com.vanilla.topup.repository;

import com.vanilla.topup.entity.Topup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopupRepository extends JpaRepository<Topup, Long> {
}
