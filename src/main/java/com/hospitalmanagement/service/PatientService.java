package com.hospitalmanagement.service;

import com.hospitalmanagement.model.Patient;
import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);
    List<Patient> getAllPatients();
    void deletePatient(Long patientId);
}

