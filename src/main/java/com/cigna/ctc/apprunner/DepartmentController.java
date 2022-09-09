package com.cigna.ctc.apprunner;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class DepartmentController {
  Logger logger = LoggerFactory.getLogger(DepartmentController.class);

  @Autowired
  private DepartmentService departmentService;

  // Save operation
  @PostMapping("/departments")
  public Department saveDepartment(@Valid @RequestBody Department department) {
    return departmentService.saveDepartment(department);
  }

  // Read operation
  @GetMapping("/departments")
  public List<Department> fetchDepartmentList() {
    logger.info("begins fetchDepartmentList()");
    List<Department> entities = departmentService.fetchDepartmentList();
    logger.info("ended fetchDepartmentList()");
    return entities;
  }

  // Update operation
  @PutMapping("/departments/{id}")
  public Department updateDepartment(@RequestBody Department department, @PathVariable("id") String departmentId) {
    return departmentService.updateDepartment(department, departmentId);
  }

  // Delete operation
  @DeleteMapping("/departments/{id}")
  public String deleteDepartmentById(@PathVariable("id") String departmentId) {

    departmentService.deleteDepartmentById(departmentId);
    return "Deleted Successfully";
  }
}
