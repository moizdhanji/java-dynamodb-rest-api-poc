package com.cigna.ctc.apprunner;

import java.util.List;

public interface DepartmentService {
  Department saveDepartment(Department department);

  List<Department> fetchDepartmentList();

  Department updateDepartment(Department department, String departmentId);

  void deleteDepartmentById(String departmentId);
}
