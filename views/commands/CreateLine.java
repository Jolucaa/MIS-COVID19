package views.commands;

import views.strategy.StrategyAlghoritm;

public class CreateLine extends MenuLine {
    private StrategyAlghoritm alghoritm;

    public CreateLine setAlghoritm(StrategyAlghoritm alghoritm) {
        this.alghoritm = alghoritm;
        return this;
    }

    @Override
    public String getTitle() {
        return alghoritm.getTitle();
    }

    @Override
    public void execute() {
        assert alghoritm != null;
        alghoritm.execute();
    }

}
