DROP DATABASE IF EXISTS health_clinic;
CREATE DATABASE health_clinic;
USE health_clinic;

-- Patients
CREATE TABLE patients (
    patient_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    dob DATE,
    phone VARCHAR(15) UNIQUE,
    email VARCHAR(100) UNIQUE,
    address TEXT,
    blood_group VARCHAR(5)
);

-- Specialties
CREATE TABLE specialties (
    specialty_id INT AUTO_INCREMENT PRIMARY KEY,
    specialty_name VARCHAR(50) UNIQUE
);

-- Doctors
CREATE TABLE doctors (
    doctor_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    contact VARCHAR(15),
    consultation_fee DECIMAL(10,2),
    specialty_id INT,
    is_active BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (specialty_id)
        REFERENCES specialties(specialty_id)
);

-- Appointments
CREATE TABLE appointments (
    appointment_id INT AUTO_INCREMENT PRIMARY KEY,
    patient_id INT,
    doctor_id INT,
    appointment_date DATE,
    appointment_time TIME,
    status VARCHAR(20),
    FOREIGN KEY (patient_id)
        REFERENCES patients(patient_id),
    FOREIGN KEY (doctor_id)
        REFERENCES doctors(doctor_id)
);

-- Visits
CREATE TABLE visits (
    visit_id INT AUTO_INCREMENT PRIMARY KEY,
    appointment_id INT,
    diagnosis TEXT,
    notes TEXT,
    visit_date DATE,
    FOREIGN KEY (appointment_id)
        REFERENCES appointments(appointment_id)
);

-- Prescriptions
CREATE TABLE prescriptions (
    prescription_id INT AUTO_INCREMENT PRIMARY KEY,
    visit_id INT,
    medicine_name VARCHAR(100),
    dosage VARCHAR(50),
    duration VARCHAR(50),
    FOREIGN KEY (visit_id)
        REFERENCES visits(visit_id)
);

-- Bills
CREATE TABLE bills (
    bill_id INT AUTO_INCREMENT PRIMARY KEY,
    visit_id INT,
    total_amount DECIMAL(10,2),
    payment_status VARCHAR(20),
    FOREIGN KEY (visit_id)
        REFERENCES visits(visit_id)
);

-- Payment Transactions
CREATE TABLE payment_transactions (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    bill_id INT,
    payment_mode VARCHAR(30),
    payment_date DATE,
    FOREIGN KEY (bill_id)
        REFERENCES bills(bill_id)
);

INSERT INTO specialties (specialty_name)
VALUES ('General');

INSERT INTO doctors (name, contact, consultation_fee, specialty_id, is_active)
VALUES ('Dr. Sharma', '9876543210', 500.00, 1, true);

