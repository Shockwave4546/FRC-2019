package frc.robot;

//import java.util.HashMap;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Sendable;
//import edu.wpi.first.wpilibj.command.Command;

public class Dashboard {

    private static Dashboard instance;

    private boolean shouldDisplayField(String key) {
        return true;
    }

    public boolean showDiagnostics;

    public void init(boolean showDiagonistics) {
        this.showDiagnostics = showDiagonistics;
    }

    public void putString(boolean isCompetition, String key, String value) {
        if (shouldDisplayField(key)) {
            SmartDashboard.putString(key, value);
        }
    }

    public void putNumber(boolean isCompetition, String key, double value) {
        if (shouldDisplayField(key))

        {
            SmartDashboard.putNumber(key, value);
        }
    }

    public void putBoolean(boolean isCompetition, String key, boolean value) {
        if (shouldDisplayField(key)) {
            SmartDashboard.putBoolean(key, value);
        }
    }

    public void putData(boolean isCompetition, String key, Sendable value) {
        if (shouldDisplayField(key)) {
            SmartDashboard.putData(key, value);
        }
    }

    public static Dashboard getInstance() {
        if (instance == null)
            instance = new Dashboard();
        return instance;
    }

}