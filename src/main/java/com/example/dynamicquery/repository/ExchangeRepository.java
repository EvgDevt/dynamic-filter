package com.example.dynamicquery.repository;

import com.example.dynamicquery.entity.ExchangeRate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ExchangeRepository extends CrudRepository<ExchangeRate, Long> {

    @Query("FROM ExchangeRate e WHERE e.baseCurrency = :baseCurrency AND e.targetCurrency = :targetCurrency")
    Optional<ExchangeRate> findByCodes(@Param("baseCurrency") String baseCurrency,
                                       @Param("targetCurrency") String targetCurrency);
}
