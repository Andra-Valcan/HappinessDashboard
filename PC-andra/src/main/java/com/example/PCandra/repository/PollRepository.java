package com.example.PCandra.repository;

import com.example.PCandra.entity.Poll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PollRepository extends JpaRepository<Poll, Long> {
    List<Poll> findByTopic(String topic);

   @Query(
        value = "SELECT * FROM poll offset :my_offset fetch first 10 row only",
        nativeQuery = true)
   List<Poll> findAllActivePolls( @Param("my_offset") int my_offset);
}
