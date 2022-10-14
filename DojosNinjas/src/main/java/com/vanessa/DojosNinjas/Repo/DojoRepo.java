package com.vanessa.DojosNinjas.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanessa.DojosNinjas.Models.DojoModel;
@Repository
public interface DojoRepo extends CrudRepository<DojoModel, Long> {
	List<DojoModel> findAll();
}
