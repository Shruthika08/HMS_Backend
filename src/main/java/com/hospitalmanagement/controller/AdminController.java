package com.hospitalmanagement.controller;
import com.hospitalmanagement.model.Appointment;
import com.hospitalmanagement.model.Doctor;
import com.hospitalmanagement.model.Patient;
import com.hospitalmanagement.service.AppointmentService;
import com.hospitalmanagement.service.DoctorService;
import com.hospitalmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
public class AdminController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    // Endpoint: GET /appointments
    @GetMapping("")
    public List<Appointment> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    // Endpoint: POST /appointments/patients
    @PostMapping("/patients")
    public Patient addPatientAndBookAppointment(@RequestBody Patient patientDetails) {
        return patientService.addPatient(patientDetails);
    }

    // Endpoint: GET /appointments/patients
    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    // Endpoint to delete a patient by ID
    @DeleteMapping("/patients/{patientId}")
    public void deletePatient(@PathVariable Long patientId) {
        patientService.deletePatient(patientId);
    }

    // Endpoint: GET /appointments/patients/{patientId}
    @GetMapping("/patients/{patientId}/appointments")
    public List<Appointment> getAppointmentsByPatientId(@PathVariable Long patientId) {
        return appointmentService.getAppointmentsByPatient(patientId);
    }

    // Endpoint: GET /appointments/doctors/{doctorId}/appointments
    @GetMapping("/doctors/{doctorId}/appointments")
    public List<Appointment> getAppointmentsByDoctor(@PathVariable Long doctorId) {
        return appointmentService.getAppointmentsByDoctor(doctorId);
    }

    // Endpoint: GET /appointments/doctors
    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    // Endpoint: POST /appointments/doctors
    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctorDetails) {
        return doctorService.addDoctor(doctorDetails);
    }

    // Endpoint: PUT /appointments/doctors/{doctorId}
    @PutMapping("/doctors/{doctorId}")
    public Doctor updateDoctor(@PathVariable Long doctorId, @RequestBody Doctor doctorDetails) {
        return doctorService.updateDoctor(doctorId, doctorDetails);
    }

    // Endpoint: DELETE /appointments/doctors/{doctorId}
    @DeleteMapping("/doctors/{doctorId}")
    public void deleteDoctor(@PathVariable Long doctorId) {
        doctorService.deleteDoctor(doctorId);
    }

    // Endpoint: POST /appointments/doctors/{doctorId}/appointments
    @PostMapping("/doctors/{doctorId}/appointments")
    public void scheduleAppointment(@PathVariable Long doctorId, @RequestBody Appointment appointmentDetails) {
        appointmentService.scheduleAppointment(doctorId, appointmentDetails);
    }

    // Endpoint: PUT /appointments/doctors/{doctorId}/appointments/{appointmentId}
    @PutMapping("/doctors/{doctorId}/appointments/{appointmentId}")
    public void rescheduleAppointment(@PathVariable Long doctorId, @PathVariable Long appointmentId,
                                      @RequestBody Appointment newAppointmentDetails) {
        appointmentService.rescheduleAppointment(doctorId, appointmentId, newAppointmentDetails);
    }

    // Endpoint: DELETE /appointments/doctors/{doctorId}/appointments/{appointmentId}
    @DeleteMapping("/doctors/{doctorId}/appointments/{appointmentId}")
    public void cancelAppointment(@PathVariable Long doctorId, @PathVariable Long appointmentId) {
        appointmentService.cancelAppointment(doctorId, appointmentId);
    }
}
