package cakar.springframework.springelasticsearch.controllers;


import cakar.springframework.springelasticsearch.dtos.UserDTO;
import cakar.springframework.springelasticsearch.entities.User;
import cakar.springframework.springelasticsearch.genUtilMapper.UtilMap;
import cakar.springframework.springelasticsearch.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(UserController.BASE_URL)
@RequiredArgsConstructor
public class UserController {

    public static final String BASE_URL = "/api/user";

    private final UserRepository userRepository;


    @RequestMapping( path ="/getList", method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getList(){
        List<UserDTO> userDTOList = new ArrayList<>();
        userRepository.findAll()
                .forEach(user -> {
                    userDTOList.add(new UtilMap<UserDTO,User>().pojoToDto(new UserDTO(),user));
                });
        return ResponseEntity.ok(userDTOList);
    }

    @RequestMapping( path ="/getId/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> getId(@PathVariable("id") String id){
       return ResponseEntity.ok(userRepository.findById(id)
                .stream()
                .map(user -> new UtilMap<UserDTO,User>().pojoToDto(new UserDTO(),user))
               .findAny()
               .get());
    }
}
