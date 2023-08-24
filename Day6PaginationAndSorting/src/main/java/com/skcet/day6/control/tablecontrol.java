package com.skcet.day6.control;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skcet.day6.model.tablemodel;
import com.skcet.day6.service.tableservice;

@RestController
public class tablecontrol {
	@Autowired
	public tableservice serv;
	
	//post mapping
	@PostMapping("/posttable")
	public String posttable(@RequestBody tablemodel mr)
	{
		serv.savetable(mr);
		return "your data is saved in database";
	}
	
	//get mapping
	@GetMapping("/gettable")
	public  List<tablemodel> getmatrix()
	{
		return serv.gettable();
	}
	
	//put mapping
	@PutMapping("/puttable/{id}")
	public tablemodel updatematrix(@RequestBody tablemodel mrs)
	{
		return serv.updatetable(mrs);
	}
	//delete mapping using path variable
	@DeleteMapping("/deletetable/{id}")
	public String removetable(@PathVariable("id") int id)
	{
		serv.deletetable(id);
		return "Table with id "+id+" is deleted";
	}
	
	//delete mapping using request param
	@DeleteMapping("/byReqParam")
	public String removeByRequest(@RequestParam ("id") int id)
	{
		serv.deletetable(id);
		return "Table with id "+id+" is deleted";
	}
	
	//if there is no id
	@DeleteMapping("/deletetableif/{id}")
	public ResponseEntity<String> deleteTable(@PathVariable int id){
		boolean deleted = serv.deletetableif(id);
		if(deleted) {
			return ResponseEntity.ok("Table with ID "+id+" deleted successfully");
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Hotel with ID "+id+" not found");
		}
	}
	
	//getUserById
			@GetMapping("users/{userId}")
			public ResponseEntity<?> getUserById(@PathVariable int userId)
			{
		        Optional<tablemodel> home = serv.getuserById(userId);
				if(home != null) {
					return ResponseEntity.ok(home);
				}
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(home);
			}

			//sorting ascending
			@GetMapping("/sortAsc/{name}")
			public List<tablemodel> sortasc(@PathVariable("name") String name)
			{
				return serv.sortByAsc(name);
			}
			//sorting descending
					@GetMapping("/sortDesc/{name}")
					public List<tablemodel> sortdesc(@PathVariable("name") String name)
					{
						return serv.sortByDesc(name);
					}
					
					//paging
					@GetMapping("pagination/{number}/{s}")
					public List<tablemodel> paginationValue(@PathVariable("number") int no,@PathVariable ("s") int size)
					{
						return serv.pagination(no, size);
					}
					//paging and sort
					@GetMapping("paginationdetails/{number}/{s}/{name}")
					public List<tablemodel> paginationAndSortingValue(@PathVariable("number") int no,@PathVariable ("s") int size,@PathVariable ("name") String name)
					{
						return serv.paginationAndSort(no, size, name);
					}
}
