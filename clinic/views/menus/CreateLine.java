package clinic.views.menus;

import clinic.views.menus.algorithms.LineAlgorihtm;

public class CreateLine extends MenuLine {
    private LineAlgorihtm algorithm;

    public CreateLine(String title) {
        super(title);
    }

    public CreateLine setAlgorithm(LineAlgorihtm algorithm) {
        this.algorithm = algorithm;
        return this;
    }

    @Override
    public void execute() {
        assert algorithm != null;
        algorithm.execute();
    }

}
