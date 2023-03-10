package com.digitazon.digitatrain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.digitazon.digitatrain.model.Train;

public interface TrainRepository extends JpaRepository<Train, Long>{

}
