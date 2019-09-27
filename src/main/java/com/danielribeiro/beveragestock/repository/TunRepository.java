package com.danielribeiro.beveragestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danielribeiro.beveragestock.domain.Tun;

@Repository
public interface TunRepository extends JpaRepository<Tun, Integer> {

}
