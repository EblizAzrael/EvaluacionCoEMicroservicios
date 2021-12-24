package com.aguadarramal.apirest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aguadarramal.apirest.entity.Clientes;
import com.aguadarramal.apirest.service.IClientesService;

@CrossOrigin("*")
@RestController
@RequestMapping("/")
public class ApiController {
 
	@Autowired
	IClientesService clientesService;
	    
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAll(){
        return ResponseEntity.ok(this.clientesService.getAllClientes());
    }
    
    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> findById(@PathVariable long id){
        return ResponseEntity.ok(this.clientesService.getClienteDetails(id) );
    }
    
    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> update(@PathVariable long id, @RequestBody Clientes cliente){
        return ResponseEntity.ok(this.clientesService.updateCliente(id, cliente) );
    }
    
    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> deleteById(@PathVariable long id){
        return ResponseEntity.ok(this.clientesService.deleteClientes(id) );
    }
    
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> add(@RequestBody Clientes cliente){
        return ResponseEntity.ok(this.clientesService.addCliente(cliente));
    }
   
}
