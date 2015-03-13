package cu.uci.abcd.dataprovider.jisis.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.unesco.jisis.corelib.client.ClientDbProxy;
import org.unesco.jisis.corelib.common.CreateDbParams;
import org.unesco.jisis.corelib.common.FieldDefinitionTable;
import org.unesco.jisis.corelib.common.FieldSelectionTable;
import org.unesco.jisis.corelib.common.Global;
import org.unesco.jisis.corelib.common.PrintFormat;
import org.unesco.jisis.corelib.common.WorksheetDef;
import org.unesco.jisis.corelib.exceptions.DbException;
import org.unesco.jisis.corelib.record.IRecord;
import org.unesco.jisis.corelib.record.Record;

import cu.uci.abcd.dataprovider.jisis.IJisisDataProvider;
import cu.uci.abcd.dataprovider.jisis.exception.JisisDatabaseException;
import cu.uci.abcd.dataprovider.jisis.impl.util.ConnectionManager;
import cu.uci.abcd.dataprovider.jisis.search.option.Option;
import cu.uci.abcd.dataprovider.jisis.search.option.OptionAND;
import cu.uci.abcd.dataprovider.jisis.search.option.OptionOR;

public class JisisDataProviderImpl implements IJisisDataProvider {

	private String dbHome;

	private ClientDbProxy proxy;
	private ConnectionManager connectionManager;

	/**
	 * Used to initialize bean configuration from spring context
	 * */
	@SuppressWarnings("unused")
	private void initialize() {
		proxy = connectionManager.getProxy();
	}

	@Override
	public void createDatabase(String name, FieldDefinitionTable fdt,
			FieldSelectionTable fst, WorksheetDef defaultWorksheet,
			PrintFormat defaultPft) throws JisisDatabaseException {
		try {
			CreateDbParams params = new CreateDbParams(dbHome, name);
			params.setFieldDefinitionTable(fdt);
			params.setFieldSelectionTable(fst);
			params.setDefaultWorkSheet(defaultWorksheet);
			params.setDefaultPft(defaultPft.getName(), defaultPft.getFormat());

			proxy.createDatabase(params, Global.DATABASE_DURABILITY_WRITE);
		} catch (DbException e) {
			System.out
					.println("========================================ERROR=====================================");
			e.printStackTrace();
			System.out.println("Database connection failed");
			System.out
					.println("==================================================================================");
			throw new JisisDatabaseException("Error creating database");
		}
	}

	public void saveFieldSelectionTable(FieldSelectionTable fst)
			throws JisisDatabaseException {
		try {
			proxy.saveFieldSelectionTable(fst);
		} catch (DbException e) {
			System.out
					.println("========================================ERROR=====================================");
			e.printStackTrace();
			System.out.println("Database connection failed");
			System.out
					.println("==================================================================================");
			throw new JisisDatabaseException("Error saving fst");
		}
	}

	public void removeDatabase(String databaseName)
			throws JisisDatabaseException {
		throw new JisisDatabaseException(
				"Exception removing database. Not implemented yet");
	}

	public List<String> getDatabaseNames() throws JisisDatabaseException {
		List<String> databaseNames = new ArrayList<>();
		try {
			databaseNames = connectionManager.getConnection().getDbNames(
					getDbHome());
		} catch (DbException e) {
			System.out
					.println("========================================ERROR=====================================");
			e.printStackTrace();
			System.out.println("Database connection failed");
			System.out
					.println("==================================================================================");
			throw new JisisDatabaseException("Error getting database names");
		}

		return databaseNames;
	}

	public void saveRecord(IRecord record, String databaseName)
			throws JisisDatabaseException {
		try {
			proxy.getDatabase(getDbHome(), databaseName,
					Global.DATABASE_DURABILITY_WRITE);
			proxy.updateRecord((Record) record);
		} catch (Exception e) {
			System.out
					.println("========================================ERROR=====================================");
			e.printStackTrace();
			System.out.println("Error creating record");
			System.out
					.println("==================================================================================");
			throw new JisisDatabaseException("Error saving record");
		}
	}

	public void deleteRecord(IRecord record, String databaseName) {
		try {
			proxy.getDatabase(getDbHome(), databaseName,
					Global.DATABASE_DURABILITY_WRITE);
			proxy.deleteRecord(record.getMfn());
		} catch (Exception e) {
			System.out
					.println("========================================ERROR=====================================");
			e.printStackTrace();
			System.out.println("Error removing record");
			System.out
					.println("==================================================================================");
		}
	}

	public FieldSelectionTable getFieldSelectionTable(String databaseName)
			throws JisisDatabaseException {
		try {
			proxy.getDatabase(getDbHome(), databaseName,
					Global.DATABASE_DURABILITY_WRITE);
			return proxy.getFieldSelectionTable();
		} catch (DbException e) {
			System.out
					.println("========================================ERROR=====================================");
			e.printStackTrace();
			System.out.println("Database connection failed");
			System.out
					.println("==================================================================================");
			throw new JisisDatabaseException("Error obtaining FST");
		}
	}

	public List<Record> findByOptions(List<Option> options, String databaseName)
			throws JisisDatabaseException {
		List<Record> records = new ArrayList<>();
		long[] mfn = null;
		String parte1 = "";
		String parte2 = "";
		String consulta = "";
		for (int i = 0; i < options.size(); i++) {
			if (options.get(i) instanceof Option) {
				consulta = options.get(1).getField() + ":"
						+ options.get(1).getTerm();
			} else if (options.get(i) instanceof OptionAND) {
				parte1 += options.get(i).getField() + ":"
						+ options.get(i).getTerm() + " AND ";
				parte2 = options.get(options.size()).getField() + ":"
						+ options.get(options.size()).getTerm();
				consulta = parte1 + parte2;
			} else if (options.get(i) instanceof OptionOR) {
				parte1 += options.get(i).getField() + ":"
						+ options.get(i).getTerm() + " OR ";
				parte2 = options.get(options.size()).getField() + ":"
						+ options.get(options.size()).getTerm();
				consulta = parte1 + parte2;
			} else {
				parte1 += options.get(i).getField() + ":"
						+ options.get(i).getTerm() + " AND NOT ";
				parte2 = options.get(options.size()).getField() + ":"
						+ options.get(options.size()).getTerm();
				consulta = parte1 + parte2;
			}
		}
		try {
			proxy.getDatabase("DEF_HOME", databaseName,
					Global.DATABASE_DURABILITY_WRITE);
			mfn = proxy.searchLucene(consulta);
			if (null != mfn) {
				for (int j = 0; j < mfn.length; j++) {
					records.add((Record) proxy.getRecord(mfn[j]));
				}
			}
		} catch (DbException e) {
			e.printStackTrace();
		}
		return records;
	}

	public List<Record> find(String term, String databaseName) {
		FieldSelectionTable fst = new FieldSelectionTable();
		List<Record> records = new ArrayList<>();
		long[] mfn = null;
		int[] tags = null;
		String parte1 = "";
		String parte2 = "";
		String consulta = "";
		try {
			fst = proxy.getFieldSelectionTable();
			tags = fst.getEntriesTag();
		} catch (DbException e) {
			e.printStackTrace();
		}
		String[] terms = term.split(" ");
		for (int i = 0; i < terms.length; i++) {
			if (terms.length == 1) {
				for (int j = 0; j < tags.length - 1; j++) {
					parte1 += tags[j] + ":" + terms[0] + " OR ";
					parte2 = tags[tags.length] + ":" + terms[0];
				}
				consulta = parte1 + parte2;
			} else if (terms.length > 1) {
				for (int j = 0; j < tags.length; j++) {
					parte1 = tags[j] + ":" + terms[i] + " OR ";
				}
				consulta = parte1.substring(0, parte1.length() - 4);
			}
		}
		try {
			proxy.getDatabase("DEF_HOME", databaseName,
					Global.DATABASE_DURABILITY_WRITE);
			mfn = proxy.searchLucene(consulta);

			if (null != mfn) {
				for (int h = 0; h < mfn.length; h++) {
					records.add((Record) proxy.getRecord(mfn[h]));
				}
			}
		} catch (DbException e) {
			e.printStackTrace();
		}
		return records;
	}

	public String getDbHome() {
		return dbHome;
	}

	public void setDbHome(String dbHome) {
		this.dbHome = dbHome;
	}

	public ConnectionManager getConnectionManager() {
		return connectionManager;
	}

	public void setConnectionManager(ConnectionManager connectionManager) {
		this.connectionManager = connectionManager;
	}

	@Override
	public void updateRecord(IRecord record, String databaseName)
			throws JisisDatabaseException {
		try {
			proxy.getDatabase(getDbHome(), databaseName,
					Global.DATABASE_DURABILITY_WRITE);
			proxy.updateRecord((Record) record);
		} catch (Exception e) {
			System.out
					.println("========================================ERROR=====================================");
			e.printStackTrace();
			System.out.println("Error updating record");
			System.out
					.println("==================================================================================");
			throw new JisisDatabaseException("Error saving record");
		}

	}

	@Override
	public List<String> getWorksheetNames(String databaseName)
			throws JisisDatabaseException {
		try {
			proxy.getDatabase(getDbHome(), databaseName,
					Global.DATABASE_DURABILITY_WRITE);
			return Arrays.asList(proxy.getWorksheetNames());
		} catch (DbException e) {
			e.printStackTrace();
			throw new JisisDatabaseException(e.getMessage());
		}

	}

	@Override
	public WorksheetDef getWorksheet(String worksheetName, String databaseName)
			throws JisisDatabaseException {
		try {
			proxy.getDatabase(getDbHome(), databaseName,
					Global.DATABASE_DURABILITY_WRITE);
			return proxy.getWorksheetDef(worksheetName);
		} catch (DbException e) {
			e.printStackTrace();
			throw new JisisDatabaseException(e.getMessage());
		}

	}

}
