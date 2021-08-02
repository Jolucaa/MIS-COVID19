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
public class MedicalHistory implements MedicalProcedureVisitor {
    // instance variables - replace the example below with your own
    private HashMap<String, ArrayList<MedicalProcedure>> groupedMedicalProcedures;
    private Calendar calendar;

    public MedicalHistory() {
        this.groupedMedicalProcedures = new HashMap<>();
        this.calendar = new Calendar();
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

    protected HashMap<String, ArrayList<MedicalProcedure>> getGroupedProcedures() {
        return this.groupedMedicalProcedures;
    }

    public void add(String className, MedicalProcedure medicalProcedure) {
        if (this.getGroupedProcedures().containsKey(className)) {
            this.getGroupedProcedures().get(className).add(medicalProcedure);
        } else {
            ArrayList<MedicalProcedure> list = new ArrayList<MedicalProcedure>();
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
    public boolean visit(Pfizer pfizer) {
        return new VaccinationAlghoritm(this).isFulfillWithRequirements(pfizer);
    }

    @Override
    public boolean visit(Moderna moderna) {
        return new VaccinationAlghoritm(this).isFulfillWithRequirements(moderna);
    }

    @Override
    public boolean visit(Johnson johnson) {
        return new VaccinationAlghoritm(this).isFulfillWithRequirements(johnson);
    }

    @Override
    public boolean visit(PCR pcr) {
        this.add(pcr.getClass().toString(), pcr);
        return false;
    }

    @Override
    public boolean visit(SerologicalAnalysis serologicalAnalysis) {
        this.add(serologicalAnalysis.getClass().toString(), serologicalAnalysis);
        return false;
    }

    @Override
    public boolean visit(ClassicTest classicTest) {
        this.add(classicTest.getClass().toString(), classicTest);
        return false;
    }

    @Override
    public boolean visit(FastTest fastTest) {
        this.add(fastTest.getClass().toString(), fastTest);
        return false;
    }

    @Override
    public DiagnosticTest identify(PCR pcr) {
        return pcr;
    }

    @Override
    public DiagnosticTest identify(SerologicalAnalysis serologicalAnalysis) {
        return serologicalAnalysis;
    }

    @Override
    public DiagnosticTest identify(ClassicTest classicTest) {
        return classicTest;
    }

    @Override
    public DiagnosticTest identify(FastTest fastTest) {
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


    public ArrayList<Vaccine> getVaccineCanInject() {
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

    public ArrayList<DiagnosticTest> getDiagnosticsCanDo() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        ArrayList<String> diagnosticClass = new ArrayList<>();
        ArrayList<DiagnosticTest> diagnosticList = new ArrayList<>();
        diagnosticClass.add(Pfizer.class.getSimpleName());
        diagnosticClass.add(Moderna.class.getSimpleName());
        diagnosticClass.add(Johnson.class.getSimpleName());
        for (String className : diagnosticClass) {
            ArrayList<MedicalProcedure> list = this.getOneGroupOfHistory(className);
            if (list.isEmpty()) {
                diagnosticList.add((DiagnosticTest) Class.forName(className).newInstance());
            } else {
                for (MedicalProcedure medicalProcedure : this.getOneGroupOfHistory(className)) {
                    DiagnosticTest procedureMedic = medicalProcedure.identify(this);
                    if (procedureMedic != null) {
                        diagnosticList.add(procedureMedic);
                    }
                }
            }
        }
        return diagnosticList;
    }

    public ArrayList<DiagnosticTest> searchLockdown() {
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

    protected ArrayList<MedicalProcedure> searchInHistory() {
        assert (this.getGroupedProcedures().isEmpty());
        for (int i = 0; i <= this.getGroupedProcedures().size(); i++) {
            ArrayList<MedicalProcedure> groupObserverd =
                    this.getOneGroupOfHistory(this.getGroupedProcedures().get(i).getClass().getSimpleName());
            if (!groupObserverd.isEmpty()) {
                return groupObserverd;
            }
        }
        return null;
    }

    protected ArrayList<MedicalProcedure> getOneGroupOfHistory(String className) {
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
            Long daysFromLastLockdown = this.calendar.durationBetweenDays(currentDate, diagnosticTest.getDateRealization());
            if (daysFromLastLockdown.intValue() >= DiagnosticTestInformation.LOCKDOWN_TIME.getOrdinal()) {
                elapsedTimeConfined++;
            }
        }

        return elapsedTimeConfined;
    }
}
