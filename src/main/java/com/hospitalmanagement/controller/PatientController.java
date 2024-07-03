package com.hospitalmanagement.controller;

import com.hospitalmanagement.model.Appointment;
import com.hospitalmanagement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private AppointmentService appointmentService;

    // Endpoint: GET /patients
    @GetMapping
    public List<Appointment> viewPastAppointments(@RequestParam Long patientId) {
        return appointmentService.getAppointmentsByPatient(patientId);
    }
}
