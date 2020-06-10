load data
infile 'final.csv'
insert into table DartTable
FIELDS TERMINATED BY ',' 
TRAILING NULLCOLS
(num, companyname, code, market, upjjong, buchae, yoodongboochae, yoodongjasan, jabongum, jabumhap, jasanhap)