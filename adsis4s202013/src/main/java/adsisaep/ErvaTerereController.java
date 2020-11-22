package adsisaep;

import java.util.List;
import java.util.NoSuchElementException;

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

@RestController
@RequestMapping("/api/ervasterere")
public class ErvaTerereController {
	@Autowired
	private ErvaRepository repo;

	@GetMapping
	public List<ErvaTerere> getAll() {
		return repo.findAll();
	}

	@PostMapping
	public String post(@RequestBody ErvaTerere novo) {
		if (repo.findById(novo.getId()).isPresent()) {
			throw new ErvaJaRegistradaException();
		}
		novo = repo.save(novo);
		return novo.getId();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") String id) {
		try {
			repo.deleteById(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<ErvaTerere> getById(@PathVariable("id") String id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(repo.findById(id).get());
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> put(@PathVariable("id") String id, @RequestBody ErvaTerere erva) {
		if (!id.equals(erva.getId())) {
			return ResponseEntity.badRequest().build();
		}
		repo.save(erva);
		return ResponseEntity.ok().build();
	}

}
