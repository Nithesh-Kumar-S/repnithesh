package com.skcet.day6.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skcet.day6.model.gardenmodel;
import com.skcet.day6.repo.gardenrepo;

@Service
public class gardenservice {

	@Autowired
	public gardenrepo grepo;
	
	

	//post the data
	public String savegarden(gardenmodel m)
	{
		 grepo.save(m);
		 return "Data is saved";
		
	}
	
	//get the data
    public List<gardenmodel> getgarden()
	{
		 return grepo.findAll();
			
	}
    // update the data
    public gardenmodel updategarden (gardenmodel mm)
    {
    	return grepo.saveAndFlush(mm);
    }
    //delete the data
    public void deletegarden(int humans) {
    	grepo.deleteById(humans);
    }
    //delete data
    public boolean deletegardenif(int humans)
    {
    	if(grepo.existsById(humans)) {
    		grepo.deleteById(humans);
    		return true;
    	}else {
    		return false;
    	}
    }
    
}
