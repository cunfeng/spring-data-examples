/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package example;

import example.mongo.Person;
import example.mongo.ReactivePersonRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller using a MongoDB {@link org.springframework.data.repository.reactive.ReactiveCrudRepository}.
 * 
 * @author Mark Paluch
 */
@RestController
@RequiredArgsConstructor
public class PersonController {

	final ReactivePersonRepository personRepository;

	@GetMapping("people")
	Flux<Person> getPeople() {
		return personRepository.findAll();
	}

	@PutMapping("people")
	Mono<Person> storePerson(Person person) {
		return personRepository.save(person);
	}
}