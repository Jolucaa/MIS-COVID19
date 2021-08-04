package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Write a description of class MedicalHistory here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MedicalHistory implements MedicalProcedureFamilyIdentificator {
    // instance variables - replace the example below with your own
    private HashMap<String, List<MedicalProcedure>> groupedMedicalProcedures;
    private Calendar calendar;
    private VaccinationAlgorithm vaccinationAlgorithm;

    public MedicalHistory() {
        this.groupedMedicalProcedures = new HashMap<>();
        this.calendar = new Calendar();
        this.vaccinationAlgorithm = new VaccinationAlgorithm(this);
    }

    /**
     * Constructor for objects of class MedicalHistory
     */
    public MedicalHistory(List<MedicalProcedure> medicalProcedures) {
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
    public void visit(Pfizer pfizer) {
        this.getVaccinationAlgorithm().isFulfillWithRequirements(pfizer);
    }

    private VaccinationAlgorithm getVaccinationAlgorithm() {
        return vaccinationAlgorithm;
    }

    @Override
    public void visit(Moderna moderna) {
        this.getVaccinationAlgorithm().isFulfillWithRequirements(moderna);
    }


    @Override
    public void visit(Johnson johnson) {
        this.getVaccinationAlgorithm().isFulfillWithRequirements(johnson);
    }

    @Override
    public void visit(PCR pcr) {
        this.add(pcr.getClass().toString(), pcr);

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

    @Override
    public DiagnosticTest diagnosticFamily(PCR pcr) {
        return pcr;
    }

    @Override
    public DiagnosticTest diagnosticFamily(SerologicalAnalysis serologicalAnalysis) {
        return serologicalAnalysis;
    }

    @Override
    public DiagnosticTest diagnosticFamily(ClassicTest classicTest) {
        return classicTest;
    }

    @Override
    public DiagnosticTest diagnosticFamily(FastTest fastTest) {
        return fastTest;
    }

    @Override
    public Vaccine vaccineFamily(Pfizer pfizer) {
        return pfizer;
    }

    @Override
    public Vaccine vaccineFamily(Moderna moderna) {
        return moderna;
    }

    @Override
    public Vaccine vaccineFamily(Johnson johnson) {
        return johnson;
    }


    public List<Vaccine> getVaccineCanInject() {
        ArrayList<String> diagnosticClass = new ArrayList<>();
        ArrayList<Vaccine> diagnosticList = new ArrayList<>();
        diagnosticClass.add(Pfizer.class.getSimpleName());
        diagnosticClass.add(Moderna.class.getSimpleName());
        diagnosticClass.add(Johnson.class.getSimpleName());
        for (String className : diagnosticClass) {
            for (MedicalProcedure medicalProcedure : this.getOneGroupOfHistory(className)) {
                Vaccine vaccine = medicalProcedure.vaccineFamily(this);
                if (vaccine != null) {
                    diagnosticList.add(vaccine);
                }
            }
        }
        return diagnosticList;
    }

    public List<DiagnosticTest> getDiagnosticsCanDo() {
        ArrayList<String> diagnosticClass = new ArrayList<>();
        ArrayList<DiagnosticTest> diagnosticList = new ArrayList<>();
        diagnosticClass.add(Pfizer.class.getSimpleName());
        diagnosticClass.add(Moderna.class.getSimpleName());
        diagnosticClass.add(Johnson.class.getSimpleName());
        for (String className : diagnosticClass) {
            for (MedicalProcedure medicalProcedure : this.getOneGroupOfHistory(className)) {
                DiagnosticTest procedureMedic = medicalProcedure.identify(this);
                if (procedureMedic != null) {
                    diagnosticList.add(procedureMedic);
                }
            }

        }
        return diagnosticList;
    }

    public List<DiagnosticTest> searchLockdown() {
        ArrayList<String> diagnosticClass = new ArrayList<>();
        ArrayList<DiagnosticTest> diagnosticList = new ArrayList<>();
        diagnosticClass.add(FastTest.class.getSimpleName());
        diagnosticClass.add(PCR.class.getSimpleName());
        diagnosticClass.add(ClassicTest.class.getSimpleName());
        for (String className : diagnosticClass) {
            for (MedicalProcedure medicalProcedure : this.getOneGroupOfHistory(className)) {
                DiagnosticTest diagnosticTest = medicalProcedure.identify(this);
                if (diagnosticTest.isPositive()) {
                    diagnosticList.add(diagnosticTest);
                }
            }
        }
        return diagnosticList;
    }

    protected List<MedicalProcedure> searchInHistory() {
        assert (this.getGroupedProcedures().isEmpty());
        for (List<MedicalProcedure> medicalProcedure:this.getGroupedProcedures().values()) {
            List<MedicalProcedure> groupObserved =
                    this.getOneGroupOfHistory(medicalProcedure.getClass().getSimpleName());
            if (!groupObserved.isEmpty()) {
                return groupObserved;
            }
        }
        return new ArrayList<>();
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
            DiagnosticTest diagnosticTest = medicalProcedure.identify(this);
            if (diagnosticTest.getDiagnosticTestAnalyzer() == technician) {
                if (this.isInSameWeek(medicalProcedure.getDateAssigned(), date)
                        || this.isInSameWeek(medicalProcedure.getDateRealization(), date)) {
                    numberOfProceduresInOneWeek++;
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
            if (daysFromLastLockdown.intValue() >= DiagnosticTestInformation.LOCKDOWN_TIME.getOrdinal()) {
                elapsedTimeConfined++;
            }
        }

        return elapsedTimeConfined;
    }
}
