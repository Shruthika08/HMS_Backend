package com.hospitalmanagement.controller;

import com.hospitalmanagement.model.Appointment;
import com.hospitalmanagement.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private AppointmentService appointmentService;

    // Endpoint: GET /doctors/{doctorId}/patients/{patientId}
    @GetMapping("/{doctorId}/patients/{patientId}")
    public Appointment viewPatientDetails(@PathVariable Long doctorId, @PathVariable Long patientId) {
        return appointmentService.getAppointmentByDoctorAndPatient(doctorId, patientId);
    }

    // Endpoint: PUT /doctors/{doctorId}/patients/{patientId}/prescription
    @PutMapping("/{doctorId}/patients/{patientId}/prescription")
    public void uploadPrescription(@PathVariable Long doctorId, @PathVariable Long patientId,
                                   @RequestBody String prescriptionDetails) {
        appointmentService.uploadPrescription(doctorId, patientId, prescriptionDetails);
    }
}
