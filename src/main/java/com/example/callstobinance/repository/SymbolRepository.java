package com.example.callstobinance.repository;

import com.example.callstobinance.model.Symbol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymbolRepository extends JpaRepository<Symbol,Long> {
}
