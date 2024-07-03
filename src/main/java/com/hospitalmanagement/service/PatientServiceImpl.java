package com.hospitalmanagement.service;

import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    @Override
    public void deletePatient(Long patientId) {
        patientRepository.deleteById(patientId);
    }
}