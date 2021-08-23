package clinic.models.users;

import clinic.models.MedicalHistoric;
import clinic.models.MedicalHistoricStatistics;
import clinic.models.errors.ClinicError;
import clinic.models.medical.MedicalProcedure;
import clinic.models.medical.ReceptorMedicalProcedure;
import clinic.models.medical.vaccines.Vaccine;

import java.util.Random;

/**
 * Write a description of class Patient here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Patient extends Person implements ReceptorMedicalProcedure, User {

    private static Integer numInstance = 0;
    private final MedicalHistoric medicalHistoric;
    private final Random random = new Random();
    private final MedicalHistoricStatistics medicalStatistics;
    private Integer identifier;
    private Integer SIP;

    /**
     * Constructor for objects of class Patient
     */
    public Patient(PersonalData personalData) {
        super(personalData);
        medicalHistoric = new MedicalHistoric();
        this.medicalStatistics = new MedicalHistoricStatistics(medicalHistoric);
        this.SIP = this.random.nextInt(7);
        this.identifier = Patient.numInstance++;
    }

    /**
     * Constructor for objects of class Patient
     */
    public Patient(PersonalData personalData, Integer SIP) {
        this(personalData);
        this.SIP = SIP;
    }


    public Integer getSIP() {
        return SIP;
    }

    public boolean isSIPMatch(Integer SIP) {
        return this.getSIP().equals(SIP);
    }

    protected MedicalHistoric getMedicalHistory() {
        return medicalHistoric;
    }

    @Override
    public ClinicError canBeVaccinated(Vaccine vaccine) {
        return this.getMedicalHistory().meetVaccinationRequirements(vaccine);
    }

    public MedicalHistoricStatistics getMedicalStatistics() {
        return medicalStatistics;
    }

    @Override
    public Integer getVaccineDoseInjected(String className) {
        return this.getMedicalHistory().sizeOfMedicalProcedure(className);
    }

    @Override
    public void addToMedicalHistory(MedicalProcedure medicalProcedure) {
        this.getMedicalHistory().add(medicalProcedure.getClass().toString(), medicalProcedure);
    }

    @Override
    public boolean isLockdown() {
        return this.getMedicalStatistics().isLockdown();
    }

    public Integer elapsedTimeConfined() {
        return this.getMedicalHistory().elapsedTimeConfined();
    }

    @Override
    public Integer getId() {
        return this.identifier;
    }
}
