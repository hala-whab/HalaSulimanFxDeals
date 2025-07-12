package com.HalaSuliman.Bloomberg.FXDeals.Reposeitory;

import com.HalaSuliman.Bloomberg.FXDeals.Entites.DealDetails;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DealDetailsRepo extends JpaRepository<DealDetails, Long> {
}
