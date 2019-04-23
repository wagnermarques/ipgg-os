select * from information_schema.tables where 
	table_schema = 'public' and 
	table_catalog = 'ipggos' and 
	table_type = 'BASE TABLE'