package com.devsuperior.bds01.services;

import com.devsuperior.bds01.dto.DepartmentDTO;
import com.devsuperior.bds01.entities.Department;
import com.devsuperior.bds01.repositories.DepartmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
  @Autowired
  private DepartmentRepository repository;

  public List<DepartmentDTO> findAll() {
    List<Department> list = repository.findAll(Sort.by("name"));
    return list
      .stream()
      .map(x -> new DepartmentDTO(x))
      .collect(java.util.stream.Collectors.toList());
  }
}
