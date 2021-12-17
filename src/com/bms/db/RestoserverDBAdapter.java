package com.bms.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;


public class RestoserverDBAdapter {

	
	private static final  String TAG = "com.scm.db.RestoserverDBAdapter" ;
	private static final Logger logger = Logger.getLogger(TAG);

	
	protected static String MEASUREMENT_TABLE_NAME = "measurementTable";
	public static String COLUMN_MEASUREMENT_ID = "measurementId";
	public static String COLUMN_MEASUREMENT_UNIT = "measurementUnit";
	public static String COLUMN_MEASUREMENT_NAME = "measurementName";
	public static String COLUMN_MEASUREMENT_SYMBOL = "measurementSymbol";
	
	protected static String SUPPLIER_TABLE_NAME = "supplierTable";
	public static String COLUMN_SUPPLIER_ID = "supplierId";
	public static String COLUMN_SUPPLIER_COMPANY_NAME = "supplierCompanyName";
	public static String COLUMN_SUPPLIER_ADDRESS = "supplierAddress";
	public static String COLUMN_SUPPLIER_CONTACT_PERSON_FIRST = "supplierContactPersonFirst";
	public static String COLUMN_SUPPLIER_CONTACT_PERSON_SECOND = "supplierContactPersonSecond";
	public static String COLUMN_SUPPLIER_CONTACT_PERSON_THIRD = "supplierContactPersonThird";
	public static String COLUMN_SUPPLIER_PHONE_NO_FIRST = "supplierPhoneNoFirst";
	public static String COLUMN_SUPPLIER_PHONE_NO_SECOND = "supplierPhoneNoSecond";
	public static String COLUMN_SUPPLIER_PHONE_NO_THIRD = "supplierPhoneNoThird";
	public static String COLUMN_SUPPLIER_VAT_NO = "supplierVatNo";
	public static String COLUMN_SUPPLIER_TIN_NO = "supplierTinNo";
	public static String COLUMN_SUPPLIER_BANK_NAME = "supplierBankName";
	public static String COLUMN_SUPPLIER_BANK_ACCOUNT_NO = "supplierBankAccountNo";
	public static String COLUMN_SUPPLIER_IS_ACTIVE= "isSupplierActive";
	
	
	protected static String ITEM_ENTRY_TABLE_NAME = "itemEntryTable";
	public static String COLUMN_ITEM_ENTRY_ID = "itemEntryId";
	public static String COLUMN_DELIVERY_DATE = "deliveryDate";
	public static String COLUMN_QUANTITY = "quantity";
	public static String COLUMN_ITEM_PRICE = "itemPrice";
	public static String COLUMN_EXPIRY_DATE = "expiryDate";
	public static String COLUMN_IS_EXPIRE = "isExpire";
	public static String COLUMN_BASE_QUANTITY = "baseQuantity";
	public static String COLUMN_BASE_QUANTITY_LEFT = "baseQuantityLeft";
	public static String COLUMN_ITEM_ENTRY_GOODS_ENTRY_ID= "goodsEntryId";
	public static String COLUMN_ITEM_ENTRY_TAX_VALUE="taxValue";
	public static String COLUMN_ITEM_ENTRY_TOTAL="total";
	
	protected static String MMS_DEPT_REQUEST_MASTER_TABLE_NAME = "mms_dept_request_master";
	public static String COLUMN_REQUEST_MASTER_ID = "requestMasterId";
	public static String COLUMN_REQUEST_DATE = "requestDate";
	public static String COLUMN_OUTLET_ID="outletId";
	public static String COLUMN_DEPARTMENT_ID="deptId";
	public static String COLUMN_PRIORITY = "priority";
	public static String COLUMN_REQUEST_MASTER_STATE = "requestMasterState";
	
	protected static String MMS_DEPT_REQUEST_DETAILS_TABLE_NAME = "mms_dept_request_details";
	public static String COLUMN_REQUEST_DETAILS_ID = "requestDetailsId";
	public static String COLUMN_CURRENT_QUANTITY = "currentQuantity";
	public static String COLUMN_NEED_QUANTITY="needQuantity";
	public static String COLUMN_REQUEST_DETAILS_STATE="requestDetailsState";
	
	
	 
    protected static String ITEM_TABLE_NAME = "itemTable";
	public static String COLUMN_ITEM_ID = "itemId";
	public static String COLUMN_ITEM_NAME = "itemName";

	public static String COLUMN_ITEM_LIFE = "itemLife";
	public static String COLUMN_ITEM_ISACTIVE = "itemIsActive";
	public static String COLUMN_ITEM_THRESHOLD_VALUE = "itemThresholdValue";
	
	
	
	public static String COLUMN_ITEM_QUANTITY = "itemQuantity";
	public static String COLUMN_ITEM_BASE_QUANTITY = "baseItemQuantity";
	public static String COLUMN_ITEM_IS_FINISH = "itemIsFinish";
	
	//user table fields
	public static final String USER_TABLE_NAME="users";
	public static final String KEY_UID="userMasterId";
	public static final String KEY_USERNAME="userName";
	public static final String KEY_PASSWORD="password";
	public static final String KEY_FIRSTNAME="firstName";
	public static final String KEY_LASTNAME="lastName";
	public static final String KEY_PHONE1="phoneNumber1";
	public static final String KEY_ADDRESS="address";
	public static final String KEY_ROLE="userRoleName";
	public static final String KEY_CREATIONDTTM="createdDTTM";
	public static final String KEY_LASTLOGINDTTM="modifiedDTTM";
	public static final String KEY_CREATEDBY="createdBy";
	public static final String KEY_MODIFIEDBY="modifiedBy";
	public static final String KEY_COMPANYID="companyMasterId";
	public static final String KEY_SITE_ID="siteId";
    
	protected static final String CONFIG_TABLE_NAME = "neetai_configuration";
	public static final String KEY_PROPERTY = "property";
	public static final String KEY_VALUE = "value";
	public static final String KEY_PROPERTY_TYPE = "propertytype";
	public static final String KEY_COMPANY_ID="companyid";

	protected static final String CUSTOMER_TABLE_NAME="customerTable";
	public static final String KEY_CUSTOMERID="customerId";
	public static final String KEY_CUSTOMER_CONTACTNO="contactNumber";
	public static final String KEY_CUSTOMER_NAME="name";
	public static final String KEY_CUSTOMER_ADDRESS="address";
	public static final String KEY_CUSTOMER_DOB="dob";
	public static final String KEY_CUSTOMER_PINCODE="pincode";
	public static final String KEY_ORDER_MASTER_CREATED_DATE="createdDate";
	public static final String KEY_ORDER_MASTER_CREATED_DTTM="createdDTTM";
	
	
	private DBConnectionPool dbConnectionPool;

	protected Connection connection;

	public RestoserverDBAdapter()
	{
		dbConnectionPool= DBConnectionPool.getInstance();
	}

	public void open()
	{
		System.out.println("open connection");
		try {
			connection = (Connection)dbConnectionPool.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("exception in error connection");
		}
	}

	public void close()
	{
		dbConnectionPool.free(connection);
		System.out.println("close connection");
	}



	/**
	 * Convenience method for inserting a row into the database.
	 *
	 * @param table the table to insert the row into
	 * @param nullColumnHack SQL doesn't allow inserting a completely empty row,
	 *            so if initialValues is empty this column will explicitly be
	 *            assigned a NULL value
	 * @param values this map contains the initial column values for the
	 *            row. The keys should be the column names and the values the
	 *            column values
	 * @return the row ID of the newly inserted row, or -1 if an error occurred
	 */
	public long insert(String table, String nullColumnHack, ContentValues values) {
		return insertWithOnConflict(table, nullColumnHack, values);
	}

	/**
	 * General method for inserting a row into the database.
	 *
	 * @param table the table to insert the row into
	 * @param nullColumnHack SQL doesn't allow inserting a completely empty row,
	 *            so if initialValues is empty this column will explicitly be
	 *            assigned a NULL value
	 * @param initialValues this map contains the initial column values for the
	 *            row. The keys should be the column names and the values the
	 *            column values
	 * @param algorithm  {@link ConflictAlgorithm} for insert conflict resolver
	 * @return the row ID of the newly inserted row, or -1 if an error occurred
	 * @hide
	 */
	public long insertWithOnConflict(String table, String nullColumnHack,
			ContentValues initialValues) {
		/* if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
		 */
		// Measurements show most sql lengths <= 152
		StringBuilder sql = new StringBuilder(152);
		sql.append("INSERT");

		sql.append(" INTO ");
		sql.append(table);
		// Measurements show most values lengths < 40
		StringBuilder values = new StringBuilder(40);

		Set<Map.Entry<String, Object>> entrySet = null;
		if (initialValues != null && initialValues.size() > 0) {
			entrySet = initialValues.valueSet();
			Iterator<Map.Entry<String, Object>> entriesIter = entrySet.iterator();
			sql.append('(');

			boolean needSeparator = false;
			while (entriesIter.hasNext()) {
				if (needSeparator) {
					sql.append(", ");
					values.append(", ");
				}
				needSeparator = true;
				Map.Entry<String, Object> entry = entriesIter.next();
				sql.append(entry.getKey());
				values.append('?');
			}

			sql.append(')');
		} else {
			sql.append("(" + nullColumnHack + ") ");
			values.append("NULL");
		}

		sql.append(" VALUES(");
		sql.append(values);
		sql.append(");");

		try {
			//          statement = compileStatement(sql.toString())
			System.out.println("QURERY "+sql);
			PreparedStatement ps = connection.prepareStatement(sql.toString(),Statement.RETURN_GENERATED_KEYS);
			// Bind the values
			if (entrySet != null) {
				int size = entrySet.size();
				Iterator<Map.Entry<String, Object>> entriesIter = entrySet.iterator();
				for (int i = 0; i < size; i++) {
					Map.Entry<String, Object> entry = entriesIter.next();
					bindObjectToProgram(ps, i + 1, entry.getValue());
				}
			}
			 ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int result = 0;
			if (rs.next()){
			    result =rs.getInt(1);
			}
			return result;
		}catch(Exception ex)
		{
			System.out.println(ex);
			return -1;
		}


		/*lock();
        SQLiteStatement statement = null;
        try {
            statement = compileStatement(sql.toString());

            // Bind the values
            if (entrySet != null) {
                int size = entrySet.size();
                Iterator<Map.Entry<String, Object>> entriesIter = entrySet.iterator();
                for (int i = 0; i < size; i++) {
                    Map.Entry<String, Object> entry = entriesIter.next();
                    DatabaseUtils.bindObjectToProgram(statement, i + 1, entry.getValue());
                }
            }

            // Run the program and then cleanup
            statement.execute();

            long insertedRowId = lastInsertRow();
            if (insertedRowId == -1) {
                Log.e(TAG, "Error inserting " + initialValues + " using " + sql);
            } else {
                if (Config.LOGD && Log.isLoggable(TAG, Log.VERBOSE)) {
                    Log.v(TAG, "Inserting row " + insertedRowId + " from "
                            + initialValues + " using " + sql);
                }
            }
            return insertedRowId;
        } catch (SQLiteDatabaseCorruptException e) {
            onCorruption();
            throw e;
        } finally {
            if (statement != null) {
                statement.close();
            }
            unlock();
        }*/
		//        return -1;
	}

	public static void bindObjectToProgram(PreparedStatement prog, int index,
			Object value) throws SQLException {
		if (value == null) {
			prog.setNull(index,java.sql.Types.NULL);
		} else if (value instanceof Double || value instanceof Float) {
			prog.setDouble(index, ((Number)value).doubleValue());
		} else if (value instanceof Number) {
			prog.setLong(index, ((Number)value).longValue());
		} else if (value instanceof Boolean) {
			Boolean bool = (Boolean)value;
			if (bool) {
				prog.setLong(index, 1);
			} else {
				prog.setLong(index, 0);
			}
		} else if (value instanceof byte[]){
			prog.setBytes(index, (byte[]) value);
		} else {
			prog.setString(index, value.toString());
		}
	}


	/**
	 * Convenience method for updating rows in the database.
	 *
	 * @param table the table to update in
	 * @param values a map from column names to new column values. null is a
	 *            valid value that will be translated to NULL.
	 * @param whereClause the optional WHERE clause to apply when updating.
	 *            Passing null will update all rows.
	 * @return the number of rows affected
	 */
	public int update(String table, ContentValues values, String whereClause, String[] whereArgs) {
		return updateWithOnConflict(table, values, whereClause, whereArgs);
	}

	/**
	 * Convenience method for updating rows in the database.
	 *
	 * @param table the table to update in
	 * @param values a map from column names to new column values. null is a
	 *            valid value that will be translated to NULL.
	 * @param whereClause the optional WHERE clause to apply when updating.
	 *            Passing null will update all rows.
	 * @param algorithm  {@link ConflictAlgorithm} for update conflict resolver
	 * @return the number of rows affected
	 * @hide
	 */
	public int updateWithOnConflict(String table, ContentValues values, 
			String whereClause, String[] whereArgs) {
		/*if (!isOpen()) {
            throw new IllegalStateException("database not open");
        }
		 */
		if (values == null || values.size() == 0) {
			throw new IllegalArgumentException("Empty values");
		}

		StringBuilder sql = new StringBuilder(120);
		sql.append("UPDATE ");


		sql.append(table);
		sql.append(" SET ");

		Set<Map.Entry<String, Object>> entrySet = values.valueSet();
		Iterator<Map.Entry<String, Object>> entriesIter = entrySet.iterator();

		while (entriesIter.hasNext()) {
			Map.Entry<String, Object> entry = entriesIter.next();
			sql.append(entry.getKey());
			sql.append("=?");
			if (entriesIter.hasNext()) {
				sql.append(", ");
			}
		}

		if (!isEmpty(whereClause)) {
			sql.append(" WHERE ");
			sql.append(whereClause);
		}

		try {
			
			PreparedStatement ps = connection.prepareStatement(sql.toString());
			// Bind the values
			int size = entrySet.size();
			entriesIter = entrySet.iterator();
			int bindArg = 1;
			for (int i = 0; i < size; i++) {
				Map.Entry<String, Object> entry = entriesIter.next();
				bindObjectToProgram(ps, bindArg, entry.getValue());
				bindArg++;
			}

			if (whereArgs != null) {
				size = whereArgs.length;
				for (int i = 0; i < size; i++) {
					ps.setString(bindArg, whereArgs[i]);
					bindArg++;
				}
			}

			System.out.println("Query"+sql);
			return ps.executeUpdate();
		}catch(Exception ex)
		{
			System.out.print(ex);
			return -1;
		}


	}



	public static boolean isEmpty(CharSequence str) {
		if (str == null || str.length() == 0)
			return true;
		else
			return false;
	}


	/**
	 * Convenience method for deleting rows in the database.
	 *
	 * @param table the table to delete from
	 * @param whereClause the optional WHERE clause to apply when deleting.
	 *            Passing null will delete all rows.
	 * @return the number of rows affected if a whereClause is passed in, 0
	 *         otherwise. To remove all rows and get a count pass "1" as the
	 *         whereClause.
	 */
	public int delete(String table, String whereClause, String[] whereArgs) {

		String stringStatement = null;
		try {
			stringStatement = "DELETE FROM " + table
					+ (!isEmpty(whereClause)
							? " WHERE " + whereClause : "");

			PreparedStatement ps = connection.prepareStatement(stringStatement.toString());

			if (whereArgs != null) {
				int numArgs = whereArgs.length;
				for (int i = 0; i < numArgs; i++) {
					bindObjectToProgram(ps, i + 1, whereArgs[i]);
				}
			}

			return ps.executeUpdate();
		}catch(Exception ex)
		{
			logger.error(ex);
			return -1;
		}


	}

	/**
	 * Query the given table, returning a {@link Cursor} over the result set.
	 *
	 * @param table The table name to compile the query against.
	 * @param columns A list of which columns to return. Passing null will
	 *            return all columns, which is discouraged to prevent reading
	 *            data from storage that isn't going to be used.
	 * @param selection A filter declaring which rows to return, formatted as an
	 *            SQL WHERE clause (excluding the WHERE itself). Passing null
	 *            will return all rows for the given table.
	 * @param selectionArgs You may include ?s in selection, which will be
	 *         replaced by the values from selectionArgs, in order that they
	 *         appear in the selection. The values will be bound as Strings.
	 * @param groupBy A filter declaring how to group rows, formatted as an SQL
	 *            GROUP BY clause (excluding the GROUP BY itself). Passing null
	 *            will cause the rows to not be grouped.
	 * @param having A filter declare which row groups to include in the cursor,
	 *            if row grouping is being used, formatted as an SQL HAVING
	 *            clause (excluding the HAVING itself). Passing null will cause
	 *            all row groups to be included, and is required when row
	 *            grouping is not being used.
	 * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause
	 *            (excluding the ORDER BY itself). Passing null will use the
	 *            default sort order, which may be unordered.
	 * @return A {@link Cursor} object, which is positioned before the first entry
	 * @see Cursor
	 */
	public ResultSet query(String table, String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having,
			String orderBy) {

		return query(false, table, columns, selection, selectionArgs, groupBy,
				having, orderBy, null /* limit */);
	}
	
	public ResultSet query(String table, String[] columns, String selection,
			String[] selectionArgs, String groupBy, String having,
			String orderBy, String limit) {

		return query(false, table, columns, selection, selectionArgs, groupBy,
				having, orderBy, limit);
	}

	/**
	 * Query the given URL, returning a {@link Cursor} over the result set.
	 *
	 * @param distinct true if you want each row to be unique, false otherwise.
	 * @param table The table name to compile the query against.
	 * @param columns A list of which columns to return. Passing null will
	 *            return all columns, which is discouraged to prevent reading
	 *            data from storage that isn't going to be used.
	 * @param selection A filter declaring which rows to return, formatted as an
	 *            SQL WHERE clause (excluding the WHERE itself). Passing null
	 *            will return all rows for the given table.
	 * @param selectionArgs You may include ?s in selection, which will be
	 *         replaced by the values from selectionArgs, in order that they
	 *         appear in the selection. The values will be bound as Strings.
	 * @param groupBy A filter declaring how to group rows, formatted as an SQL
	 *            GROUP BY clause (excluding the GROUP BY itself). Passing null
	 *            will cause the rows to not be grouped.
	 * @param having A filter declare which row groups to include in the cursor,
	 *            if row grouping is being used, formatted as an SQL HAVING
	 *            clause (excluding the HAVING itself). Passing null will cause
	 *            all row groups to be included, and is required when row
	 *            grouping is not being used.
	 * @param orderBy How to order the rows, formatted as an SQL ORDER BY clause
	 *            (excluding the ORDER BY itself). Passing null will use the
	 *            default sort order, which may be unordered.
	 * @param limit Limits the number of rows returned by the query,
	 *            formatted as LIMIT clause. Passing null denotes no LIMIT clause.
	 * @return A Cursor object, which is positioned before the first entry
	 * @see Cursor
	 */
	public ResultSet query(boolean distinct, String table, String[] columns,
			String selection, String[] selectionArgs, String groupBy,
			String having, String orderBy, String limit) {
		return queryWithFactory(distinct, table, columns, selection, selectionArgs,
				groupBy, having, orderBy, limit);
	}

	public ResultSet rawQuery(String sql, String[] selectionArgs)
	{
		return queryWithFactory(sql, selectionArgs);
	}
	public boolean execute(String sql)
	{
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(sql);
			return ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public ResultSet queryWithFactory(String sql, String[] selectionArgs){
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			if (selectionArgs != null && selectionArgs.length != 0) {
				int size = selectionArgs.length;
				for (int i = 0; i < size; i++) {

					bindObjectToProgram(ps, i + 1, selectionArgs[i]);
				
				}
			}
			ResultSet rs= ps.executeQuery();
			
			//ps.executeQuery();
//			ps.executeQuery().geti
			
			 return rs;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		return rawQueryWithFactory(
				cursorFactory, sql, selectionArgs, findEditTable(table));*/
		
		return null;
	}
	
	
	
	public ResultSet queryWithFactory(
			boolean distinct, String table, String[] columns,
			String selection, String[] selectionArgs, String groupBy,
			String having, String orderBy, String limit) {
			String sql = buildQueryString(
				distinct, table, columns, selection, groupBy, having, orderBy, limit);
			//System.out.println("query"+sql);
		try {
			
			PreparedStatement ps = connection.prepareStatement(sql);
			if (selectionArgs != null && selectionArgs.length>0) {
				int size = selectionArgs.length;
				for (int i = 0; i < size; i++) {
					
					bindObjectToProgram(ps, i + 1, selectionArgs[i]);
				
				}
			}
			System.out.println("Query "+sql);
			return ps.executeQuery();
		
			//ps.executeQuery();
//			ps.executeQuery().geti
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		return rawQueryWithFactory(
				cursorFactory, sql, selectionArgs, findEditTable(table));*/
		
		return null;
	}



	public static String buildQueryString(
			boolean distinct, String tables, String[] columns, String where,
			String groupBy, String having, String orderBy, String limit) {
		if (isEmpty(groupBy) && !isEmpty(having)) {
			throw new IllegalArgumentException(
					"HAVING clauses are only permitted when using a groupBy clause");
		}
		/*if (!isEmpty(limit) && !sLimitPattern.matcher(limit).matches()) {
			throw new IllegalArgumentException("invalid LIMIT clauses:" + limit);
		}*/

		StringBuilder query = new StringBuilder(120);

		query.append("SELECT ");
		if (distinct) {
			query.append("DISTINCT ");
		}
 		if (columns != null && columns.length != 0) {
			appendColumns(query, columns);
		} else {
			query.append("* ");
		}
		query.append("FROM ");
		query.append(tables);
		appendClause(query, " WHERE ", where);
		appendClause(query, " GROUP BY ", groupBy);
		appendClause(query, " HAVING ", having);
		appendClause(query, " ORDER BY ", orderBy);
		appendClause(query, " LIMIT ", limit);

		return query.toString();
	}

	private static void appendClause(StringBuilder s, String name, String clause) {
		if (!isEmpty(clause)) {
			s.append(name);
			s.append(clause);
		}
	}

	public static void appendColumns(StringBuilder s, String[] columns) {
		int n = columns.length;

		for (int i = 0; i < n; i++) {
			String column = columns[i];

			if (column != null) {
				if (i > 0) {
					s.append(", ");
				}
				s.append(column);
			}
		}
		s.append(' ');
	}

}
