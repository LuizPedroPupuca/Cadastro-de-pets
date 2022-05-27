package br.com.zup.edu.cadastropets;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/pet")
public class PetController {

    private final PetRepository petRepository;

    public PetController(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody @Valid PetRequest petRequest, UriComponentsBuilder uri){
        Pet pet = petRequest.toModel();
        petRepository.save(pet);
        URI location = uri.path("/pet/{id}").buildAndExpand(pet.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
