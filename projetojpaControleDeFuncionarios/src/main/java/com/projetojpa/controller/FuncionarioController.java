package com.projetojpa.controller; 
  
import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.DeleteMapping; 
import org.springframework.web.bind.annotation.GetMapping; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.PostMapping; 
import org.springframework.web.bind.annotation.PutMapping; 
import org.springframework.web.bind.annotation.RequestBody; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RestController; 
import com.projetojpa.entities.Funcionario; 
import com.projetojpa.services.FuncionarioService; 
  
@RestController 
@RequestMapping("/funcionarios") 
public class FuncionarioController { 
	private final FuncionarioService funcionarioService;  
    @Autowired  
    public FuncionarioController(FuncionarioService funcionarioService) {  
        this.funcionarioService = funcionarioService;  
    }  
    @GetMapping("/{id}")  
    public ResponseEntity<Funcionario> buscaFuncionarioControlId(@PathVariable Long id){  
    	Funcionario funcionario = funcionarioService.buscaFuncionarioById(id);  
    	if (funcionario != null) {  
    		return ResponseEntity.ok(funcionario);  
    	}  
    	else {  
    		return ResponseEntity.notFound().build();  
    	}  
    }  
    @GetMapping("/")  
    public ResponseEntity<List<Funcionario>> buscaTodosDrogariasControl(){  
    	List<Funcionario>funcionario = funcionarioService.buscaTodosFuncionarios();  
    	return ResponseEntity.ok(funcionario);  
    }  
    @PostMapping("/")  
    public ResponseEntity<Funcionario> salvaFuncionariosControl(@RequestBody Funcionario funcionario){  
    	Funcionario salvaFuncionario = funcionarioService.salvaFuncionario(funcionario);  
    	return ResponseEntity.status(HttpStatus.CREATED).body(salvaFuncionario);  
    }  
    @PutMapping("/{id}")  
    public ResponseEntity<Funcionario> alteraFuncionariosControl(@PathVariable Long id, @RequestBody Funcionario funcionario){  
    	Funcionario alteraFuncionario = funcionarioService.alterarFuncionario(id, funcionario);  
    	if (alteraFuncionario!= null) {  
    		return ResponseEntity.ok(funcionario);  
    	}  
    	else {  
    		return ResponseEntity.notFound().build();  
    	}  
    }  
    @DeleteMapping("/{id}")  
    public ResponseEntity<String> apagaFuncionarioControl(@PathVariable Long id){  
    	boolean apagar = funcionarioService.apagarFuncionario(id);  
    	if(apagar) {  
    		return ResponseEntity.ok().body("O funcionario foi excluida!");  
    	}  
    	else {  
    		return ResponseEntity.notFound().build();  
    	}  
    }  
} 