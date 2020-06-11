load data
infile 'finance_19_3.csv'
insert into table DartTable2
FIELDS TERMINATED BY ',' 
TRAILING NULLCOLS
(com_code, bs_19_3, is_19_3, cf_19_3)