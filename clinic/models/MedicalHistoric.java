package clinic.models;

import clinic.models.errors.ClinicError;
import clinic.models.errors.ErrorVaccinationError;
import clinic.models.medical.DiagnosticFamily;
import clinic.models.medical.MedicalProcedure;
import clinic.models.medical.MedicalProcedureVisitor;
import clinic.models.medical.VaccineFamily;
import clinic.models.medical.diagnostics.*;
import clinic.models.medical.vaccines.Johnson;
import clinic.models.medical.vaccines.Moderna;
import clinic.models.medical.vaccines.Pfizer;
import clinic.models.medical.vaccines.Vaccine;
import clinic.models.users.Nurse;
import clinic.models.users.Technician;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Write a description of class MedicalHistoric here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MedicalHistoric implements MedicalProcedureVisitor {
    // instance variables - replace the example below with your own
    private HashMap<String, List<MedicalProcedure>> groupedMedicalProcedures;
    private Calendar calendar;
    private VaccinationAlgorithm vaccinationAlgorithm;
    private DiagnosticFamily diagnosticFamily;
    private VaccineFamily vaccineFamily;

    public MedicalHistoric() {
        this.groupedMedicalProcedures = new HashMap<>();
        this.calendar = new Calendar();
        this.vaccinationAlgorithm = new VaccinationAlgorithm(this);
        this.diagnosticFamily = new DiagnosticFamily();
        this.vaccineFamily = new VaccineFamily();
    }

    /**
     * Constructor for objects of class MedicalHistoric
     */
    public MedicalHistoric(List<MedicalProcedure> medicalProcedures) {
        this();
        for (MedicalProcedure medicalProcedure : medicalProcedures) {
            medicalProcedure.accept(this);
        }
    }

    public boolean isEmpty() {
        return this.getGroupedProcedures().isEmpty();
    }

    public Integer sizeOfMedicalProcedure(String className) {
        return this.getGroupedProcedures().get(className).size();
    }

    protected HashMap<String, List<MedicalProcedure>> getGroupedProcedures() {
        return this.groupedMedicalProcedures;
    }

    public void add(String className, MedicalProcedure medicalProcedure) {
        if (this.getGroupedProcedures().containsKey(className)) {
            this.getGroupedProcedures().get(className).add(medicalProcedure);
        } else {
            ArrayList<MedicalProcedure> list = new ArrayList<>();
            list.add(medicalProcedure);
            this.getGroupedProcedures().put(className, list);
        }
    }

    public boolean contains(String className) {
        return this.getGroupedProcedures().containsKey(className);
    }

    private Calendar getCalendar() {
        return this.calendar;
    }

    @Override
    public ClinicError visit(Pfizer pfizer) {
        ClinicError error = new ClinicError();
        if(this.getVaccinationAlgorithm().isFulfillWithRequirements(pfizer)){
            error.add(new ErrorVaccinationError());
        }
        return error;
    }

    private VaccinationAlgorithm getVaccinationAlgorithm() {
        return vaccinationAlgorithm;
    }

    @Override
    public ClinicError visit(Moderna moderna) {
        ClinicError error = new ClinicError();
        if(this.getVaccinationAlgorithm().isFulfillWithRequirements(moderna)){
            error.add(new ErrorVaccinationError());
        }
        return error;
    }


    @Override
    public ClinicError visit(Johnson johnson) {
        ClinicError error = new ClinicError();
        if(this.getVaccinationAlgorithm().isFulfillWithRequirements(johnson)){
            error.add(new ErrorVaccinationError());
        }
        return error;
    }

    @Override
    public void visit(PCR pcr) {
        this.add(pcr.getClass().getSimpleName(), pcr);

    }

    @Override
    public void visit(SerologicalAnalysis serologicalAnalysis) {
        this.add(serologicalAnalysis.getClass().getSimpleName(), serologicalAnalysis);
    }

    @Override
    public void visit(ClassicTest classicTest) {
        this.add(classicTest.getClass().getSimpleName(), classicTest);
    }

    @Override
    public void visit(FastTest fastTest) {
        this.add(fastTest.getClass().getSimpleName(), fastTest);
    }

    public List<Vaccine> getVaccineCanInject() {
        ArrayList<String> diagnosticClass = new ArrayList<>();
        ArrayList<Vaccine> diagnosticList = new ArrayList<>();
        diagnosticClass.add(Pfizer.class.getSimpleName());
        diagnosticClass.add(Moderna.class.getSimpleName());
        diagnosticClass.add(Johnson.class.getSimpleName());
        for (String className : diagnosticClass) {
            for (MedicalProcedure medicalProcedure : this.getOneGroupOfHistory(className)) {
                this.getVaccineFamily().accept(medicalProcedure);
                if(this.getVaccineFamily().isBelongsFamily()) {
                    Vaccine vaccine = this.getVaccineFamily().getAndRenewValue();
                    if (vaccine != null) {
                        diagnosticList.add(vaccine);
                    }
                }
            }
        }
        return diagnosticList;
    }

    private VaccineFamily getVaccineFamily() {
        return vaccineFamily;
    }

    public List<DiagnosticTest> getDiagnosticsCanDo() {
        ArrayList<String> diagnosticClass = new ArrayList<>();
        ArrayList<DiagnosticTest> diagnosticList = new ArrayList<>();
        diagnosticClass.add(Pfizer.class.getSimpleName());
        diagnosticClass.add(Moderna.class.getSimpleName());
        diagnosticClass.add(Johnson.class.getSimpleName());
        for (String className : diagnosticClass) {
            for (MedicalProcedure medicalProcedure : this.getOneGroupOfHistory(className)) {
                this.getDiagnosticFamily().accept(medicalProcedure);
                if(this.getDiagnosticFamily().isBelongsFamily()) {
                        diagnosticList.add(this.getDiagnosticFamily().getAndRenewValue());
                }
            }

        }
        return diagnosticList;
    }

    protected List<MedicalProcedure> getOneGroupOfHistory(String className) {
        ArrayList<MedicalProcedure> elementsFind = new ArrayList<>();
        if (!this.getGroupedProcedures().isEmpty()) {
            if (this.getGroupedProcedures().containsKey(className)) {
                return this.getGroupedProcedures().get(className);
            }
        }
        return elementsFind;
    }

    private DiagnosticFamily getDiagnosticFamily() {
        return diagnosticFamily;
    }

    public List<DiagnosticTest> searchLockdown() {
        ArrayList<String> diagnosticClass = new ArrayList<>();
        ArrayList<DiagnosticTest> diagnosticList = new ArrayList<>();
        diagnosticClass.add(FastTest.class.getSimpleName());
        diagnosticClass.add(PCR.class.getSimpleName());
        diagnosticClass.add(ClassicTest.class.getSimpleName());
        for (String className : diagnosticClass) {
            for (MedicalProcedure medicalProcedure : this.getOneGroupOfHistory(className)) {
                this.getDiagnosticFamily().accept(medicalProcedure);
                if(this.getDiagnosticFamily().isBelongsFamily()) {
                    DiagnosticTest diagnosticTest = this.getDiagnosticFamily().getAndRenewValue();
                    if (diagnosticTest.isPositive()) {
                        diagnosticList.add(diagnosticTest);
                    }
                }
            }
        }
        return diagnosticList;
    }

    protected List<MedicalProcedure> searchInHistory() {
        assert (this.getGroupedProcedures().isEmpty());
        for (List<MedicalProcedure> medicalProcedure : this.getGroupedProcedures().values()) {
            List<MedicalProcedure> groupObserved =
                    this.getOneGroupOfHistory(medicalProcedure.getClass().getSimpleName());
            if (!groupObserved.isEmpty()) {
                return groupObserved;
            }
        }
        return new ArrayList<>();
    }

    public Integer searchInThatWeek(LocalDate date, Nurse nurse) {
        Integer numberOfProceduresInOneWeek = 0;
        if (!this.getGroupedProcedures().isEmpty()) {
            for (MedicalProcedure medicalProcedure : this.searchInHistory()) {
                if (medicalProcedure.getMedicalProcedureManager() == nurse) {
                    if (this.isInSameWeek(medicalProcedure.getDateAssigned(), date)
                            || this.isInSameWeek(medicalProcedure.getDateRealization(), date)) {
                        numberOfProceduresInOneWeek++;
                    }
                }
            }
        }
        return numberOfProceduresInOneWeek;
    }

    public boolean isInSameWeek(LocalDate dateOfReference, LocalDate dateToInvestigate) {
        return this.getCalendar().isInSameWeek(dateOfReference, dateToInvestigate);
    }

    public Integer searchInThatWeek(LocalDate date, Technician technician) {
        Integer numberOfProceduresInOneWeek = 0;
        for (MedicalProcedure medicalProcedure : this.searchInHistory()) {
            this.getDiagnosticFamily().accept(medicalProcedure);
            if(this.getDiagnosticFamily().isBelongsFamily()) {
                DiagnosticTest diagnosticTest = this.getDiagnosticFamily().getAndRenewValue();
                if (diagnosticTest.getDiagnosticTestAnalyzer() == technician) {
                    if (this.isInSameWeek(medicalProcedure.getDateAssigned(), date)
                            || this.isInSameWeek(medicalProcedure.getDateRealization(), date)) {
                        numberOfProceduresInOneWeek++;
                    }
                }
            }
        }

        return numberOfProceduresInOneWeek;
    }

    public Integer elapsedTimeConfined() {
        Integer elapsedTimeConfined = 0;
        for (DiagnosticTest diagnosticTest : this.searchLockdown()) {
            LocalDate currentDate = LocalDate.now();
            Long daysFromLastLockdown = this.getCalendar().durationBetweenDays(currentDate, diagnosticTest.getDateRealization());
            if (daysFromLastLockdown.intValue() >= DiagnosticTestInformation.LOCKDOWN_TIME.getRequirement()) {
                elapsedTimeConfined++;
            }
        }

        return elapsedTimeConfined;
    }

    public ClinicError meetVaccinationRequirements(Vaccine vaccine) {
        ClinicError error = new ClinicError();
        error.add(vaccine.accept(this));
        return error;
    }

    public Integer weekProcedureAmount(Nurse nurse, LocalDate date) {
        return this.searchInThatWeek(date, nurse);
    }

    public Integer weekProcedureAmount(Technician technician, LocalDate date) {
        return this.searchInThatWeek(date, technician);
    }
}
