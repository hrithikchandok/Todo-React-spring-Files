package com.in28minutes.rest.webservices.restfulwebservices.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@RestController
public class TodoResouce {
       
	@Autowired 
	   private TodoService todoService;
	    
	  @GetMapping("/users/{username}/todos")
	   public List<Todo> gettodos(@PathVariable String username) {
		      return todoService.findByUsername(username);
	  }
	  
	  @GetMapping(value="/users/{usename}/todos/{id}")
	  public Todo getTodos(@PathVariable int id)
	  {
		  System.out.println("this is m,e ");
		 return  todoService.findById(id);  
//		return null;    
		     
	  }       
	  
	  @DeleteMapping(value="/users/{usename}/todos/{id}")
	  public void deltodo(@PathVariable int id)
	  {   
		    
		   todoService.deleteById(id);  
		    
//		return null; 
		   
	  } 
	  
	  @PutMapping(value="/users/{username}/todos/{id}")
	  public Todo updatre(@PathVariable int id, @RequestBody Todo todo)
	  {
		   todoService.updateTodo(todo);
		   return todo;
	  }
	  
	  @PostMapping(value="/users/{username}/todos")
	  public Todo addTodo(@PathVariable String username, @RequestBody Todo todo)
	  {
		   return todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
		   
	  }
	  
        	  
}
 