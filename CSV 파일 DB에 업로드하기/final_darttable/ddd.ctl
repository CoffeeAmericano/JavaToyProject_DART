load data
characterset utf8
infile 'darttable_final.csv'
insert into table darttable
FIELDS TERMINATED BY ',' 
TRAILING NULLCOLS
(num, com_code, bs_15_4, is_15_4, cf_15_4,
              bs_16_1, is_16_1, cf_16_1,
              bs_16_2, is_16_2, cf_16_2,
              bs_16_3, is_16_3, cf_16_3,
              bs_16_4, is_16_4, cf_16_4,
              bs_17_1, is_17_1, cf_17_1,
              bs_17_2, is_17_2, cf_17_2,
              bs_17_3, is_17_3, cf_17_3,
              bs_17_4, is_17_4, cf_17_4,
              bs_18_1, is_18_1, cf_18_1,
              bs_18_2, is_18_2, cf_18_2,
              bs_18_3, is_18_3, cf_18_3,
              bs_18_4, is_18_4, cf_18_4,
              bs_19_1, is_19_1, cf_19_1,
              bs_19_2, is_19_2, cf_19_2,
              bs_19_3, is_19_3, cf_19_3,
              bs_19_4, is_19_4, cf_19_4,
              bs_20_1, is_20_1, cf_20_1)