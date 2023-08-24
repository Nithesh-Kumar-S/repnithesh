package com.skcet.day6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import com.skcet.day6.model.tablemodel;
import com.skcet.day6.repo.tablerepo;

@Service
public class tableservice {
	@Autowired
	public tablerepo grepo;
	
	

	//post the data
	public String savetable(tablemodel m)
	{
		 grepo.save(m);
		 return "Data is saved";
		
	}
	
	//get the data
    public List<tablemodel> gettable()
	{
		 return grepo.findAll();
			
	}
    // update the data
    public tablemodel updatetable (tablemodel mm)
    {
    	return grepo.saveAndFlush(mm);
    }
    //delete the data
    public void deletetable(int studentid) {
    	grepo.deleteById(studentid);
    }
    //delete data
    public boolean deletetableif(int studentid)
    {
    	if(grepo.existsById(studentid)) {
    		grepo.deleteById(studentid);
    		return true;
    	}else {
    		return false;
    	}
    }
    
  //getUserId
    @GetMapping("/users/userId")
    
    public Optional<tablemodel> getuserById(int userId)
    {
    	Optional<tablemodel> home = grepo.findById(userId);
    	if(home.isPresent()) {
    		return home;
    	}
    	else
    	{
    		return null;
    	}
    }
    
  //sorting ascending
    public List<tablemodel> sortByAsc(String name)
	{
		return grepo.findAll(Sort.by(name).ascending());
	}
    //sorting descending
    public List<tablemodel> sortByDesc(String name)
	{
		return grepo.findAll(Sort.by(name).descending());
	}
    
  //paging
  	public List<tablemodel> pagination(int no,int size)
  	{
  		Page<tablemodel> count = grepo.findAll(PageRequest.of(no, size));
  		return count.getContent();
  	}
  	
  	//pagination and sorting
  	public List<tablemodel> paginationAndSort(int no,int size,String name)
  	{
  		Page<tablemodel> count1 = grepo.findAll(PageRequest.of(no, size, Sort.by(name)));
  		return count1.getContent();
  	}
}
