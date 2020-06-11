load data
characterset utf8
infile 'companyinfo.csv'
insert into table company_list
FIELDS TERMINATED BY ',' 
TRAILING NULLCOLS
(num, com_name, industry_name, com_code)