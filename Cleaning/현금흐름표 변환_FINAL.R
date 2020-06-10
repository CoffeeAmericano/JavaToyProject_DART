

## 손익계산서 변환
setwd('C:/Users/Playdata/Desktop/Dataset')

cf <- read.csv(file = "C:/Users/Playdata/Downloads/2019년 3,4분기_CSV/2019 3Q_현금흐름표.csv")
cf <- as_tibble(cf)

account <- c('ifrs-full_CashFlowsFromUsedInOperatingActivities',
             'ifrs-full_CashFlowsFromUsedInInvestingActivities',
             'ifrs-full_CashFlowsFromUsedInFinancingActivities')

cf_1 <- cf %>%
  select(com_code = 종목코드, acc_code = 항목코드, value = 당기.3분기) %>%
  filter(acc_code %in% account) %>%
  spread(key = acc_code, value = value) %>%
  select(com_code, all_of(account)) %>% 
  unite(cf_19_3, all_of(account), sep = "_", remove = T)

cf_1$com_code <- gsub(pattern = "[^0-9]", replacement = "", x = cf_1$com_code)

write.csv(cf_1, "cf_19_3.csv", fileEncoding = "UTF-8")