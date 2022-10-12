package com.example.profileservice.repository;

import com.example.profileservice.dto.ProfileDTO;
import com.example.profileservice.entity.ProfileDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends MongoRepository<ProfileDetails, Integer> {
//    Optional<ProfileDetails> getProfileDataByEmail(String email);
  @Query("{ 'email' : ?0 }")
    Optional<ProfileDetails> findByMail(String email);
}
