package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.model.Launcher;
@Repository
public interface ILauncherRepository extends JpaRepository<Launcher, Integer> {

}
