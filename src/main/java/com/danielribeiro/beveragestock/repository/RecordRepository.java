package com.danielribeiro.beveragestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danielribeiro.beveragestock.domain.Record;

public interface RecordRepository extends JpaRepository<Record, Integer> {

}
