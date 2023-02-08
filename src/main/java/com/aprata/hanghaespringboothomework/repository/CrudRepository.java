package com.aprata.hanghaespringboothomework.repository;

import com.aprata.hanghaespringboothomework.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository extends JpaRepository<Member, Long> {
    List<Member> findAllByOrderByCreatedAtDesc();

}