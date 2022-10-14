package com.vanessa.DojosNinjas.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vanessa.DojosNinjas.Models.NinjaModel;
import com.vanessa.DojosNinjas.Repo.NinjaRepo;

@Service
public class NinjaService {
	private final NinjaRepo ninjaRepo;
//	Adding Dependency
	public NinjaService(NinjaRepo ninjaRepo) {
		this.ninjaRepo = ninjaRepo;
	}
	
//	Get All
	public List<NinjaModel> allNinja(){
		return ninjaRepo.findAll();
	}
//	Create One
	public NinjaModel createNinja(NinjaModel ninjaModel) {
		return ninjaRepo.save(ninjaModel);
	}
//	Read One
	public NinjaModel findNinja(Long id) {
		Optional<NinjaModel> optionalNinja = ninjaRepo.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else {
			return null;
		}
	}
	
//	Update
	
	public NinjaModel updateNinja(NinjaModel ninjaModel) {
		NinjaModel updateninja = ninjaRepo.save(ninjaModel);
		return updateninja;
	}
	
//	Delete
	
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
