package cu.uci.abcd.dataprovider.jisis;

import java.util.List;

import org.unesco.jisis.corelib.common.FieldDefinitionTable;
import org.unesco.jisis.corelib.common.FieldSelectionTable;
import org.unesco.jisis.corelib.common.PrintFormat;
import org.unesco.jisis.corelib.common.WorksheetDef;
import org.unesco.jisis.corelib.record.IRecord;
import org.unesco.jisis.corelib.record.Record;

import cu.uci.abcd.dataprovider.jisis.exception.JisisDatabaseException;
import cu.uci.abcd.dataprovider.jisis.search.option.Option;

/**
 * 
 * @author
 * @version
 * 
 */
public interface IJisisDataProvider {

    /**
     * 
     * @param name
     * @param fdt
     * @param fst
     * @param defaultWorksheet
     * @param defaultPft
     * @throws JisisDatabaseException
     */
    public void createDatabase(String name, FieldDefinitionTable fdt, FieldSelectionTable fst, WorksheetDef defaultWorksheet, PrintFormat defaultPft) throws JisisDatabaseException;

    /**
     * 
     * @param record
     * @param databaseName
     * @throws JisisDatabaseException
     */
    public void deleteRecord(IRecord record, String databaseName) throws JisisDatabaseException;

    /**
     * 
     * @param record
     * @param databaseName
     * @throws JisisDatabaseException
     */
    public void updateRecord(IRecord record, String databaseName) throws JisisDatabaseException;

    /**
     * 
     * @param name
     * @throws JisisDatabaseException
     */
    public void removeDatabase(String name) throws JisisDatabaseException;

    /**
     * 
     * @return
     * @throws JisisDatabaseException
     */
    public List<String> getDatabaseNames() throws JisisDatabaseException;

    /**
     * 
     * @param record
     * @param databaseName
     * @throws JisisDatabaseException
     */
    public void saveRecord(IRecord record, String databaseName) throws JisisDatabaseException;

    /**
     * 
     * @param fst
     * @throws JisisDatabaseException
     */
    public void saveFieldSelectionTable(FieldSelectionTable fst) throws JisisDatabaseException;

    /**
     * 
     * @param databaseName
     * @return
     * @throws JisisDatabaseException
     */
    public FieldSelectionTable getFieldSelectionTable(String databaseName) throws JisisDatabaseException;

    /**
     * 
     * @param options
     * @return
     * @throws JisisDatabaseException
     */
    public List<Record> findByOptions(List<Option> options, String databaseName) throws JisisDatabaseException;

    /**
     * 
     * @param term
     * @return
     * @throws JisisDatabaseException
     */
    public List<Record> find(String term, String databaseName) throws JisisDatabaseException;

    public List<String> getWorksheetNames(String databaseName) throws JisisDatabaseException;

    public WorksheetDef getWorksheet(String worksheetName, String databaseName) throws JisisDatabaseException;

}
