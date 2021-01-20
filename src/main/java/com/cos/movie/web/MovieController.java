package com.cos.movie.web;

import java.util.List;


import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.movie.domain.CommonDto;
import com.cos.movie.domain.Movie;
import com.cos.movie.domain.MovieRepository;
import com.cos.movie.domain.SaveReqDto;
import com.cos.movie.domain.UpdateReqDto;

@RestController
public class MovieController {
	
	private MovieRepository movieRepository;
	
	public MovieController(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	@GetMapping("/movie")
	public List<Movie> findAll() {
		return movieRepository.findAll();
	}
	
	@GetMapping("/movie/{id}")
	public Movie findById(@PathVariable int id) {
		return movieRepository.findById(id);
	}
	
	@PostMapping("/movie")
	public CommonDto save(@Valid @RequestBody SaveReqDto dto, BindingResult bindingResult) {
		movieRepository.save(dto);
		return new CommonDto(HttpStatus.OK.value(),"ok");
	}
	
	@DeleteMapping("/movie/{id}")
	public CommonDto delete(@PathVariable int id) {
		movieRepository.delete(id);
		return new CommonDto(HttpStatus.OK.value(),"ok");
	}
	
	@PutMapping("/movie/{id}")
	public CommonDto update(@PathVariable int id,@Valid @RequestBody UpdateReqDto dto, BindingResult bindingResult) {
		movieRepository.update(id, dto);
		return new CommonDto(HttpStatus.OK.value(),"ok");
	}
}
