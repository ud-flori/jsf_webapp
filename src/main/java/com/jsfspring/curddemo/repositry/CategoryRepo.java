package com.jsfspring.curddemo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jsfspring.curddemo.entity.CategoryDTO;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryDTO, Long> {

	CategoryDTO findTitleByCatName(String catName);
}