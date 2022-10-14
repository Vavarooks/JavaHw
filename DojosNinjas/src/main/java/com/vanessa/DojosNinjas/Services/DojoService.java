package com.vanessa.DojosNinjas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vanessa.DojosNinjas.Models.DojoModel;
import com.vanessa.DojosNinjas.Repo.DojoRepo;

@Service
public class DojoService {
	private final DojoRepo dojoRepo;
//	Adding Dependency
	public DojoService(DojoRepo dojoRepo) {
		this.dojoRepo = dojoRepo;
	}
	
//	Get All
	public List<DojoModel> allDojo(){
		return dojoRepo.findAll();
	}
//	Create One
	public DojoModel createDojo(DojoModel dojoModel) {
		return dojoRepo.save(dojoModel);
	}
//	Read One
	public DojoModel findDojo(Long id) {
		Optional<DojoModel> optionalDojo = dojoRepo.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
	
//	Update
	
	public DojoModel updateDojo(DojoModel dojoModel) {
		DojoModel updateninja = dojoRepo.save(dojoModel);
		return updateninja;
	}
	
//	Delete
	
	public void deleteDojo(Long id) {
		dojoRepo.deleteById(id);
	}
}
