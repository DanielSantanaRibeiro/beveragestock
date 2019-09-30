package com.danielribeiro.beveragestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danielribeiro.beveragestock.domain.BeverageRecord;

@Repository
public interface BeverageRecordRepository extends JpaRepository<BeverageRecord, Integer>{

}
