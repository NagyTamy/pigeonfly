package com.pigeon.fly.repository;

import com.pigeon.fly.model.Pigeon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PigeonRepository extends JpaRepository<Pigeon, Long> {

}
