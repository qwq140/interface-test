package com.cos.movie.domain;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
	public List<Movie> findAll(){
		List<Movie> movies = new ArrayList<>();
		movies.add(new Movie(1, "아이엠히어", 8.45, Timestamp.valueOf("2021-01-14 00:00:00.0")));
		movies.add(new Movie(2, "도굴", 8.48,Timestamp.valueOf("2020-11-04 00:00:00.0")));
		movies.add(new Movie(3, "늑대와 춤을", 9.30,Timestamp.valueOf("2021-01-14 00:00:00.0")));
		return movies;
	}
	
	public Movie findById(int id) {
		return new Movie(id, "아이엠히어", 8.45, Timestamp.valueOf("2021-01-14 00:00:00.0"));
	}
	
	public void save(SaveReqDto dto) {
		System.out.println("DB에 insert");
	}
	
	public void delete(int id) {
		System.out.println("DB에 delete");
	}
	
	public void update(int id, UpdateReqDto dto) {
		System.out.println("update");
	}
}
