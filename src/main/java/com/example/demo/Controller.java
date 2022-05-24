package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.repo.CollegeRepo;
import com.example.demo.repo.DepartmentRepo;
import com.example.demo.repo.TeacherRepo;
import com.example.demo.repo.UserRepo;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {
	
	@Autowired
	UserRepo u;
	
    @Autowired
 	TeacherRepo tr;
     
    @Autowired
    DepartmentRepo dr;
    
    @Autowired
    CollegeRepo cr;
    

    
    @RequestMapping("/deletet")
    public List<Teacher> delete( @RequestBody Teacher t ) {
   
    	tr.delete(t);
    	List<Teacher> list = get();
    	return list;
    }
    
    
    @RequestMapping("/getallt")
    public List<Teacher> get() {
    	List<Teacher> t=new ArrayList<Teacher>();
    	 List<Teacher> all = tr.findAll();
    	 //System.out.println("teachers");
    	return all;
    }
    
    @RequestMapping("/addt")
    public Teacher add(@RequestBody Teacher t) {
    	Teacher save2 = tr.save(t);
    	return save2;
    }
    
    @RequestMapping("/addteachers")
	public String dis() {
    	ModelAndView m =new ModelAndView("form");
    	Teacher t = new Teacher();
    	t.setName("venkat");
    	t.setImage("v");
    	tr.save(t);
    	t.setName("raju");
    	t.setImage("r");
    	tr.save(t);
    	t.setName("somu");
    	t.setImage("s");
    	tr.save(t);
    	
		return "done";
	}
    
    
    
    
    
    @RequestMapping("/adddept")
	public ModelAndView dept() {
    	ModelAndView m =new ModelAndView("form");
    	Department d =new Department();
    	d.setId(1);
    	d.setName("cse");
    	List<Teacher> list = new ArrayList<Teacher>();
    	
    	Teacher t = new Teacher();
    	  //t = tr.findById(1).get();
    	  list.add(t);
    	  //t = tr.findById(2).get();
    	  list.add(t);
    	  
    	  
    	d.setB(list);
    	
    	Department save = dr.save(d);
    	m.addObject("v",save);
		return m;
	}
    
    
    
    @RequestMapping("/addcollege")
   	public ModelAndView college() {
       	ModelAndView m =new ModelAndView("form");
       	
       	College c = new College();
       	List<Department> list = new ArrayList<Department>();
       	
       	
       	Department department = dr.findById(1).get();
       	//System.out.println(department);
       	
       	list.add(department);
       	department=dr.findById(2).get();
       	list.add(department);
      
       	
       
       	c.setId(2);
       	c.setName("vijay");
       	c.setD(list);
       	College save = cr.save(c);
       	
       	m.addObject("v",save);
   		return m;
   	}
    
    @RequestMapping("/updateteacher")
   	public ModelAndView updateteacher() {
       	ModelAndView m =new ModelAndView("form");
       	
       	Teacher t = new Teacher();
       	t=tr.findByName("somu");
       	t.setName("somesh");
       	Teacher save = tr.save(t);
       	m.addObject("v",save);
   		return m;
   	}
    
    
    @RequestMapping("/u")
   	public ModelAndView updatedeptteacher() {
       	ModelAndView m =new ModelAndView("form");
       	
       Department d= new Department();
       
       	List<Teacher> tlist = new ArrayList<Teacher>(); 
       	
       	d=dr.findByName("ece");
       	
       	tlist=d.getB();
       
       	
       	for(Teacher i:tlist) {
       		String name = i.getName();
       		if(name.equals("somu")) {
       			i.setName("somesh");
       		     tr.save(i);
       			d.setB(tlist);
       			d = dr.save(d);
       		}
       	}
       	
       	m.addObject("v",d);
   		return m;
   	}
    
    @RequestMapping("/d")
    @Transactional
   	public ModelAndView deletedeptteacher() {
       	ModelAndView m =new ModelAndView("form");
       	
       Department d= new Department();
       
       	List<Teacher> tlist = new ArrayList<Teacher>(); 
       	
       	d=dr.findByName("cse");
       	
       	tlist=d.getB();
       
       	int id = 0;
       	for(Teacher i:tlist) {
       		String name = i.getName();
       		if(name.equals("raju")) {
       			id = tlist.indexOf(i);
       			 
       		}
       	}
       	
       	tlist.remove(id);
			d.setB(tlist);
			d = dr.save(d);
       	
       	m.addObject("v",d);
   		return m;
   	}
    
    
    
    @RequestMapping("/adduser")
    public User adduser(@RequestBody User user ) {
    	User save = u.save(user);
    	return save;
    }
    
    @RequestMapping("/finduser")
    public Boolean finduser(@RequestBody User user ) {
    	User user2 = u.findByName(user.getName());
    	if(user2.getPassword().equals(user.getPassword())) {
    		return true;
    	}
    	else {
    		return false;
    	}
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
}
