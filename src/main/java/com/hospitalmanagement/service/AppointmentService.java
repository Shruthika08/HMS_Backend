package com.hospitalmanagement.service;

import com.hospitalmanagement.model.Appointment;

import java.util.List;

public interface AppointmentService {
    List<Appointment> getAppointmentsByPatient(Long patientId);
    List<Appointment> getAppointmentsByDoctor(Long doctorId);
    List<Appointment> getAllAppointments();
    Appointment getAppointmentByDoctorAndPatient(Long doctorId, Long patientId);
    void scheduleAppointment(Long doctorId, Appointment appointment);
    void rescheduleAppointment(Long doctorId, Long appointmentId, Appointment newAppointmentDetails);
    void cancelAppointment(Long doctorId, Long appointmentId);
    void uploadPrescription(Long doctorId, Long patientId, String prescriptionDetails);
}
