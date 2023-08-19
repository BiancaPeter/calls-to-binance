package com.example.callstobinance.repository;

import com.example.callstobinance.model.Kline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlineRepository extends JpaRepository<Kline, Long> {
}
