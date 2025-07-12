package com.HalaSuliman.Bloomberg.FXDeals.Reposeitory;

import com.HalaSuliman.Bloomberg.FXDeals.Entites.DealDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface DealDetailsRepo extends JpaRepository<DealDetails, Long> {
}
