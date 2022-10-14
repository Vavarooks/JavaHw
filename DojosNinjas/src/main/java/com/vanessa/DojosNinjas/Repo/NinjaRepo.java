package com.vanessa.DojosNinjas.Repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vanessa.DojosNinjas.Models.NinjaModel;
@Repository
public interface NinjaRepo extends CrudRepository<NinjaModel, Long> {
	List<NinjaModel> findAll();
}
