# REGEXP
SELECT patient_id, patient_name, conditions
FROM Patients
WHERE conditions REGEXP 'DIAB1';

# LIKE
SELECT patient_id, patient_name, conditions
FROM Patients
WHERE conditions LIKE '%DIAB1%';
