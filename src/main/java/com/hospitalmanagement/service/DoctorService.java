package com.hospitalmanagement.service;

import com.hospitalmanagement.model.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    Doctor addDoctor(Doctor doctor);
    Doctor updateDoctor(Long doctorId, Doctor doctorDetails);
    void deleteDoctor(Long doctorId);
}
