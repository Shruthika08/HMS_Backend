package com.hospitalmanagement.service;

import com.hospitalmanagement.model.Appointment;
import com.hospitalmanagement.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Override
    public List<Appointment> getAppointmentsByPatient(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    public List<Appointment> getAppointmentsByDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    @Override
    public Appointment getAppointmentByDoctorAndPatient(Long doctorId, Long patientId) {
        return appointmentRepository.findByDoctorIdAndPatientId(doctorId, patientId).orElse(null);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public void scheduleAppointment(Long doctorId, Appointment appointment) {
        appointment.setDoctorId(doctorId);
        appointment.setStatus("Scheduled");
        appointmentRepository.save(appointment);
    }

    @Override
    public void rescheduleAppointment(Long doctorId, Long appointmentId, Appointment newAppointmentDetails) {
        Optional<Appointment> existingAppointmentOpt = appointmentRepository.findById(appointmentId);
        if (existingAppointmentOpt.isPresent()) {
            Appointment existingAppointment = existingAppointmentOpt.get();
            existingAppointment.setAppointmentDateTime(newAppointmentDetails.getAppointmentDateTime());
            existingAppointment.setPrescription(newAppointmentDetails.getPrescription());
            existingAppointment.setStatus("Rescheduled");
            appointmentRepository.save(existingAppointment);
        }
    }

    @Override
    public void cancelAppointment(Long doctorId, Long appointmentId) {
        appointmentRepository.deleteById(appointmentId);
    }

    @Override
    public void uploadPrescription(Long doctorId, Long patientId, String prescriptionDetails) {
        Optional<Appointment> existingAppointmentOpt = appointmentRepository.findByDoctorIdAndPatientId(doctorId, patientId);
        if (existingAppointmentOpt.isPresent()) {
            Appointment existingAppointment = existingAppointmentOpt.get();
            existingAppointment.setPrescription(prescriptionDetails);
            appointmentRepository.save(existingAppointment);
        }
    }
}
