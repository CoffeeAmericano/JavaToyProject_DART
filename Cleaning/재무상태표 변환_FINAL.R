
## 재무상태표 변환 ## 
setwd('C:/Users/Playdata/Desktop/Dataset')

bs <- read.csv(file = "C:/Users/Playdata/Downloads/2019년 3,4분기_CSV/2019 3Q_재무상태표.csv")
bs <- as_tibble(bs)

account <- c('ifrs-full_Assets',
             'ifrs-full_Equity', 
             'ifrs-full_Liabilities', 
             'ifrs-full_CurrentAssets', 
             'ifrs-full_CashAndCashEquivalents', 
             'ifrs-full_Inventories', 
             'ifrs-full_NoncurrentAssets', 
             'ifrs-full_CurrentLiabilities', 
             'ifrs-full_IssuedCapital',
             'ifrs-full_PropertyPlantAndEquipment',
             'ifrs-full_RetainedEarnings')


bs_1 <- bs %>%
  select(com_code = 종목코드, acc_code = 항목코드, value = 당기.3분기말) %>%
  filter(acc_code %in% account) %>%
  spread(key = acc_code, value = value) %>%
  select(com_code, all_of(account)) %>% 
  unite(bs_19_3, all_of(account), sep = "_", remove = T)

bs_1$com_code <- gsub(pattern = "[^0-9]", replacement = "", x = bs_1$com_code)

write.csv(bs_1, "bs_19_3.csv", fileEncoding = "UTF-8")




