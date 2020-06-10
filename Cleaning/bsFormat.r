### 재무상태표 클리닝 ##########################
setwd('C:/Users/Playdata/Desktop/Dataset')
data2 <- read.csv(file = 'C:/Users/Playdata/Desktop/Dataset/19_3_a.csv', header = T)
data2_tf <- tbl_df(data2)

### options(max.print = 9999999)
##### dplyr ######
data2_tf <- data2_tf %>%
  select(회사명, 종목코드, 시장구분, 업종, 항목명, 당기.3분기말)
data2_tf$항목명 <- gsub(pattern = "\\s", replacement = "", x = data2_tf$항목명)
data2_tf$항목명 <- gsub(pattern = "[^ㄱ-힣]", replacement = "", x = data2_tf$항목명)
data2_tf <- data2_tf %>%
  filter(항목명 %in% c("자본금", 
                    "유동자산", 
                    "유동부채", 
                    "자산총계",
                    "자본금", 
                    "자본통계", 
                    "자본총계",
                    "부채총계",
                    "총부채",
                    "총자본",   
                    "총자산"))
data2_tf <- spread(data2_tf, key = 항목명, value = 당기.3분기말)
write.csv(data2_tf, "최종포맷.csv")
