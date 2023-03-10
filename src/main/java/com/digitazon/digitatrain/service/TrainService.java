package com.digitazon.digitatrain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.digitazon.digitatrain.model.Train;
import com.digitazon.digitatrain.repository.TrainRepository;

@Service
public class TrainService {
    
    @Autowired
    TrainRepository trainRepository;
    
    public Train createTrain(Train t){
        return trainRepository.save(t);
    }

    public List<Train> getAll(){
        return trainRepository.findAll();
    }
    
    public Train getTrainById(long id){
        return trainRepository.findById(id).get();
    }
}
