
## 손익계산서 변환
setwd('C:/Users/Playdata/Desktop/Dataset')

is <- read.csv(file = "C:/Users/Playdata/Downloads/2019년 3,4분기_CSV/2019 3Q_포괄손익계산서.csv")
is <- as_tibble(is)

account <- c('ifrs-full_Revenue',
             'ifrs-full_CostOfSales',
             'ifrs-full_GrossProfit',
             'ifrs-full_ProfitLossBeforeTax',
             'ifrs-full_IncomeTaxExpenseContinuingOperations',
             'ifrs-full_ProfitLoss',
             'ifrs-full_ComprehensiveIncome',
             'ifrs-full_BasicEarningsLossPerShare')

is_1 <- is %>%
  select(com_code = 종목코드, acc_code = 항목코드, value = 당기.3분기.3개월) %>%
  filter(acc_code %in% account) %>%
  spread(key = acc_code, value = value) %>%
  select(com_code, all_of(account)) %>% 
  unite(bs_19_3, all_of(account), sep = "_", remove = T)

is_1$com_code <- gsub(pattern = "[^0-9]", replacement = "", x = is_1$com_code)

write.csv(is_1, "is_19_3.csv", fileEncoding = "UTF-8")
