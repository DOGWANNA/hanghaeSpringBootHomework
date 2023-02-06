package com.aprata.hanghaespringboothomework.repository;

import com.aprata.hanghaespringboothomework.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrudRepository extends JpaRepository<Member, Long> {

}
