package com.danielribeiro.beveragestock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danielribeiro.beveragestock.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
