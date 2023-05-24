package rrcc.basico.controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rrcc.basico.dtos.NewUserDTO;
import rrcc.basico.dtos.UserDTO;
import rrcc.basico.exceptions.UserNotFoundException;
import rrcc.basico.services.UsersService;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    UsersService<UserDTO, NewUserDTO> userService;

    public UserController(UsersService<UserDTO, NewUserDTO> userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Collection<UserDTO>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> get(@PathVariable long id){
        //return userService.get(id).orElseThrow(() -> new UserNotFoundException(id));
        return userService.get(id)
                //.map(userDTO -> new ResponseEntity<>(userDTO, HttpStatus.OK))
                //.map(userDTO -> ResponseEntity.ok(userDTO))
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping                            //aplicamos @valid para las validacines
    public ResponseEntity<UserDTO> create(@Valid @RequestBody NewUserDTO newUserDTO){
        UserDTO userDTO = userService.create(newUserDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(userDTO.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        if(!userService.delete(id)){
            //throw new UserNotFoundException(id);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  //correcto, pero nada que mostrar
        }
    return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
