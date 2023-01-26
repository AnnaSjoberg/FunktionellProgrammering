package JDBC.övn1;

import java.util.List;

public interface RepoInterface {

    int getNumberOfChildren();
    int getRowCount(String tableName);
    List<Elf> getAllElves();
    double getNicenessAverage();

}
